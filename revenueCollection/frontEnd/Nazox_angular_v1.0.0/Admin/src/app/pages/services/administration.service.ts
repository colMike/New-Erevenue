import { Urls } from './url';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class AdministrationService {
  API_URL = new Urls();
  headers: { 'Content-Type': 'application/json' };
  constructor(private http: HttpClient) { }

  getUserProfiles() {
    return this.http.get(`${this.API_URL.url}/userGroupService/sysusers`);
  }
  getUserGroups() {
    return this.http.get(`${this.API_URL.url}/userGroupService/usergroups`);
  }

  getGroups() {
    return this.http.get(`${this.API_URL.url}/userGroupService/getGroups`);
  }
  getUserTypes() {
    return this.http.get(`${this.API_URL.url}/userGroupService/usergrouptypes`);
  }
  addUserGroup(userGroup) :Observable<any> {
    return this.http.post(`${this.API_URL.url}/userGroupService/usergroups/assignrights`, userGroup);
  }
  getAllUserMenus() {
    return this.http.get(`${this.API_URL.url}/userGroupService/rightsmenulist`);
  }
  addUserProfile(userProfile) {
    return this.http.post(`${this.API_URL.url}/userGroupService/sysusers/create`, userProfile);
  }

  getUserGroupsByUserType(userTypeId) {
    return this.http.get(`${this.API_URL.url}/userGroupService/user/gtGroupsByUserType/` + userTypeId);
  }


  getUserRightsByUserType(userTypeId) {
    return this.http.get(`${this.API_URL.url}/userGroupService/userGroups/gtRights/` + userTypeId);
  }
  getUserGroupsAndRights():Observable<any> {
    return this.http.get(`${this.API_URL.url}/userGroupService/usergroups/gtUserGroups`);
  }

  getUserGroupRights():Observable<any> {
    return this.http.get(`${this.API_URL.url}/userGroupService/usergroups/gtRights`);
  }


  gtUsernames() {
    return this.http.get(`${this.API_URL.url}/dashboard/stats`);
  }

  getUserMenus(group) :Observable<any>{
    return this.http.get(`${this.API_URL.url}/menuService/menulist/group?groupId=` + group);
  }

  getRolesToApprove ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/userGroupService/viewRolesToApprove`);
  }
  getRolesToApproveDelete ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/userGroupService/viewRolesToApproveDelete`);
  }

  approveRole(group):Observable<any> {
    return this.http.put(`${this.API_URL.url}/UserService/approveUser` ,group);
  }
  deleteRole(group):Observable<any> {
    return this.http.put(`${this.API_URL.url}/UserService/deleteUser` ,group);
  }
  approveDeleteRole(group):Observable<any> {
    return this.http.put(`${this.API_URL.url}/UserService/approveDeleteUser` ,group);
  }

}
