import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Urls } from './url';
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class LandService {

  API_URL = new Urls();
  constructor(private http: HttpClient) { }

  /*  updLand (customer) {
      return this.http.post(`${this.API_URL.url}/store` , customer);
    }*/

  gtLand ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/LandService/viewLand`);
  }
  gtLandToApprove ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/LandService/viewLandToApprove`);
  }
  gtPermitType ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/PermitTypeService/viewPermitType`);
  }
  addLandType(LandType):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/LandTypeService/addLandType`, LandType);
  }
  getLandToApprove ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/LandService/viewLandToApprove`);
  }
  getLandToApproveDelete ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/LandService/viewLandToApproveDelete`);
  }
  addLand(Land):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/LandService/addLand`, Land);
  }

  updateLand(Land):Observable<any> {
    return this.http.put(`${this.API_URL.url}/LandService/updateLand` ,Land);
  }
  approveLand(Land):Observable<any> {
    return this.http.post(`${this.API_URL.url}/LandService/approveLand` ,Land);
  }
  deleteLand(Land):Observable<any> {
    return this.http.put(`${this.API_URL.url}/LandService/deleteLand` ,Land);
  }
  approveDeleteLand(Land):Observable<any> {
    return this.http.put(`${this.API_URL.url}/LandService/approveDeleteLand` ,Land);
  }


  gtinvoice():Observable<any> {
    return this.http.get(`${this.API_URL.url}/LandService/viewLand`);
  }

  addinvoice(invoice):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/LandService/addLand`, invoice );
  }
  renewLand(land):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/LandService/renewLand`, land );
  }

  gtLandToRenew():Observable<any> {
    return this.http.get(`${this.API_URL.url}/LandService/viewLandToRenew`);
  }
}
