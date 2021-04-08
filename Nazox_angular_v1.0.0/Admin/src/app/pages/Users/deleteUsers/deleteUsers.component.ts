import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, Validators, FormGroup, FormControl} from '@angular/forms';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ToastrService } from 'ngx-toastr';
import { DOCUMENT } from '@angular/common';
import {logger} from "codelyzer/util/logger";
import {first} from "rxjs/operators";
import {UserService} from "../../services/user.service";


@Component({
  selector: 'app-users',
  templateUrl: './deleteUsers.html'

})
export class deleteUsersComponent implements OnInit {

  // breadcrumb items
  breadCrumbItems: Array<{}>;
  public users1: any = [];
  public users: any = [];
  submitted: boolean;
  public response: any = null;
  sessionId:any;
  isAddMode: boolean;
  isExisting:boolean;
  userId:any;
  status:any;

  //usersData: users[];
  userForm: FormGroup;

  // constructor(private modalService: NgbModal, public formBuilder: FormBuilder) { }
  constructor(private toastr: ToastrService,
    private userSvc: UserService, @Inject(DOCUMENT) private document: any,public formBuilder: FormBuilder,
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
    console.log(this.users1,"users")
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
        alert("Great! The user information was saved succesfully");

      }else{

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

      userEmail :new FormControl(user.userEmail, Validators.required),
      active :new FormControl(user.active, Validators.required),
      userPhone :new FormControl(user.userPhone, Validators.required),
      userNationalId :new FormControl(user.userNationalId, Validators.required),
      remarks :new FormControl(user.remarks, Validators.required)
    });

  }
  cancel() {
    this.getUsers();
    this.isAddMode = true;
    this.isExisting = true;

  }
  Delete()

  {
    //this.users1.userId=this.users.userId;
    // this.users1.userId = this.userForm.get('users1').value;

    //this.users1.userId=this.userId;
    this.users1.remarks = this.userForm.get('remarks').value;
    if(this.users1.remarks =='' || this.users1.remarks==null ){
      return this.toastr.warning('Kindly enter the reason for deleting','Warning!', { timeOut: 3000 });

    }

    console.log( this.users1.userId, " this.users1.userId")
    this.users1.deleted = 'D';
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.users1");
    console.log(this.sessionId.entity,"this.users1");
      this.users1.deletedBy=this.sessionId.entity.userId;
    const user2 = {
      'userId': this.users1.userId,
      'deleted':this.users1.deleted,
      'deletedBy':this.users1.deletedBy,
      'remarks':this.users1.remarks


    };
    console.log(user2,"$$$$$$$$$$$$$$$")
    console.log(this.users1, "$$$$$$$$$$$$$$$$")
    this.userSvc.deleteUser(user2).subscribe((response) => {
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

        return this.toastr.success('Great! The user information was deleted successfully. Pending Approval', 'success!', { timeOut: 3000 });



      }else{
        return this.toastr.error('Exception Occured', ' error!', { timeOut: 3000 });

      }
      this.submitted = true;
    });
  }

  getUsers(){
    //  this.blockUI.start("Loading data....");
    this.isAddMode=false;
    console.log(this.users1.approved,"this.users1")
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
