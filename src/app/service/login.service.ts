import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginDTO } from "../dto/LoginDTO";


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  applyLoginInfo(login : LoginDTO) {
    return this.http.post<LoginDTO>(`${environment.apiUrl}/cv/` + login.employee.id, login);
  }
}
