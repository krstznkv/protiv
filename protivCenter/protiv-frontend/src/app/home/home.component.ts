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
