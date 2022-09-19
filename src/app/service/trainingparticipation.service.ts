import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TrainingParticipationDTO } from '../dto/TrainingParticipationDTO';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { HTTPService } from './abstract_service/HTTPService';

@Injectable({
  providedIn: 'root'
})
export class TrainingParticipationService implements HTTPService<TrainingParticipationDTO>{
  constructor(private http: HttpClient) { }

  getEntity(id: number, dtoId: number) : Observable<TrainingParticipationDTO>{
    return this.http.get<TrainingParticipationDTO>(`${environment.apiUrl}/cv/${id}/training/${dtoId}`);
  }
  updateEntity(entity: TrainingParticipationDTO): Observable<TrainingParticipationDTO> {
    return this.http.put<TrainingParticipationDTO>(`${environment.apiUrl}/cv/${entity.employee.id}/training/${entity.id}`, entity);
  }
  createEntity(entity: TrainingParticipationDTO): Observable<TrainingParticipationDTO> {
    entity.id = 0;
    return this.http.post<TrainingParticipationDTO>(`${environment.apiUrl}/cv/${entity.employee.id}/training`, entity);
  }
  deleteEntity(toDeleteEntity: TrainingParticipationDTO): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/cv/${toDeleteEntity.employee.id}/training/${toDeleteEntity.id}`);
  }
  getEntities(id: number): Observable<TrainingParticipationDTO[]> {
    return this.http.get<TrainingParticipationDTO[]>(`${environment.apiUrl}/cv/${id}/training`);
  }
}
