import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Urls } from './url';
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class PermitService {

  API_URL = new Urls();
  constructor(private http: HttpClient) { }

  /*  updPermit (customer) {
      return this.http.post(`${this.API_URL.url}/store` , customer);
    }*/

  gtPermit ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/PermitService/viewPermit`);
  }
  gtPermitToApprove ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/PermitService/viewPermitToApprove`);
  }
  gtPermitType ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/PermitTypeService/viewPermitType`);
  }
  addPermitType(PermitType):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/PermitTypeService/addPermitType`, PermitType);
  }
  getPermitToApprove ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/PermitService/viewPermitToApprove`);
  }
  getPermitToApproveDelete ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/PermitService/viewPermitToApproveDelete`);
  }
  addPermit(Permit):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/PermitService/addPermit`, Permit);
  }
  renewPermit(Permit):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/PermitService/renewPermit`, Permit);
  }
  updatePermit(Permit):Observable<any> {
    return this.http.put(`${this.API_URL.url}/PermitService/updatePermit` ,Permit);
  }
  approvePermit(Permit):Observable<any> {
    return this.http.post(`${this.API_URL.url}/PermitService/approvePermit` ,Permit);
  }
  deletePermit(Permit):Observable<any> {
    return this.http.put(`${this.API_URL.url}/PermitService/deletePermit` ,Permit);
  }
  approveDeletePermit(Permit):Observable<any> {
    return this.http.put(`${this.API_URL.url}/PermitService/approveDeletePermit` ,Permit);
  }


  gtinvoice():Observable<any> {
    return this.http.get(`${this.API_URL.url}/PermitService/viewPermit`);
  }

  addinvoice(invoice):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/PermitService/addPermit`, invoice );
  }

  gtPermitToRenew():Observable<any> {
    return this.http.get(`${this.API_URL.url}/PermitService/viewPermitToRenew`);
  }
}
