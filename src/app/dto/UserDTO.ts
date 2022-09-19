import {EmployeeDTO} from './EmployeeDTO';
import {RoleDTO} from './RoleDTO';

export class UserDTO {
  id!: number | null;
  emailAddress!: string;
  roles!: RoleDTO[];
  employee!: EmployeeDTO;

  constructor() {
    this.roles = [new RoleDTO()];
    this.employee = new EmployeeDTO;
  }
}
