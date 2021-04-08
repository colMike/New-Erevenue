import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, Validators, FormGroup, FormControl} from '@angular/forms';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {ToastrService} from "ngx-toastr";
import {CustomerService} from "../../services/customer.service";
import {DOCUMENT} from "@angular/common";


@Component({
  selector: 'app-customers',
  templateUrl: './approveDeleteCustomers.component.html'

})
export class approveDeleteCustomersComponent implements OnInit {

  // breadcrumb items
  breadCrumbItems: Array<{}>;
  public users1: any = [];
  public users: any = [];
  submitted: boolean;
  public response: any = null;
  isAddMode: boolean;
  isExisting:boolean;
  userId:any;
  sessionId:any;
  status:any;
  storageObject: any = {};


  userForm: FormGroup;

  // constructor(private modalService: NgbModal, public formBuilder: FormBuilder) { }
  constructor(private toastr: ToastrService,
              private customerSvc: CustomerService, @Inject(DOCUMENT) private document: any,public formBuilder: FormBuilder,
              private modalService: NgbModal
  ) {
  }


  ngOnInit():void {

    this.getUsers();
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
      userEmail: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
      active: ['', [Validators.required]],
      userNationalId: ['', [Validators.required]]

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
    this.users1. userNationalId = this.userForm.get('userNationalId').value;
    // this.users1.userFullName=(+ this.userForm.get('secondname').value +this.userForm.get('lastname').value;
    console.log(this.users1,"users")
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.users1");
    console.log(this.sessionId.entity,"this.users1");

    this.users1.createdBy=this.sessionId.entity.userId;
    console.log(this.users1.createdBy, "this.users1.createdBy")

    this.customerSvc.addCustomer(this.users1).subscribe((response) => {
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
    this.users1.id=user.id;
    console.log(this.users1.userId,"user id ................")
    this.userForm = this.formBuilder.group({
      customername :new FormControl(user.customername, Validators.required),
      phonenumber :new FormControl(user.phonenumber, Validators.required),
      email :new FormControl(user.email, Validators.required),
      /* address :new FormControl(user.address, Validators.required),

       userEmail :new FormControl(user.userEmail, Validators.required),
       active :new FormControl(user.active, Validators.required),
       userPhone :new FormControl(user.userPhone, Validators.required),
       userNationalId :new FormControl(user.userNationalId, Validators.required)*/
    });

  }
  cancel() {
    this.getUsers();
    this.isAddMode = true;
    this.isExisting = true;

  }
  Approve()

  {
    //this.users1.userId=this.users.userId;
    // this.users1.userId = this.userForm.get('users1').value;

    //this.users1.userId=this.userId;


    console.log( this.users1.userId, " this.users1.userId")
    this.users1.deleted = 'AD';
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.users1");
    console.log(this.sessionId.entity,"this.users1");

    this.users1.approvedBy=this.sessionId.entity.userId;
    console.log(this.users1, "that hell")

    console.log(this.sessionId.entity.userId, "this.sessionId.entity.userId")
    for (var i = 0; i <= this.users1.length - 1; i++) {
      console.log(this.users1[i].deleted_by, "this.users1.deletedB")
      if (this.users1[i].deleted_by === this.sessionId.entity.userId) {

        return this.toastr.warning('A user who deletes a user cannot approve the deletion', ' Warning!', {timeOut: 3000});


      }
    }

    const user2 = {
      'id': this.users1.id,
      'deleted':  this.users1.deleted


    };
    console.log(user2,"$$$$$$$$$$$$$$$")
    console.log(this.users1, "$$$$$$$$$$$$$$$$")
    this.customerSvc.approveDeleteCustomer(user2).subscribe((response) => {
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
        return this.toastr.success('Great! The user information was approved successfully', ' Warning!', { timeOut: 3000 });


      }else{

      }
      this.submitted = true;
    });
  }
  Reject(){
    //this.users1.userId=this.users.userId;
    // this.users1.userId = this.userForm.get('users1').value;

    //this.users1.userId=this.userId;


    console.log( this.users1.userId, " this.users1.userId")
    this.users1.deleted = 'RD';

    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.users1");
    console.log(this.sessionId.entity,"this.users1");

    this.users1.approvedBy=this.sessionId.entity.userId;

    console.log(this.users1.createdBy, "users @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2")
    for (var i = 0; i <= this.users1.length - 1; i++) {
      console.log(this.users1[i].deleted_by, "this.users1.deletedB")
      if (this.users1[i].deleted_by === this.sessionId.entity.userId) {

        return this.toastr.warning('A user who deletes a user cannot reject the deletion', ' Warning!', {timeOut: 3000});


      }
    }

    const user2 = {
      'id': this.users1.id,
      'deleted':  this.users1.deleted


    };
    console.log(user2,"$$$$$$$$$$$$$$$")
    console.log(this.users1, "$$$$$$$$$$$$$$$$")
    this.customerSvc.approveDeleteCustomer(user2).subscribe((response) => {
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



        //alert(response.respMessage);
        this.modalService.dismissAll();


        //alert(response.respMessage);

        this.getUsers();
        this.isAddMode = true;
        return this.toastr.success('Great! The user information was rejected successfully', ' Success!', { timeOut: 3000 });




      }else{
        return this.toastr.error('Exception Occured', ' error!', { timeOut: 3000 });

      }
      this.submitted = true;
    });

  }
  getUsers(){
    //  this.blockUI.start("Loading data....");
    this.isAddMode=false;
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.users1");
    console.log(this.sessionId.entity,"this.users1");

    this.customerSvc.getCustomersToApproveDelete().subscribe(users =>{
      // if(data){

      console.log( this.users1, "this.users1.approved")
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
