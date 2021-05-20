import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {LogoutComponent} from './logout/logout.component';
import {ApiService} from './api.service';
import {HttpInterceptorService} from './http-interceptor-service';
import { StationReportsComponent } from './reportsForStatation/station-reports/station-reports.component';
import { StationReportForCenterComponent } from './reportForCenter/station-report-for-center/station-report-for-center.component';
import { HomeComponent } from './home/home.component';
import { NaturalFocusOfPlagueRepComponent } from './reportsForStatation/natural-focus-of-plague-rep/natural-focus-of-plague-rep.component';
import { NaturalFocusCenterComponent } from './reportForCenter/natural-focus-center/natural-focus-center.component';
import { HeaderPanelComponent } from './header-panel/header-panel.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'logout', component: LoginComponent},
  {path: 'station-report', component: StationReportsComponent},
  {path: 'station-report-for-center', component: StationReportForCenterComponent},
  {path: 'home', component: HomeComponent},
  {path: 'natural-focus', component: NaturalFocusOfPlagueRepComponent},
  {path: 'natural-focus-center', component: NaturalFocusCenterComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LogoutComponent,
    StationReportsComponent,
    StationReportForCenterComponent,
    HomeComponent,
    NaturalFocusOfPlagueRepComponent,
    NaturalFocusCenterComponent,
    HeaderPanelComponent
  ],
  imports: [
    BrowserModule,
    [RouterModule.forRoot(routes)],
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [ApiService, {provide: HTTP_INTERCEPTORS, useClass: HttpInterceptorService, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
