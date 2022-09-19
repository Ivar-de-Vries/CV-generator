import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.scss']
})
export class OverviewComponent implements OnInit {
  correctId = false;

  constructor(private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    const userId = Number(localStorage.getItem('id'));
    if(localStorage.getItem('id') == null){
      this.router.navigateByUrl('/create').then(r => window.location.reload());
    } else if(localStorage.getItem('ROLE_ADMIN') != null){
      this.correctId = true;
    } else if(id !== userId){
      this.router.navigateByUrl(`/cv/${id}`).then(r => window.location.reload());
    } else {
      this.correctId = true;
    }
  }

}
