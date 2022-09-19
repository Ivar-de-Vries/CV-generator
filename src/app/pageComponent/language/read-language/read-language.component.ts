import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {LanguageLevelService} from '../../../service/languageLevel.service';
import {LanguageLevelDTO} from '../../../dto/LanguageLevelDTO';
import {TrainingParticipationDTO} from '../../../dto/TrainingParticipationDTO';
import {ErrorSubscribeService} from '../../../service/errorsubscribe.service';
import { AbstractDelete } from '../../abstractPage/delete-abstract';

@Component({
  selector: 'app-read-language',
  templateUrl: './read-language.component.html',
  styleUrls: ['./read-language.component.scss', '../../../styles.scss']
})
export class ReadLanguageComponent extends AbstractDelete<LanguageLevelDTO> implements OnInit {
  constructor(
    languageLevelService: LanguageLevelService,
    route: ActivatedRoute,
    router: Router,
    errorService: ErrorSubscribeService
  ) {
    super(languageLevelService, errorService, route, router, 'languagelevel');
  }

  getEntityName(entity: LanguageLevelDTO): string {
    return entity.language.name;
  }
}
