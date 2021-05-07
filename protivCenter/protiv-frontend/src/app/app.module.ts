import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {RegistrationComponent} from './registration/registration.component';
import {LogoutComponent} from './logout/logout.component';
import {ApiService} from './api.service';
import {HttpInterceptorService} from './http-interceptor-service';
import { StationReportsComponent } from './station-reports/station-reports.component';
import { StationReportForCenterComponent } from './station-report-for-center/station-report-for-center.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'logout', component: LoginComponent},
  {path: 'station-report', component: StationReportsComponent},
  {path: 'station-report-for-center', component: StationReportForCenterComponent},
  {path: 'home', component: HomeComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    LogoutComponent,
    StationReportsComponent,
    StationReportForCenterComponent,
    HomeComponent
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
