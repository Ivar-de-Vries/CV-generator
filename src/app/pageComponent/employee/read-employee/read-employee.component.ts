import { Component, OnInit } from '@angular/core';
import { EmployeeDTO } from 'src/app/dto/EmployeeDTO';
import { EmployeeService } from '../../../service/employee.service';
import {ActivatedRoute, Router} from '@angular/router';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';

@Component({
  selector: 'app-read-employee',
  templateUrl: './read-employee.component.html',
  styleUrls: ['./read-employee.component.scss', '../../../styles.scss']
})
export class ReadEmployeeComponent implements OnInit {
  employee!: EmployeeDTO;
  
  constructor(
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private errorService: ErrorSubscribeService
    ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    const observable = this.employeeService.getEmployee(id);
    observable.subscribe({
      next: employee => {
        this.employee = employee;
      },
      error: (error) => {
        this.errorService.addError(error);
      }
    });
  }

  displayGender(): string {
    switch (this.employee.gender) {
      case 'M':
        return 'Man';
      case 'F':
        return 'Vrouw';
      default:
        return 'Overig';
    }
  }

  displayDriverLicense(): string {
    if (this.employee.driverLicense) {
      return 'B';
    }
    return '-';
  }
}
