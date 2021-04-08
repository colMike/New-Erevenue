import {ElementRef, Injectable} from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Urls } from './url';
import {Observable} from "rxjs";
import * as FileSaver from 'file-saver';
import * as XLSX from 'xlsx';

const EXCEL_EXTENSION = '.csv';
@Injectable({
  providedIn: 'root'
})
export class AuditTrailService {

  API_URL = new Urls();
  constructor(private http: HttpClient) { }

  /*  updUser (customer) {
      return this.http.post(`${this.API_URL.url}/store` , customer);
    }*/

  gtAudit ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/AuditTrailService/viewAudit_trails`);
  }

  updateAudit(audit):Observable<any> {
    return this.http.put(`${this.API_URL.url}/AuditTrailService/addAudit_trails` ,audit);
  }

  public exportTableElmToExcel(element: ElementRef, fileName: string): void {
    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(element.nativeElement);
    // generate workbook and add the worksheet
    const workbook: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(workbook, ws, 'Sheet1');
    // save to file
    XLSX.writeFile(workbook, `${fileName}${EXCEL_EXTENSION}`);

  }





}
