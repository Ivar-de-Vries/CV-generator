import { Component, OnInit, ViewChild, ElementRef, ComponentFactoryResolver } from '@angular/core';
import { CertificateDTO } from 'src/app/dto/CertificateDTO';
import { EducationParticipationDTO } from 'src/app/dto/EducationParticipationDTO';
import { EmployeeDTO } from 'src/app/dto/EmployeeDTO';
import { LanguageLevelDTO } from 'src/app/dto/LanguageLevelDTO';
import { ProjectDTO } from 'src/app/dto/ProjectDTO';
import { SkillLevelDTO } from 'src/app/dto/SkillLevelDTO';
import { TrainingParticipationDTO } from 'src/app/dto/TrainingParticipationDTO';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import { CertificateService } from 'src/app/service/certificate.service';
import { EducationParticipationService } from 'src/app/service/educationparticipation.service';
import { EmployeeService } from 'src/app/service/employee.service';
import { LanguageLevelService } from 'src/app/service/languageLevel.service';
import { ActivatedRoute } from '@angular/router';
import { SkillLevelService } from 'src/app/service/skill-level.service';
import { TrainingParticipationService } from 'src/app/service/trainingparticipation.service';
import { JobService } from 'src/app/service/job.service';
import { JobDTO } from 'src/app/dto/JobDTO';
import { ProjectParticipationDTO } from 'src/app/dto/ProjectParticipationDTO';
import { ProjectparticipationService } from 'src/app/service/projectparticipation.service';

@Component({
  selector: 'app-generate-cv',
  templateUrl: './generate-cv.component.html',
  styleUrls: ['./generate-cv.component.scss']
})

export class GenerateCvComponent implements OnInit {
  userId!: number;
  employee!: EmployeeDTO;
  educationParticipation!: EducationParticipationDTO[];
  certificate!: CertificateDTO[];
  trainingParticipations!: TrainingParticipationDTO[];
  languages!: LanguageLevelDTO[];
  skillLevels!: SkillLevelDTO[];
  projects!: ProjectParticipationDTO[];
  currentJob!: string;
  jobs!: JobDTO[];


  constructor(
    private certificateService: CertificateService,
    private route: ActivatedRoute,
    private errorService: ErrorSubscribeService,
    private educationParticipationService: EducationParticipationService,
    private employeeService: EmployeeService,
    private languageLevelService: LanguageLevelService,
    private skillLevelService: SkillLevelService,
    private trainingParticipationService: TrainingParticipationService,
    private jobService: JobService,
    private projectParticipationService: ProjectparticipationService
  ) {
  }

  ngOnInit(): void {
    this.userId = Number(this.route.snapshot.paramMap.get('id'));
    let observable = this.certificateService.getEntities(this.userId);
    observable.subscribe({
      next: certificate => {
        this.certificate = certificate;
      },
      error: (error) => {
        this.errorService.addError(error);
      }
    });
    this.educationParticipationService.getEntities(this.userId).subscribe({
      next: educationParticipation => {
        this.educationParticipation = educationParticipation;
      },
      error: (error) => {
        this.errorService.addError(error);
      }
    });
    this.employeeService.getEmployee(this.userId).subscribe({
      next: employee => {
        this.employee = employee;
      },
      error: (error) => {
        this.errorService.addError(error);
      }
    });
    this.languageLevelService.getEntities(this.userId).subscribe({
      next: languages => {
        this.languages = languages;
      },
      error: (error) => {
        this.errorService.addError(error);
      }
    });
    this.skillLevelService.getEntities(this.userId).subscribe({
      next: skillLevels => {
        this.skillLevels = skillLevels;
      },
      error: (error) => {
        this.errorService.addError(error);
      }
    });
    this.trainingParticipationService.getEntities(this.userId).subscribe({
      next: training => {
        this.trainingParticipations = training;
      },
      error: (error) => {
        this.errorService.addError(error);
      }
    });
    this.projectParticipationService.getEntities(this.userId).subscribe({
      next: project => {
        this.projects = project;
      },
      error: (error) => {
        this.errorService.addError(error);
      }
    });
    this.jobService.getEntities(this.userId).subscribe({
      next: job => {
        this.jobs = job;
      },
      error: (error) => {
        this.errorService.addError(error);
      }
    });
  }

  displayGender(): string {
    switch (this.employee.gender) {
      case 'M':
        return 'Man';
      case 'F':
        return 'Vrouw';
      default:
        return 'Overig';
    }
  }

  displayDriverLicense(): string {
    if (this.employee.driverLicense) {
      return 'B';
    }
    return '-';
  }

  showBirthdate(): string {
    return this.employee.birthdate.toLocaleDateString();
  }

  toRating(getal: number) {
    const maxRating = 5;
    let i = 1;
    // Somehow the css has no effect
    let size = 15;
    let filled = ` <img class='actionIcon' src='assets/svg/circle_black_24dp.svg' height='${size}px' width='${size}px' alt='X' > `;
    let empty = ` <img class='actionIcon' src='assets/svg/circle_black_24dp_empty.svg' height='${size}px' width='${size}px' alt='X' > `; //' &#x25CB '

    let returnString = '';
    for (i; i <= maxRating; i++) {
      if (i > getal) {
        returnString = returnString + empty;
      } else {
        returnString = returnString + filled;
      }
    }

    return returnString;
  }

  calculateEndDate(endDate: Date | undefined) {
    if (endDate === undefined) {
      return 'heden';
    } else {
      return endDate.getFullYear();
    }
  }
}
