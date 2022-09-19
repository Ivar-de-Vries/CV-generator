import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SkillLevelDTO } from 'src/app/dto/SkillLevelDTO';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import { SkillLevelService } from 'src/app/service/skill-level.service';
import { AbstractDelete } from '../../abstractPage/delete-abstract';

@Component({
  selector: 'app-read-skill-level',
  templateUrl: './read-skill-level.component.html',
  styleUrls: ['./read-skill-level.component.scss', '../../../styles.scss']
})

export class ReadSkillLevelComponent extends AbstractDelete<SkillLevelDTO> implements OnInit {
  constructor(
    skillLevelService: SkillLevelService,
    route: ActivatedRoute,
    errorService: ErrorSubscribeService,
    router: Router
    ) {
      super(skillLevelService, errorService, route, router, 'skill');
    }

    getEntityName(entity: SkillLevelDTO): string {
      return entity.skill.name;
    }
}
