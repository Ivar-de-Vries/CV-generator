import { Injectable } from '@angular/core';
import { EmployeeDTO } from '../dto/EmployeeDTO';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  text!: string;
  constructor(private http: HttpClient) { }

  createEmployee(employeeDTO: EmployeeDTO) : Observable<EmployeeDTO> {
    employeeDTO.id = 0;
    return this.http.post<EmployeeDTO>(`${environment.apiUrl}/cv`, employeeDTO);
  }

  getEmployee(id: number): Observable<EmployeeDTO> {
    return this.http.get<EmployeeDTO>(`${environment.apiUrl}/cv/${id}`);
  }

  updateEmployee(employeeDTO: EmployeeDTO) : Observable<EmployeeDTO> {
    return this.http.put<EmployeeDTO>(`${environment.apiUrl}/cv/${employeeDTO.id}`, employeeDTO);
  }

  deleteEmployee(employeeId: number): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/cv/${employeeId}`);
  }
}
