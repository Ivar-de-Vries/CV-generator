import { DTO } from './DTO';
import { InstituteDTO } from './InstituteDTO';

export class EducationDTO implements DTO{
    id!: number;
    name!: string;
    institute!: InstituteDTO;

    constructor() {
        this.institute = new InstituteDTO;
      }
}
