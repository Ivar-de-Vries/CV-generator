import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {LanguageSkillDTO} from '../dto/LanguageSkillDTO';

@Injectable({
  providedIn: 'root'
})
export class LanguageSkillService {

  constructor(
    private http: HttpClient
  ) { }

  getAllLanguageSkills(): Observable<LanguageSkillDTO[]> {
    return this.http.get<LanguageSkillDTO[]>(`${environment.apiUrl}/languageskill`);
  }
}
