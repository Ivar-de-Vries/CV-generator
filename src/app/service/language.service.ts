import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {LanguageDTO} from '../dto/LanguageDTO';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LanguageService {

  constructor(
    private http: HttpClient
  ) { }

  getAllLanguages(): Observable<LanguageDTO[]> {
    return this.http.get<LanguageDTO[]>(`${environment.apiUrl}/language`);
  }


}
