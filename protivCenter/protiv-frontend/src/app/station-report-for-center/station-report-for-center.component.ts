import { Component, OnInit } from '@angular/core';
import {EpEx} from '../model/ep-ex';
import {Station} from '../model/station';
import {ApiService} from '../api.service';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-station-report-for-center',
  templateUrl: './station-report-for-center.component.html',
  styleUrls: ['./station-report-for-center.component.css']
})
export class StationReportForCenterComponent implements OnInit {
  role = sessionStorage.getItem('authenticatedUserRole');
  report = {} as EpEx;
  stationObj = {} as Station;
  month = 0;
  year = 0;
  isButtonEnable = false;
  message;
  stations: Station[];
  constructor(private service: ApiService) { }

  ngOnInit(): void {
    this.findAllStation();
  }
  findAllStation(){
    this.service.findAllStations().subscribe((data) => this.stations = data);
  }

  findReport(year: number, month: number, id: number) {
    this.year = year;
    this.month = month;
    this.stationObj.id = id;
    this.service.findReport(this.stationObj.id, this.year, this.month).subscribe((data) => {
        if (data !== null) {
          this.report = data;
        }
        else {
          this.message = 'К сожалению данные за период отсутсвуют'; }
      }
    );
  }

  downloadFile(year: number, month: number) {
    this.service.downloadReportForMonth(year, month).subscribe(data => saveAs(data, 'report' + year + '-' + month + '.xlsx'));
  }
}
