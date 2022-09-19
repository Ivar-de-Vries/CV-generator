import { EmployeeDTO } from './EmployeeDTO';
import { ProjectDTO } from './ProjectDTO';

export class ProjectParticipationDTO {
  id!: number;

  employee!: EmployeeDTO;

  project!: ProjectDTO;

  description!: string;

  beginDate!: Date;

  endDate?: Date;

  constructor() {
    this.employee = new EmployeeDTO();
    this.project = new ProjectDTO();
  }
}
