import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ProjectParticipationDTO } from '../dto/ProjectParticipationDTO';
import { HTTPService } from './abstract_service/HTTPService';

@Injectable({
  providedIn: 'root'
})
export class ProjectparticipationService implements HTTPService<ProjectParticipationDTO>{

  constructor(private http: HttpClient) { }
  getEntity(userId: number, dtoId: number): Observable<ProjectParticipationDTO> {
    return this.http.get<ProjectParticipationDTO>(`${environment.apiUrl}/cv/${userId}/projectparticipation/${dtoId}`);
  }
  deleteEntity(toDeleteEntity: ProjectParticipationDTO): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/cv/${toDeleteEntity.employee.id}/projectparticipation/${toDeleteEntity.id}`);
  }
  getEntities(id: number): Observable<ProjectParticipationDTO[]> {
    return this.http.get<ProjectParticipationDTO[]>(`${environment.apiUrl}/cv/${id}/projectparticipation`);
  }
  createEntity(entity: ProjectParticipationDTO): Observable<ProjectParticipationDTO> {
    entity.id = 0;
    return this.http.post<ProjectParticipationDTO>(`${environment.apiUrl}/cv/${entity.employee.id}/projectparticipation`, entity);
  }
  updateEntity(entity: ProjectParticipationDTO): Observable<ProjectParticipationDTO> {
    return this.http.put<ProjectParticipationDTO>(`${environment.apiUrl}/cv/${entity.employee.id}/projectparticipation/${entity.id}`, entity);
  }

}
