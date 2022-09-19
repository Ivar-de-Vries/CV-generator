import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from 'src/app/service/employee.service';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import {UserDTO} from '../../dto/UserDTO';
import {UserService} from '../../service/user.service';

@Component({
  selector: 'app-actions',
  templateUrl: './actions.component.html',
  styleUrls: ['./actions.component.scss', '../../styles.scss']
})
export class ActionsComponent implements OnInit {
  userId!: number;

  constructor(
    private employeeService: EmployeeService,
    private userService: UserService,
    private route: ActivatedRoute,
    private errorService: ErrorSubscribeService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.userId = Number(this.route.snapshot.paramMap.get('id'));
  }


  deleteEmployee() {
    let result = confirm('Weet u zeker dat u alle gegevens wil verwijderen');
    if (result) {
      const observable = this.userService.updateEmployeeIdInUser(new UserDTO(), localStorage.getItem('emailAddress'));
      observable.subscribe({
        next: () => {
          const observable = this.employeeService.deleteEmployee(this.userId);
          observable.subscribe({
            next: () => {
              localStorage.removeItem('id');
              this.router.navigateByUrl('/create');
            },
            error: (error) => {
              this.errorService.addError(error);
            }
          });
        },
        error: (error) => {
          this.errorService.addError(error);
        }
      });
    }
  }
}
