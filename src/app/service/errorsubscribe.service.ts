import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ErrorSubscribeService {

  private errorSource = new Subject<string>();
  errorObservable = this.errorSource.asObservable();

  constructor() { }

  addError(error: Error) {
    this.errorSource.next(error.message);
  }

}
