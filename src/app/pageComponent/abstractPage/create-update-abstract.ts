import { Directive } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DTO } from 'src/app/dto/DTO';
import { HTTPService } from 'src/app/service/abstract_service/HTTPService';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';

@Directive()
export default abstract class AbstractCreateUpdate<T extends DTO>{

  toUpdateObject!: T;
  abstractClassForm! : FormGroup;
  id : number;
  dtoId!: number;
  isCreate! : boolean;

  protected constructor(
    protected httpService : HTTPService<T>,
    private route: ActivatedRoute,
    protected errorService: ErrorSubscribeService,
    protected formBuilder: FormBuilder,
    private router: Router) {
      this.id = Number(this.route.snapshot.paramMap.get('id'));
      this.isCreate = true;
      if(this.route.snapshot.paramMap.has('dtoId')) {
        this.dtoId = Number(this.route.snapshot.paramMap.get('dtoId'));
        this.isCreate = false;
      }
      if(this.isCreate) {
        this.abstractClassForm = this.makeFormGroup(null);
    } else {
      this.httpService.getEntity(this.id, this.dtoId).subscribe({
          next: entity => {
            this.toUpdateObject = entity;
            this.abstractClassForm = this.makeFormGroup(entity);
          },
          error: error => {
            this.errorService.addError(error);
          }
      });
    }
  }
  abstract makeFormGroup(entity : T | null) : FormGroup;

  abstract getEmployeeId(entity: T) : number;

  abstract transformFormGroupIntoObject(formGroup: FormGroup, id : number) : T;

  submit() {
    if(this.abstractClassForm.valid) {
      this.toUpdateObject = this.transformFormGroupIntoObject(this.abstractClassForm, this.id);

      this.toUpdateObject.id = this.dtoId;
      let observable;
      if (this.isCreate) {
        observable = this.httpService.createEntity(this.toUpdateObject);
      } else {
        observable = this.httpService.updateEntity(this.toUpdateObject);
      }
      observable.subscribe({
        next: (createdObject) => {
          this.router.navigateByUrl(`/cv/${this.getEmployeeId(createdObject)}`);
        },
        error: (error) => {
          this.errorService.addError(error);
        }
      });
    }
  }

  goBack() {
    this.router.navigateByUrl(`/cv/${this.id}`);
  }
}

