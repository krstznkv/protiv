import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  activeTab = 'home';
  path1: string;
  path2: string;
  role: string;
  constructor() {
    this.role = sessionStorage.getItem('authenticatedUserRole');
    console.log(sessionStorage.getItem('authenticatedUserRole'));
    if (this.role === 'ADMIN'){
      this.path1 = 'station-report-for-center';
      this.path2 = 'natural-focus-center';
    }
    else {
      this.path1 = 'station-report';
      this.path2 = 'natural-focus';
    }
  }

  changeTab(activeTav) {
    this.activeTab = activeTav;
  }

  isAutorise() {
    return (sessionStorage.getItem('authenticatedUser') != null);
  }
}
