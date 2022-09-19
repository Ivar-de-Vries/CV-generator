import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {LanguageLevelDTO} from '../dto/LanguageLevelDTO';
import { HTTPService } from './abstract_service/HTTPService';

@Injectable({
  providedIn: 'root'
})
export class LanguageLevelService implements HTTPService<LanguageLevelDTO> {

  constructor(
    private http: HttpClient
  ) { }

  getEntity(userId: number, dtoId: number): Observable<LanguageLevelDTO> {
    return this.http.get<LanguageLevelDTO>(`${environment.apiUrl}/cv/${userId}/languagelevel/${dtoId}`);
  }
  deleteEntity(toDeleteEntity: LanguageLevelDTO): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/cv/${toDeleteEntity.employee.id}/languagelevel/${toDeleteEntity.id}`);
  }
  getEntities(id: number): Observable<LanguageLevelDTO[]> {
    return this.http.get<LanguageLevelDTO[]>(`${environment.apiUrl}/cv/${id}/languagelevel`);
  }
  createEntity(entity: LanguageLevelDTO): Observable<LanguageLevelDTO> {
    entity.id = 0;
    return this.http.post<LanguageLevelDTO>(`${environment.apiUrl}/cv/${entity.employee.id}/languagelevel`, entity);
  }
  updateEntity(entity: LanguageLevelDTO): Observable<LanguageLevelDTO> {
    return this.http.put<LanguageLevelDTO>(`${environment.apiUrl}/cv/${entity.employee.id}/languagelevel/${entity.id}`, entity);
  }
}
