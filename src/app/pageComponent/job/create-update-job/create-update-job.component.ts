import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { map } from 'rxjs';
import { EmployeeDTO } from 'src/app/dto/EmployeeDTO';
import { JobDTO } from 'src/app/dto/JobDTO';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import { JobService } from 'src/app/service/job.service';
import { CompanyService } from 'src/app/service/company.service';
import AbstractCreateUpdate from '../../abstractPage/create-update-abstract';
import { CompanyDTO } from 'src/app/dto/CompanyDTO';


@Component({
  selector: 'app-update-jobs',
  templateUrl: './create-update-job.component.html',
  styleUrls: ['./create-update-job.component.scss',  '../../../styles.scss']
})
export class CreateUpdateJobComponent extends AbstractCreateUpdate<JobDTO> implements OnInit{
  constructor(
     jobService: JobService,
     route: ActivatedRoute,
     errorService: ErrorSubscribeService,
     formBuilder: FormBuilder,
     router: Router,
     private companyService: CompanyService) {
    super(jobService, route, errorService, formBuilder, router);
  }

  makeFormGroup(entity: JobDTO | null): FormGroup {
    if(entity == null) {
      entity = new JobDTO();
      entity.company = new CompanyDTO();
    }
    return this.formBuilder.group({
      function: entity.function, 
        company: this.formBuilder.group({
          company: [entity.company.id , Validators.required]
        }),
        beginDate: [entity.beginDate, Validators.required],
        endDate: entity.endDate
    });
  }

  getEmployeeId(entity: JobDTO): number {
    return entity.employee.id;
  }

  transformFormGroupIntoObject(formGroup: FormGroup, id : number): JobDTO {
    let job = formGroup.value;

    let employeeDto : EmployeeDTO = new EmployeeDTO;
    employeeDto.id = id;
    job.employee = employeeDto;

    let companyDto : CompanyDTO = new CompanyDTO;
    companyDto.id = Number(formGroup.value.company.company);
    job.company = companyDto;

    return job;
}

  ngOnInit(): void {

    
    this.companyService.getCompanies().pipe(
      map(res => res.map(item => ({name: item.name, value: item.id.toString()}))))
      .subscribe({
      next: (listOfCompaniesTransformed)=>{
        this.companies = listOfCompaniesTransformed;
      },
      error: (error)=>{
        this.errorService.addError(error);
      }
    });
  }

  

  inputList: {type: string, name: string, id: string}[] = [
    {type:'text', name:'Baan', id:'function'},
  ];
  dateList: {type: string, name: string, id: string}[] = [
    {type:'date', name:'Begin datum' ,id:'beginDate'},
    {type:'date', name:'Eind datum', id:'endDate'},
  ];

  company = 'company';
  companyShowName = 'Company';
  companies: {name: string, value:string}[] = [];

  getMaxDate(): string {
    const currentDate : Date = new Date();
    return formatDate(currentDate, 'yyyy-MM-dd', 'en-US');
  }
}


