import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from './registration/model/user';
import {map} from 'rxjs/operators';
import {RequestT} from './model/requestT';
import {Ticket} from './model/ticket';
import {AirlineTop} from './model/airline-top';
import {Message} from './model/message';
import {EpEx} from './model/ep-ex';
import {Station} from './model/station';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  username: string;
  password: string;
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';
  USER_PASSWORD_SESSION_ATTRIBUTE_PASSWORD = 'authenticatedUserPassword';
  USER_ROLE_SESSION_ATTRIBUTE_ROLE = 'authenticatedUserRole';
  USER_STATION_ATTRIBUTE_STATION = 'authenticatedUserStation';
  USER_STATION_ID = 'userStationId';


  constructor(private client: HttpClient) {
  }

  login(username: string, password: string) {
    return this.client.get('http://localhost:8080/login',
      {headers: {authorization: this.createBasicAuthToken(username, password)}}).pipe(map(() => {
      this.username = username;
      this.password = password;
      sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username);
      sessionStorage.setItem(this.USER_PASSWORD_SESSION_ATTRIBUTE_PASSWORD, password);
      this.findUser(this.username).subscribe((data) => {
        console.log(data);
        sessionStorage.setItem(this.USER_ROLE_SESSION_ATTRIBUTE_ROLE, data.message);
       }, error => {

        console.log(error);
      });
      this.findUserByUsername().subscribe((data) => {
        console.log(data.station);
        sessionStorage.setItem(this.USER_STATION_ATTRIBUTE_STATION, data.station.stationName);
        sessionStorage.setItem(this.USER_STATION_ID, String(data.station.id));
        console.log(sessionStorage.getItem('userStationId'));
      }, error => {

        console.log(error);
      });
    }));
  }
  findUser(username){
    return this.client.post<Message>('http://localhost:8080/findUser', username);
  }
  findUserByUsername(){
    return this.client.post<User>('http://localhost:8080/findUserByUsername', this.username);
  }
  createBasicAuthToken(username: string, password: string) {
    return 'Basic ' + window.btoa(username + ':' + password);
  }

  registration(user: User) {
    return this.client.post<User>('http://localhost:8080/registration', user);
  }

  isUserLoggedIn() {
    const user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    return user !== null;
  }

  logout() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    sessionStorage.removeItem(this.USER_ROLE_SESSION_ATTRIBUTE_ROLE);
    sessionStorage.removeItem(this.USER_STATION_ID);
    sessionStorage.removeItem(this.USER_STATION_ATTRIBUTE_STATION);
    sessionStorage.clear();
    this.username = null;
    this.password = null;
  }
  saveReport(report: EpEx){
    return this.client.post<EpEx>('http://localhost:8080/saveReport', report);
  }
  findReport(id: number, year: number, month: number){
    return this.client.get<EpEx>('http://localhost:8080/findReport/' + id + '/' + year + '/' + month );
  }
  findAllStations(){
    return this.client.get<Station[]>('http://localhost:8080/findAllStations/');
  }
  downloadReportForMonth(year: number, month: number): Observable<Blob> {
    return this.client.get('http://localhost:8080/findAllReport/' + year + '/' + month,
    {responseType: 'blob'});
  }
}
