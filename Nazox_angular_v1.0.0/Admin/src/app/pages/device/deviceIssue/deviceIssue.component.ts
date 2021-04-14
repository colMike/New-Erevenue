import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';


import {ToastrService} from 'ngx-toastr';


import {DOCUMENT} from '@angular/common';

import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {DeviceService} from '../../services/device.service';


@Component({
  selector: 'app-subCountys',
  templateUrl: './deviceIssue.component.html',


})
export class DeviceIssueComponent implements OnInit {

  // breadcrumb items
  breadCrumbItems: Array<{}>;
  public Device1: any = [];
  public region1: any = [];
  arrs = [];
  public subCountys: any = [];
  submitted: boolean;
  public response: any = null;
  isAddMode: boolean;
  isExisting: boolean;
  subCountyId: any;
  sessionId: any;
  status: any;
  storageObject: any = {};

  // subCountysData: subCountys[];

  deviceIssueForm: FormGroup;

  // constructor(private modalService: NgbModal, public formBuilder: FormBuilder) { }
  public pos1: any;
  public DeviceIssue1: any;

  constructor(private toastr: ToastrService,
              private deviceRegSvc: DeviceService, @Inject(DOCUMENT) private document: any, public formBuilder: FormBuilder,
              private modalService: NgbModal
  ) {
  }

  /**
   * Returns form
   */
  get form() {
    return this.deviceIssueForm.controls;
  }

  ngOnInit(): void {
    this.getPosUsers();
    this.getDevicesIssued();

    this.getDevicesToIssue();


    // this.initAddsubCounty();
    // this.initEditsubCounty();
    /*  this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'subCountys', active: true }];*/

    /* this.deviceIssueForm = this.formBuilder.group({
       DeviceName: ['', [Validators.required]],
       subCountyFullName: ['', [Validators.required]],
       subCountyPhone: ['', [Validators.required]],
       subCountyEmail: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
       active: ['', [Validators.required]],
       subCountyNationalId: ['', [Validators.required]]
     });
 */
    // this._fetchData();*/
  }

  /*  private _fetchData() {
      this.subCountysData = subCountysData;
    }*/

  initAddDevice(): void {
    this.isAddMode = true;
    this.isExisting = false;


    this.deviceIssueForm = this.formBuilder.group({
      device_imei: ['', [Validators.required]],
      userId: ['', [Validators.required]],


    });

  }

  /**
   * Modal Open
   * @param content modal content
   */
  openModal(content: any) {
    this.isAddMode = true;
    this.modalService.open(content, {centered: true});
  }

  /**
   * save the subCountys data
   */
  saveData() {


    this.Device1 = this.deviceIssueForm.value;

    this.Device1.device_imei = this.deviceIssueForm.get('device_imei').value;
    this.Device1.userId = this.deviceIssueForm.get('userId').value;


    // this.Device1.subCountyFullName=(+ this.deviceIssueForm.get('secondname').value +this.deviceIssueForm.get('lastname').value;
    console.log(this.Device1, 'subCountys');
    const session = localStorage.getItem('currentUser');

    this.sessionId = JSON.parse(session);

    console.log(this.sessionId.entity.subCountyId, 'this.Device1');
    console.log(this.sessionId.entity, 'this.Device1');

    this.Device1.issuedBy = this.sessionId.entity.userId;
    console.log(this.Device1.issuedBy, 'this.Device1.createdBy');

    this.deviceRegSvc.addDevice(this.Device1).subscribe((response) => {
      this.response = response;
      console.log(this.response.status, 'response');
      if (this.response.status === 200) {


        // logger.info("Great! The subCounty information was saved succesfully")
        this.modalService.dismissAll();
        this.getDevicesIssued();
        return this.toastr.success('Great! The subCounty information was saved succesfully"', ' Success!', {timeOut: 3000});

        // alert("Great! The subCounty information was saved succesfully");

      } else {
        return this.toastr.error('Exception Occurred', ' Error!', {timeOut: 3000});

      }
      this.submitted = true;
    });
  }

  initEditDevice(device) {
    this.isAddMode = false;
    this.isExisting = true;
    this.Device1.id = device.id;
    console.log(this.Device1, 'subCounty id ................');
    this.deviceIssueForm = this.formBuilder.group({
      device_imei: new FormControl(device.device_imei, Validators.required),
      userId: new FormControl(device.userId, Validators.required),
      id: new FormControl(device.id, Validators.required)

    });

  }

  cancel() {
    this.getDevicesIssued();
    this.isAddMode = true;
    this.isExisting = true;

  }

  updateDevice() {
    // this.Device1.subCountyId=this.subCountys.subCountyId;
    // this.Device1.subCountyId = this.deviceIssueForm.get('Device1').value;

    // this.Device1.subCountyId=this.subCountyId;


    console.log(this.Device1.subCountyId, ' this.Device1.subCountyId');

    this.Device1.device_imei = this.deviceIssueForm.get('device_imei').value;
    this.Device1.userId = this.deviceIssueForm.get('userId').value;

    const subCounty2 = {
      id: this.Device1.id,
      device_imei: this.Device1.device_imei,
      userId: this.Device1.userId,


    };
    console.log(subCounty2, '$$$$$$$$$$$$$$$');
    console.log(this.Device1, '$$$$$$$$$$$$$$$$');
    this.deviceRegSvc.addDevice(subCounty2).subscribe((response) => {
      this.response = response;
      console.log(this.response.status, 'response');
      if (this.response.status === 200) {


        // logger.info("Great! The subCounty information was saved succesfully")

        this.modalService.dismissAll();


        // alert(response.respMessage);

        this.getDevicesIssued();
        this.isAddMode = true;

        // alert(response.respMessage);
        return this.toastr.success('Great! The device issue information was saved successfully"', ' Success!', {timeOut: 3000});


      } else {
        return this.toastr.error('Exception Occurred', ' Error!', {timeOut: 3000});

      }
      this.submitted = true;
    });
  }

  getDevicesIssued() {
    //  this.blockUI.start("Loading data....");
    this.isAddMode = false;
    const session = localStorage.getItem('currentUser');

    this.sessionId = JSON.parse(session);

    console.log(this.sessionId.entity.subCountyId, 'this.Device1');
    console.log(this.sessionId.entity, 'this.Device1');

    this.deviceRegSvc.gtDevice().subscribe(dev => {
      // if(data){


      this.Device1 = dev;
      console.log(this.Device1);
      this.arrs = this.Device1.collection;
      // this.blockUI.stop();
      console.log(this.arrs);
      /*  for(var i = 0;i <= this.arrs.length - 1;i++){
          const user = {



            device_imei: this.Device1.collection[i]. device_imei,
            active: this.Device1.collection[i].active,
            userFullName: this.Device1.userFullName,


          };
         console.log(user,"LLLLLLLLLLLLL")
          this.Device1.push(user);
          console.log(this.Device1, "console.log(userFullName)")
        }*/
      /* }
       else{*/
      for (let i = 0; i <= this.Device1.length - 1; i++) {
        console.log(this.Device1[i].approved, 'this.Device1.approved');


        if (this.Device1[i].approved === 'N') {

          this.Device1[i].approved === 'Pending Approval';
          console.log(this.Device1[i].approved, '$$$$$$$$$$$$$$$$$$$$');
        } else {
          this.Device1[i].approved === 'Approved';
        }
        console.log(this.Device1, 'data.message');
        // this.blockUI.stop();
        // return this.toastr.info(data.message);
        // }
      }
    }, () => {
      console.log('error fetching customers...');
      // this.blockUI.stop();
    });
  }


  getDevicesToIssue() {
    //  this.blockUI.start("Loading data....");
    this.isAddMode = false;
    const session = localStorage.getItem('currentUser');

    this.sessionId = JSON.parse(session);

    console.log(this.sessionId.entity.subCountyId, 'this.Device1');
    console.log(this.sessionId.entity, 'this.Device1');

    this.deviceRegSvc.getDevicesToIssue().subscribe(dev => {
      // if(data){


      this.DeviceIssue1 = dev;
      // this.blockUI.stop();

      /* }
       else{*/
      for (let i = 0; i <= this.Device1.length - 1; i++) {
        console.log(this.Device1[i].approved, 'this.Device1.approved');


        if (this.Device1[i].approved === 'N') {

          this.Device1[i].approved === 'Pending Approval';
          console.log(this.Device1[i].approved, '$$$$$$$$$$$$$$$$$$$$');
        } else {
          this.Device1[i].approved === 'Approved';
        }
        console.log(this.Device1, 'data.message');
        // this.blockUI.stop();
        // return this.toastr.info(data.message);
        // }
      }
    }, () => {
      console.log('error fetching customers...');
      // this.blockUI.stop();
    });
  }

  getPosUsers() {
    //  this.blockUI.start("Loading data....");
    this.isAddMode = false;
    const session = localStorage.getItem('currentUser');

    this.sessionId = JSON.parse(session);

    console.log(this.sessionId.entity.subCountyId, 'this.Device1');
    console.log(this.sessionId.entity, 'this.Device1');

    this.deviceRegSvc.getPosUsers().subscribe(dev => {
      // if(data){


      this.pos1 = dev;
      console.log(this.pos1, 'looking for serid');


      // console.log(this.DeviceIssue1.userFullName," fullllllllllllllllll")
      // this.blockUI.stop();
      /* }
       else{*/
      for (let i = 0; i <= this.Device1.length - 1; i++) {
        console.log(this.Device1[i].approved, 'this.Device1.approved');


        if (this.Device1[i].approved === 'N') {

          this.Device1[i].approved === 'Pending Approval';
          console.log(this.Device1[i].approved, '$$$$$$$$$$$$$$$$$$$$');
        } else {
          this.Device1[i].approved === 'Approved';
        }
        console.log(this.pos1, 'data.users');
        // this.blockUI.stop();
        // return this.toastr.info(data.message);
        // }
      }
    }, () => {
      console.log('error fetching customers...');
      // this.blockUI.stop();
    });
  }


}
