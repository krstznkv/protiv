import { Component, OnInit } from '@angular/core';
import {NaturalFocusOfPlague} from '../../model/natural-focus-of-plague';
import {Station} from '../../model/station';
import {ApiService} from '../../api.service';

@Component({
  selector: 'app-natural-focus-of-plague-rep',
  templateUrl: './natural-focus-of-plague-rep.component.html',
  styleUrls: ['./natural-focus-of-plague-rep.component.css']
})
export class NaturalFocusOfPlagueRepComponent implements OnInit {
  year: number;
  month: number;
  message: string;
  showForm: boolean;
  isButtonEnable: boolean;
  report = {} as NaturalFocusOfPlague;
  station = {} as Station;
  private role: string;
  path = 'naturalFocus';
  modal: boolean;
  constructor(private service: ApiService) { }

  ngOnInit(): void {
    this.role = sessionStorage.getItem('authenticatedUserRole');
    this.station.id =  Number(sessionStorage.getItem('userStationId'));
    this.station.stationName = sessionStorage.getItem('authenticatedUserStation');
  }

  saveReport(report: NaturalFocusOfPlague) {
    this.report = report;
    this.report.month = this.month;
    this.report.year = this.year;
    this.report.station = this.station;
    this.service.saveReport(this.report, this.path).subscribe((data) => {
      this.modal = true; },
      error => console.log('do not save'));
  }

  findReport(year: number, month: number) {
    this.year = year;
    this.month = month;
    this.service.findReportN(this.station.id, this.year, this.month).subscribe((data) => {
        if (data !== null) {
          this.report = data;
          this.isButtonEnable = false;
          this.showForm = true;
        }
        else {
          if (this.isRedactor()) {
            this.isButtonEnable = true;
            this.showForm = true;
          }
          else { this.message = 'К сожалению данные за период отсутсвуют'; }}
      }
    );
  }
  isRedactor(){
    return this.role === 'REDACTOR';
  }

  close() {
    this.modal = false;
  }
}
