import { DTO } from './DTO';

export class EmployeeDTO implements DTO{
    id!: number;
    emailAddress!: string;
    firstname!: string;
    lastname!: string;
    gender!: string;
    birthdate!: Date;
    city!: string;
    driverLicense!: boolean;
    description!: string;
}
