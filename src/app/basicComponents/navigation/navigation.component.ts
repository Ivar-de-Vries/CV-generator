import { Component, OnInit } from '@angular/core';
import { CurrentRouteService } from 'src/app/service/routeservice.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {
  id!: number;
  constructor( private  currentRouteService : CurrentRouteService) { }

  ngOnInit(): void {
    this.currentRouteService.currentRoutesObservable.subscribe(parammap => {
      this.id = Number(parammap.get('id'));
    });
  }

}
