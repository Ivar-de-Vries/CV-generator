import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {map, Observable} from 'rxjs';
import {UserDTO} from '../dto/UserDTO';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public username: string | undefined;
  public password: string | undefined;

  constructor(private http: HttpClient) {

  }

  login(username: string, password: string) {
    return this.http.get(`${environment.apiUrl}/login`,
      { headers: { authorization: this.createBasicAuthToken(username, password) } }).pipe(map((res) => {
      this.username = username;
      this.password = password;
      this.registerSuccessfulLogin(username, password);
    }));
  }

  createBasicAuthToken(username: string, password: string) {
    return `Basic ${window.btoa(`${username}:${password}`)}`;
  }

  registerSuccessfulLogin(username: string | undefined, password: string | undefined) {
    this.username = username;
    this.password = password;
    // save the username to session
  }
}
