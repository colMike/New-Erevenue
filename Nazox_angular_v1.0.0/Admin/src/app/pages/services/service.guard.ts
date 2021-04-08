import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, Router, CanActivate } from '@angular/router';

import { MySharedService } from './sharedService';
import {AuthenticationService} from "../../core/services/auth.service";


@Injectable()
export class ServiceGuard implements CanActivate {
  groups:any;
  rights:any;
  rightId:any;
  groupId:any;
  idright:any;
  constructor(private authService: AuthenticationService, private router: Router, private globalService: MySharedService) {}
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (this.globalService.isAuthenticated) {
      return true;
    }  else if (localStorage.getItem('ucred')) {
      this.globalService.setAuth(true);
      const globalObject = JSON.parse(localStorage.getItem('ucred'));
      console.log(globalObject.groupId, "kwa service guard");
      for(let i=0;i<globalObject.groupId.length;i++) {
        console.log(globalObject.groupId, "globalObject.groupId")

        for(let i=0;i<globalObject.groupId.length;i++){
          console.log(globalObject.groupId.id, "this.part 2.user.id)");

          for (let i = 0; i < globalObject.groupId.length; i++){


            console.log(globalObject.groupId[i].id,"step zero")
          }

          this.rights= globalObject.groupId[i].menus;
          console.log(this.rights,"step 1")
          for(let i=0;i< this.rights.length;i++) {
            console.log(this.rights[i].groups, "this.part 3.user.id)");
            this.globalService.setGroupId(this.rights[i].groups[i].id);
            //this.globalService.setRights(this.rights[i].rights);
            this.rightId = this.rights[i].groups
            for (let i = 0; i < this.rightId.length; i++) {
              console.log(this.rightId[i].rights, "this.part 4.user.id)");
              this.idright=this.rightId[i].rights;
              for (let i = 0; i < this.idright.length; i++){
                this.globalService.setRightId(this.idright[i].rightId);
              }


            }
          }


        }

      }


      this.globalService.setUsername(globalObject.username);
      this.globalService.setRights(this.idright);
      //this.globalService.setGroupId(globalObject.groupId);
     // this.globalService.setRightId(globalObject.rightId);
      console.log(this.globalService,"Last results")
      this.router.navigate(['/']);
    } else {
      this.router.navigate(['/account/login']);
      return false;
    }
  }
}
