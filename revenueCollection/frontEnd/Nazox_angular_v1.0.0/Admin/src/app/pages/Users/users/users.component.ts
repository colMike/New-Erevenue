import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, Validators, FormGroup, FormControl} from '@angular/forms';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { usersData } from './data';

import { ToastrService } from 'ngx-toastr';

import { users } from './users.model';

import { DOCUMENT } from '@angular/common';
import {logger} from "codelyzer/util/logger";
import {first} from "rxjs/operators";
import {UserService} from "../../services/user.service";
import {LocalDataSource} from "ng2-smart-table";
import {BlockUI, NgBlockUI} from "ng-block-ui";
import {AdministrationService} from "../../services/administration.service";


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  // breadcrumb items
  breadCrumbItems: Array<{}>;
  public users1: any = [];
  public users: any = [];
  submitted: boolean;
  userGroups: any = [];
  collection : any;
  public response: any = null;
  isAddMode: boolean;
isExisting:boolean;
 userId:any;
  public usersGroupType1:any=[];
 groupId:any;
 groupName:any;
  groups: any;
  userGroup: any = {};
  sessionId:any;
  status:any;
  storageObject: any = {};
  session: any = {};
  userGroupTypeId: any;
  source: LocalDataSource;
  @BlockUI() blockUI: NgBlockUI;

  usersData: users[];
  userForm: FormGroup;
  public profileTypes = [{ 'id': 1, 'name': 'WEB' }, { 'id': 2, 'name': 'WEB' }];

 // constructor(private modalService: NgbModal, public formBuilder: FormBuilder) { }
  constructor(private toastr: ToastrService,private apiService: AdministrationService,
              private userSvc: UserService, @Inject(DOCUMENT) private document: any,public formBuilder: FormBuilder,
              private modalService: NgbModal
             ) {
  }


  ngOnInit():void {

    this.getUsers();
    this.getGroupsAndUserRights();
    this.getUsersGroupType();
    //this.initAddUser();
   // this.initEditUser();
  /*  this.breadCrumbItems = [{ label: 'Ecommerce' }, { label: 'Users', active: true }];*/

   /* this.userForm = this.formBuilder.group({
      userName: ['', [Validators.required]],
      userFullName: ['', [Validators.required]],
      userPhone: ['', [Validators.required]],
      userEmail: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
      active: ['', [Validators.required]],
      userNationalId: ['', [Validators.required]]
    });
*/
   // this._fetchData();*/
  }


/*  private _fetchData() {
    this.usersData = usersData;
  }*/

initAddUser():void{
  this.isAddMode=true;
  this.isExisting =false;

  this.userForm = this.formBuilder.group({



    userName: ['', [Validators.required]],
    firstname: ['', [Validators.required]],
    lastname: ['', [Validators.required]],
    secondname: ['', [Validators.required]],
    address: ['', [Validators.required]],
    userPhone: ['', [Validators.required]],
    groupId: ['', [Validators.required]],
    userEmail: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
    active: ['', [Validators.required]],
    userNationalId: ['', [Validators.required]],
    userGroupTypeId: ['', [Validators.required]]

   // userNationalId: ['', [Validators.required],



  });



}

  getGroupsAndUserRights() {
    this.blockUI.start('Loading group data...');
    this.apiService.getGroups().subscribe(data => {
      console.log(JSON.stringify(data),"HEREEEEEEEEEEEEEE")
      this.groups = data;
      this.userGroups = this.groups.collection;
      console.log(this.groups);
      for(let i=0;i<this.groups.length;i++){
        console.log(this.groups[i].collection);

      this.collection=this.groups[i].collection;

        console.log( this.collection,"cccccccccccccccccccc")
        for(let i=0;i<this.collection.length;i++){
         this.groupId=this.collection[i].id;
          this.groupName=this.collection[i].groupName;
        }
      }
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
  /**
   * Returns form
   */
  get form() {
    return this.userForm.controls;
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
   * save the users data
   */
  saveData() {


    this.users1 = this.userForm.value;

    this.users1.userName = this.userForm.get('firstname').value;
    this.users1.firstname = this.userForm.get('firstname').value;
    this.users1.secondname = this.userForm.get('secondname').value;
    this.users1.lastname = this.userForm.get('lastname').value;
    this.users1.address = this.userForm.get('address').value;
    this.users1.userEmail = this.userForm.get('userEmail').value;
    this.users1.userPhone = this.userForm.get('userPhone').value;
    this.users1.active = this.userForm.get('active').value;
    this.users1.groupId = this.userForm.get('groupId').value;
    this.users1. userNationalId = this.userForm.get('userNationalId').value;
    this.users1. userGroupTypeId = this.userForm.get('userGroupTypeId').value;


   // this.users1.userFullName=(+ this.userForm.get('secondname').value +this.userForm.get('lastname').value;
    console.log(this.users1,"users")
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.users1");
    console.log(this.sessionId.entity,"this.users1");

    this.users1.createdBy=this.sessionId.entity.userId;
    console.log(this.users1.createdBy, "this.users1.createdBy")

    this.userSvc.addUser(this.users1).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
    if (this.response.status===200) {



   /*   this.usersData.push({
        this.users1.userName,
        userFullName,
        userEmail,
        active,
        userPhone,
        userNationalId
      });*/
      this.userForm = this.formBuilder.group({
       // userName: '',
        userFullName: '',
        userEmail: '',
        active: '',
        userPhone: '',
        userNationalId: ''
      });

      //logger.info("Great! The user information was saved succesfully")
      this.modalService.dismissAll();
      this.getUsers();
      return this.toastr.success('Great! The user information was saved succesfully"', ' Success!', { timeOut: 3000 });

      //alert("Great! The user information was saved succesfully");

    }else{
      return this.toastr.error('Exception Occurred', ' Error!', { timeOut: 3000 });

    }
    this.submitted = true;
  });
  }

  initEditUser(user){
    this.isAddMode=false;
    this.isExisting =true;
    this.users1.userId=user.userId;
    console.log(this.users1.userId,"user id ................")
    this.userForm = this.formBuilder.group({
      firstname :new FormControl(user.firstname, Validators.required),
      secondname :new FormControl(user.secondname, Validators.required),
      lastname :new FormControl(user.lastname, Validators.required),
      address :new FormControl(user.address, Validators.required),
      groupId :new FormControl(user.groupId, Validators.required),
      userEmail :new FormControl(user.userEmail, Validators.required),
      active :new FormControl(user.active, Validators.required),
      userPhone :new FormControl(user.userPhone, Validators.required),
      userNationalId :new FormControl(user.userNationalId, Validators.required),
      userGroupTypeId :new FormControl(user.userGroupTypeId, Validators.required)
  });

  }
  cancel() {
    this.getUsers();
    this.isAddMode = true;
    this.isExisting = true;

  }
  updateUser()

  {
    //this.users1.userId=this.users.userId;
   // this.users1.userId = this.userForm.get('users1').value;

    //this.users1.userId=this.userId;


    console.log( this.users1.userId, " this.users1.userId")
    this.users1.firstname = this.userForm.get('firstname').value;
    this.users1.lastname = this.userForm.get('lastname').value;
    this.users1.secondname = this.userForm.get('secondname').value;
    this.users1.address = this.userForm.get('address').value;
    this.users1.userEmail = this.userForm.get('userEmail').value;
    this.users1.userPhone = this.userForm.get('userPhone').value;
    this.users1.groupId = this.userForm.get('groupId').value;
    this.users1.active = this.userForm.get('active').value;
    this.users1. userNationalId = this.userForm.get('userNationalId').value;
    this.users1. userGroupTypeId = this.userForm.get('userGroupTypeId').value;

    const user2 = {
      'userId': this.users1.userId,
      'firstname' :this.users1.firstname,
      'lastname' :this.users1.lastname,
      'secondname' :this.users1.secondname,
      'address' :this.users1.address,
      'userEmail':this.users1.userEmail,
      'active':this.users1.active,
      'userPhone':  this.users1.userPhone,
      'groupId': this.users1.groupId,
      'userNationalId':this.users1.userNationalId,
      'userGroupTypeId':this.users1.userGroupTypeId

    };
    console.log(user2,"$$$$$$$$$$$$$$$")
 console.log(this.users1, "$$$$$$$$$$$$$$$$")
    this.userSvc.updateUser(user2).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {



        /*   this.usersData.push({
             this.users1.userName,
             userFullName,
             userEmail,
             active,
             userPhone,
             userNationalId
           });*/
        this.userForm = this.formBuilder.group({
          // userName: '',
          userFullName: '',
          userEmail: '',
          active: '',
          userPhone: '',
          userNationalId: ''
        });

        //logger.info("Great! The user information was saved succesfully")

        this.modalService.dismissAll();


        //alert(response.respMessage);

        this.getUsers();
        this.isAddMode = true;

        //alert(response.respMessage);
        return this.toastr.success('Great! The User information was saved succesfully"', ' Success!', { timeOut: 3000 });



      }else{
        return this.toastr.error('Exception Occurred', ' Error!', { timeOut: 3000 });

      }
      this.submitted = true;
    });
  }
  getUsersGroupType(){
    //  this.blockUI.start("Loading data....");
    this.isAddMode=false;


    this.userSvc.gtUsersGroupType().subscribe(users =>{
      // if(data){


      this.usersGroupType1 = users;
      console.log( this.usersGroupType1 ," this.usersGroupType1 ")
      //this.blockUI.stop();
      /* }
       else{*/

    },()=>{
      console.log("error fetching customers...");
      //this.blockUI.stop();
    })
  }
  getUsers(){
  //  this.blockUI.start("Loading data....");
    this.isAddMode=false;
     const session=localStorage.getItem('currentUser');

     this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.users1");
    console.log(this.sessionId.entity,"this.users1");

    this.userSvc.gtUsers().subscribe(users =>{
     // if(data){


        this.users1 = users;
        //this.blockUI.stop();
     /* }
      else{*/
      for (var i = 0; i <= this.users1.length - 1; i++) {
        console.log(this.users1[i].approved, "this.users1.approved")


        if (this.users1[i].approved === 'N') {

         this.users1[i].approved ==='Pending Approval';
          console.log(this.users1[i].approved,"$$$$$$$$$$$$$$$$$$$$")
        } else {
          this.users1[i].approved === 'Approved';
        }
        console.log(this.users1, "data.message");
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
