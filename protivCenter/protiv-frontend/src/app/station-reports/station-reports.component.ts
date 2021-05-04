import { Component, OnInit } from '@angular/core';
import {EpEx} from '../model/ep-ex';
import {ApiService} from '../api.service';
import {Station} from '../model/station';

@Component({
  selector: 'app-station-reports',
  templateUrl: './station-reports.component.html',
  styleUrls: ['./station-reports.component.css']
})
export class StationReportsComponent implements OnInit {
  role = sessionStorage.getItem('authenticatedUserRole');
  station = sessionStorage.getItem('authenticatedUserStation');
  stationId = Number(sessionStorage.getItem('userStationId'));
  report = {} as EpEx;
  stationObj = {} as Station;
  month = 0;
  year = 0;
  isButtonEnable = false;
  message;
  constructor(private service: ApiService) { }

  ngOnInit(): void {
    this.role = sessionStorage.getItem('authenticatedUserRole');
    this.station = sessionStorage.getItem('authenticatedUserStation');
    this.stationId =  Number(sessionStorage.getItem('userStationId'));
  }
  saveReport(report) {
    this.report = report;
    this.report.month = this.month;
    this.report.year = this.year;
    this.stationObj.id = this.stationId;
    this.report.station = this.stationObj;
    this.service.saveReport(this.report).subscribe((data) => console.log(data)
    , error => console.log('do not save'));
  }

  findReport(year: number, month: number) {
    this.year = year;
    this.month = month;
    this.service.findReport(this.stationId, this.year, this.month).subscribe((data) => {
      if (data !== null) {
        this.report = data;
        this.isButtonEnable = false;
      }
      else {
        if (this.isRedactor()) {
        this.isButtonEnable = true;
      }
      else { this.message = 'К сожалению данные за период отсутсвуют'; }}
      }
    );
  }
  isRedactor(){
    return this.role === 'REDACTOR';
  }
}
