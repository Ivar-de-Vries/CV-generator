import { Component, OnInit } from '@angular/core';
import {LoginService} from '../../service/login-service.service';
import {ErrorSubscribeService} from '../../service/errorsubscribe.service';
import {UserDTO} from '../../dto/UserDTO';
import {Router} from '@angular/router';
import {UserService} from '../../service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss', '../../styles.scss']
})
export class LoginComponent implements OnInit {
  user!: UserDTO;
  emailAddress!: string;
  password!: string;
  error!: Error;
  successMessage!: string;

  constructor(private loginService: LoginService,
              private userService: UserService,
              private errorService: ErrorSubscribeService,
              private router: Router) {
    this.error = new Error('Uw e-mailadres of wachtwoord is incorrect!');
  }

  ngOnInit(): void {
    if(localStorage.getItem('id')){
      const userId = Number(localStorage.getItem('id'));
      this.router.navigateByUrl(`/cv/${userId}`).then(r => window.location.reload());
    } else if(localStorage.getItem('emailAddress')) {
      this.router.navigateByUrl('/create').then(r => window.location.reload());

    }
  }

  handleLogin() {
    this.loginService.login(this.emailAddress, this.password).subscribe((result) => {
      const observable = this.userService.getUserByEmailAddress(this.emailAddress);
      observable.subscribe({
        next: user => {
          this.handleSuccessfulLogin(user);
          if(user.employee != null){
            this.router.navigateByUrl(`/cv/${user.employee.id}`).then(r => window.location.reload());
          } else {
            this.router.navigateByUrl('/create');
          }

        },
        error: (error) => {
          this.errorService.addError(error);
        }
      });
    }, () => {
      this.errorService.addError(this.error);
    });
  }

  handleSuccessfulLogin(user: UserDTO){
    localStorage.setItem('emailAddress', user.emailAddress);
    user.roles.forEach(role => {
      localStorage.setItem(role.role, role.role);
    });
    if(user.employee != null){
      localStorage.setItem('name', `${user.employee.firstname} ${user.employee.lastname}`);
      localStorage.setItem('id', String(user.employee.id));
    } else {
      localStorage.setItem('name', this.emailAddress);
    }
  }
}
