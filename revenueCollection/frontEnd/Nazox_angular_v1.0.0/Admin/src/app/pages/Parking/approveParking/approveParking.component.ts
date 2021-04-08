import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, Validators, FormGroup, FormControl} from '@angular/forms';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';

import { DOCUMENT } from '@angular/common';
import {logger} from "codelyzer/util/logger";
import {first} from "rxjs/operators";
import {UserService} from "../../services/user.service";
import {ParkingService} from "../../services/parking.service";
import {RegionService} from "../../services/region.service";


@Component({
  selector: 'app-users',
  templateUrl: './approveParking.component.html'

})
export class approveParkingComponent implements OnInit {

  breadCrumbItems: Array<{}>;
  public Parkings1: any = [];
  public price1: any = [];
  public car1:any=[];
  public region1:any=[];
  public Parkings: any = [];
  submitted: boolean;
  public response: any = null;
  isAddMode: boolean;
  isExisting:boolean;
  serviceId:any;
  sessionId:any;
  status:any;

  //usersData: users[];
  priceForm: FormGroup;

  // constructor(private modalService: NgbModal, public formBuilder: FormBuilder) { }
  constructor(private toastr: ToastrService,private regionSvc:RegionService,
              private parkingSvc: ParkingService, @Inject(DOCUMENT) private document: any,public formBuilder: FormBuilder,
              private modalService: NgbModal
  ) {
  }

  Reject(){
    //this.price1.userId=this.users.userId;
    // this.price1.userId = this.userForm.get('price1').value;

    //this.price1.userId=this.userId;


    console.log( this.price1.userId, " this.price1.userId")
    this.price1.approved = 'R';

    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.price1");
    console.log(this.sessionId.entity,"this.price1");

    this.price1.approvedBy=this.sessionId.entity.userId;

    console.log(this.price1.createdBy, "users @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2")
    for (var i = 0; i <= this.price1.length - 1; i++) {
      if (this.price1[i].createdBy === this.price1.approvedBy) {

        return this.toastr.warning('User creator cannot reject a user he/she created', ' Warning!', {timeOut: 3000});

        //this.getUsers();
        //this.router.navigate(['/']);

      }
    }
    const user2 = {
      'id': this.price1.id,
      'approved':this.price1.approved,
      'approvedBy':this.price1.approvedBy


    };
    console.log(user2,"$$$$$$$$$$$$$$$")
    console.log(this.price1, "$$$$$$$$$$$$$$$$")
    this.parkingSvc.approveParkings(user2).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {



        /*   this.usersData.push({
             this.price1.userName,
             userFullName,
             userEmail,
             active,
             userPhone,
             userNationalId
           });*/


        //logger.info("Great! The user information was saved succesfully")



        //alert(response.respMessage);
        this.modalService.dismissAll();


        //alert(response.respMessage);

        this.getPrice();
        this.isAddMode = true;
        return this.toastr.success('Great! The user was Rejected successfully', ' Success!', { timeOut: 3000 });





      }else{
        return this.toastr.error('Exception Occurred', ' Warning!', { timeOut: 3000 });

      }
      this.submitted = true;
    });

  }

  ngOnInit():void {

    this.getPrice();
    this.getParkings();
    this.getcarType();
    this.getsubCountys();


  }


  /*  private _fetchData() {
      this.usersData = usersData;
    }*/
  initEditParking(Parking){
    this.isAddMode=false;
    this.isExisting =true;
    this.price1.id=Parking.id;
    console.log(Parking,"Parking id ................")
    this.priceForm = this.formBuilder.group({
      serviceId :new FormControl(Parking.serviceId, Validators.required),
      subCountyId :new FormControl(Parking.subCountyId, Validators.required),
      carTypeId :new FormControl(Parking.carTypeId, Validators.required),
      fee :new FormControl(Parking.fee, Validators.required),
      active :new FormControl(Parking.active, Validators.required)

    });

  }
  /**
   * Returns form
   */
  get form() {
    return this.priceForm.controls;
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


  cancel() {
    this.getPrice();
    this.isAddMode = true;
    this.isExisting = true;

  }
  Approve()

  {
    //this.price1.userId=this.users.userId;
    // this.price1.userId = this.userForm.get('price1').value;

    //this.price1.userId=this.userId;


    console.log( this.price1.userId, " this.price1.userId")
    this.price1.approved = 'V';
    // console.log(user2,"$$$$$$$$$$$$$$$")
    console.log(this.price1, "$$$$$$$$$$$$$$$$");
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.price1");
    console.log(this.sessionId.entity,"this.price1");

    this.price1.approvedBy=this.sessionId.entity.userId;

    console.log(this.price1.createdBy, "users @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2")

    if(this.price1.createdBy === this.price1.approvedBy){

      return this.toastr.warning('User creator cannot approve a user he/she created', ' Warning!', { timeOut: 3000 });

    }
    const user2 = {
      'id': this.price1.id,
      'approved':this.price1.approved,
      'approvedBy':this.price1.approvedBy


    };


    this.parkingSvc.approveParkings(user2).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {



        /*   this.usersData.push({
             this.price1.userName,
             userFullName,
             userEmail,
             active,
             userPhone,
             userNationalId
           });*/


        //logger.info("Great! The user information was saved succesfully")
        this.modalService.dismissAll();


        //alert(response.respMessage);

        this.getPrice();
        this.isAddMode = true;
        return this.toastr.success('Great! The Price Config was approved successfully', ' Success!', { timeOut: 3000 });



      }else{
        return this.toastr.error('Exception Occurred', ' error!', { timeOut: 3000 });

      }
      this.submitted = true;
    });
  }

  getPrice(){
    //  this.blockUI.start("Loading data....");
    this.isAddMode=false;
    console.log(this.price1.approved,"this.price1")
    this.parkingSvc.getParkingsToApprove().subscribe(users =>{
      // if(data){
      this.price1 = users;
      //this.blockUI.stop();
      /* }
       else{*/
      for (var i = 0; i <= this.price1.length - 1; i++) {
        console.log(this.price1[i].approved, "this.price1.approved")


        if (this.price1[i].approved === 'N') {

          this.price1[i].approved ==='Pending Approval';
          console.log(this.price1[i].approved,"$$$$$$$$$$$$$$$$$$$$")
        } else {
          this.price1[i].approved === 'Approved';
        }
        console.log(this.price1, "data.message");
        // this.blockUI.stop();
        //return this.toastr.info(data.message);
        //}
      }
    },()=>{
      console.log("error fetching customers...");
      //this.blockUI.stop();
    })
  }

  getParkings(){
    //  this.blockUI.start("Loading data....");
    this.isAddMode=false;
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.serviceId,"this.Parkings1");
    console.log(this.sessionId.entity,"this.Parkings1");

    this.parkingSvc.gtParkings().subscribe(Parkings =>{
      // if(data){


      this.Parkings1 = Parkings;
      //this.blockUI.stop();
      /* }
       else{*/
      for (var i = 0; i <= this.Parkings1.length - 1; i++) {
        console.log(this.Parkings1[i].approved, "this.Parkings1.approved")


        if (this.Parkings1[i].approved === 'N') {

          this.Parkings1[i].approved ==='Pending Approval';
          console.log(this.Parkings1[i].approved,"$$$$$$$$$$$$$$$$$$$$")
        } else {
          this.Parkings1[i].approved === 'Approved';
        }
        console.log(this.Parkings1, "data.message");
        // this.blockUI.stop();
        //return this.toastr.info(data.message);
        //}
      }
    },()=>{
      console.log("error fetching customers...");
      //this.blockUI.stop();
    })
  }

  getcarType(){
    //  this.blockUI.start("Loading data....");
    this.isAddMode=false;
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.carTypeId,"this.car1");
    console.log(this.sessionId.entity,"this.car1");

    this.parkingSvc.gtCarType().subscribe(carType =>{
      // if(data){


      this.car1 = carType;
      console.log(this.car1 ,"carrrrrrrrrrrrrrrrrrrrr")
      //this.blockUI.stop();
      /* }
       else{*/
      for (var i = 0; i <= this.car1.length - 1; i++) {
        console.log(this.car1[i].approved, "this.car1.approved")


        if (this.car1[i].approved === 'N') {

          this.car1[i].approved ==='Pending Approval';
          console.log(this.car1[i].approved,"$$$$$$$$$$$$$$$$$$$$")
        } else {
          this.car1[i].approved === 'Approved';
        }
        console.log(this.car1, "data.message");
        // this.blockUI.stop();
        //return this.toastr.info(data.message);
        //}
      }
    },()=>{
      console.log("error fetching customers...");
      //this.blockUI.stop();
    })
  }

  getsubCountys(){
    //  this.blockUI.start("Loading data....");
    this.isAddMode=false;
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.subCountyId,"this.region1");
    console.log(this.sessionId.entity,"this.region1");

    this.regionSvc.gtSubcounty().subscribe(subCountys =>{
      // if(data){


      this.region1 = subCountys;
      //this.blockUI.stop();
      /* }
       else{*/
      for (var i = 0; i <= this.region1.length - 1; i++) {
        console.log(this.region1[i].approved, "this.region1.approved")


        if (this.region1[i].approved === 'N') {

          this.region1[i].approved ==='Pending Approval';
          console.log(this.region1[i].approved,"$$$$$$$$$$$$$$$$$$$$")
        } else {
          this.region1[i].approved === 'Approved';
        }
        console.log(this.region1, "data.message");
        // this.blockUI.stop();
        //return this.toastr.info(data.message);
        //}
      }
    },()=>{
      console.log("error fetching customers...");
      //this.blockUI.stop();
    })
  }

}
