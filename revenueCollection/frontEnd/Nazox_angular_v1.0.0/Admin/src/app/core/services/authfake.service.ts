import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { User } from '../models/auth.models';
import {Urls} from "../../pages/services/url";
import {AgentService} from "../../pages/services/agent.service";
import {AdministrationService} from "../../pages/services/administration.service";
import {BlockUI, NgBlockUI} from "ng-block-ui";
import {ToastrService} from "ngx-toastr";
import {MySharedService} from "../../pages/services/sharedService";
import {Router} from "@angular/router";

@Injectable({ providedIn: 'root' })

export class AuthfakeauthenticationService {
  @BlockUI() blockUI: NgBlockUI;
    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;

  API_URL = new Urls();
  response: any;
  menus: any;
  groups:any;
  rights:any;
  rightId:any;
  groupId:any;
  storageObject: any = {};

  user: any = {};


    constructor(private http: HttpClient,  private globalService: MySharedService,private router: Router,private adminSvc: AdministrationService,private toastr: ToastrService) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(JSON.stringify(localStorage.getItem('currentUser'))));
        this.currentUser = this.currentUserSubject.asObservable();

    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    login(userName: string, userPwd: string) {
      console.log(userName,"&&&&&&&&&&&&&&");
      console.log(userPwd,"userpassword");
      //this.users1.userName, this.users1.userPwd
      this.blockUI.start("please wait");
      return this.http.post<any>(`${this.API_URL.url}/LoginService/authenticate`, { userName, userPwd })
            .pipe(map(user => {
              console.log(JSON.parse(JSON.stringify(user.entity)));
              console.log(user.entity.respCode,"&&&&&&&&&&&&&&");
                // login successful if there's a jwt token in the response
               // if (user.entity.respCode==200) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                  //alert("Login Success") ;

                  if (user.entity.respCode==200) {
                    localStorage.setItem('currentUser', JSON.stringify(user));
                    console.log(JSON.stringify(user),"JSON.stringify(user)")
                    //localStorage.setItem('otc', JSON.stringify(user));
                    //console.log(JSON.stringify(user), "JSON.stringify(user)");
                  console.log(user.entity.groupId,"user.entity.groupId")
                    this.currentUserSubject.next(user);
                    this.adminSvc.getUserMenus(user.entity.groupId).subscribe(resp => {
                     this.blockUI.stop();
                      this.menus = resp;
                      console.log(resp,"resp");
                      if (this.menus.status === false) {
                        this.storageObject.username = this.user.username;
                        console.log( this.storageObject.username, " this.storageObject.username")
                      //  this.storageObject.rightId = this.response.model.id;
                        this.storageObject.rights = this.menus.collection;

                        console.log(this.menus.user, "this.menus.groups")
                        for(let i=0;i<this.menus.user.length;i++) {
                          console.log(this.menus.user[i].menus, "this.gggggg.user.id)");
                          this.groups=this.menus.user[i].menus;
                          console.log(this.groups)
                          for(let i=0;i<this.groups.length;i++){
                            console.log(this.groups[i].groups, "this.part 2.user.id)");
                           this.groupId= this.groups[i].groups;
                            for (let i = 0; i < this.groupId.length; i++){
                              this.globalService.setGroupId(this.groupId[i].id);
                            }

                            this.rights= this.groups[i].groups;
                            for(let i=0;i< this.rights.length;i++) {
                              console.log(JSON.stringify(this.rights[i].rights), "this.part 3.user.id)");
                              this.globalService.setRights(this.rights[i].rights);
                              this.rightId = this.rights[i].rights
                              for (let i = 0; i < this.rightId.length; i++) {
                                console.log(this.rightId[i].rightId, "this.part 4.user.id)");
                                this.globalService.setRightId(this.rightId[i].rightId);
                              }
                            }


                          }

                        }
                        console.log(this.menus.user.group,"this.menus.user.id)");
                        console.log(this.user.username,"this.user.username)");
                        console.log( this.menus.collection," this.menus.collection");
                        this.storageObject.groupId = this.menus.user;
                        console.log( "EEEEEE", localStorage.getItem('ucred'))

                        localStorage.setItem('ucred', JSON.stringify(this.storageObject));
                        console.log( "EEEEEE", localStorage.getItem('ucred'))
                       this.globalService.setAuth(true);




                        this.globalService.setUsername(user.entity.username);

                        console.log(this.globalService,"lets try")

                        this.router.navigate(['/']);
                      } else {
                        this.storageObject.username = this.user.username;
                        this.storageObject.rightId = this.response.model.id;
                        this.storageObject.rights = this.menus.collection;
                        this.storageObject.groupId = this.response.model.group;
                        localStorage.setItem('otc', JSON.stringify(this.storageObject));
                        this.globalService.setAuth(true);
                        this.globalService.setRightId(this.response.model.id);
                        this.globalService.setGroupId(this.response.model.group);
                        this.globalService.setUsername(this.user.username);
                        this.globalService.setRights(this.menus.collection);
                        this.router.navigate(['/dashboard']);
                        return this.toastr.warning(this.menus.respMessage, 'Alert!', { timeOut: 1500 });
                      }

                //}
             /*   else if(user.entity.respCode==201){

                  alert("Invalid Credetials Please try again") ;
                  return user;
                }
                return user;*/
            })
                  }else {

                    return this.toastr.warning('Invalid Username or Password', 'Alert!', {timeOut: 1500});
                  }
            }));
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');

      localStorage.removeItem('ucred');
        this.currentUserSubject.next(null);
    }
}
