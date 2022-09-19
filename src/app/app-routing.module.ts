import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CreateEmployeeComponent} from './pageComponent/employee/create-employee/create-employee.component';
import {OverviewComponent} from './pageComponent/overview/overview.component';
import {UpdateEmployeeComponent} from './pageComponent/employee/update-employee/update-employee.component';
import {ReadCertificateComponent} from './pageComponent/certificate/read-certificate/read-certificate.component';
import {CreateUpdateSkillLevelComponent} from './pageComponent/SkillLevel/create-update-skill-level/create-update-skill-level.component';
import {CreateUpdateLanguageComponent} from './pageComponent/language/create-update-language/create-update-language.component';
import {CreateUpdateEducationParticipationComponent} from
'./pageComponent/EducationParticipation/create-update-education-participation/create-update-education-participation.component';
import {CreateUpdateTrainingParticipationsComponent} from './pageComponent/training/create-update-trainingParticipations/create-update-trainingParticipations.component';
import {CreateUpdateCertificateComponent} from './pageComponent/certificate/create-update-certificate/create-update-certificate.component';
import {GenerateCvComponent} from './pageComponent/generate/generate-cv/generate-cv.component';
import {LoginComponent} from './pageComponent/login/login.component';
import {ReadJobComponent} from './pageComponent/job/read-job/read-job.component';
import {CreateUpdateJobComponent} from './pageComponent/job/create-update-job/create-update-job.component';
import { CreateUpdateProjectparticipationsComponent } from './pageComponent/projectparticipation/create-update-projectparticipations/create-update-projectparticipations.component';

const routes: Routes = [
  { path: 'create', component: CreateEmployeeComponent },
  { path: 'cv/:id', component: OverviewComponent },
  { path: 'cv/:id/update', component: UpdateEmployeeComponent },
  { path: 'cv/:id/certificate', component: ReadCertificateComponent},
  { path: 'cv/:id/skill/create', component: CreateUpdateSkillLevelComponent },
  { path: 'cv/:id/skill/:dtoId/update', component: CreateUpdateSkillLevelComponent },
  { path: 'cv/:id/languagelevel/create', component: CreateUpdateLanguageComponent },
  { path: 'cv/:id/languagelevel/:dtoId/update', component: CreateUpdateLanguageComponent },
  { path: 'cv/:id/educationparticipation/create', component: CreateUpdateEducationParticipationComponent },
  { path: 'cv/:id/educationparticipation/:dtoId/update', component: CreateUpdateEducationParticipationComponent },
  { path: 'cv/:id/training/create', component: CreateUpdateTrainingParticipationsComponent},
  { path: 'cv/:id/training/:dtoId/update', component: CreateUpdateTrainingParticipationsComponent},
  { path: 'cv/:id/certificate/create', component: CreateUpdateCertificateComponent },
  { path: 'cv/:id/projectparticipations/create', component: CreateUpdateProjectparticipationsComponent },
  { path: 'cv/:id/projectparticipation/:dtoId/update', component: CreateUpdateProjectparticipationsComponent },
  { path: 'cv/:id/certificate/:dtoId/update', component: CreateUpdateCertificateComponent },
  { path: 'cv/:id/generate', component: GenerateCvComponent},
  { path: 'cv/:id/jobs/create', component: CreateUpdateJobComponent },
  { path: 'cv/:id/jobs/:dtoId/update', component: CreateUpdateJobComponent },
  { path: 'cv/:id/jobs', component: ReadJobComponent},
  { path: '', component: LoginComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
