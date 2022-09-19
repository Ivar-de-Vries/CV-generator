import { Observable } from 'rxjs';

export interface HTTPService<T = any> {
  getEntity(userId: number, dtoId: number) : Observable<T>;
  deleteEntity(toDeleteEntity: T) : Observable<void>;
  getEntities(id: number) : Observable<T[]>;
  createEntity(entity: T) : Observable<T>;
  updateEntity(entity: T) : Observable<T>;
}
