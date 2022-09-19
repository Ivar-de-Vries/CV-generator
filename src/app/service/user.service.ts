import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserDTO} from '../dto/UserDTO';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getUserByEmailAddress(emailAddress: string) : Observable<UserDTO> {
    return this.http.get<UserDTO>(`${environment.apiUrl}/user/${emailAddress}`);
  }

  updateUser(user: UserDTO, emailAddress: string | null) : Observable<UserDTO> {
    return this.http.put<UserDTO>(`${environment.apiUrl}/user/${emailAddress}`, user);
  }

  updateEmployeeIdInUser(user: UserDTO, emailAddress: string | null) : Observable<UserDTO> {
    return this.http.put<UserDTO>(`${environment.apiUrl}/user/${emailAddress}/resetEmployee`, user);
  }

}
