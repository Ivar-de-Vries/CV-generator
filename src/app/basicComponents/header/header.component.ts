import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss', '../../styles.scss']
})
export class HeaderComponent implements OnInit {
  loggedIn = false;
  user!: string | null;

  constructor() { }

  ngOnInit(): void {
    if(localStorage.getItem('name') != null) {
      this.loggedIn = true;
      this.user = localStorage.getItem('name');
    }
  }

  logOut() {
    localStorage.clear();
    window.location.reload();
  }
}
