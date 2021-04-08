import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, Validators, FormGroup, FormControl} from '@angular/forms';



import { ToastrService } from 'ngx-toastr';



import { DOCUMENT } from '@angular/common';
import {logger} from "codelyzer/util/logger";
import {first} from "rxjs/operators";

import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

import {RegionService} from "../services/region.service";



@Component({
  selector: 'app-subCountys',
  templateUrl: './ward.component.html',


})
export class WardComponent implements OnInit {

  // breadcrumb items
  breadCrumbItems: Array<{}>;
  public ward1: any = [];
  public region1: any = [];
  public subCountys: any = [];
  submitted: boolean;
  public response: any = null;
  isAddMode: boolean;
  isExisting:boolean;
  subCountyId:any;
  sessionId:any;
  status:any;
  storageObject: any = {};

  // subCountysData: subCountys[];

  wardForm:FormGroup;

  // constructor(private modalService: NgbModal, public formBuilder: FormBuilder) { }
  constructor(private toastr: ToastrService,
              private regionSvc: RegionService, @Inject(DOCUMENT) private document: any,public formBuilder: FormBuilder,
              private modalService: NgbModal
  ) {
  }


  ngOnInit():void {

    this.getWards();
    this.getsubCountys();
    //this.initAddsubCounty();
    // this.initEditsubCounty();
    /*  this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'subCountys', active: true }];*/

    /* this.wardForm = this.formBuilder.group({
       wardName: ['', [Validators.required]],
       subCountyFullName: ['', [Validators.required]],
       subCountyPhone: ['', [Validators.required]],
       subCountyEmail: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
       active: ['', [Validators.required]],
       subCountyNationalId: ['', [Validators.required]]
     });
 */
    // this._fetchData();*/
  }
  initAddWard():void{
    this.isAddMode=true;
    this.isExisting =false;


    this.wardForm = this.formBuilder.group({


      wardCode : ['', [Validators.required]],
      wardName : ['', [Validators.required]],
      subCountyId : ['', [Validators.required]],






    });

  }

  /*  private _fetchData() {
      this.subCountysData = subCountysData;
    }*/

  /**
   * Returns form
   */
  get form() {
    return this.wardForm.controls;
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
   * save the subCountys data
   */
  saveData() {


    this.ward1 = this.wardForm.value;

    this.ward1.wardName = this.wardForm.get('wardName').value;
    this.ward1.wardCode = this.wardForm.get('wardCode').value;
    this.ward1.subCountyId = this.wardForm.get('subCountyId').value;


    // this.ward1.subCountyFullName=(+ this.wardForm.get('secondname').value +this.wardForm.get('lastname').value;
    console.log(this.ward1,"subCountys")
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.subCountyId,"this.ward1");
    console.log(this.sessionId.entity,"this.ward1");

    this.ward1.createdBy=this.sessionId.entity.subCountyId;
    console.log(this.ward1.createdBy, "this.ward1.createdBy")

    this.regionSvc.addWard(this.ward1).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {


        //logger.info("Great! The subCounty information was saved succesfully")
        this.modalService.dismissAll();
        this.getWards();
        return this.toastr.success('Great! The subCounty information was saved succesfully"', ' Success!', { timeOut: 3000 });

        //alert("Great! The subCounty information was saved succesfully");

      }else{
        return this.toastr.error('Exception Occurred', ' Error!', { timeOut: 3000 });

      }
      this.submitted = true;
    });
  }

  initEditWard(subCounty){
    this.isAddMode=false;
    this.isExisting =true;
    this.ward1.subCountyId=subCounty.subCountyId;
    console.log(this.ward1.subCountyId,"subCounty id ................")
    this.wardForm = this.formBuilder.group({
      wardName :new FormControl(subCounty.wardName, Validators.required),
      wardCode :new FormControl(subCounty.wardCode, Validators.required),
      subCountyId :new FormControl(subCounty.subCountyId, Validators.required)

    });

  }
  cancel() {
    this.getWards();
    this.isAddMode = true;
    this.isExisting = true;

  }
  updateWard()

  {
    //this.ward1.subCountyId=this.subCountys.subCountyId;
    // this.ward1.subCountyId = this.wardForm.get('ward1').value;

    //this.ward1.subCountyId=this.subCountyId;


    console.log( this.ward1.subCountyId, " this.ward1.subCountyId")
    this.ward1.wardName = this.wardForm.get('wardName').value;
    this.ward1.wardCode = this.wardForm.get('wardCode').value;
    this.ward1.subCountyId = this.wardForm.get('subCountyId').value;

    const subCounty2 = {
      'wardId': this.ward1.wardId,
      'subCountyId': this.ward1.subCountyId,
      'wardName' :this.ward1.wardName,
      'wardCode' :this.ward1.wardCode,


    };
    console.log(subCounty2,"$$$$$$$$$$$$$$$")
    console.log(this.ward1, "$$$$$$$$$$$$$$$$")
    this.regionSvc.addWard(subCounty2).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {


        //logger.info("Great! The subCounty information was saved succesfully")

        this.modalService.dismissAll();


        //alert(response.respMessage);

        this.getWards();
        this.isAddMode = true;

        //alert(response.respMessage);
        return this.toastr.success('Great! The subCounty information was saved succesfully"', ' Success!', { timeOut: 3000 });



      }else{
        return this.toastr.error('Exception Occurred', ' Error!', { timeOut: 3000 });

      }
      this.submitted = true;
    });
  }

  getWards(){
    //  this.blockUI.start("Loading data....");
    this.isAddMode=false;
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.subCountyId,"this.ward1");
    console.log(this.sessionId.entity,"this.ward1");

    this.regionSvc.gtWard().subscribe(subCountys =>{
      // if(data){


      this.ward1 = subCountys;
      //this.blockUI.stop();
      /* }
       else{*/
      for (var i = 0; i <= this.ward1.length - 1; i++) {
        console.log(this.ward1[i].approved, "this.ward1.approved")


        if (this.ward1[i].approved === 'N') {

          this.ward1[i].approved ==='Pending Approval';
          console.log(this.ward1[i].approved,"$$$$$$$$$$$$$$$$$$$$")
        } else {
          this.ward1[i].approved === 'Approved';
        }
        console.log(this.ward1, "data.message");
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
