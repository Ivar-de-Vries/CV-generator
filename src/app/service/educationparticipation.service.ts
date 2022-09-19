import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { EducationParticipationDTO } from '../dto/EducationParticipationDTO';
import { HTTPService } from './abstract_service/HTTPService';

@Injectable({
  providedIn: 'root'
})
export class EducationParticipationService implements HTTPService<EducationParticipationDTO> {

  constructor(private http: HttpClient) { }
  getEntity(userId: number, dtoId: number): Observable<EducationParticipationDTO> {
    return this.http.get<EducationParticipationDTO>(`${environment.apiUrl}/cv/${userId}/education/${dtoId}`);
  }
  deleteEntity(toDeleteEntity: EducationParticipationDTO): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/cv/${toDeleteEntity.employee.id}/education/${toDeleteEntity.id}`);
  }
  getEntities(id: number): Observable<EducationParticipationDTO[]> {
    return this.http.get<EducationParticipationDTO[]>(`${environment.apiUrl}/cv/${id}/education`);
  }
  createEntity(entity: EducationParticipationDTO): Observable<EducationParticipationDTO> {
    entity.id = 0;
    return this.http.post<EducationParticipationDTO>(`${environment.apiUrl}/cv/${entity.employee.id}/education`, entity);
  }
  updateEntity(entity: EducationParticipationDTO): Observable<EducationParticipationDTO> {
    return this.http.put<EducationParticipationDTO>(`${environment.apiUrl}/cv/${entity.employee.id}/education/${entity.id}`, entity);
  }
}
