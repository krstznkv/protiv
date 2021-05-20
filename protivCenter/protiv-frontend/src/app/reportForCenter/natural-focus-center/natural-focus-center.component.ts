import { Component, OnInit } from '@angular/core';
import {ApiService} from '../../api.service';
import {Station} from '../../model/station';
import {saveAs} from 'file-saver';
import {NaturalFocusOfPlague} from '../../model/natural-focus-of-plague';

@Component({
  selector: 'app-natural-focus-center',
  templateUrl: './natural-focus-center.component.html',
  styleUrls: ['./natural-focus-center.component.css']
})
export class NaturalFocusCenterComponent implements OnInit {
   stations: Station[];
  report = {} as NaturalFocusOfPlague;
  stationObj = {} as Station;
  month = 0;
  year = 0;
  message;
  path = 'naturalFocus';
  isButtonEnable: false;
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
    this.message = '';
    this.service.findReportN(this.stationObj.id, this.year, this.month).subscribe((data) => {
        if (data !== null) {
          this.report = data;
        }
        else {
          this.message = 'К сожалению данные за период отсутсвуют'; }
      }
    );
  }

  downloadFile(year: number, month: number) {
    this.service.downloadReportForMonth(year, month, this.path).subscribe(data => saveAs(data, 'report' + year + '-' + month + '.xlsx'));
  }
}
