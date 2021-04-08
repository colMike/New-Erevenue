import { Component, OnInit, OnDestroy } from '@angular/core';
import { LocalDataSource } from 'ng2-smart-table';
import { AdministrationService } from '../../services/administration.service';
import { ToastrService } from 'ngx-toastr';

import { BlockUI, NgBlockUI } from 'ng-block-ui';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {PermitService} from "../../services/permitService";


@Component({
  templateUrl: './permitType.component.html',
  styleUrls: ['./permitType.component.css']

})
export class permitTypeComponent implements OnInit, OnDestroy {
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
  editMode = false;
  rightView = false;
  rightAdd = false;
  rightEdit = false;
  rightDelete = false;
  title: string;
  button: string;
  public permitType1: any = [];
  rId:any;
  ug:any;
  idRight:any;
  rightId: any;
  session: any = {};
  permitTypeForm: FormGroup;
  appEditMode:any;
  appDetailMode:any;
  source: LocalDataSource;
  @BlockUI() blockUI: NgBlockUI;
  constructor(private permitService: PermitService,public formBuilder: FormBuilder, private toastr: ToastrService,  private modalService: NgbModal) {


  }
  settings = settings;

  ngOnInit() {
    this.getAllpermitTypes();
   // this.initUserRights();

  }

  initAddpermitType() {
  //  this.initUserRights();
    this.appEditMode = true;
    this.appDetailMode=false;
    this.permitTypeForm = this.formBuilder.group({
      permitTypeCode : ['', [Validators.required]],
    permitTypeName : ['', [Validators.required]],
    permitFee: ['', [Validators.required]],
   active : ['', [Validators.required]],




  });

  }
  get form() {
    return this.permitTypeForm.controls;
  }

  initEditpermitType($event) {
    this.appEditMode = true;
    this.appDetailMode=true;
    this.permitType1.permitTypeId=$event.permitTypeId;
    this.permitTypeForm = this.formBuilder.group({
      permitTypeCode :new FormControl($event.permitTypeCode, Validators.required),
      permitTypeName:new FormControl($event.permitTypeName, Validators.required),
      permitFee:new FormControl($event.permitFee, Validators.required),
      active :new FormControl($event.active, Validators.required),

  })
  }

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

  savepermitType() {
      this.permitType1 = this.permitTypeForm.value;
      this.permitType1.permitTypeCode= this.permitTypeForm.get('permitTypeCode').value;
      this.permitType1.permitTypeName= this.permitTypeForm.get('permitTypeName').value;
      this.permitType1.permitFee= this.permitTypeForm.get('permitFee').value;
      this.permitType1.active= this.permitTypeForm.get('active').value;


    this.blockUI.start("Please wait....");
      this.permitService.addPermitType(this.permitType1).subscribe(res => {
        this.res = res;
        this.blockUI.stop();

        console.log(this.res,"LLLLLLLLLLLLLLLL")
        if (this.res.status === 200) {
          this.appEditMode = false;
          this.asignedRights = [];
          this.rights = [];
          this.userGroup = {};

          this.getAllpermitTypes();
          this.modalService.dismissAll();

          return this.toastr.success('Permit Type saved Successfully', 'Success!', { timeOut: 4000 });
        }
        if (this.res.status != true) {
          // if (this.userGroup.id === 0) {
          //     this.log(this.rightId, 'added group ' + this.userGroup.groupName);
          // } else {
          //     this.log(this.rightId, 'modified group ' + this.userGroup.id);
          // }
          this.appEditMode = false;
          this.asignedRights = [];
          this.rights = [];
          this.userGroup = {};
          this.getAllpermitTypes();
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
  updatePermitType (){


    this.permitType1.permitTypeCode= this.permitTypeForm.get('permitTypeCode').value;
    this.permitType1.permitTypeName= this.permitTypeForm.get('permitTypeName').value;
    this.permitType1.permitFee= this.permitTypeForm.get('permitFee').value;
    this.permitType1.active= this.permitTypeForm.get('active').value;
    const permitType2={
      'permitTypeId':this.permitType1.permitTypeId,
      'permitTypeCode': this.permitType1.permitTypeCode,
    'permitTypeName': this.permitType1.permitTypeName,
    'permitFee':this.permitType1.permitFee,
    'active':this.permitType1.active
    };

     console

    this.permitService.addPermitType(permitType2).subscribe(res => {
      this.res = res;
      console.log(this.res,"LLLLLLLLLLLLLLLL")
      if (this.res.status === 200) {
        this.appEditMode = false;
        this.asignedRights = [];
        this.rights = [];
        this.userGroup = {};
        this.getAllpermitTypes();
        this.modalService.dismissAll();
        this.blockUI.stop();
        return this.toastr.success('Permit Type saved Successfully', 'Success!', { timeOut: 4000 });
      }
      if (this.res.status != true) {
        // if (this.userGroup.id === 0) {
        //     this.log(this.rightId, 'added group ' + this.userGroup.groupName);
        // } else {
        //     this.log(this.rightId, 'modified group ' + this.userGroup.id);
        // }
        this.appEditMode = false;
        this.asignedRights = [];
        this.rights = [];
        this.userGroup = {};
        this.getAllpermitTypes();
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
  cancel() {
    this.getAllpermitTypes();
    this.appEditMode = false;

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
