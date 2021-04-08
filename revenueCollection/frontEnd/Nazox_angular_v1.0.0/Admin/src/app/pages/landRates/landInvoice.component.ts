import { Component, OnInit, OnDestroy } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';

import { ToastrService } from 'ngx-toastr';

import { BlockUI, NgBlockUI } from 'ng-block-ui';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

import {RegionService} from "../services/region.service";
import {LandService} from "../services/landRates.service";



@Component({
  templateUrl: './landInvoice.html',


})
export class LandInvoiceComponent implements OnInit, OnDestroy {
  groups: any;
  types: any;
  breadCrumbItems: Array<{}>;
  res: any;
  userGroups: any = [];
  rights: any = [];
  reportUrl:any;
  showPaymentModes:any;
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
  public land1: any = [];
  public region1: any = [];
  public ward1: any = [];

  public permitType1: any = [];
  rId:any;
  ug:any;
  idRight:any;
  rightId: any;
  session: any = {};
  landForm: FormGroup;
  appEditMode:any;
  appDetailMode:any;
  source: LocalDataSource;
  @BlockUI() blockUI: NgBlockUI;
  constructor(private Landervice: LandService,private regionSvc: RegionService,public formBuilder: FormBuilder, private toastr: ToastrService,  private modalService: NgbModal) {


  }
  settings = settings;


  ngOnInit() {
    this.getAllLand();
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

  initAddLand() {
    //  this.initUserRights();
    this.appEditMode = true;
    this.appDetailMode=false;



    this.landForm = this.formBuilder.group({
      plotNumber: ['', [Validators.required]],
      //sublocation: ['', [Validators.required]],
      code: ['', [Validators.required]],
      phone: ['', [Validators.required]],
      address: ['', [Validators.required]],
      mapSheetNumber: ['', [Validators.required]],
      // location: ['', [Validators.required]],
      acreage: ['', [Validators.required]],
      titleDeedNumber: ['', [Validators.required]],
      name: ['', [Validators.required]],
      krapin: ['', [Validators.required]],
      nationalIdNumber: ['', [Validators.required]],
      wardId: ['', [Validators.required]],
      subcountyId: ['', [Validators.required]],
      id: ['', [Validators.required]],

      permitTypeId: ['', [Validators.required]],




    });


  }
  get form() {
    return this.landForm.controls;
  }
  printInvoice() {

    console.log('clicked....');

   // this.reportUrl = `/erevenue/reports?type=R&businessNo=${this.businessNo}&paidUser=${this.paidUser}&year=${this.appliedFor}`;
  }
  initEditLand($event) {
    this.appEditMode = true;
    this.appDetailMode=true;
    this.showPaymentModes=true;
    this.land1.permitId=$event.LandId;
    this.title = 'update';
    console.log(this.land1.id,'  this.land1.LandId')
    this.landForm = this.formBuilder.group({

      plotNumber:new FormControl($event.plotNumber, Validators.required),

      code:new FormControl($event.code, Validators.required),
      phone:new FormControl($event.phone, Validators.required),
      address:new FormControl($event.address, Validators.required),
      mapSheetNumber:new FormControl($event.mapSheetNumber, Validators.required),
      paymentMode:new FormControl($event.paymentMode, Validators.required),
      mpesaCode:new FormControl($event.mpesaCode, Validators.required),
      regNo:new FormControl($event.regNo, Validators.required),
      paidStatus:new FormControl($event.paidStatus, Validators.required),
      fee:new FormControl($event.fee, Validators.required),
      acreage:new FormControl($event.acreage, Validators.required),
      titleDeedNumber:new FormControl($event.titleDeedNumber, Validators.required),
      name :new FormControl($event.name, Validators.required),
      krapin :new FormControl($event.krapin, Validators.required),
      nationalIdNumber :new FormControl($event.nationalIdNumber, Validators.required),
      wardId:new FormControl($event.wardId, Validators.required),
      subcountyId:new FormControl($event.subcountyId, Validators.required),
      id:new FormControl($event.id, Validators.required),

      permitTypeId:new FormControl($event.permitTypeId, Validators.required),

      //name: ['', [Validators.required]]
    })

  }

  getAllLand() {
    this.blockUI.start('Loading group data...');
    this.appEditMode=false;
    this.Landervice.gtLand().subscribe(data => {
      console.log(JSON.stringify(data),"HEREEEEEEEEEEEEEE")
      this.land1 = data;

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
    this.Landervice.gtPermitType().subscribe(data => {

      console.log(JSON.stringify(data),"HEREEEEEEEEEEEEEE")
      this.permitType1 = data;

      this.blockUI.stop();

    }, error => {
      this.blockUI.stop();
      return this.toastr.error('Error in loading  data.', 'Error!', { timeOut: 4000 });
    });
  }

  addLand() {
    if (this.land1.businessName === '') {
      this.toastr.warning('Please specify the businessName', 'Alert!', { timeOut: 4000 });
    }
    if (this.land1.PIN === '') {
      this.toastr.warning('Please specify the PIN', 'Alert!', { timeOut: 4000 });
    }
    if (this.land1.postalAdd === '') {
      this.toastr.warning('Please specify the postal Address', 'Alert!', { timeOut: 4000 });
    }
    if (this.land1.mobileNo === '') {
      this.toastr.warning('Please specify the  Business mobileNo', 'Alert!', { timeOut: 4000 });
    }
    if (this.land1.email === '') {
      this.toastr.warning('Please specify the Business Email', 'Alert!', { timeOut: 4000 });
    }
    if (this.land1.landZone === '') {
      this.toastr.warning('Please specify the Physical Address', 'Alert!', { timeOut: 4000 });
    }
    if (this.land1.applicant === '') {
      this.toastr.warning('Please specify the applicant name', 'Alert!', { timeOut: 4000 });
    }
    if (this.land1.nationalId === '') {
      this.toastr.warning('Please specify the nationalId', 'Alert!', { timeOut: 4000 });
    }
    if (this.land1.applicantMobile === '') {
      this.toastr.warning('Please specify the applicant Mobile', 'Alert!', { timeOut: 4000 });
    }
    if (this.land1.personalAdd === '') {
      this.toastr.warning('Please specify the applicant Postal Add', 'Alert!', { timeOut: 4000 });
    }
    if (this.land1.businessDesc === '') {
      this.toastr.warning('Please specify the business Description', 'Alert!', { timeOut: 4000 });
    }
    if (this.land1.area === '') {
      this.toastr.warning('Please specify the area', 'Alert!', { timeOut: 4000 });
    }
    if (this.land1.permitTypeId === '') {
      this.toastr.warning('Please specify the Permit Type', 'Alert!', { timeOut: 4000 });
    }
    if (this.land1.subCountyId === '') {
      this.toastr.warning('Please specify the Subcounty', 'Alert!', { timeOut: 4000 });
    }

    if (this.land1.wardId === '') {
      this.toastr.warning('Please specify the Ward', 'Alert!', { timeOut: 4000 });
    }
    this.land1 = this.landForm.value;

    this.land1.plotNumber= this.landForm.get('plotNumber').value;

    this.land1.code= this.landForm.get('code').value;
    this.land1.phone= this.landForm.get('phone').value;
    this.land1.address= this.landForm.get('address').value;
    this.land1.mapSheetNumber= this.landForm.get('mapSheetNumber').value;

    this.land1.acreage= this.landForm.get('acreage').value;
    this.land1.titleDeedNumber= this.landForm.get('titleDeedNumber').value;
    this.land1.name = this.landForm.get('name').value;
    this.land1.krapin = this.landForm.get('krapin').value;
    this.land1.nationalIdNumber = this.landForm.get('nationalIdNumber').value;
    this.land1.wardId= this.landForm.get('wardId').value;
    this.land1.subcountyId= this.landForm.get('subcountyId').value;
    this.land1.id= this.landForm.get('id').value;

    this.land1.permitTypeId= this.landForm.get('permitTypeId').value;
    //this.land1.name= this.landForm.get('name').value;
    //this.land1.id=this.asignedRights.groupId;

    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.users1");
    console.log(this.sessionId.entity,"this.users1");

    this.land1.createdBy=this.sessionId.entity.userId;
    console.log(this.land1.createdBy, "this.users1.createdBy")
    console.log(this.land1.permitId,"finding permit id" )
    this.Landervice.addLand(this.land1).subscribe(res => {
      this.res = res;
      console.log(this.res,"LLLLLLLLLLLLLLLL")
      if (this.res.status === 200) {
        this.appEditMode = false;
        this.asignedRights = [];
        this.rights = [];
        this.land1 = {};
        this.getAllLand();
        this.modalService.dismissAll();
        this.blockUI.stop();
        return this.toastr.success('Great! Land saved Successfully', 'Success!', { timeOut: 4000 });
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
        this.getAllLand();
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
  updateLand(){
    this.land1 = this.landForm.value;

    this.land1.mpesaCode == this.landForm.get('mpesaCode').value;
    console.log(this.land1.mpesaCode,"when updating");
    if (this.land1.mpesaCode==null) {
       return this.toastr.warning('Please fill in the mpesa code', 'Alert!', { timeOut: 4000 });
     // return false;
    }

    this.land1.plotNumber= this.landForm.get('plotNumber').value;

    this.land1.code= this.landForm.get('code').value;
    this.land1.phone= this.landForm.get('phone').value;
    this.land1.address= this.landForm.get('address').value;
    this.land1.mapSheetNumber= this.landForm.get('mapSheetNumber').value;

    this.land1.acreage= this.landForm.get('acreage').value;
    this.land1.titleDeedNumber= this.landForm.get('titleDeedNumber').value;
    this.land1.name = this.landForm.get('name').value;
    this.land1.krapin = this.landForm.get('krapin').value;
    this.land1.nationalIdNumber = this.landForm.get('nationalIdNumber').value;
    this.land1.wardId= this.landForm.get('wardId').value;
    this.land1.subcountyId= this.landForm.get('subcountyId').value;
    this.land1.id= this.landForm.get('id').value;
    this.land1.paymentMode= this.landForm.get('paymentMode').value;
      this.land1.mpesaCode= this.landForm.get('mpesaCode').value;


    this.land1.permitTypeId= this.landForm.get('permitTypeId').value;
    const Land2 ={
      'id':this.land1.id,
      'plotNumber':this.land1.plotNumber,

      'code': this.land1.code,
      'phone': this.land1.phone,
      'address': this.land1.address,
      'mapSheetNumber': this.land1.mapSheetNumber,

      'acreage': this.land1.acreage,
      'titleDeedNumber' :this.land1.titleDeedNumber,
      'name ' :this.land1.name,
      'krapin ':this.land1.krapin,
      'nationalIdNumber ':this.land1.nationalIdNumber,
      'wardId': this.land1.wardId,
      'subcountyId': this.land1.subcountyId,

      'paymentMode':this.land1.paymentMode,
      'mpesaCode':this.land1.mpesaCode,

      'permitTypeId':this.land1.permitTypeId,


    }
    console.log(Land2," PPPPPPPPPPPPPPPPPP")
    this.Landervice.addLand(Land2).subscribe(res => {
      this.res = res;
      console.log(this.res,"LLLLLLLLLLLLLLLL")
      if (this.res.status === 200) {
        this.appEditMode = false;
        this.asignedRights = [];
        this.rights = [];
        this.userGroup = {};
        this.getAllLand();
        this.modalService.dismissAll();
        this.blockUI.stop();
        return this.toastr.success('Great! Land saved Successfully', 'Success!', { timeOut: 4000 });
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
        this.getAllLand();
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
    this.getAllLand();
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
