import { EmployeeDTO } from './EmployeeDTO';
import { DTO } from './DTO';
import { SkillDTO } from './SkillDTO';

export class SkillLevelDTO implements DTO{
    id!: number;
    employee!: EmployeeDTO;
    skill!: SkillDTO;
    score!: number;

    constructor() {
        this.employee = new EmployeeDTO();
        this.skill = new SkillDTO();
    }
}
