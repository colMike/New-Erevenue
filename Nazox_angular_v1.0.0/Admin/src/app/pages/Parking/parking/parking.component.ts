import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, Validators, FormGroup, FormControl} from '@angular/forms';



import { ToastrService } from 'ngx-toastr';



import { DOCUMENT } from '@angular/common';
import {logger} from "codelyzer/util/logger";
import {first} from "rxjs/operators";

import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ParkingService} from "../../services/parking.service";


@Component({
  selector: 'app-Parkings',
  templateUrl: './parking.component.html'

})
export class ParkingComponent implements OnInit {

  // breadcrumb items
  breadCrumbItems: Array<{}>;
  public Parkings1: any = [];
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
  ParkingForm: FormGroup;

  // constructor(private modalService: NgbModal, public formBuilder: FormBuilder) { }
  constructor(private toastr: ToastrService,
              private parkingSvc: ParkingService, @Inject(DOCUMENT) private document: any,public formBuilder: FormBuilder,
              private modalService: NgbModal
  ) {
  }


  ngOnInit():void {

    this.getParkings();
    //this.initAddParking();
    // this.initEditParking();
    /*  this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Parkings', active: true }];*/

    /* this.ParkingForm = this.formBuilder.group({
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


    this.ParkingForm = this.formBuilder.group({



      serviceName: ['', [Validators.required]],
      serviceCode: ['', [Validators.required]],

      active: ['', [Validators.required]],



    });

  }
  /**
   * Returns form
   */
  get form() {
    return this.ParkingForm.controls;
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


    this.Parkings1 = this.ParkingForm.value;

    this.Parkings1.serviceName = this.ParkingForm.get('serviceName').value;
    this.Parkings1.serviceCode = this.ParkingForm.get('serviceCode').value;
    this.Parkings1.active = this.ParkingForm.get('active').value;

    // this.Parkings1.ParkingFullName=(+ this.ParkingForm.get('secondname').value +this.ParkingForm.get('lastname').value;
    console.log(this.Parkings1,"Parkings")
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.serviceId,"this.Parkings1");
    console.log(this.sessionId.entity,"this.Parkings1");

    this.Parkings1.createdBy=this.sessionId.entity.serviceId;
    console.log(this.Parkings1.createdBy, "this.Parkings1.createdBy")

    this.parkingSvc.addParkings(this.Parkings1).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {


        //logger.info("Great! The Parking information was saved succesfully")
        this.modalService.dismissAll();
        this.getParkings();
        return this.toastr.success('Great! The Parking information was saved succesfully"', ' Success!', { timeOut: 3000 });

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
    this.Parkings1.serviceId=Parking.serviceId;
    console.log(this.Parkings1.serviceId,"Parking id ................")
    this.ParkingForm = this.formBuilder.group({
      serviceCode :new FormControl(Parking.serviceCode, Validators.required),
      serviceName :new FormControl(Parking.serviceName, Validators.required),
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
    // this.Parkings1.serviceId = this.ParkingForm.get('Parkings1').value;

    //this.Parkings1.serviceId=this.serviceId;


    console.log( this.Parkings1.serviceId, " this.Parkings1.serviceId")
    this.Parkings1.serviceCode = this.ParkingForm.get('serviceCode').value;
    this.Parkings1.serviceName = this.ParkingForm.get('serviceName').value;
    this.Parkings1.active = this.ParkingForm.get('active').value;

    const Parking2 = {
      'serviceId': this.Parkings1.serviceId,
      'serviceCode' :this.Parkings1.serviceCode,
      'serviceName' :this.Parkings1.serviceName,
      'active' :this.Parkings1.active,


    };
    console.log(Parking2,"$$$$$$$$$$$$$$$")
    console.log(this.Parkings1, "$$$$$$$$$$$$$$$$")
    this.parkingSvc.updateParkings(Parking2).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {


        //logger.info("Great! The Parking information was saved succesfully")

        this.modalService.dismissAll();


        //alert(response.respMessage);

        this.getParkings();
        this.isAddMode = true;

        //alert(response.respMessage);
        return this.toastr.success('Great! The Parking information was saved succesfully"', ' Success!', { timeOut: 3000 });



      }else{
        return this.toastr.error('Exception Occurred', ' Error!', { timeOut: 3000 });

      }
      this.submitted = true;
    });
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
