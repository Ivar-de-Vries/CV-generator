import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { JobDTO } from '../dto/JobDTO';
import { HTTPService } from './abstract_service/HTTPService';

@Injectable({
  providedIn: 'root'
})
export class JobService implements HTTPService<JobDTO> {

  constructor(private http: HttpClient) { }

  getEntity(userId: number, dtoId: number): Observable<JobDTO> {
    return this.http.get<JobDTO>(`${environment.apiUrl}/cv/${userId}/jobs/${dtoId}`);
  }
  deleteEntity(toDeleteEntity: JobDTO): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/cv/${toDeleteEntity.employee.id}/jobs/${toDeleteEntity.id}`);
  }
  getEntities(id: number): Observable<JobDTO[]> {
    return this.http.get<JobDTO[]>(`${environment.apiUrl}/cv/${id}/jobs`);
  }
  createEntity(entity: JobDTO): Observable<JobDTO> {
    entity.id = 0;
    return this.http.post<JobDTO>(`${environment.apiUrl}/cv/${entity.employee.id}/jobs`, entity);
  }
  updateEntity(entity: JobDTO): Observable<JobDTO> {
    return this.http.put<JobDTO>(`${environment.apiUrl}/cv/${entity.employee.id}/jobs/${entity.id}`, entity);
  }
}
