import { Component, OnInit, OnDestroy } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { AdministrationService } from '../../services/administration.service';
import { ToastrService } from 'ngx-toastr';

import { BlockUI, NgBlockUI } from 'ng-block-ui';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

import {RegionService} from "../../services/region.service";
import {PermitService} from "../../services/permitService";
import {ReportsService} from "../../services/reports.service";

@Component({
  templateUrl: './invoice.component.html',
  styleUrls:['./invoice.component.css']


})
export class InvoiceComponent implements OnInit, OnDestroy {
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
  reportUrl:any;
  title: string;
  button: string;
  showWards:any;
  showPaymentModes:any;
  public invoice1: any = [];
  public region1: any = [];
  public ward1: any = [];

  public invoiceType1: any = [];
  rId:any;
  ug:any;
  idRight:any;
  rightId: any;
  session: any = {};
  invoiceForm: FormGroup;

  appEditMode:any;
  appDetailMode:any;
  source: LocalDataSource;
  @BlockUI() blockUI: NgBlockUI;
  public permitType1: any;
  private appliedFor: any;
  private businessNo: any;
  private paidUser: any;
  constructor(private invoiceService: PermitService,private regionSvc: RegionService,public formBuilder: FormBuilder, private reportSvc: ReportsService,private toastr: ToastrService,  private modalService: NgbModal) {


  }
  settings = settings;



  ngOnInit() {
    this.getAllinvoices();
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
  getAllpermitTypes() {
    this.blockUI.start('Loading group data...');
    this.invoiceService.gtPermitType().subscribe(data => {


      this.permitType1 = data;
      console.log( this.permitType1 ,"HEREEEEEEEEEEEEEE")
      this.blockUI.stop();

    }, error => {
      this.blockUI.stop();
      return this.toastr.error('Error in loading  data.', 'Error!', { timeOut: 4000 });
    });
  }
  initAddinvoice() {
    //  this.initUserRights();
    this.appEditMode = true;
    this.appDetailMode=false;

    this.invoiceForm = this.formBuilder.group({
      applicant: ['', [Validators.required]],
      businessName: ['', [Validators.required]],
      noOfEmployees: ['', [Validators.required]],
      invoiceTypeId: ['', [Validators.required]],
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
    return this.invoiceForm.controls;
  }

  initEditinvoice($event) {;
    this.appEditMode = true;
    this.appDetailMode=true;
    this.showPaymentModes=true;
    this.invoice1.permitId=$event.permitId;
    this.title = 'update';
    console.log(this.invoice1.permitId,'  this.invoice1.invoiceId')
    this.invoiceForm = this.formBuilder.group({


   // invoiceDetailModefalse:new FormControl($event.applicant, Validators.required),
      applicant:new FormControl($event.applicant, Validators.required),

      noOfEmployees:new FormControl($event.noOfEmployees, Validators.required),

      vat:new FormControl($event.vat, Validators.required),

      area:new FormControl($event.area, Validators.required),

      businessDesc:new FormControl($event.businessDesc, Validators.required),
      postalAdd:new FormControl($event.postalAdd, Validators.required),
      postalCode:new FormControl($event.postalCode, Validators.required),
      email:new FormControl($event.email, Validators.required),
      fax:new FormControl($event.fax, Validators.required),
      mobileNo:new FormControl($event.mobileNo, Validators.required),
      landLineNo:new FormControl($event.landLineNo, Validators.required),
      subcountyId:new FormControl($event.subcountyId, Validators.required),
      paidStatus:new FormControl($event.paidStatus, Validators.required),

      wardId:new FormControl($event.wardId, Validators.required),

      landZone:new FormControl($event.landZone, Validators.required),
      plotNo:new FormControl($event.plotNo, Validators.required),

      //businessId:new FormControl($event.firstname, Validators.required),
      nationalId:new FormControl($event.nationalId, Validators.required),

      altMobileNo:new FormControl($event.altMobileNo, Validators.required),
      building:new FormControl($event.building, Validators.required),
      room:new FormControl($event.room, Validators.required),
      applicantFax:new FormControl($event.nationalId, Validators.required),
      applicantMobile:new FormControl($event.applicantFax, Validators.required),
      personalNumber:new FormControl($event.personalNumber, Validators.required),
      personalAdd:new FormControl($event.personalAdd, Validators.required),
      personalCode:new FormControl($event.personalCode, Validators.required),

      otherActivity:new FormControl($event.nationalId, Validators.required),
      businessName:new FormControl({value:$event.businessName,disabled:true}, Validators.required),
      permitTypeId:new FormControl({value:$event.permitTypeId,disabled:true}, Validators.required),
      regNo:new FormControl($event.regNo, Validators.required),
      PIN:new FormControl($event.PIN, Validators.required),
      fee:new FormControl($event.fee, Validators.required),
      paymentMode:new FormControl($event.paymentMode, Validators.required),
      mpesaCode:new FormControl($event.mpesaCode, Validators.required),
      bankName:new FormControl($event.bankName, Validators.required),
      accNo:new FormControl($event.accNo, Validators.required),
      transNo:new FormControl($event.transNo, Validators.required)


    //name: ['', [Validators.required]]
    })
    console.log(this.invoice1.permitTypeId,"MMMMMMMMMMMMMMM")
/*   if(this.invoice1.paymentMode =='M'){

   }*/

  }

  getAllinvoices() {
    this.blockUI.start('Loading group data...');
    this.appEditMode=false;
    this.invoiceService.gtinvoice().subscribe(data => {
      console.log(JSON.stringify(data),"HEREEEEEEEEEEEEEE")
      this.invoice1 = data;

      this.blockUI.stop();

    }, error => {
      this.blockUI.stop();
      return this.toastr.error('Error in loading  data.', 'Error!', { timeOut: 4000 });
    });
  }
  /**
   * gets the list of wards based on subcounty selected
   */


  getAllinvoiceTypes() {
    this.blockUI.start('Loading group data...');
    this.invoiceService.gtPermitType().subscribe(data => {

      console.log(JSON.stringify(data),"HEREEEEEEEEEEEEEE")
      this.invoiceType1 = data;

      this.blockUI.stop();

    }, error => {
      this.blockUI.stop();
      return this.toastr.error('Error in loading  data.', 'Error!', { timeOut: 4000 });
    });
  }

  addinvoice() {

   // this.invoice1 = this.invoiceForm.value;



      //this.invoice1.regNo= this.invoiceForm.get('regNo').value;
    console.log(this.invoice1.permitId,"when updatingg")
      this.invoice1.fee= this.invoiceForm.get('fee').value;
   // this.invoice1.balance= this.invoiceForm.get('balance').value;
    this.invoice1.paymentMode= this.invoiceForm.get('paymentMode').value;
   // this.invoice1.amountPaid= this.invoiceForm.get('amountPaid').value;
    this.invoice1.bankName= this.invoiceForm.get('bankName').value;
    this.invoice1.accNo= this.invoiceForm.get('accNo').value;
    this.invoice1.transNo= this.invoiceForm.get('transNo').value;
    this.invoice1.mpesaCode= this.invoiceForm.get('mpesaCode').value;
    const invoice2 = {
      'permitId': this.invoice1.permitId,
      //'businessName': this.invoice1.businessName,
      //'regNo': this.invoice1.regNo,
      //'PIN': this.invoice1.PIN,
      //'permitTypeId': this.invoice1.permitTypeId,
      'fee': this.invoice1.fee,
      'paymentMode': this.invoice1.paymentMode,
      'bankName': this.invoice1.bankName,
      'accNo': this.invoice1.accNo,
      'transNo': this.invoice1.transNo,
      'mpesaCode': this.invoice1.mpesaCode,
    };



      /* this.invoice1.waterAccNo= this.invoiceForm.get('waterAccNo').value;

       this.invoice1.electricityAccNo= this.invoiceForm.get('electricityAccNo').value;*/





    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.users1");
    console.log(this.sessionId.entity,"this.users1");

    this.invoice1.createdBy=this.sessionId.entity.userId;
    console.log(this.invoice1.createdBy, "this.users1.createdBy")
    console.log(this.invoice1.invoiceId,"finding invoice id" );
    console.log(invoice2,"mbona empty")
    this.invoiceService.addPermit(invoice2).subscribe(res => {
      this.res = res;
      console.log(this.res,"LLLLLLLLLLLLLLLL")
      if (this.res.status === 200) {
        this.appEditMode = false;
        this.asignedRights = [];
        this.rights = [];
        this.invoice1 = {};
        this.getAllinvoices();
        this.modalService.dismissAll();
        this.blockUI.stop();
        return this.toastr.success('Great! invoice saved Successfully', 'Success!', { timeOut: 4000 });
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
        this.getAllinvoices();
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
  updateinvoice(){
    // this.invoice1 = this.invoiceForm.value;
    console.log(this.invoice1.invoiceId,"when updating")
    this.invoice1.applicant= this.invoiceForm.get('applicant').value;
    this.invoice1.businessName= this.invoiceForm.get('businessName').value;
    this.invoice1.noOfEmployees= this.invoiceForm.get('noOfEmployees').value;
    this.invoice1.permitTypeId= this.invoiceForm.get('permitTypeId').value;
    this.invoice1.fee= this.invoiceForm.get('fee').value;
    //this.invoice1.area= this.invoiceForm.get('area').value;
    this.invoice1.regNo= this.invoiceForm.get('regNo').value;
    this.invoice1.businessDesc= this.invoiceForm.get('businessDesc').value;
    this.invoice1.postalAdd= this.invoiceForm.get('postalAdd').value;
    this.invoice1.postalCode= this.invoiceForm.get('postalCode').value;
    this.invoice1.email= this.invoiceForm.get('email').value;
    this.invoice1.fax= this.invoiceForm.get('fax').value;
    this.invoice1.mobileNo= this.invoiceForm.get('mobileNo').value;
    this.invoice1.landLineNo= this.invoiceForm.get('landLineNo').value;
    this.invoice1.subcountyId= this.invoiceForm.get('subcountyId').value;
    this.invoice1.wardId= this.invoiceForm.get('wardId').value;
    //this.invoice1.marketSelect= this.invoiceForm.get('marketSelect').value;
    this.invoice1.landZone= this.invoiceForm.get('landZone').value;
    this.invoice1.plotNo= this.invoiceForm.get('plotNo').value;

    //this.invoice1.businessId= this.invoiceForm.get('businessId').value;
    this.invoice1.nationalId= this.invoiceForm.get('nationalId').value;
    this.invoice1.altMobileNo= this.invoiceForm.get('altMobileNo').value;
    this.invoice1.building= this.invoiceForm.get('building').value;
    this.invoice1.room= this.invoiceForm.get('room').value;
    this.invoice1. applicantFax= this.invoiceForm.get('applicantFax').value;
    this.invoice1.applicantMobile= this.invoiceForm.get('applicantMobile').value;
    this.invoice1.personalNumber= this.invoiceForm.get('personalNumber').value;
    this.invoice1.personalAdd= this.invoiceForm.get('personalAdd').value;
    this.invoice1.personalCode= this.invoiceForm.get('personalCode').value;
    this.invoice1.area= this.invoiceForm.get('area').value;
    this.invoice1.otherActivity= this.invoiceForm.get('otherActivity').value;
    this.invoice1.paymentMode= this.invoiceForm.get('paymentMode').value;
    this.invoice1.PIN= this.invoiceForm.get('PIN').value;
    this.invoice1.bankName= this.invoiceForm.get('bankName').value;
    this.invoice1.accNo= this.invoiceForm.get('accNo').value;
    this.invoice1.transNo= this.invoiceForm.get('transNo').value;
    this.invoice1.mpesaCode= this.invoiceForm.get('mpesaCode').value;

    const invoice2 ={
      'permitId':this.invoice1.permitId,
      'applicant':this.invoice1.applicant,
      'businessName':this.invoice1.businessName,
      'noOfEmployees':this.invoice1.noOfEmployees,
      'invoiceTypeId':this.invoice1.invoiceTypeId,

      //this.invoice1.area= this.invoiceForm.get('area').value;
      'regNo':this.invoice1.regNo,
      'businessDesc':this.invoice1.businessDesc,
      'postalAdd':this.invoice1.postalAdd,
      'postalCode':this.invoice1.postalCode,
      'email':this.invoice1.email,
      'fax':this.invoice1.fax,
      'mobileNo':this.invoice1.mobileNo,
      'landLineNo':this.invoice1.landLineNo,
      'subcountyId':this.invoice1.subcountyId,

      'PIN':this.invoice1.PIN,
      // this.invoice1.wardSelect= this.invoiceForm.get('wardSelect').value;
      //this.invoice1.marketSelect= this.invoiceForm.get('marketSelect').value;
      'landZone':this.invoice1.landZone,
      'plotNo':this.invoice1.plotNo,
      'wardId':this.invoice1.wardId,
      'permitTypeId':this.invoice1.permitTypeId,
      //this.invoice1.businessId= this.invoiceForm.get('businessId').value;
      'nationalId':this.invoice1.nationalId,
      'altMobileNo': this.invoice1.altMobileNo,
      'building': this.invoice1.building,
      'room': this.invoice1.room,
      'applicantFax': this.invoice1.applicantFax,
      'applicantMobile':this.invoice1.applicantMobile,
      'personalNumber': this.invoice1.personalNumber,
      'personalAdd': this.invoice1.personalAdd,
      'personalCode': this.invoice1.personalCode,
      'area': this.invoice1.area,
      'otherActivity': this.invoice1.otherActivity,
      'fee': this.invoice1.fee,
      'paymentMode': this.invoice1.paymentMode,
      'bankName': this.invoice1.bankName,
      'accNo': this.invoice1.accNo,
      'transNo': this.invoice1.transNo,
      'mpesaCode': this.invoice1.mpesaCode,

    }
    console.log(invoice2," PPPPPPPPPPPPPPPPPP")
    this.invoiceService.addinvoice(invoice2).subscribe(res => {
      this.res = res;
      console.log(this.res,"LLLLLLLLLLLLLLLL")
      if (this.res.status === 200) {
        this.appEditMode = false;
        this.asignedRights = [];
        this.rights = [];
        this.userGroup = {};
        this.getAllinvoices();
        this.modalService.dismissAll();
        this.blockUI.stop();
        return this.toastr.success('Great! invoice saved Successfully', 'Success!', { timeOut: 4000 });
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
        this.getAllinvoices();
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
    this.getAllinvoices();
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
  /**
   * prints the invoice and payment receipts
   */
 printInvoice1=function(){

   console.log('clicked....');
    if(this.invoice1.paidStatus=="Paid"){
    this.reportUrl = '/erevenue/reports?type=R&businessNo=' + this.invoice1.businessNo+'&paidUser=' + this.invoice1.paidUser+'&year='+this.invoice1.appliedFor;
    }else{
      this.reportUrl = '/erevenue/reports?type=I&businessNo=' + this.invoice1.businessNo+'&approvedUser ='+ this.invoice1.approvedUser+'&year='+ this.invoice1.appliedFor;
    }
  }

  printInvoice() {

    console.log('clicked....');

    this.reportUrl = `erevenue/reports?type=I&businessNo=${this.businessNo}&paidUser=${this.paidUser}&year=${this.appliedFor}`;
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
