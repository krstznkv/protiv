import { Component, OnInit } from '@angular/core';
import {EpEx} from '../../model/ep-ex';
import {Station} from '../../model/station';
import {ApiService} from '../../api.service';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-station-report-for-center',
  templateUrl: './station-report-for-center.component.html',
  styleUrls: ['./station-report-for-center.component.css']
})
export class StationReportForCenterComponent implements OnInit {
  report = {} as EpEx;
  stationObj = {} as Station;
  month = 0;
  year = 0;
  isButtonEnable = false;
  message;
  showForm;
  stations: Station[];
  stNone = {} as  Station[];
  constructor(private service: ApiService) { }
  path = 'ExEp';
  ngOnInit(): void {
    this.findAllStation();
  }
  findAllStation(){
    this.service.findAllStations().subscribe((data) => this.stations = data);
  }

  findReport(year: number, month: number, id: number) {
    this.stNone = null;
    this.year = year;
    this.month = month;
    this.stationObj.id = id;
    this.service.findReport(this.stationObj.id, this.year, this.month).subscribe((data) => {
        if (data !== null && data.approveByDirector) {
          this.report = data;
          this.showForm = true;
          this.message = null;
        }
        else {
          this.showForm = false;
          this.message = 'К сожалению данные за период отсутсвуют'; }
      }
    );
  }
    findStationWithoutReport(year: number, month: number){
    this.service.findStationWithoutReport(year, month, this.path).subscribe((data) =>
    {
        this.stNone = data;
    });
  }
  downloadFile(year: number, month: number) {
    this.stNone = null;
    this.service.downloadReportForMonth(year, month, this.path).subscribe((data) => saveAs(data, 'report' + year + '-' + month + '.xlsx'),
      (error) =>
      {this.message = 'Невозможно сформировать отчет. Отсутствуют данные по следующим станциям:';
       this.findStationWithoutReport(year, month);
      }
    );
  }
}
