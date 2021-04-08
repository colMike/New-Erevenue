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
  templateUrl: './region.component.html',


})
export class RegionComponent implements OnInit {

  // breadcrumb items
  breadCrumbItems: Array<{}>;
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
  subCountyForm: FormGroup;
  wardForm:FormGroup;

  // constructor(private modalService: NgbModal, public formBuilder: FormBuilder) { }
  constructor(private toastr: ToastrService,
              private regionSvc: RegionService, @Inject(DOCUMENT) private document: any,public formBuilder: FormBuilder,
              private modalService: NgbModal
  ) {
  }


  ngOnInit():void {

    this.getsubCountys();
    //this.initAddsubCounty();
    // this.initEditsubCounty();
    /*  this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'subCountys', active: true }];*/

    /* this.subCountyForm = this.formBuilder.group({
       subCountyName: ['', [Validators.required]],
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
  initAddsubCounty():void{
    this.isAddMode=true;
    this.isExisting =false;


    this.subCountyForm = this.formBuilder.group({



      subCountyName: ['', [Validators.required]],
      subCountyCode: ['', [Validators.required]],





    });

  }
  /**
   * Returns form
   */
  get form() {
    return this.subCountyForm.controls;
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


    this.region1 = this.subCountyForm.value;

    this.region1.subCountyName = this.subCountyForm.get('subCountyName').value;
    this.region1.subCountyCode = this.subCountyForm.get('subCountyCode').value;


    // this.region1.subCountyFullName=(+ this.subCountyForm.get('secondname').value +this.subCountyForm.get('lastname').value;
    console.log(this.region1,"subCountys")
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.subCountyId,"this.region1");
    console.log(this.sessionId.entity,"this.region1");

    this.region1.createdBy=this.sessionId.entity.subCountyId;
    console.log(this.region1.createdBy, "this.region1.createdBy")

    this.regionSvc.addSubCounty(this.region1).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {


        //logger.info("Great! The subCounty information was saved succesfully")
        this.modalService.dismissAll();
        this.getsubCountys();
        return this.toastr.success('Great! The subCounty information was saved succesfully"', ' Success!', { timeOut: 3000 });

        //alert("Great! The subCounty information was saved succesfully");

      }else{
        return this.toastr.error('Exception Occurred', ' Error!', { timeOut: 3000 });

      }
      this.submitted = true;
    });
  }

  initEditsubCounty(subCounty){
    this.isAddMode=false;
    this.isExisting =true;
    this.region1.subCountyId=subCounty.subCountyId;
    console.log(this.region1.subCountyId,"subCounty id ................")
    this.subCountyForm = this.formBuilder.group({
      subCountyName :new FormControl(subCounty.subCountyName, Validators.required),
      subCountyCode :new FormControl(subCounty.subCountyCode, Validators.required),
     // active :new FormControl(subCounty.active, Validators.required)

    });

  }
  cancel() {
    this.getsubCountys();
    this.isAddMode = true;
    this.isExisting = true;

  }
  updatesubCounty()

  {
    //this.region1.subCountyId=this.subCountys.subCountyId;
    // this.region1.subCountyId = this.subCountyForm.get('region1').value;

    //this.region1.subCountyId=this.subCountyId;


    console.log( this.region1.subCountyId, " this.region1.subCountyId")
    this.region1.subCountyName = this.subCountyForm.get('subCountyName').value;
    this.region1.subCountyCode = this.subCountyForm.get('subCountyCode').value;
    //this.region1.active = this.subCountyForm.get('active').value;

    const subCounty2 = {
      'subCountyId': this.region1.subCountyId,
      'subCountyName' :this.region1.subCountyName,
      'subCountyCode' :this.region1.subCountyCode,


    };
    console.log(subCounty2,"$$$$$$$$$$$$$$$")
    console.log(this.region1, "$$$$$$$$$$$$$$$$")
    this.regionSvc.updateSubcounty(subCounty2).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {


        //logger.info("Great! The subCounty information was saved succesfully")

        this.modalService.dismissAll();


        //alert(response.respMessage);

        this.getsubCountys();
        this.isAddMode = true;

        //alert(response.respMessage);
        return this.toastr.success('Great! The subCounty information was saved succesfully"', ' Success!', { timeOut: 3000 });



      }else{
        return this.toastr.error('Exception Occurred', ' Error!', { timeOut: 3000 });

      }
      this.submitted = true;
    });
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
