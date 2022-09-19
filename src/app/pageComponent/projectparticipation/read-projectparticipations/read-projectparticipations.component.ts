import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProjectParticipationDTO } from 'src/app/dto/ProjectParticipationDTO';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import { ProjectparticipationService as ProjectParticipationService } from 'src/app/service/projectparticipation.service';
import { AbstractDelete } from '../../abstractPage/delete-abstract';

@Component({
  selector: 'app-read-projectparticipations',
  templateUrl: './read-projectparticipations.component.html',
  styleUrls: ['./read-projectparticipations.component.scss', '../../../styles.scss']
})
export class ReadProjectparticipationsComponent extends AbstractDelete<ProjectParticipationDTO> implements OnInit {

  constructor(
    projectParticipationService: ProjectParticipationService,
    route: ActivatedRoute,
    errorService: ErrorSubscribeService,
    router: Router
  ) {
    super(projectParticipationService, errorService, route, router, 'projectparticipation');
  }

  getEntityName(entity: ProjectParticipationDTO): string {
    return entity.project.name;
  }
}
