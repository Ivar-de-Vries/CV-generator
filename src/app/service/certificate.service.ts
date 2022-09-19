import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CertificateDTO } from '../dto/CertificateDTO';
import {HTTPService} from './abstract_service/HTTPService';

@Injectable({
    providedIn: 'root'
})

export class CertificateService implements HTTPService<CertificateDTO>{

  constructor(private http: HttpClient) { }

  getEntity(userId: number, dtoId: number): Observable<CertificateDTO> {
    return this.http.get<CertificateDTO>(`${environment.apiUrl}/cv/${userId}/certificate/${dtoId}`);
  }

  deleteEntity(toDeleteEntity: CertificateDTO): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/cv/${toDeleteEntity.employee.id}/certificate/${toDeleteEntity.id}`);
  }

  getEntities(id: number): Observable<CertificateDTO[]> {
    return this.http.get<CertificateDTO[]>(`${environment.apiUrl}/cv/${id}/certificate`);
  }

  createEntity(entity: CertificateDTO): Observable<CertificateDTO> {
    entity.id = 0;
    return this.http.post<CertificateDTO>(`${environment.apiUrl}/cv/${entity.employee.id}/certificate`, entity);
  }

  updateEntity(entity: CertificateDTO): Observable<CertificateDTO> {
    return this.http.put<CertificateDTO>(`${environment.apiUrl}/cv/${entity.employee.id}/certificate/${entity.id}`, entity);
  }
}
