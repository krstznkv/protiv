import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {ApiService} from '../api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  role;
  username;
  constructor(private  router: Router, private service: ApiService) { }

  ngOnInit(): void {
    this.username = sessionStorage.getItem('authenticatedUser');
    this.service.findUser(this.username).subscribe((data) => {
      this.role = data.message;
      sessionStorage.setItem('authenticatedUserRole', data.message);
      this.service.findUserByUsername(this.username).subscribe((data1) => {
        sessionStorage.setItem('authenticatedUserStation', data1.station.stationName);
        sessionStorage.setItem('userStationId', String(data1.station.id));
      });
      if (this.role === 'ADMIN'){
        this.router.navigate(['/station-report-for-center']);
      } else {
        this.router.navigate(['/station-report']);
      }
    }, error => {

      console.log(error);
    });
  }

}
