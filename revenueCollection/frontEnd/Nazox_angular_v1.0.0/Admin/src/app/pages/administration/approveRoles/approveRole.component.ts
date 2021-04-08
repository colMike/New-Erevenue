
import {BlockUI, NgBlockUI} from "ng-block-ui";
import {AdministrationService} from "../../services/administration.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ToastrService} from "ngx-toastr";
import {LocalDataSource} from "ng2-smart-table";
import {Component, OnDestroy, OnInit} from "@angular/core";



@Component({
  templateUrl: './approveRole.component.html'

})
export class approveRoleComponent implements OnInit, OnDestroy {
  groups: any;
  types: any;
  res: any;
  group1:any;
  sessionId:any;
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
  rId:any;
  ug:any;
  idRight:any;
  rightId: any;
  session: any = {};
  source: LocalDataSource;
  @BlockUI() blockUI: NgBlockUI;
  constructor(
    private apiService: AdministrationService,
              private toastr: ToastrService,  private modalService: NgbModal) {
    this.userGroup.id = 0;
    this.userGroup.groupName = '';
    this.userGroup.groupCode = '';
    this.userGroup.active = true;

    this.source = new LocalDataSource(this.userGroups); // create the source
  }
  settings = settings;

  ngOnInit() {
    this.getGroupsAndUserRights();
    this.initUserRights();
    /*      this.session = JSON.parse(localStorage.getItem('ucred'));
          console.log(this.session.groupId,"tsart 1")
          for(let i=0;i<this.session.groupId.length;i++){
            console.log(this.session.groupId[i].menus,"start 2 ")
            this.ug=this.session.groupId[i].menus
            for(let i=0;i< this.ug.length;i++){
              console.log(this.ug[i].groups,"start 3 ")

              this.rId=this.ug[i].groups
              for(let i=0;i< this.rId.length;i++){
                console.log(this.rId[i].rights,"start 4 ")
                this.idRight=this.rId[i].rights
                for(let i=0;i<  this.idRight.length;i++)
                this.rightId = this.idRight[i].rightId;
              }

            }

          }

          console.log( this.rightId,"this right ID")*/
    this.rightId=this.getGroupsAndUserRights();
    console.log( this.rightId,"this right ID")

  }

  initAddGroup() {
    this.initUserRights();
    this.userGroup.id = 0;
    this.userGroup.groupName = '';
    this.userGroup.groupCode = '';
    this.userGroup.active = true;
    this.editMode = true;
    this.is_edit = false;
    this.rights = this.initRights;
    this.title = 'Add user group';
    this.button = 'Add group';
  }
  initEditGroup($event) {

    this.editMode = true;
    this.userGroup = $event.data;
    console.log(this.userGroup,"this.userGroup")
    this.is_edit = true;
    console.log('event####', this.userGroup);
    this.title = 'Edit user group';
    this.button = 'Update user group';
    this.rights = this.userGroup.rights;
    console.log(this.rights,"rihts")
  }

  Approve(){
    //this.group1.userId=this.users.userId;
    // this.group1.userId = this.userForm.get('group1').value;

    //this.group1.userId=this.userId;


    console.log( this.group1.userId, " this.group1.userId")
    this.group1.approved = 'V';

    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.group1");
    console.log(this.sessionId.entity,"this.group1");

    this.group1.approvedBy=this.sessionId.entity.userId;

    console.log(this.group1.createdBy, "users @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2")
    for (var i = 0; i <= this.group1.length - 1; i++) {

      if (this.group1[i].createdBy === this.group1.approvedBy) {

        return this.toastr.warning('Role creator cannot Approve a Role he/she created', ' Warning!', {timeOut: 3000});

        //this.getUsers();
        //this.router.navigate(['/']);

      }
    }
    const user2 = {
      'id': this.group1.id,
      'approved':this.group1.approved,
      'approvedBy':this.group1.approvedBy


    };
    console.log(user2,"$$$$$$$$$$$$$$$")
    console.log(this.group1, "$$$$$$$$$$$$$$$$")
    this.apiService.approveRole(user2).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {



        /*   this.usersData.push({
             this.group1.userName,
             userFullName,
             userEmail,
             active,
             userPhone,
             userNationalId
           });*/


        //logger.info("Great! The user information was saved succesfully")



        //alert(response.respMessage);
        this.modalService.dismissAll();


        //alert(response.respMessage);

        this.getGroupsAndUserRights();
        this.editMode = true;
        return this.toastr.success('Great! The Role was Approved successfully', ' Success!', { timeOut: 3000 });





      }else{
        return this.toastr.error('Exception Occurred', ' Warning!', { timeOut: 3000 });

      }

    });

  }
  Reject(){
    //this.group1.userId=this.users.userId;
    // this.group1.userId = this.userForm.get('group1').value;

    //this.group1.userId=this.userId;


    console.log( this.group1.userId, " this.group1.userId")
    this.group1.approved = 'R';

    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.group1");
    console.log(this.sessionId.entity,"this.group1");

    this.group1.approvedBy=this.sessionId.entity.userId;

    console.log(this.group1.createdBy, "users @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2")
    for (var i = 0; i <= this.group1.length - 1; i++) {

      if (this.group1[i].createdBy === this.group1.approvedBy) {

        return this.toastr.warning('Role creator cannot reject a Role he/she created', ' Warning!', {timeOut: 3000});

        //this.getUsers();
        //this.router.navigate(['/']);

      }
    }
    const user2 = {
      'id': this.group1.id,
      'approved':this.group1.approved,
      'approvedBy':this.group1.approvedBy


    };
    console.log(user2,"$$$$$$$$$$$$$$$")
    console.log(this.group1, "$$$$$$$$$$$$$$$$")
    this.apiService.approveRole(user2).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {



        /*   this.usersData.push({
             this.group1.userName,
             userFullName,
             userEmail,
             active,
             userPhone,
             userNationalId
           });*/


        //logger.info("Great! The user information was saved succesfully")



        //alert(response.respMessage);
        this.modalService.dismissAll();


        //alert(response.respMessage);

        this.getGroupsAndUserRights();
        this.editMode = true;
        return this.toastr.success('Great! The Role was Rejected successfully', ' Success!', { timeOut: 3000 });





      }else{
        return this.toastr.error('Exception Occurred', ' Warning!', { timeOut: 3000 });

      }

    });

  }

  getGroupsAndUserRights() {
    this.blockUI.start('Loading group data...');
    this.apiService.getRolesToApprove().subscribe(data => {
      console.log(JSON.stringify(data),"HEREEEEEEEEEEEEEE")
      this.groups = data;
      console.log(this.groups);
      this.blockUI.stop();
      if (this.groups.status === true) {
        this.userGroups = this.groups.collection;
        this.source = new LocalDataSource(this.userGroups);
      } else {
        return this.toastr.warning(this.groups.respMessage, 'Warning!', { timeOut: 4000 });
      }
    }, error => {
      this.blockUI.stop();
      return this.toastr.error('Error in loading group data.', 'Error!', { timeOut: 4000 });
    });
  }
  initUserRights() {
    this.apiService.getUserGroupRights().subscribe(res => {
      console.log(res, "ressss")
      this.res = res;
      if (this.res.status === true) {
        this.initRights = this.res.collection;
      } else {
        return this.toastr.warning('No rights to assign.', 'Warning!', { timeOut: 4000 });
      }
    }, error => {
      this.blockUI.stop();
      return this.toastr.error('Error in loading data.', 'Error!', { timeOut: 4000 });
    });
  }
  addGroup() {
    console.log(this.userGroup.id,"  this.userGrou")
    if (this.userGroup.groupCode === '') {
      this.toastr.warning('Please specify the group code', 'Alert!', { timeOut: 4000 });
    } else if (this.userGroup.groupName === '') {
      this.toastr.warning('Please specify the group name', 'Alert!', { timeOut: 4000 });
    } else {
      console.log('rights ##############################', this.rights);
      console.log('rights ##############################', this.rights.length);
      // this.userGroup.rights = this.rights;
      for (let l = 0; l < this.rights.length; l++) {
        if (this.rights[l].allowView === true || this.rights[l].allowEdit === true
          || this.rights[l].allowAdd === true || this.rights[l].allowDelete === true) {
          this.asignedRights.push(this.rights[l]);
          console.log('assigned rights', this.asignedRights);
        }
      }
      this.userGroup.rights = this.asignedRights;
      console.log(this.asignedRights,"this.asignedRights $$$$$$$$$$$$$$$$");
      console.log(this.userGroup.id,"@@@@@@@@@@@@@@@");
      this.blockUI.start('Updating user group details...');
      //this.userGroup.id=this.asignedRights.groupId;
      this.apiService.addUserGroup(this.userGroup).subscribe(res => {
        this.res = res;
        console.log(this.res,"LLLLLLLLLLLLLLLL")
        if (this.res.status === false) {
          this.editMode = false;
          this.asignedRights = [];
          this.rights = [];
          this.userGroup = {};
          this.getGroupsAndUserRights();
          this.modalService.dismissAll();
          this.blockUI.stop();
          return this.toastr.success(this.res.respMessage, 'Success!', { timeOut: 4000 });
        }
        if (this.res.status === true) {
          // if (this.userGroup.id === 0) {
          //     this.log(this.rightId, 'added group ' + this.userGroup.groupName);
          // } else {
          //     this.log(this.rightId, 'modified group ' + this.userGroup.id);
          // }
          this.editMode = false;
          this.asignedRights = [];
          this.rights = [];
          this.userGroup = {};
          this.getGroupsAndUserRights();
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
  }
  cancel() {
    this.userGroup = {};
    this.editMode = false;
    this.rights = [];
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
      title: 'Search',
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
