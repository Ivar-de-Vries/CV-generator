import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CompanyDTO } from '../dto/CompanyDTO';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http: HttpClient) { }

  getCompanies() : Observable<CompanyDTO[]>   {
    return this.http.get<CompanyDTO[]>(`${environment.apiUrl}/companies`);
  }
}
