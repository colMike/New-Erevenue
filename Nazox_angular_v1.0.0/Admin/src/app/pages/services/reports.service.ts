import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Urls } from './url';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ReportsService {
  API_URL = new Urls();
  EXP_API = 'erevenue/reports?';
  constructor(private http: HttpClient) { }

  getCustomerPreview(fromDate, toDate, custStatus) {
    return  this.http.get(`${this.API_URL.url}/customers/report?fromDate=${fromDate}&toDate=${toDate}&status=${custStatus}`);
  }

/*  getPdfCustomerReport(fromDt, toDt) {
    return  this.http.get(`${this.EXP_API}reportType=BD&exportType=P&FromDt=${fromDt}&ToDt=${toDt}`);
  }

  getExcelCustomerReport(fromDt, toDt) {
    return  this.http.get(`${this.EXP_API}reportType=BD&exportType=E&FromDt=${fromDt}&ToDt=${toDt}`);
  }

 /!* getCsvCustomerReport(fromDt, toDt) {
    return  this.http.get(`${this.EXP_API}reportType=BD&exportType=C&FromDt=${fromDt}&ToDt=${toDt}`);
  }*!/*/
  printInvoice (businnessNo, paidUser,appliedFor)  {
    console.log("......Here 2")
    return this.http.get(`${this.API_URL.url}/erevenue/reports?type=I&businnessNo= ${businnessNo}'&paidUser=${paidUser}&appliedFor=${appliedFor}`);
  }

}
