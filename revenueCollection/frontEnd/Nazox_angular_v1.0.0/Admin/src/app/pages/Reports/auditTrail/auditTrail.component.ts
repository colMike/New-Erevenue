import {Component, ElementRef, Inject, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, Validators, FormGroup, FormControl} from '@angular/forms';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import * as $ from "jquery";

import html2canvas from 'html2canvas';


import * as jsPDF from 'jspdf';
import { ToastrService } from 'ngx-toastr';



import { DOCUMENT } from '@angular/common';
import {logger} from "codelyzer/util/logger";
import {first} from "rxjs/operators";
import {UserService} from "../../services/user.service";
import {AuditTrailService} from "../../services/auditTrail.service";
import * as jspdf from "jspdf";



@Component({
  selector: 'app-users',
  templateUrl: './auditTrail.component.html',
  styleUrls: ['./audit.component.scss']
})
export class AuditTrailComponent implements OnInit {

  // breadcrumb items
  /* the table reference */
  @ViewChild('auditTable') auditTable: ElementRef;
  breadCrumbItems: Array<{}>;
  users1: any = [];
  public users: any = [];
  submitted: boolean;
  public response: any = null;
  isAddMode: boolean;
isExisting:boolean;
 userId:any;
  sessionId:any;
  status:any;
  storageObject: any = {};


  userForm: FormGroup;

 // constructor(private modalService: NgbModal, public formBuilder: FormBuilder) { }
  constructor(private toastr: ToastrService,
              private auditSvc: AuditTrailService, @Inject(DOCUMENT) private document: any,public formBuilder: FormBuilder,
              private modalService: NgbModal
             ) {
  }


  ngOnInit():void {

    this.getUsers();
    //this.initAddUser();
   // this.initEditUser();
  /*  this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Users', active: true }];*/

   /* this.userForm = this.formBuilder.group({
      userName: ['', [Validators.required]],
      userFullName: ['', [Validators.required]],
      userPhone: ['', [Validators.required]],
      userEmail: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
      active: ['', [Validators.required]],
      userNationalId: ['', [Validators.required]]
    });
*/
   // this._fetchData();*/
  }


/*  private _fetchData() {
    this.usersData = usersData;
  }*/
initAddUser():void{
  this.isAddMode=true;
  this.isExisting =false;


  this.userForm = this.formBuilder.group({



    userName: ['', [Validators.required]],
    firstname: ['', [Validators.required]],
    lastname: ['', [Validators.required]],
    secondname: ['', [Validators.required]],
    address: ['', [Validators.required]],
    userPhone: ['', [Validators.required]],
    userEmail: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
    active: ['', [Validators.required]],
    userNationalId: ['', [Validators.required]]

  });

}
  /**
   * Returns form
   */
  get form() {
    return this.userForm.controls;
  }
  /**
   * Modal Open
   * @param content modal content
   */
  openModal(content: any) {
    this.isAddMode=true;
    this.modalService.open(content, { centered: true });
  }

  /**
   * save the users data
   */
  exportElmToExcel(): void {
    this.auditSvc.exportTableElmToExcel(this.auditTable, 'Audit Trail data ');
  }

 SavePDF():void{
   let DATA = document.getElementById('auditTable');

   html2canvas(DATA).then(canvas => {

     let fileWidth = 208;
     let fileHeight = canvas.height * fileWidth / canvas.width;

     const FILEURI = canvas.toDataURL('image/png')
     let PDF = new jsPDF('p', 'mm', 'a4');
     let position = 0;
     PDF.addImage(FILEURI, 'PNG', 0, position, fileWidth, fileHeight)

     PDF.save('audit Trail.pdf');
   });

 }





  getUsers(){
  //  this.blockUI.start("Loading data....");
    this.isAddMode=false;
     const session=localStorage.getItem('currentUser');

     this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.users1");
    console.log(this.sessionId.entity,"this.users1");

    this.auditSvc.gtAudit().subscribe(users =>{
     // if(data){
      this.users1 = users;
      console.log(this.users1);
        /*console.log(this.users,"createdNamecreatedNamecreatedName")

        //this.blockUI.stop();
     /!* }
      else{*!/
      for (var i = 0; i <= this.users1.length - 1; i++) {
        console.log(this.users1[i].approved, "this.users1.approved")


        if (this.users1[i].approved === 'N') {

         this.users1[i].approved ==='Pending Approval';
          console.log(this.users1[i].approved,"$$$$$$$$$$$$$$$$$$$$")
        } else {
          this.users1[i].approved === 'Approved';
        }*/
        console.log(JSON.stringify(this.users), "data.message");
        // this.blockUI.stop();
        //return this.toastr.info(data.message);
        //}
      //}
    },()=>{
      console.log("error fetching customers...");
      //this.blockUI.stop();
    })
  }

}
