import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { map } from 'rxjs';
import { EducationDTO } from 'src/app/dto/EducationDTO';
import { EducationParticipationDTO } from 'src/app/dto/EducationParticipationDTO';
import { EmployeeDTO } from 'src/app/dto/EmployeeDTO';
import { EducationService } from 'src/app/service/education.service';
import { EducationParticipationService } from 'src/app/service/educationparticipation.service';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import AbstractCreateUpdate from '../../abstractPage/create-update-abstract';

@Component({
  selector: 'app-create-update-education-participation',
  templateUrl: './create-update-education-participation.component.html',
  styleUrls: ['./create-update-education-participation.component.scss', '../../../styles.scss']
})
export class CreateUpdateEducationParticipationComponent extends AbstractCreateUpdate<EducationParticipationDTO> implements OnInit {
  
  constructor(
    educationParticipationService: EducationParticipationService,
    private educationService: EducationService,
    route: ActivatedRoute,
    errorService: ErrorSubscribeService,
    formBuilder: FormBuilder,
    router: Router) {
      super(educationParticipationService, route, errorService, formBuilder, router);
    }

  ngOnInit(): void {
    this.educationService.getEducations().pipe(
      map(res => res.map(item => ({name: item.name, value: item.id.toString()})))
      ).subscribe({
        next: (listOfEducationsTransformed)=>{
          this.educations = listOfEducationsTransformed;
        },
        error: (error)=>{
          this.errorService.addError(error);
        }
      });
  }

  makeFormGroup(entity: EducationParticipationDTO | null): FormGroup {
    if (entity == null) {
      entity = new EducationParticipationDTO();
      entity.education = new EducationDTO();
    }

    return this.formBuilder.group({
      education: this.formBuilder.group({
        education: [entity.education.id, Validators.required],
      }),
      beginDate: [entity.beginDate, Validators.required],
      endDate: entity.endDate
    });
  }

  getEmployeeId(entity: EducationParticipationDTO): number {
    return entity.employee.id;
  }

  transformFormGroupIntoObject(formGroup: FormGroup, id: number): EducationParticipationDTO {
    let educationParticipation = formGroup.value;

    let employeeDto = new EmployeeDTO();
    employeeDto.id = this.id;
    educationParticipation.employee = employeeDto;

    let educationDto : EducationDTO = new EducationDTO;
    educationDto.id = formGroup.value.education.education;
    educationParticipation.education = educationDto;

    return educationParticipation;
  }

  inputList: {type: string, name: string, id: string}[] = [
    {type:'date', name:'Begin datum' ,id:'beginDate'},
    {type:'date', name:'Eind datum', id:'endDate'},
  ];

  education = 'education';
  educationShowName = 'Education';
  educations: {name: string, value:string}[] = [
  ];

  getMaxDate(): string {
    const currentDate : Date = new Date();

    return formatDate(currentDate, 'yyyy-MM-dd', 'en-US');
  }
}
