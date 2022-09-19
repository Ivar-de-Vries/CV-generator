import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TrainingParticipationDTO } from 'src/app/dto/TrainingParticipationDTO';
import { AbstractDelete } from 'src/app/pageComponent/abstractPage/delete-abstract';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import { TrainingParticipationService } from 'src/app/service/trainingparticipation.service';

@Component({
  selector: 'app-read-trainingParticipations',
  templateUrl: './read-trainingParticipations.component.html',
  styleUrls: ['./read-trainingParticipations.component.scss', '../../../styles.scss']
})
export class ReadTrainingParticipationsComponent extends AbstractDelete<TrainingParticipationDTO> implements OnInit {

  constructor(
    trainingParticipationService: TrainingParticipationService,
    route: ActivatedRoute,
    errorService: ErrorSubscribeService,
    router: Router
  ) {
    super(trainingParticipationService, errorService, route, router, 'training');
  }

  getEntityName(entity: TrainingParticipationDTO): string {
    return entity.training.name;
  }
}
