import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {RegistrationComponent} from './registration/registration.component';
import {HomeComponent} from './home/home.component';
import {LogoutComponent} from './logout/logout.component';
import {ReportComponent} from './report/report.component';
import {ApiService} from './api.service';
import {HttpInterceptorService} from './http-interceptor-service';
import { StationReportsComponent } from './station-reports/station-reports.component';
import { StationReportForCenterComponent } from './station-report-for-center/station-report-for-center.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'home', component: HomeComponent},
  {path: 'logout', component: LoginComponent},
  {path: 'report', component: ReportComponent},
  {path: 'station-report', component: StationReportsComponent},
  {path: 'station-report-for-center', component: StationReportForCenterComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomeComponent,
    LogoutComponent,
    ReportComponent,
    StationReportsComponent,
    StationReportForCenterComponent
  ],
  imports: [
    BrowserModule,
    [RouterModule.forRoot(routes)],
    FormsModule,
    HttpClientModule,
  ],
  providers: [ApiService, {provide: HTTP_INTERCEPTORS, useClass: HttpInterceptorService, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
