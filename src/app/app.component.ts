import { Component } from '@angular/core';
import { ActivatedRoute, Router, RoutesRecognized } from '@angular/router';
import { CurrentRouteService } from './service/routeservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'CV-Generator-Front-End';

  constructor(private route: ActivatedRoute, private router: Router, private  currentRouteService : CurrentRouteService) {
  }

  ngOnInit() {
    this.router.events.subscribe(val => {
      if(val instanceof RoutesRecognized) {
        let couldBeParamMap = val.state.root.firstChild?.paramMap;
        if (couldBeParamMap) {
          this.currentRouteService.addParamMap(couldBeParamMap);
        }
      }
    });
  }
}
