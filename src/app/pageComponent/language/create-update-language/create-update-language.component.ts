import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { map } from 'rxjs';
import { EmployeeDTO } from 'src/app/dto/EmployeeDTO';
import { LanguageDTO } from 'src/app/dto/LanguageDTO';
import { LanguageLevelDTO } from 'src/app/dto/LanguageLevelDTO';
import { LanguageSkillDTO } from 'src/app/dto/LanguageSkillDTO';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import { LanguageSkillService } from 'src/app/service/language-skill.service';
import { LanguageService } from 'src/app/service/language.service';
import { LanguageLevelService } from 'src/app/service/languageLevel.service';
import AbstractCreateUpdate from '../../abstractPage/create-update-abstract';

@Component({
  selector: 'app-create-update-language',
  templateUrl: './create-update-language.component.html',
  styleUrls: ['./create-update-language.component.scss', '../../../styles.scss']
})
export class CreateUpdateLanguageComponent extends AbstractCreateUpdate<LanguageLevelDTO> implements OnInit{
  languageSkills!: {name: string, value: string}[];
  languages!: {name: string, value: string}[];

  constructor(
    languageLevelService: LanguageLevelService,
    private languageService: LanguageService,
    private languageSkillService: LanguageSkillService,
    route: ActivatedRoute,
    errorService: ErrorSubscribeService,
    formBuilder: FormBuilder,
    router: Router) {
      super(languageLevelService, route, errorService, formBuilder, router);
    }

  ngOnInit(): void {
    const languages = this.languageService.getAllLanguages().pipe(map(res => res.map(item => ({name: item.name, value: item.id.toString()}))));
    const languageSkills = this.languageSkillService.getAllLanguageSkills().pipe(map(res => res.map(item => ({name: item.value, value: item.id.toString()}))));
    languages.subscribe({
      next: languages => {
        this.languages = languages;
      }
    });
    languageSkills.subscribe({
      next: languageSkills => {
        this.languageSkills = languageSkills;
      }
    });
  }

  makeFormGroup(entity: LanguageLevelDTO | null): FormGroup {
    if (entity == null) {
      entity = new LanguageLevelDTO();
      entity.language = new LanguageDTO();
      entity.readingLevel = new LanguageSkillDTO();
      entity.speakingLevel = new LanguageSkillDTO();
      entity.writingLevel = new LanguageSkillDTO();
    }

    return this.formBuilder.group({
      employee: this.formBuilder.group({
        id: [this.id]
      }),
      language: this.formBuilder.group({
        id: [entity?.language.id, Validators.required]
      }),
      speakingLevel: this.formBuilder.group({
        id: [entity?.speakingLevel.id, Validators.required]
      }),
      readingLevel: this.formBuilder.group({
        id: [entity?.readingLevel.id, Validators.required]
      }),
      writingLevel: this.formBuilder.group({
        id: [entity?.writingLevel.id, Validators.required]
      })
    });
  }

  getEmployeeId(entity: LanguageLevelDTO): number {
    return entity.employee.id;
  }

  transformFormGroupIntoObject(formGroup: FormGroup, id: number): LanguageLevelDTO {
    let languageLevel = formGroup.value;

    let employeeDto = new EmployeeDTO();
    employeeDto.id = this.id;
    languageLevel.employee = employeeDto;

    let language = new LanguageDTO();
    language.id = formGroup.value.language.id;
    languageLevel.language = language;

    let speakingLevel = new LanguageSkillDTO();
    speakingLevel.id = formGroup.value.speakingLevel.id;
    languageLevel.speakingLevel = speakingLevel;

    let readingLevel = new LanguageSkillDTO();
    readingLevel.id = formGroup.value.readingLevel.id;
    languageLevel.readingLevel = readingLevel;

    let writingLevel = new LanguageSkillDTO();
    writingLevel.id = formGroup.value.writingLevel.id;
    languageLevel.writingLevel = writingLevel;

    return languageLevel;
  }

  taal = 'taal';
  language = 'id';
  dropDownList: {name: string, formGroup: string, id: string}[] = [
    {name: 'spreken', formGroup: 'speakingLevel' ,id: 'id'},
    {name: 'lezen', formGroup: 'readingLevel' ,id: 'id'},
    {name: 'schrijven', formGroup: 'writingLevel' ,id: 'id'}
  ];
}
