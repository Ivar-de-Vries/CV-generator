import { TrainingDTO } from './TrainingDTO';
import { EmployeeDTO } from './EmployeeDTO';
import { DTO } from './DTO';

export class TrainingParticipationDTO implements DTO{
  id!: number;
  employee!: EmployeeDTO;
  training!: TrainingDTO;
  beginDate!: Date;
  endDate!: Date;

  constructor() {
    this.employee = new EmployeeDTO;
    this.training = new TrainingDTO;

    this.beginDate = new Date;
    this.endDate = new Date;
  }
}
