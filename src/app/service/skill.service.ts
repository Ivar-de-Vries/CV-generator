import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { SkillDTO } from '../dto/SkillDTO';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  constructor(private http: HttpClient) { }

  getSkills(): Observable<SkillDTO[]> {
    return this.http.get<SkillDTO[]>(`${environment.apiUrl}/skills`);
  }
}
