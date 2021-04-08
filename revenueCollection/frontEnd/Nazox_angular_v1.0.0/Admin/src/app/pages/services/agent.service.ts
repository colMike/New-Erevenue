import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Urls } from './url';
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class AgentService {

  API_URL = new Urls();
  constructor(private http: HttpClient) { }

  /*  updUser (customer) {
      return this.http.post(`${this.API_URL.url}/store` , customer);
    }*/

  gtAgent ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/agentService/viewAgents`);
  }

  getAgentsToApprove ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/agentService/viewAgentsToApprove`);
  }
  getAgentsToApproveDelete ():Observable<any> {
    return this.http.get(`${this.API_URL.url}/agentService/viewAgentsToApproveDelete`);
  }
  addAgent(agent):Observable<any>  {
    return  this.http.post(`${this.API_URL.url}/agentService/addAgents`, agent);
  }
  updateAgent(agent):Observable<any> {
    return this.http.put(`${this.API_URL.url}/agentService/updateAgent` ,agent);
  }

  approveAgent(agent):Observable<any> {
    return this.http.put(`${this.API_URL.url}/agentService/approveAgent` ,agent);
  }
  deleteAgent(agent):Observable<any> {
    return this.http.put(`${this.API_URL.url}/agentService/deleteAgent` ,agent);
  }
  approveDeleteAgent(agent):Observable<any> {
    return this.http.put(`${this.API_URL.url}/agentService/approveDeleteAgent` ,agent);
  }




}
