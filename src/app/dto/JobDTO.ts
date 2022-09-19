import { CompanyDTO } from './CompanyDTO';
import { DTO } from './DTO';
import { EmployeeDTO } from './EmployeeDTO';

export class JobDTO implements DTO {
  id!: number;
  employee!: EmployeeDTO;
  company!: CompanyDTO;
  function!: string;
  beginDate!: Date;
  endDate!: Date;

  constructor() {
    this.employee = new EmployeeDTO;
    this.company = new CompanyDTO;
    this.beginDate = new Date;
    this.endDate = new Date;
  }
}
