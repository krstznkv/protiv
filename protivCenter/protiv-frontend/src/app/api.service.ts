import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from './model/user';
import {map} from 'rxjs/operators';
import {Message} from './model/message';
import {EpEx} from './model/ep-ex';
import {Station} from './model/station';
import {Observable} from 'rxjs';
import {NaturalFocusOfPlague} from './model/natural-focus-of-plague';
import {Report} from './model/report';

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
  URL = 'http://localhost:8080/';

  constructor(private client: HttpClient) {
  }

  login(username: string, password: string) {
    return this.client.get(this.URL + 'login',
      {headers: {authorization: this.createBasicAuthToken(username, password)}}).pipe(map(() => {
      this.username = username;
      this.password = password;
      sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username);
      sessionStorage.setItem(this.USER_PASSWORD_SESSION_ATTRIBUTE_PASSWORD, password);
    }));
  }
  findUser(username){
    return this.client.post<Message>(this.URL + 'findUser', username);
  }
  findUserByUsername(username){
    return this.client.post<User>(this.URL + 'findUserByUsername', username);
  }
  createBasicAuthToken(username: string, password: string) {
    return 'Basic ' + window.btoa(username + ':' + password);
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
  saveReport(report: Report, path: string){
    return this.client.post<Report>(this.URL  + path + '/saveReport', report);
  }
  findReport(id: number, year: number, month: number){
    return this.client.get<EpEx>(this.URL + 'ExEp/findReport/' + id + '/' + year + '/' + month );
  }
  findAllStations(){
    return this.client.get<Station[]>(this.URL + 'findAllStations/');
  }
  downloadReportForMonth(year: number, month: number, path: string): Observable<Blob> {
    return this.client.get(this.URL + path + '/findAllReport/' + year + '/' + month,
    {responseType: 'blob'});
  }
  findReportN(id: number, year: number, month: number){
    return this.client.get<NaturalFocusOfPlague>(this.URL + 'naturalFocus/findReport/' + id + '/' + year + '/' + month );
  }
  findStationWithoutReport(year: number, month: number, path: string){
    return this.client.get<Station[]>(this.URL + path + '/findStationWithoutReport/' + year + '/' + month);
  }
}
