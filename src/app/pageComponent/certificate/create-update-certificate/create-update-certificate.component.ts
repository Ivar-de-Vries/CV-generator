import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CertificateDTO } from 'src/app/dto/CertificateDTO';
import { EmployeeDTO } from 'src/app/dto/EmployeeDTO';
import { CertificateService } from 'src/app/service/certificate.service';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import AbstractCreateUpdate from '../../abstractPage/create-update-abstract';
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-create-update-certificate',
  templateUrl: './create-update-certificate.component.html',
  styleUrls: ['./create-update-certificate.component.scss', '../../../styles.scss']
})

export class CreateUpdateCertificateComponent extends AbstractCreateUpdate<CertificateDTO> implements OnInit {
  constructor(
    certificateService: CertificateService,
    route: ActivatedRoute,
    errorService: ErrorSubscribeService,
    formBuilder: FormBuilder,
    router: Router) {
      super(certificateService, route, errorService, formBuilder, router);
  }

  makeFormGroup(entity: CertificateDTO | null): FormGroup {
    const INPUT_MIN_LENGTH = 2;
    const INPUT_MAX_LENGTH = 255;

    if (entity == null) {
      entity = new CertificateDTO();
    }

    return this.formBuilder.group({
      name: [entity.name, [Validators.required, Validators.minLength(INPUT_MIN_LENGTH), Validators.maxLength(INPUT_MAX_LENGTH)]],
      courseName: [entity.courseName, [Validators.required, Validators.minLength(INPUT_MIN_LENGTH), Validators.maxLength(INPUT_MAX_LENGTH)]],
      acquired: [entity.acquired, Validators.required]
    });
  }

  getEmployeeId(entity: CertificateDTO): number {
    return entity.employee.id;
  }

  override transformFormGroupIntoObject(formGroup: FormGroup, id: number): CertificateDTO {
    let certificate = formGroup.value;

    let employeeDto = new EmployeeDTO();
    employeeDto.id = id;
    certificate.employee = employeeDto;

    return certificate;
  }

  ngOnInit(): void {}

  inputList: {type: string, name: string, id: string}[] = [
    {type: 'text', name:'Naam', id:'name'},
    {type: 'text', name:'Cursus Naam', id:'courseName'}
  ];
  dateList: {type: string, name: string, id: string}[] = [
    {type: 'Date', name:'Behaald op', id:'acquired'}
  ];

  getMaxDate(): string {
    const currentDate : Date = new Date();
    return formatDate(currentDate, 'yyyy-MM-dd', 'en-US');
  }
}
