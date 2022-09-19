import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { map } from 'rxjs';
import { EmployeeDTO } from 'src/app/dto/EmployeeDTO';
import { ProjectDTO } from 'src/app/dto/ProjectDTO';
import { ProjectParticipationDTO } from 'src/app/dto/ProjectParticipationDTO';
import { TrainingDTO } from 'src/app/dto/TrainingDTO';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import { ProjectService } from 'src/app/service/project.service';
import { ProjectparticipationService } from 'src/app/service/projectparticipation.service';
import AbstractCreateUpdate from '../../abstractPage/create-update-abstract';

@Component({
  selector: 'app-create-update-projectparticipations',
  templateUrl: './create-update-projectparticipations.component.html',
  styleUrls: ['./create-update-projectparticipations.component.scss',  '../../../styles.scss']
})
export class CreateUpdateProjectparticipationsComponent extends AbstractCreateUpdate<ProjectParticipationDTO> implements OnInit {


  constructor(
    projectParticipationService : ProjectparticipationService,
    route: ActivatedRoute,
    errorService: ErrorSubscribeService,
    formBuilder: FormBuilder,
    router: Router,
    private projectService: ProjectService
  ) {
    super(projectParticipationService, route, errorService, formBuilder, router);
  }

  ngOnInit(): void {
    this.projectService.getAllProjects().pipe(
      map(res => res.map(item => ({name: item.name, value: item.id.toString()})))
    ).subscribe({
      next: (listOfProjectsTransformed)=>{
        this.projects = listOfProjectsTransformed;
      },
      error: (error)=>{
        this.errorService.addError(error);
      }
    });
  }

  makeFormGroup(entity: ProjectParticipationDTO | null): FormGroup {
    if(entity == null) {
      entity = new ProjectParticipationDTO();
    }
    return this.formBuilder.group({
      project: this.formBuilder.group({
        project: [entity.project.id, Validators.required]
      }),
      beginDate: [entity.beginDate, Validators.required],
      endDate: entity.endDate,
      description: [entity.description, Validators.required]
    });
  }
  getEmployeeId(entity: ProjectParticipationDTO): number {
    return entity.employee.id;
  }
  transformFormGroupIntoObject(formGroup: FormGroup, id: number): ProjectParticipationDTO {
    let projectParticipation = formGroup.value;

    let employeeDto : EmployeeDTO = new EmployeeDTO();
    employeeDto.id = id;
    projectParticipation.employee = employeeDto;

    let projectDto: ProjectDTO = new ProjectDTO();
    projectDto.id = Number(formGroup.value.project.project);
    projectParticipation.project = projectDto;

    return projectParticipation;
  }

  inputList: {type: string, name: string, id: string}[]= [
    {type:'date', name:'Begin datum' ,id:'beginDate'},
    {type:'date', name:'Eind datum', id:'endDate'},
    {type:'textbox', name:'Beschrijving', id:'description'}
  ];

  project = 'project';
  projectShowName = 'Project';
  projects: {name: string, value:string}[] = [];

  getMaxDate(): string {
    const currentDate : Date = new Date();
    return formatDate(currentDate, 'yyyy-MM-dd', 'en-US');
  }
}
