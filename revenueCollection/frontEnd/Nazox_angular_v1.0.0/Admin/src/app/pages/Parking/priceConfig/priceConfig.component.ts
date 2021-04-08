import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, Validators, FormGroup, FormControl} from '@angular/forms';



import { ToastrService } from 'ngx-toastr';



import { DOCUMENT } from '@angular/common';
import {logger} from "codelyzer/util/logger";
import {first} from "rxjs/operators";

import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ParkingService} from "../../services/parking.service";
import {RegionService} from "../../services/region.service";


@Component({
  selector: 'app-Parkings',
  templateUrl: './priceConfig.component.html'

})
export class PriceConfigComponent implements OnInit {

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
  storageObject: any = {};

 // ParkingsData: Parkings[];
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
    //this.initAddParking();
    // this.initEditParking();
    /*  this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Parkings', active: true }];*/

    /* this.priceForm = this.formBuilder.group({
       ParkingName: ['', [Validators.required]],
       ParkingFullName: ['', [Validators.required]],
       ParkingPhone: ['', [Validators.required]],
       ParkingEmail: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
       active: ['', [Validators.required]],
       ParkingNationalId: ['', [Validators.required]]
     });
 */
    // this._fetchData();*/
  }


  /*  private _fetchData() {
      this.ParkingsData = ParkingsData;
    }*/
  initAddParking():void{
    this.isAddMode=true;
    this.isExisting =false;


    this.priceForm = this.formBuilder.group({



      serviceId: ['', [Validators.required]],
      subCountyId: ['', [Validators.required]],
      carTypeId: ['', [Validators.required]],
      fee: ['', [Validators.required]],
      active: ['', [Validators.required]],



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
   * save the Parkings data
   */
  saveData() {


    this.price1 = this.priceForm.value;

    this.price1.serviceId = this.priceForm.get('serviceId').value;
    this.price1.subCountyId = this.priceForm.get('subCountyId').value;
    this.price1.carTypeId = this.priceForm.get('carTypeId').value;
    this.price1.fee = this.priceForm.get('fee').value;
    this.price1.active = this.priceForm.get('active').value;

    // this.Parkings1.ParkingFullName=(+ this.priceForm.get('secondname').value +this.priceForm.get('lastname').value;
    console.log(this.price1,"Parkings")
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.serviceId,"this.Parkings1");
    console.log(this.sessionId.entity,"this.Parkings1");

    this.price1.createdBy=this.sessionId.entity.userId;
    console.log(this.price1.createdBy, "this.Parkings1.createdBy")

    this.parkingSvc.addPriceConfig(this.price1).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {


        //logger.info("Great! The Parking information was saved succesfully")
        this.modalService.dismissAll();
        this.getPrice();
        return this.toastr.success('Great! The Price information was saved succesfully"', ' Success!', { timeOut: 3000 });

        //alert("Great! The Parking information was saved succesfully");

      }else{
        return this.toastr.error('Exception Occurred', ' Error!', { timeOut: 3000 });

      }
      this.submitted = true;
    });
  }

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
  cancel() {
    this.getParkings();
    this.isAddMode = true;
    this.isExisting = true;

  }
  updateParking()

  {
    //this.Parkings1.serviceId=this.Parkings.serviceId;
    // this.Parkings1.serviceId = this.priceForm.get('Parkings1').value;

    //this.Parkings1.serviceId=this.serviceId;


    console.log( this.Parkings1.serviceId, " this.Parkings1.serviceId")
    this.price1.serviceId = this.priceForm.get('serviceId').value;
    this.price1.subCountyId = this.priceForm.get('subCountyId').value;
    this.price1.carTypeId = this.priceForm.get('carTypeId').value;
    this.price1.fee = this.priceForm.get('fee').value;
    this.price1.active = this.priceForm.get('active').value;

    const Parking2 = {
      'id': this.price1.id,
      'serviceId': this.price1.serviceId,
      'subCountyId' :this.price1.subCountyId,
      'carTypeId' :this.price1.carTypeId,
      'fee' :this.price1.fee,
      'active' :this.price1.active,


    };
    console.log(Parking2,"$$$$$$$$$$$$$$$")
    console.log(this.Parkings1, "$$$$$$$$$$$$$$$$")
    this.parkingSvc.updatePriceConfig(Parking2).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {


        //logger.info("Great! The Parking information was saved succesfully")

        this.modalService.dismissAll();


        //alert(response.respMessage);

        this.getPrice();
        this.isAddMode = true;

        //alert(response.respMessage);
        return this.toastr.success('Great! The Parking information was saved succesfully"', ' Success!', { timeOut: 3000 });



      }else{
        return this.toastr.error('Exception Occurred', ' Error!', { timeOut: 3000 });

      }
      this.submitted = true;
    });
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
      console.log(this.price1, "PRICE CONFIGS")
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

}
