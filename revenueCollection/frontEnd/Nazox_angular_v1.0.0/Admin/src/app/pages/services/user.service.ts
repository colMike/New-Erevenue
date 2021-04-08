import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Urls } from './url';
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class UserService {

  API_URL = new Urls();
  constructor(private http: HttpClient) { }

/*  updUser (customer) {
    return this.http.post(`${this.API_URL.url}/store` , customer);
  }*/

  gtUsers ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/UserService/viewUsers`);
  }
  gtUsersGroupType ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/UserService/viewUsersGroupType`);
  }
  getUsersToApprove ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/UserService/viewUsersToApprove`);
  }
  getUsersToApproveDelete ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/UserService/viewUsersToApproveDelete`);
  }
  addUser(user):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/UserService/addUsers`, user);
  }
  updateUser(user):Observable<any> {
    return this.http.put(`${this.API_URL.url}/UserService/updateUsers` ,user);
  }
  approveUser(user):Observable<any> {
    return this.http.put(`${this.API_URL.url}/UserService/approveUser` ,user);
  }
  deleteUser(user):Observable<any> {
    return this.http.put(`${this.API_URL.url}/UserService/deleteUser` ,user);
  }
  approveDeleteUser(user):Observable<any> {
    return this.http.put(`${this.API_URL.url}/UserService/approveDeleteUser` ,user);
  }



}
