import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AuthenticationService } from '../../../core/services/auth.service';
import { AuthfakeauthenticationService } from '../../../core/services/authfake.service';

import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';
import {ToastrService} from "ngx-toastr";
import { environment } from '../../../../environments/environment';
import {AdministrationService} from "../../../pages/services/administration.service";
import {BlockUI, NgBlockUI} from "ng-block-ui";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  @BlockUI() blockUI: NgBlockUI;

  loginForm: FormGroup;
  public users1: any = [];
  submitted = false;
  error = '';
  returnUrl: string;

  // set the currenr year
  year: number = new Date().getFullYear();

  // tslint:disable-next-line: max-line-length
  constructor(private toastr: ToastrService,private formBuilder: FormBuilder, private route: ActivatedRoute, private router: Router, public authenticationService: AuthenticationService, public authFackservice: AuthfakeauthenticationService) { }

  ngOnInit() {
    document.body.removeAttribute('data-layout');
    document.body.classList.add('auth-body-bg');

    this.loginForm = this.formBuilder.group({
      userName: ['', [Validators.required]],
      userPwd: ['', [Validators.required]],
    });

    // reset login status
    // this.authenticationService.logout();
    // get return url from route parameters or default to '/'
    // tslint:disable-next-line: no-string-literal
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  // convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }

  /**
   * Form submit
   */
  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    this.users1 = this.loginForm.value;
    if (this.users1.userName === '') {
      return this.toastr.warning('Please specify the user name', 'Alert!', { timeOut: 1500 });
    }
    if (this.users1.userPwd === '') {
      return this.toastr.warning('Please specify the password', 'Alert!', { timeOut: 1500 });
    }

    this.users1.userName = this.loginForm.get('userName').value;
    this.users1.userPwd = this.loginForm.get('userPwd').value;
    console.log( this.users1.userName ,"################")
   // console.log( this.users1.userPwd ,"+++++++++++++")
    if (this.loginForm.invalid) {
      console.log("response..................")
      return;
      //return this.toastr.warning('Invalid Username orrrrrrrrrrrrrr password', 'Alert!', { timeOut: 1500 });
    } else {
      if (environment.defaultauth === 'firebase') {
        console.log("response..................")
        this.blockUI.start("please wait");
        this.authenticationService.login(this.users1.userName, this.users1.userPwd).then((res: any) => {
          this.blockUI.stop();
          console.log(res,"response..................")
          this.router.navigate(['/']);
        })
          .catch(error => {
            this.error = error ? error : '';
          });
      } else {
        console.log("response...............jyug");
        this.blockUI.start("please wait");
        this.authFackservice.login(this.users1.userName, this.users1.userPwd)
          .pipe(first())
          .subscribe(
            data => {
              this.blockUI.stop();
              console.log("response...............second",data)
             // this.router.navigate(['/']);
            },
            error => {
              this.error = error ? error : '';
            });
      }
    }
  }

}
