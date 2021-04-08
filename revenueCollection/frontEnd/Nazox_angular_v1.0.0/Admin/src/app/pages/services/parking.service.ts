import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Urls } from './url';
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class ParkingService {

  API_URL = new Urls();
  constructor(private http: HttpClient) { }

  /*  updParkings (customer) {
      return this.http.post(`${this.API_URL.url}/store` , customer);
    }*/

  gtParkings ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/ParkingService/viewParking`);
  }
  getParkingsToApprove ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/ParkingService/viewParkingToApprove`);
  }
  getParkingsToApproveDelete ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/ParkingService/viewParkingToApproveDelete`);
  }
  addParkings(Parkings):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/ParkingService/addParking`, Parkings);
  }
  updateParkings(Parkings):Observable<any> {
    return this.http.put(`${this.API_URL.url}/ParkingService/updateParking` ,Parkings);
  }
  approveParkings(Parkings):Observable<any> {
    return this.http.put(`${this.API_URL.url}/ParkingService/approveparking` ,Parkings);
  }
  deleteParkings(Parkings):Observable<any> {
    return this.http.put(`${this.API_URL.url}/ParkingService/deleteparking` ,Parkings);
  }
  approveDeleteParkings(Parkings):Observable<any> {
    return this.http.put(`${this.API_URL.url}/ParkingService/approveDeleteparking` ,Parkings);
  }

  gtPriceConfig ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/ParkingService/viewPriceConfig`);
  }
  gtCarType ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/ParkingService/viewCartype`);
  }



  addPriceConfig(PriceConfig):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/ParkingService/addPriceConfig`, PriceConfig);
  }
  updatePriceConfig(PriceConfig):Observable<any> {
    return this.http.put(`${this.API_URL.url}/ParkingService/updatePriceConfig` ,PriceConfig);
  }

  addCarType(CarType):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/ParkingService/addCarType`, CarType);
  }
  updateCarType(CarType):Observable<any> {
    return this.http.put(`${this.API_URL.url}/ParkingService/updateCarType` ,CarType);
  }



}
