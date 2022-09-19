import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ErrorSubscribeService } from 'src/app/service/errorsubscribe.service';

@Component({
  selector: 'app-error',
  templateUrl: './errormessage.component.html',
  styleUrls: ['./errormessage.component.scss']
})
export class ErrorMessageComponent implements OnInit {
  errorMessages: string[] = [];

  errorSubscription: Subscription | undefined;

  constructor(private errorService: ErrorSubscribeService) { }

  ngOnInit(): void {
    this.errorSubscription = this.errorService.errorObservable.subscribe(errormessage => {
        this.errorMessages.push(errormessage);
    });
  }

  ngOnDestroy() {
    this.errorSubscription?.unsubscribe();
  }

  clearMessage(index : number) {
    this.errorMessages.splice(index, 1);
  }
}


