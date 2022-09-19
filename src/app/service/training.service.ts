import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { TrainingDTO } from '../dto/TrainingDTO';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {

  constructor(private http: HttpClient) { }

  getTrainings() : Observable<TrainingDTO[]>   {
    return this.http.get<TrainingDTO[]>(`${environment.apiUrl}/training`);
  }
}
