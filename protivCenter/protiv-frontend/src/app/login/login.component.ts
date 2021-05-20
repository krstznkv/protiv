import {Component, OnInit} from '@angular/core';
import {ApiService} from '../api.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;
  role;
  error;

  constructor(private service: ApiService, private  router: Router) {
  }

  ngOnInit(): void {
    this.role = sessionStorage.getItem('authenticatedUserRole');
  }

  login() {
    this.service.login(this.username, this.password).subscribe(data => {
      this.service.findUser(this.username).subscribe((data1) => {
          this.role = data1.message;
          sessionStorage.setItem('authenticatedUserRole', data1.message); });
      this.router.navigate(['/home']);
      },
      error => {
        if (error.status === 401) {
          this.error = 'Неверный логин или пароль';
        } else {
          this.error = error.message;
        }
        console.log(error);
      });
  }
}
