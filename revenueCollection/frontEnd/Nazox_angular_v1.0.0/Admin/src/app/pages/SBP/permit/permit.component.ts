import { Component, OnInit, OnDestroy } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { AdministrationService } from '../../services/administration.service';
import { ToastrService } from 'ngx-toastr';

import { BlockUI, NgBlockUI } from 'ng-block-ui';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {PermitService} from "../../services/permitService";
import {RegionService} from "../../services/region.service";

@Component({
  templateUrl: './permit.component.html',
  styleUrls: ['./permit.component.css']

})
export class PermitComponent implements OnInit, OnDestroy {
  groups: any;
  types: any;
  breadCrumbItems: Array<{}>;
  res: any;
  userGroups: any = [];
  rights: any = [];
  initRights: any = [];
  userGroup: any = {};
  asignedRights = [];
  response: any = null;
  is_edit: any = false;
  sessionId:any;
  editMode = false;
  rightView = false;
  rightAdd = false;
  rightEdit = false;
  rightDelete = false;
  title: string;
  button: string;
  showWards:any;
  public permit1: any = [];
  public region1: any = [];
  public ward1: any = [];

  public permitType1: any = [];
  rId:any;
  ug:any;
  idRight:any;
  rightId: any;
  session: any = {};
  permitForm: FormGroup;
  appEditMode:any;
  appDetailMode:any;
  source: LocalDataSource;
  @BlockUI() blockUI: NgBlockUI;
  constructor(private permitService: PermitService,private regionSvc: RegionService,public formBuilder: FormBuilder, private toastr: ToastrService,  private modalService: NgbModal) {


  }
  settings = settings;


  ngOnInit() {
    this.getAllPermits();
    this.getAllpermitTypes();
    this.getsubCountys();
   this.getWards();
    //this.getWards();

   /* this.ng("subCountyId", function (newValue, oldValue) {

      if (newValue != oldValue) {
        this.showWards=false;
        this.getWards(newValue);
        //$scope.$apply();

      }

    });
*/

   // this.initUserRights();

  }

  initAddPermit() {
  //  this.initUserRights();
    this.appEditMode = true;
    this.appDetailMode=false;

    this.permitForm = this.formBuilder.group({
    applicant: ['', [Validators.required]],
    businessName: ['', [Validators.required]],
    noOfEmployees: ['', [Validators.required]],
      permitTypeId: ['', [Validators.required]],
    PIN: ['', [Validators.required]],
    electricityAccNo: ['', [Validators.required]],
    area: ['', [Validators.required]],
    regNo: ['', [Validators.required]],
    businessDesc: ['', [Validators.required]],
    postalAdd: ['', [Validators.required]],
    postalCode: ['', [Validators.required]],
      postalTown: ['', [Validators.required]],
    email: ['', [Validators.required]],
    fax: ['', [Validators.required]],
      altMobileNo: ['', [Validators.required]],
    mobileNo: ['', [Validators.required]],
    vat: ['', [Validators.required]],
      subcountyId: ['', [Validators.required]],
    wardId: ['', [Validators.required]],
   // marketSelect: ['', [Validators.required]],
    landZone: ['', [Validators.required]],
    plotNo: ['', [Validators.required]],

    //businessId: ['', [Validators.required]],
    nationalId: ['', [Validators.required]],

      building: ['', [Validators.required]],
      room: ['', [Validators.required]],
      applicantFax: ['', [Validators.required]],
      applicantMobile: ['', [Validators.required]],
      personalNumber: ['', [Validators.required]],
      personalAdd: ['', [Validators.required]],
      personalCode: ['', [Validators.required]],

      otherActivity: ['', [Validators.required]],




  });


  }
  get form() {
    return this.permitForm.controls;
  }

  initEditPermit($event) {
    this.appEditMode = true;
    this.appDetailMode=true;
    this.permit1.permitId=$event.permitId;
    this.title = 'update';
    console.log(this.permit1.permitId,'  this.permit1.permitId')
    this.permitForm = this.formBuilder.group({

      applicant:new FormControl($event.applicant, Validators.required),
      businessName:new FormControl($event.businessName, Validators.required),
      noOfEmployees:new FormControl($event.noOfEmployees, Validators.required),
      permitTypeId:new FormControl($event.permitTypeId, Validators.required),
      vat:new FormControl($event.vat, Validators.required),
      PIN:new FormControl($event.PIN, Validators.required),
      area:new FormControl($event.area, Validators.required),
      regNo:new FormControl($event.regNo, Validators.required),
      businessDesc:new FormControl($event.businessDesc, Validators.required),
      postalAdd:new FormControl($event.postalAdd, Validators.required),
      postalTown:new FormControl($event.postalTown, Validators.required),

      postalCode:new FormControl($event.postalCode, Validators.required),
      email:new FormControl($event.email, Validators.required),
      fax:new FormControl($event.fax, Validators.required),
      mobileNo:new FormControl($event.mobileNo, Validators.required),
      landLineNo:new FormControl($event.landLineNo, Validators.required),
      subcountyId:new FormControl($event.subcountyId, Validators.required),

      wardId:new FormControl($event.wardId, Validators.required),
      //marketSelect:new FormControl($event.firstname, Validators.required),
      landZone:new FormControl($event.landZone, Validators.required),
      plotNo:new FormControl($event.plotNo, Validators.required),

      //businessId:new FormControl($event.firstname, Validators.required),
      nationalId:new FormControl($event.nationalId, Validators.required),

      altMobileNo:new FormControl($event.altMobileNo, Validators.required),
      building:new FormControl($event.building, Validators.required),
      room:new FormControl($event.room, Validators.required),
      applicantFax:new FormControl($event.applicantFax, Validators.required),
      applicantMobile:new FormControl($event.applicantMobile, Validators.required),
      personalNumber:new FormControl($event.personalNumber, Validators.required),
      personalAdd:new FormControl($event.personalAdd, Validators.required),
      personalCode:new FormControl($event.personalCode, Validators.required),

      otherActivity:new FormControl($event.otherActivity, Validators.required),

      //name: ['', [Validators.required]]
  })

  }

  getAllPermits() {
    this.blockUI.start('Loading group data...');
    this.appEditMode=false;
    this.permitService.gtPermit().subscribe(data => {
      console.log(JSON.stringify(data),"HEREEEEEEEEEEEEEE")
      this.permit1 = data;

      this.blockUI.stop();

    }, error => {
      this.blockUI.stop();
      return this.toastr.error('Error in loading  data.', 'Error!', { timeOut: 4000 });
    });
  }
  /**
   * gets the list of wards based on subcounty selected
   */


  getAllpermitTypes() {
    this.blockUI.start('Loading group data...');
    this.permitService.gtPermitType().subscribe(data => {

      console.log(JSON.stringify(data),"HEREEEEEEEEEEEEEE")
      this.permitType1 = data;

      this.blockUI.stop();

    }, error => {
      this.blockUI.stop();
      return this.toastr.error('Error in loading  data.', 'Error!', { timeOut: 4000 });
    });
  }

  addPermit() {
    if (this.permit1.businessName === '') {
      this.toastr.warning('Please specify the businessName', 'Alert!', { timeOut: 4000 });
    }
    if (this.permit1.PIN === '') {
      this.toastr.warning('Please specify the PIN', 'Alert!', { timeOut: 4000 });
    }
    if (this.permit1.postalAdd === '') {
      this.toastr.warning('Please specify the postal Address', 'Alert!', { timeOut: 4000 });
    }
    if (this.permit1.mobileNo === '') {
      this.toastr.warning('Please specify the  Business mobileNo', 'Alert!', { timeOut: 4000 });
    }
    if (this.permit1.email === '') {
      this.toastr.warning('Please specify the Business Email', 'Alert!', { timeOut: 4000 });
    }
    if (this.permit1.landZone === '') {
      this.toastr.warning('Please specify the Physical Address', 'Alert!', { timeOut: 4000 });
    }
    if (this.permit1.applicant === '') {
      this.toastr.warning('Please specify the applicant name', 'Alert!', { timeOut: 4000 });
    }
    if (this.permit1.nationalId === '') {
      this.toastr.warning('Please specify the nationalId', 'Alert!', { timeOut: 4000 });
    }
    if (this.permit1.applicantMobile === '') {
      this.toastr.warning('Please specify the applicant Mobile', 'Alert!', { timeOut: 4000 });
    }
    if (this.permit1.personalAdd === '') {
      this.toastr.warning('Please specify the applicant Postal Add', 'Alert!', { timeOut: 4000 });
    }
    if (this.permit1.businessDesc === '') {
      this.toastr.warning('Please specify the business Description', 'Alert!', { timeOut: 4000 });
    }
    if (this.permit1.area === '') {
      this.toastr.warning('Please specify the area', 'Alert!', { timeOut: 4000 });
    }
    if (this.permit1.permitTypeId === '') {
      this.toastr.warning('Please specify the Permit Type', 'Alert!', { timeOut: 4000 });
    }
    if (this.permit1.subCountyId === '') {
      this.toastr.warning('Please specify the Subcounty', 'Alert!', { timeOut: 4000 });
    }

    if (this.permit1.wardId === '') {
      this.toastr.warning('Please specify the Ward', 'Alert!', { timeOut: 4000 });
    }
      this.permit1 = this.permitForm.value;

      this.permit1.applicant= this.permitForm.get('applicant').value;
      this.permit1.businessName= this.permitForm.get('businessName').value;
      this.permit1.noOfEmployees= this.permitForm.get('noOfEmployees').value;
      this.permit1.permitTypeId= this.permitForm.get('permitTypeId').value;
     /* this.permit1.waterAccNo= this.permitForm.get('waterAccNo').value;

      this.permit1.electricityAccNo= this.permitForm.get('electricityAccNo').value;*/
      this.permit1.area= this.permitForm.get('area').value;
      this.permit1.regNo= this.permitForm.get('regNo').value;
      this.permit1.businessDesc= this.permitForm.get('businessDesc').value;
      this.permit1.postalAdd= this.permitForm.get('postalAdd').value;
      this.permit1.postalCode= this.permitForm.get('postalCode').value;
      this.permit1.email= this.permitForm.get('email').value;
      this.permit1.fax= this.permitForm.get('fax').value;
      this.permit1.mobileNo= this.permitForm.get('mobileNo').value;
    this.permit1.postalTown= this.permitForm.get('postalTown').value;
    this.permit1.PIN= this.permitForm.get('PIN').value;
      this.permit1.subcountyId= this.permitForm.get('subcountyId').value;
      this.permit1.wardId= this.permitForm.get('wardId').value;
      //this.permit1.marketSelect= this.permitForm.get('marketSelect').value;
      this.permit1.landZone= this.permitForm.get('landZone').value;
      this.permit1.plotNo= this.permitForm.get('plotNo').value;


      //this.permit1.businessId= this.permitForm.get('businessId').value;
      this.permit1.nationalId= this.permitForm.get('nationalId').value;

    this.permit1.altMobileNo= this.permitForm.get('altMobileNo').value;
    this.permit1.building= this.permitForm.get('building').value;
    this.permit1.room= this.permitForm.get('room').value;
    this.permit1. applicantFax= this.permitForm.get('applicantFax').value;
    this.permit1.applicantMobile= this.permitForm.get('applicantMobile').value;
    this.permit1.personalNumber= this.permitForm.get('personalNumber').value;
    this.permit1.personalAdd= this.permitForm.get('personalAdd').value;
    this.permit1.personalCode= this.permitForm.get('personalCode').value;
    this.permit1.area= this.permitForm.get('area').value;
    this.permit1.otherActivity= this.permitForm.get('otherActivity').value;

      //this.permit1.name= this.permitForm.get('name').value;
      //this.permit1.id=this.asignedRights.groupId;

    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.users1");
    console.log(this.sessionId.entity,"this.users1");

    this.permit1.createdBy=this.sessionId.entity.userId;
    console.log(this.permit1.createdBy, "this.users1.createdBy")
    console.log(this.permit1.permitId,"finding permit id" )
      this.permitService.addPermit(this.permit1).subscribe(res => {
        this.res = res;
        console.log(this.res,"LLLLLLLLLLLLLLLL")
        if (this.res.status === 200) {
          this.appEditMode = false;
          this.asignedRights = [];
          this.rights = [];
          this.permit1 = {};
          this.getAllPermits();
          this.modalService.dismissAll();
          this.blockUI.stop();
          return this.toastr.success('Great! Permit saved Successfully', 'Success!', { timeOut: 4000 });
        }
        if (this.res.status === true) {
          // if (this.userGroup.id === 0) {
          //     this.log(this.rightId, 'added group ' + this.userGroup.groupName);
          // } else {
          //     this.log(this.rightId, 'modified group ' + this.userGroup.id);
          // }
          this.appEditMode = false;
          this.asignedRights = [];
          this.rights = [];
          this.userGroup = {};
          this.getAllPermits();
          this.modalService.dismissAll();
          this.blockUI.stop();
          return this.toastr.success(this.res.respMessage, 'Success!', { timeOut: 4000 });
        }
      }, error => {
        // this.log(this.rightId, 'server error updating user group ');
        this.blockUI.stop();
        return this.toastr.error('Error in loading data.', 'Error!', { timeOut: 4000 });
      });

  }
  updatePermit(){
   // this.permit1 = this.permitForm.value;
     console.log(this.permit1.permitId,"when updating")
    this.permit1.applicant= this.permitForm.get('applicant').value;
    this.permit1.businessName= this.permitForm.get('businessName').value;
    this.permit1.noOfEmployees= this.permitForm.get('noOfEmployees').value;
    this.permit1.permitTypeId= this.permitForm.get('permitTypeId').value;

    this.permit1.postalTown= this.permitForm.get('postalTown').value;
    this.permit1.regNo= this.permitForm.get('regNo').value;
    this.permit1.businessDesc= this.permitForm.get('businessDesc').value;
    this.permit1.postalAdd= this.permitForm.get('postalAdd').value;
    this.permit1.postalCode= this.permitForm.get('postalCode').value;
    this.permit1.email= this.permitForm.get('email').value;
    this.permit1.fax= this.permitForm.get('fax').value;
    this.permit1.mobileNo= this.permitForm.get('mobileNo').value;
    this.permit1.landLineNo= this.permitForm.get('landLineNo').value;
    this.permit1.subcountyId= this.permitForm.get('subcountyId').value;
    this.permit1.wardId= this.permitForm.get('wardId').value;
    //this.permit1.fee= this.permitForm.get('fee').value;
    this.permit1.landZone= this.permitForm.get('landZone').value;
    this.permit1.plotNo= this.permitForm.get('plotNo').value;

    //this.permit1.businessId= this.permitForm.get('businessId').value;
    this.permit1.nationalId= this.permitForm.get('nationalId').value;
    this.permit1.altMobileNo= this.permitForm.get('altMobileNo').value;
    this.permit1.building= this.permitForm.get('building').value;
    this.permit1.room= this.permitForm.get('room').value;
    this.permit1. applicantFax= this.permitForm.get('applicantFax').value;
    this.permit1.PIN= this.permitForm.get('PIN').value;
    this.permit1.applicantMobile= this.permitForm.get('applicantMobile').value;
    this.permit1.personalNumber= this.permitForm.get('personalNumber').value;
    this.permit1.personalAdd= this.permitForm.get('personalAdd').value;
    this.permit1.personalCode= this.permitForm.get('personalCode').value;
    this.permit1.area= this.permitForm.get('area').value;
    this.permit1.otherActivity= this.permitForm.get('otherActivity').value;

   const permit2 ={
     'permitId':this.permit1.permitId,
     'applicant':this.permit1.applicant,
     'businessName':this.permit1.businessName,
     'noOfEmployees':this.permit1.noOfEmployees,
     'permitTypeId':this.permit1.permitTypeId,

     //this.permit1.area= this.permitForm.get('area').value;
     'PIN':this.permit1.PIN,
     'regNo':this.permit1.regNo,
     'businessDesc':this.permit1.businessDesc,
     'postalAdd':this.permit1.postalAdd,
     'postalCode':this.permit1.postalCode,
     'email':this.permit1.email,
     'fax':this.permit1.fax,
     'mobileNo':this.permit1.mobileNo,
     'landLineNo':this.permit1.landLineNo,
     'subcountyId':this.permit1.subcountyId,
     'WardId':this.permit1.WardId,
     // this.permit1.wardSelect= this.permitForm.get('wardSelect').value;
     //this.permit1.marketSelect= this.permitForm.get('marketSelect').value;
     'landZone':this.permit1.landZone,
     'plotNo':this.permit1.plotNo,
     'wardId':this.permit1.wardId,
     'fee':this.permit1.fee,

     //this.permit1.businessId= this.permitForm.get('businessId').value;
     'nationalId':this.permit1.nationalId,
     'altMobileNo': this.permit1.altMobileNo,
   'building': this.permit1.building,
   'room': this.permit1.room,
   'applicantFax': this.permit1.applicantFax,
   'applicantMobile':this.permit1.applicantMobile,
   'personalNumber': this.permit1.personalNumber,
   'personalAdd': this.permit1.personalAdd,
   'personalCode': this.permit1.personalCode,
   'area': this.permit1.area,
   'otherActivity': this.permit1.otherActivity,


   }
   console.log(permit2," PPPPPPPPPPPPPPPPPP")
    this.permitService.addPermit(permit2).subscribe(res => {
      this.res = res;
      console.log(this.res,"LLLLLLLLLLLLLLLL")
      if (this.res.status === 200) {
        this.appEditMode = false;
        this.asignedRights = [];
        this.rights = [];
        this.userGroup = {};
        this.getAllPermits();
        this.modalService.dismissAll();
        this.blockUI.stop();
        return this.toastr.success('Great! Permit saved Successfully', 'Success!', { timeOut: 4000 });
      }
      if (this.res.status === true) {
        // if (this.userGroup.id === 0) {
        //     this.log(this.rightId, 'added group ' + this.userGroup.groupName);
        // } else {
        //     this.log(this.rightId, 'modified group ' + this.userGroup.id);
        // }
        this.appEditMode = false;
        this.asignedRights = [];
        this.rights = [];
        this.userGroup = {};
        this.getAllPermits();
        this.modalService.dismissAll();
        this.blockUI.stop();
        return this.toastr.success(this.res.respMessage, 'Success!', { timeOut: 4000 });
      }
    }, error => {
      // this.log(this.rightId, 'server error updating user group ');
      this.blockUI.stop();
      return this.toastr.error('Error in loading data.', 'Error!', { timeOut: 4000 });
    });
  }

  /**
   * gets the list of wards based on subcounty selected
   */

  cancel() {

    this.appEditMode = false;
    this.getAllPermits();
  }
  getWards(){
    //  this.blockUI.start("Loading data....");

    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.subCountyId,"this.ward1");
    console.log(this.sessionId.entity,"this.ward1");
    console.log(this.region1,"region here")

    this.regionSvc.gtWard().subscribe(subCountys =>{
      // if(data){

      this.showWards=true;
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


      this.showWards=false;
    this.regionSvc.gtSubcounty().subscribe(subCountys =>{
      // if(data){


      this.region1 = subCountys;

      //this.blockUI.stop();
      /* }
       else{*/

        console.log(this.region1, "data.message");
        // this.blockUI.stop();
        //return this.toastr.info(data.message);
        //}

    },()=>{
      console.log("error fetching customers...");
      //this.blockUI.stop();
    })
  }
  selectAllViewRights() {
    for (let i = 0; i < this.rights.length; i++) {
      this.rights[i].allowView = this.rightView;
    }
  }
  selectAllAddRights() {
    for (let i = 0; i < this.rights.length; i++) {
      this.rights[i].allowAdd = this.rightAdd;
    }
  }
  selectAllEditRights() {
    for (let i = 0; i < this.rights.length; i++) {
      this.rights[i].allowEdit = this.rightEdit;
    }
  }

  ngOnDestroy() {
    //
    this.userGroups = [];
    this.rights = [];
    this.initRights = [];
    this.userGroup = {};
    this.asignedRights = [];
    this.response = null;
  }

}


export let settings = {
  mode: 'external',
  actions: {
    delete: false,
    position: 'right',
  },
  columns: {
    id: {
      title: '#',
      filter: false
    },
    groupCode: {
      title: 'Code',
      filter: true
    },
    groupName: {
      title: 'Name',
      filter: true
    }
  },
  edit: {
    // tslint:disable-next-line:max-line-length
    editButtonContent: '<a class="btn btn-block btn-outline-success m-r-10"> <i class="fas fa-check-circle text-info-custom"></i></a>',
    saveButtonContent: '<i class="ti-save text-success m-r-10"></i>',
    cancelButtonContent: '<i class="ti-close text-danger"></i>'
  },
  add: {
    // tslint:disable-next-line:max-line-length
    addButtonContent: '<a class="btn btn-block btn-outline-info m-r-10"> <i class="fas fa-plus-circle"></i></a>',
    createButtonContent: '<i class="nb-checkmark"></i>',
    cancelButtonContent: '<i class="nb-close"></i>',
  },
};
