import { Injectable } from '@angular/core';
import { ParamMap } from '@angular/router';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CurrentRouteService {

  private subject = new Subject<ParamMap>();
  currentRoutesObservable = this.subject.asObservable();

  constructor() { }

  addParamMap(paramMap : ParamMap) {
    this.subject.next(paramMap);
  }
}
