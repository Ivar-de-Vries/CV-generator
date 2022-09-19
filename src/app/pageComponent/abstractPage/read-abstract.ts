import {  Directive,  OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HTTPService } from 'src/app/service/abstract_service/HTTPService';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';

@Directive()
export abstract class AbstractRead<T = any> implements OnInit {
   id : number;

   values !: T[];

  protected constructor(protected httpService : HTTPService<T>, protected errorService: ErrorSubscribeService, protected route: ActivatedRoute) {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
  }

  ngOnInit(): void {
    this.httpService.getEntities(this.id).subscribe({
      next: information => {
        this.values = information;
      },
      error: (error) => {
        this.errorService.addError(error);
      }
    });
  }

}
