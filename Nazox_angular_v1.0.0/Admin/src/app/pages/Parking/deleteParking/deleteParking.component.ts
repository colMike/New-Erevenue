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
  templateUrl: './deleteParking.component.html'

})
export class deleteParkingComponent implements OnInit {

  // breadcrumb items
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
  constructor(private toastr: ToastrService,private regionSvc: RegionService,
              private parkingSvc: ParkingService, @Inject(DOCUMENT) private document: any,public formBuilder: FormBuilder,
              private modalService: NgbModal
  ) {
  }



  ngOnInit():void {

    this.getParkings();
    this.getcarType();
    this.getsubCountys();
    this.getPrice();
    //this.initAddUser();
    // this.initEditUser();
    /*  this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Users', active: true }];*/

    /* this.priceForm = this.formBuilder.group({
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
      remarks :new FormControl(Parking.remarks, Validators.required),
      active :new FormControl(Parking.active, Validators.required)

    });

  }
  cancel() {
    this.getPrice();
    this.isAddMode = true;
    this.isExisting = true;

  }
  Delete()

  {
    //this.users1.userId=this.users.userId;
    // this.users1.userId = this.priceForm.get('users1').value;

    //this.users1.userId=this.userId;
    this.price1.remarks = this.priceForm.get('remarks').value;
    if(this.price1.remarks =='' || this.price1.remarks==null ){
      return this.toastr.warning('Kindly enter the reason for deleting','Warning!', { timeOut: 3000 });

    }

    console.log( this.price1.id, " this.users1.userId")
    this.price1.deleted = 'D';
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.users1");
    console.log(this.sessionId.entity,"this.users1");
    this.price1.deletedBy=this.sessionId.entity.userId;
    const user2 = {
      'id': this.price1.id,
      'deleted':this.price1.deleted,
      'deletedBy':this.price1.deletedBy,
      'remarks':this.price1.remarks


    };
    console.log(user2,"$$$$$$$$$$$$$$$")
    console.log(this.price1, "$$$$$$$$$$$$$$$$")
    this.parkingSvc.deleteParkings(user2).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {



        /*   this.usersData.push({
             this.users1.userName,
             userFullName,
             userEmail,
             active,
             userPhone,
             userNationalId
           });*/
        this.priceForm = this.formBuilder.group({
          // userName: '',
          userFullName: '',
          userEmail: '',
          active: '',
          userPhone: '',
          userNationalId: ''
        });

        //logger.info("Great! The user information was saved succesfully")



        //alert(response.respMessage);
        this.modalService.dismissAll();


        //alert(response.respMessage);

        this.getPrice();
        this.isAddMode = true;

        return this.toastr.success('Great! The price config was deleted successfully. Pending Approval', 'success!', { timeOut: 3000 });



      }else{
        return this.toastr.error('Exception Occured', ' error!', { timeOut: 3000 });

      }
      this.submitted = true;
    });
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

  getPrice(){
    //  this.blockUI.start("Loading data....");
    this.isAddMode=false;
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.serviceId,"this.Parkings1");
    console.log(this.sessionId.entity,"this.Parkings1");

    this.parkingSvc.gtPriceConfig().subscribe(Parkings =>{
      // if(data){


      this.price1 = Parkings;
      console.log(this.price1, "%%%%%%%%%%%%%%%%%%%%%")
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

}
