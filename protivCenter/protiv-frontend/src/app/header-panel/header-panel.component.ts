import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header-panel',
  templateUrl: './header-panel.component.html',
  styleUrls: ['./header-panel.component.css']
})
export class HeaderPanelComponent implements OnInit {
  activeTab = 'home';
  path1: string;
  path2: string;
  role: string;
  constructor() { }

  ngOnInit(): void {
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

}
