import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { EducationDTO } from '../dto/EducationDTO';

@Injectable({
  providedIn: 'root'
})
export class EducationService {

  constructor(private http: HttpClient) { }

  getEducations() : Observable<EducationDTO[]>   {
    return this.http.get<EducationDTO[]>(`${environment.apiUrl}/educations`);
  }
}
