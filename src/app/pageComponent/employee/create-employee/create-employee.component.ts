import { Component, OnInit } from '@angular/core';
import { EmployeeDTO } from 'src/app/dto/EmployeeDTO';
import { EmployeeService } from 'src/app/service/employee.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import {UserDTO} from '../../../dto/UserDTO';
import {UserService} from '../../../service/user.service';


@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.scss', '../../../styles.scss']
})
export class CreateEmployeeComponent implements OnInit {
  employee!: EmployeeDTO;
  user = new UserDTO();
  createEmployeeForm!: FormGroup;
  constructor(private employeeService: EmployeeService,
              private userService: UserService,
              private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private errorService: ErrorSubscribeService) {
    this.createEmployeeForm = this.formBuilder.group({
      employeeForm: this.formBuilder.group({
        emailAddress: ['', [Validators.required, Validators.email]],
        firstname: ['', Validators.required],
        lastname: ['', Validators.required],
        birthdate: ['', Validators.required],
        gender: this.formBuilder.group({
          gender: ['', Validators.required],
        }),
        city: ['', Validators.required],
        driverLicense: false,
        description: ['', Validators.required]
      })
    });
  }

  ngOnInit(): void {
    if(localStorage.getItem('id') != null){
      const userId = Number(localStorage.getItem('id'));
      this.router.navigateByUrl(`/cv/${userId}`).then(r => window.location.reload());
    } else if(localStorage.getItem('emailAddress') == null){
      this.router.navigateByUrl('/').then(r => window.location.reload());
    }
  }

  createEmployee() {
    if (this.createEmployeeForm.valid) {
      this.employee = this.createEmployeeForm.value.employeeForm;
      this.employee.gender = this.createEmployeeForm.value.employeeForm.gender.gender;
      const observable = this.employeeService.createEmployee(this.employee);
      observable.subscribe({
        next: (employee) => {
          this.updateUserWithEmployee(employee);
          localStorage.setItem('id', String(employee.id));
          localStorage.setItem('name', `${employee.firstname} ${employee.lastname}`);
          this.router.navigateByUrl(`/cv/${employee.id}`).then(r => window.location.reload());
        },
        error: (error) => {
            this.errorService.addError(error);
        }
      });
    }
  }

  logOut() {
    localStorage.clear();
    window.location.reload();
  }

  updateUserWithEmployee(employee: EmployeeDTO){
    this.user.employee = employee;
    const observable = this.userService.updateUser(this.user, localStorage.getItem('emailAddress'));
    observable.subscribe({
      error: (error) => {
        this.errorService.addError(error);
      }
    });
  }
}

