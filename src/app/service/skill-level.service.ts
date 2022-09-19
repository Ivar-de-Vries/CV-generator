import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { SkillLevelDTO } from '../dto/SkillLevelDTO';
import { HTTPService } from './abstract_service/HTTPService';

@Injectable({
  providedIn: 'root'
})
export class SkillLevelService implements HTTPService<SkillLevelDTO> {

  constructor(private http: HttpClient) { }

  getEntity(userId: number, dtoId: number): Observable<SkillLevelDTO> {
    return this.http.get<SkillLevelDTO>(`${environment.apiUrl}/cv/${userId}/skill/${dtoId}`);
  }
  deleteEntity(toDeleteEntity: SkillLevelDTO): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/cv/${toDeleteEntity.employee.id}/skill/${toDeleteEntity.id}`);
  }
  getEntities(id: number): Observable<SkillLevelDTO[]> {
    return this.http.get<SkillLevelDTO[]>(`${environment.apiUrl}/cv/${id}/skill`);
  }
  createEntity(entity: SkillLevelDTO): Observable<SkillLevelDTO> {
    entity.id = 0;
    return this.http.post<SkillLevelDTO>(`${environment.apiUrl}/cv/${entity.employee.id}/skill`, entity);
  }
  updateEntity(entity: SkillLevelDTO): Observable<SkillLevelDTO> {
    return this.http.put<SkillLevelDTO>(`${environment.apiUrl}/cv/${entity.employee.id}/skill/${entity.id}`, entity);
  }
}
