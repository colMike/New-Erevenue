import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Urls } from './url';
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class RegionService {

  API_URL = new Urls();
  constructor(private http: HttpClient) { }

  /*  updUser (customer) {
      return this.http.post(`${this.API_URL.url}/store` , customer);
    }*/
  gtWard ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/SubcountyService/viewWard`);
  }
  gtWardsBySubCounty(subCountyId):Observable<any> {
    return this.http.get(`${this.API_URL.url}/SubcountyService/gtWardsBySubCounty/`);
  }

  addWard(ward):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/SubcountyService/addWard`, ward);
  }
  gtSubcounty ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/SubcountyService/viewSubCounty`);
  }

  addSubCounty(subCounty):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/SubcountyService/addSubcounty`, subCounty);
  }
  updateSubcounty(subCounty):Observable<any> {
    return this.http.put(`${this.API_URL.url}/SubcountyService/updateSubcounty` ,subCounty);
  }




}
