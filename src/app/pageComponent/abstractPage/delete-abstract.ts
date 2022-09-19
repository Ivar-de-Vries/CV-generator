import { Directive } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DTO } from 'src/app/dto/DTO';
import { HTTPService } from 'src/app/service/abstract_service/HTTPService';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';
import { AbstractRead } from './read-abstract';

@Directive()
export abstract class AbstractDelete<T extends DTO> extends AbstractRead<T> {


  protected constructor(
      httpService : HTTPService<T>,
      errorService : ErrorSubscribeService,
      route: ActivatedRoute,
      protected router: Router,
      protected componentAdress: string) {
    super(httpService, errorService, route);
  }


  delete(toDeleteEntity : T ) {
    let result = confirm(`Weet u zeker dat u dit gegeven \'${this.getEntityName(toDeleteEntity)}\' uit uw CV wil verwijderen?`);
    if (result) {
      this.httpService.deleteEntity(toDeleteEntity).subscribe({
        next: () => {
          this.values = this.values.filter((item) => item.id !== toDeleteEntity.id);
        },
        error: (error) => {
          this.errorService.addError(error);
        }
      });
    }
  }

  updateNavigation(entity: T) {
    this.router.navigateByUrl(`/cv/${this.id}/${this.componentAdress}/${entity.id}/update`);
  }

  abstract getEntityName(entity: T): string;
}
