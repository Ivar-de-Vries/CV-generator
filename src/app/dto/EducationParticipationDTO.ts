import { EducationDTO } from './EducationDTO';
import { EmployeeDTO } from './EmployeeDTO';
import { DTO } from './DTO';

export class EducationParticipationDTO implements DTO{
    id!: number;
    employee!: EmployeeDTO;
    education!: EducationDTO;
    beginDate!: Date;
    endDate!: Date;

    constructor() {
        this.employee = new EmployeeDTO;
        this.education = new EducationDTO;

        this.beginDate = new Date;
        this.endDate = new Date;
      }
}
