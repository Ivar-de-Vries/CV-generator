import { Component, OnInit } from '@angular/core';
import { EmployeeDTO } from 'src/app/dto/EmployeeDTO';
import { EmployeeService } from 'src/app/service/employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.scss', '../../../styles.scss']
})
export class UpdateEmployeeComponent implements OnInit {
  employee: EmployeeDTO;
  updateEmployeeForm!: FormGroup;

  constructor(private employeeService: EmployeeService,
              private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private errorService: ErrorSubscribeService
  ) {
    this.employee = new EmployeeDTO();
    const id = Number(this.route.snapshot.paramMap.get('id'));
    const observable = this.employeeService.getEmployee(id);
    observable.subscribe({
      next: employee => {
        this.employee = employee;
        this.updateEmployeeForm = this.formBuilder.group({
          employeeForm: this.formBuilder.group({
            id: [employee.id],
            emailAddress: [employee.emailAddress, [Validators.required, Validators.email]],
            firstname: [employee.firstname, Validators.required],
            lastname: [employee.lastname, Validators.required],
            birthdate: [employee.birthdate, Validators.required],
            gender: this.formBuilder.group({
              gender: [employee.gender, Validators.required],
            }),
            city: [employee.city, Validators.required],
            driverLicense: employee.driverLicense,
            description: [employee.description, Validators.required]
          }),
        });
      },
      error: (error) => {
        this.errorService.addError(error);
      }
    });
  }

  ngOnInit(): void {

  }

  updateEmployee() {
    if (this.updateEmployeeForm.valid){
      this.employee = this.updateEmployeeForm.value.employeeForm;
      this.employee.gender = this.updateEmployeeForm.value.employeeForm.gender.gender;
      const observable = this.employeeService.updateEmployee(this.employee);
      observable.subscribe({
        next: (employee) => this.router.navigateByUrl(`/cv/${employee.id}`),
        error: error => {
          this.errorService.addError(error);
        }
      });
    }
  }

  goBack() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.router.navigateByUrl(`/cv/${id}`);
  }
}
