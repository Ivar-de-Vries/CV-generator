import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { map } from 'rxjs';
import { EmployeeDTO } from 'src/app/dto/EmployeeDTO';
import { TrainingDTO } from 'src/app/dto/TrainingDTO';
import { TrainingParticipationDTO } from 'src/app/dto/TrainingParticipationDTO';
import AbstractCreateUpdate from 'src/app/pageComponent/abstractPage/create-update-abstract';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import { TrainingService } from 'src/app/service/training.service';
import { TrainingParticipationService } from 'src/app/service/trainingparticipation.service';


@Component({
  selector: 'app-update-trainingParticipations',
  templateUrl: './create-update-trainingParticipations.component.html',
  styleUrls: ['./create-update-trainingParticipations.component.scss',  '../../../styles.scss']
})
export class CreateUpdateTrainingParticipationsComponent extends AbstractCreateUpdate<TrainingParticipationDTO> implements OnInit{
  constructor(
     trainingParticipationService: TrainingParticipationService,
     route: ActivatedRoute,
     errorService: ErrorSubscribeService,
     formBuilder: FormBuilder,
     router: Router,
     private trainingService: TrainingService) {
    super(trainingParticipationService, route, errorService, formBuilder, router);
  }

  makeFormGroup(entity: TrainingParticipationDTO | null): FormGroup {
    if(entity == null) {
      entity = new TrainingParticipationDTO();
      entity.training = new TrainingDTO();
    }
    return this.formBuilder.group({
        training: this.formBuilder.group({
          training: [entity.training.id , Validators.required],
        }),
        beginDate: [entity.beginDate, Validators.required],
        endDate: entity.endDate
    });
  }

  getEmployeeId(entity: TrainingParticipationDTO): number {
    return entity.employee.id;
  }

  transformFormGroupIntoObject(formGroup: FormGroup, id : number): TrainingParticipationDTO {
    let trainingParticipation = formGroup.value;

    let employeeDto : EmployeeDTO = new EmployeeDTO;
    employeeDto.id = id;
    trainingParticipation.employee = employeeDto;

    let trainingDto : TrainingDTO = new TrainingDTO;
    trainingDto.id = Number(formGroup.value.training.training);
    trainingParticipation.training = trainingDto;

    return trainingParticipation;
}

  ngOnInit(): void {
    this.trainingService.getTrainings().pipe(
      map(res => res.map(item => ({name: item.name, value: item.id.toString()})))
    ).subscribe({
      next: (listOfTrainingsTransformed)=>{
        this.trainings = listOfTrainingsTransformed;
      },
      error: (error)=>{
        this.errorService.addError(error);
      }
    });
  }

  inputList: {type: string, name: string, id: string}[] = [
    {type:'date', name:'Begin datum' ,id:'beginDate'},
    {type:'date', name:'Eind datum', id:'endDate'},
  ];

  training = 'training';
  trainingShowName  = 'Training';
  trainings: {name: string, value:string}[] = [];

  getMaxDate(): string {
    const currentDate : Date = new Date();
    return formatDate(currentDate, 'yyyy-MM-dd', 'en-US');
  }
}


