import { EmployeeDTO } from './EmployeeDTO';
import { DTO } from './DTO';

export class CertificateDTO implements DTO{
    id!: number;
    name!: string;
    courseName!: string;
    acquired!: Date;
    employee!: EmployeeDTO;
    userId!: number;
}
