import {EmployeeDTO} from './EmployeeDTO';
import {LanguageSkillDTO} from './LanguageSkillDTO';
import {LanguageDTO} from './LanguageDTO';
import { DTO } from './DTO';

export class LanguageLevelDTO implements DTO{
  id!: number;
  employee!: EmployeeDTO;
  language!: LanguageDTO;
  speakingLevel!: LanguageSkillDTO;
  readingLevel!: LanguageSkillDTO;
  writingLevel!: LanguageSkillDTO;
}
