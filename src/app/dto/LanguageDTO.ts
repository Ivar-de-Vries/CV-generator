import { DTO } from './DTO';

export class LanguageDTO implements DTO{
  id!: number;
  name! : string;
  countryCode! : string;
}
