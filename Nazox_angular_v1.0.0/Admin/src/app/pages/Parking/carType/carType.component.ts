import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, Validators, FormGroup, FormControl} from '@angular/forms';



import { ToastrService } from 'ngx-toastr';



import { DOCUMENT } from '@angular/common';
import {logger} from "codelyzer/util/logger";
import {first} from "rxjs/operators";

import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ParkingService} from "../../services/parking.service";





@Component({
  selector: 'app-carType',
  templateUrl: './carType.component.html'

})
export class CarTypeComponent implements OnInit {

  // breadcrumb items
  breadCrumbItems: Array<{}>;
  public car1: any = [];
  public carType: any = [];
  submitted: boolean;
  public response: any = null;
  isAddMode: boolean;
  isExisting:boolean;
  carTypeId:any;
  sessionId:any;
  status:any;
  storageObject: any = {};

 // carTypeData: carType[];
  carTypeForm: FormGroup;

  // constructor(private modalService: NgbModal, public formBuilder: FormBuilder) { }
  constructor(private toastr: ToastrService,
              private carSvc: ParkingService, @Inject(DOCUMENT) private document: any,public formBuilder: FormBuilder,
              private modalService: NgbModal
  ) {
  }


  ngOnInit():void {

    this.getcarType();
    //this.initAddcarType();
    // this.initEditcarType();
    /*  this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'carType', active: true }];*/

    /* this.carTypeForm = this.formBuilder.group({
       carTypeName: ['', [Validators.required]],
       carTypeFullName: ['', [Validators.required]],
       carTypePhone: ['', [Validators.required]],
       carTypeEmail: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
       active: ['', [Validators.required]],
       carTypeNationalId: ['', [Validators.required]]
     });
 */
    // this._fetchData();*/
  }


  /*  private _fetchData() {
      this.carTypeData = carTypeData;
    }*/
  initAddcarType():void{
    this.isAddMode=true;
    this.isExisting =false;


    this.carTypeForm = this.formBuilder.group({



      carTypeName: ['', [Validators.required]],






    });

  }
  /**
   * Returns form
   */
  get form() {
    return this.carTypeForm.controls;
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
   * save the carType data
   */
  saveData() {


    this.car1 = this.carTypeForm.value;

    this.car1.CarTypeName = this.carTypeForm.get('CarTypeName').value;



    // this.car1.carTypeFullName=(+ this.carTypeForm.get('secondname').value +this.carTypeForm.get('lastname').value;
    console.log(this.car1,"carType")
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.carTypeId,"this.car1");
    console.log(this.sessionId.entity,"this.car1");

    this.car1.createdBy=this.sessionId.entity.userId;
    console.log(this.car1.createdBy, "this.car1.createdBy")

    this.carSvc.addCarType(this.car1).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {


        //logger.info("Great! The carType information was saved succesfully")
        this.modalService.dismissAll();
        this.getcarType();
        return this.toastr.success('Great! The carType information was saved succesfully"', ' Success!', { timeOut: 3000 });

        //alert("Great! The carType information was saved succesfully");

      }else{
        return this.toastr.error('Exception Occurred', ' Error!', { timeOut: 3000 });

      }
      this.submitted = true;
    });
  }

  initEditcarType(carType){
    this.isAddMode=false;
    this.isExisting =true;
    this.car1.CarTypeId=carType.CarTypeId;
    console.log(this.car1.carTypeId,"carType id ................")
    this.carTypeForm = this.formBuilder.group({
      carTypeName :new FormControl(carType.carTypeName, Validators.required),
     // active :new FormControl(carType.active, Validators.required)

    });

  }
  cancel() {
    this.getcarType();
    this.isAddMode = true;
    this.isExisting = true;

  }
  updatecarType()

  {
    //this.car1.carTypeId=this.carType.carTypeId;
    // this.car1.carTypeId = this.carTypeForm.get('car1').value;

    //this.car1.carTypeId=this.carTypeId;


    console.log( this.car1.carTypeId, " this.car1.carTypeId")
    this.car1.CarTypeName = this.carTypeForm.get('CarTypeName').value;

    //this.car1.active = this.carTypeForm.get('active').value;

    const carType2 = {
      'carTypeId': this.car1.carTypeId,
      'carTypeName' :this.car1.carTypeName,



    };
    console.log(carType2,"$$$$$$$$$$$$$$$")
    console.log(this.car1, "$$$$$$$$$$$$$$$$")
    this.carSvc.updateCarType(carType2).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {


        //logger.info("Great! The carType information was saved succesfully")

        this.modalService.dismissAll();


        //alert(response.respMessage);

        this.getcarType();
        this.isAddMode = true;

        //alert(response.respMessage);
        return this.toastr.success('Great! The carType information was saved succesfully"', ' Success!', { timeOut: 3000 });



      }else{
        return this.toastr.error('Exception Occurred', ' Error!', { timeOut: 3000 });

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

    this.carSvc.gtCarType().subscribe(carType =>{
      // if(data){


      this.car1 = carType;
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

}
