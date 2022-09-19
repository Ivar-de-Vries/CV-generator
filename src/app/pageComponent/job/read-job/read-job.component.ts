import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { JobDTO } from 'src/app/dto/JobDTO';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import { JobService } from 'src/app/service/job.service';
import { AbstractDelete } from '../../abstractPage/delete-abstract';

@Component({
  selector: 'app-read-job',
  templateUrl: './read-job.component.html',
  styleUrls: ['./read-job.component.scss', '../../../styles.scss']
})
export class ReadJobComponent extends AbstractDelete<JobDTO> implements OnInit {
  constructor(
    jobService: JobService,
    route: ActivatedRoute,
    errorService: ErrorSubscribeService,
    router: Router
  ) {
    super(jobService, errorService, route, router, 'jobs');
  }

  getEntityName(entity: JobDTO): string {
    return entity.function;
  }
}


