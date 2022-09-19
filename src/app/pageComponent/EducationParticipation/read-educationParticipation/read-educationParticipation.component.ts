import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EducationParticipationDTO } from 'src/app/dto/EducationParticipationDTO';
import { EducationParticipationService } from 'src/app/service/educationparticipation.service';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import { AbstractDelete } from '../../abstractPage/delete-abstract';


@Component({
  selector: 'app-read-educationParticipation',
  templateUrl: './read-educationParticipation.component.html',
  styleUrls: ['./read-educationParticipation.component.scss', '../../../styles.scss']
})
export class ReadEducationParticipationComponent extends AbstractDelete<EducationParticipationDTO> implements OnInit {

  constructor(
    educationParticipationService: EducationParticipationService,
    route: ActivatedRoute,
    errorService: ErrorSubscribeService,
    router: Router
    ) {
      super(educationParticipationService, errorService, route, router, 'educationparticipation');
    }

  getEntityName(entity: EducationParticipationDTO): string {
    return entity.education.name;
  }
}

