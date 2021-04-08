import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Urls } from './url';
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  API_URL = new Urls();
  constructor(private http: HttpClient) { }


  gtCustomers ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/CustomerService/viewCustomers`);
  }
  getCustomersToApprove ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/CustomerService/viewCustomersToApprove`);
  }
  getCustomersToApproveDelete ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/CustomerService/viewCustomersToApproveDelete`);
  }
  addCustomer(Customer):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/CustomerService/addCustomers`, Customer);
  }
  updateCustomer(Customer):Observable<any> {
    return this.http.put(`${this.API_URL.url}/CustomerService/updateCustomer` ,Customer);
  }
  approveCustomer(Customer):Observable<any> {
    return this.http.put(`${this.API_URL.url}/CustomerService/approveCustomer` ,Customer);
  }
  deleteCustomer(Customer):Observable<any> {
    return this.http.put(`${this.API_URL.url}/CustomerService/deleteCustomer` ,Customer);
  }
  approveDeleteCustomer(Customer):Observable<any> {
    return this.http.put(`${this.API_URL.url}/CustomerService/approveDeleteCustomer` ,Customer);
  }



}
