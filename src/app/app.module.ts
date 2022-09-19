import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ErrorMessageComponent } from './basicComponents/errormessage/errormessage.component';
import { FooterComponent } from './basicComponents/footer/footer.component';
import { HeaderComponent } from './basicComponents/header/header.component';
import { NavigationComponent } from './basicComponents/navigation/navigation.component';
import { DropdownFormComponent } from './dropdown-form/dropdown-form.component';
import { ActionsComponent } from './pageComponent/actions/actions.component';
import { CreateUpdateCertificateComponent } from './pageComponent/certificate/create-update-certificate/create-update-certificate.component';
import { ReadCertificateComponent } from './pageComponent/certificate/read-certificate/read-certificate.component';
import { DownloadComponent } from './pageComponent/download/download.component';
import { CreateUpdateEducationParticipationComponent }
from './pageComponent/EducationParticipation/create-update-education-participation/create-update-education-participation.component';
import { ReadEducationParticipationComponent } from './pageComponent/EducationParticipation/read-educationParticipation/read-educationParticipation.component';
import { CreateEmployeeComponent } from './pageComponent/employee/create-employee/create-employee.component';
import { EmployeeFormComponent } from './pageComponent/employee/employee-form/employee-form.component';
import { ReadEmployeeComponent } from './pageComponent/employee/read-employee/read-employee.component';
import { UpdateEmployeeComponent } from './pageComponent/employee/update-employee/update-employee.component';
import { GenerateCvComponent } from './pageComponent/generate/generate-cv/generate-cv.component';
import { CreateUpdateJobComponent } from './pageComponent/job/create-update-job/create-update-job.component';
import { ReadJobComponent } from './pageComponent/job/read-job/read-job.component';
import { CreateUpdateLanguageComponent } from './pageComponent/language/create-update-language/create-update-language.component';
import { ReadLanguageComponent } from './pageComponent/language/read-language/read-language.component';
import { LoginComponent } from './pageComponent/login/login.component';
import { OverviewComponent } from './pageComponent/overview/overview.component';
import { CreateUpdateProjectparticipationsComponent } from './pageComponent/projectparticipation/create-update-projectparticipations/create-update-projectparticipations.component';
import { ReadProjectparticipationsComponent } from './pageComponent/projectparticipation/read-projectparticipations/read-projectparticipations.component';
import { CreateUpdateSkillLevelComponent } from './pageComponent/SkillLevel/create-update-skill-level/create-update-skill-level.component';
import { ReadSkillLevelComponent } from './pageComponent/SkillLevel/read-skill-level/read-skill-level.component';
import { CreateUpdateTrainingParticipationsComponent } from './pageComponent/training/create-update-trainingParticipations/create-update-trainingParticipations.component';
import { ReadTrainingParticipationsComponent } from './pageComponent/training/read-trainingParticipations/read-trainingParticipations.component';


@NgModule({
  declarations: [
    AppComponent,
    ErrorMessageComponent,
    FooterComponent,
    HeaderComponent,
    NavigationComponent,
    DropdownFormComponent,
    ActionsComponent,
    CreateUpdateCertificateComponent,
    ReadCertificateComponent,
    DownloadComponent,
    CreateUpdateEducationParticipationComponent,
    ReadEducationParticipationComponent,
    CreateEmployeeComponent,
    UpdateEmployeeComponent,
    ReadEmployeeComponent,
    EmployeeFormComponent,
    GenerateCvComponent,
    CreateUpdateLanguageComponent,
    ReadLanguageComponent,
    LoginComponent,
    OverviewComponent,
    CreateUpdateSkillLevelComponent,
    ReadSkillLevelComponent,
    CreateUpdateTrainingParticipationsComponent,
    ReadTrainingParticipationsComponent,
    CreateUpdateJobComponent,
    ReadJobComponent,
    ReadProjectparticipationsComponent,
    CreateUpdateProjectparticipationsComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
