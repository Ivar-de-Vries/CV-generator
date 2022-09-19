import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { map } from 'rxjs';
import { EmployeeDTO } from 'src/app/dto/EmployeeDTO';
import { SkillDTO } from 'src/app/dto/SkillDTO';
import { SkillLevelDTO } from 'src/app/dto/SkillLevelDTO';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import { SkillLevelService } from 'src/app/service/skill-level.service';
import { SkillService } from 'src/app/service/skill.service';
import AbstractCreateUpdate from '../../abstractPage/create-update-abstract';

@Component({
  selector: 'app-create-update-skill-level',
  templateUrl: './create-update-skill-level.component.html',
  styleUrls: ['./create-update-skill-level.component.scss', '../../../styles.scss']
})
export class CreateUpdateSkillLevelComponent extends AbstractCreateUpdate<SkillLevelDTO> implements OnInit {
  constructor(
    skillLevelService: SkillLevelService,
    private skillService: SkillService,
    route: ActivatedRoute,
    errorService: ErrorSubscribeService,
    formBuilder: FormBuilder,
    router: Router) {
      super(skillLevelService, route, errorService, formBuilder, router);
    }

  ngOnInit(): void {
    this.skillService.getSkills().pipe(
      map(res => res.map(item => ({name: item.name, value: item.id.toString()})))
    ).subscribe({
      next: (listOfSkillsTransformed)=>{
        this.skills = listOfSkillsTransformed;
      },
      error: (error)=>{
        this.errorService.addError(error);
      }
    });
  }


  makeFormGroup(entity: SkillLevelDTO | null): FormGroup {
    const MAX_SCORE = 5;
    if (entity == null) {
      entity = new SkillLevelDTO();
      entity.skill = new SkillDTO();
    }

    return this.formBuilder.group({
      skill: this.formBuilder.group({
        skill: [entity.skill.id, Validators.required]
      }),
      score: [entity.score, [Validators.required, Validators.min(1), Validators.max(MAX_SCORE)]]
    });
  }

  getEmployeeId(entity: SkillLevelDTO): number {
    return entity.employee.id;
  }

  transformFormGroupIntoObject(formGroup: FormGroup, id: number): SkillLevelDTO {
    let skillLevel = formGroup.value;

    let employeeDTO = new EmployeeDTO();
    employeeDTO.id = this.id;
    skillLevel.employee = employeeDTO;

    let skill = new SkillDTO();
    skill.id = formGroup.value.skill.skill;
    skillLevel.skill = skill;

    return skillLevel;
  }

  inputList: {type: string, name: string, id: string}[] = [
    {type: 'number', name:'score 1-5', id:'score'}
  ];

  skill = 'skill';
  skillShowName = 'Vaardigheden';
  skills: {name: string, value:string}[] = [];
}
