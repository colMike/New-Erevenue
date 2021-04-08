import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators, FormGroup, FormControl} from '@angular/forms';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { agentsData } from './data';
import { ToastrService } from 'ngx-toastr';
import {AgentService} from "../../services/agent.service";
import { agents } from './agents.model';


@Component({
  selector: 'app-agents',
  templateUrl: './agents.component.html',

  styleUrls: ['./agents.component.scss']
})
export class AgentsComponent implements OnInit {

  // breadcrumb items
  breadCrumbItems: Array<{}>;

  submitted: boolean;
  isExisting:boolean;
  isAddMode: boolean;
  sessionId:any;
  public agents: any = [];
  public response: any = null;

 // agentsData: agents[];
  validationform: FormGroup;

  constructor(private toastr: ToastrService,private modalService: NgbModal, private agentSvc: AgentService, public formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.breadCrumbItems = [{ label: 'Agents' }, { label: 'agents', active: true }];
    this.gtAgent();


    //this._fetchData();
  }

  initAddAgent():void{
    this.isAddMode=true;
    this.isExisting =false;


    this.validationform = this.formBuilder.group({


      agent_names: ['', [Validators.required]],
      location: ['', [Validators.required]],
      mobile: ['', [Validators.required]],
      branch: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
      business_name: ['', [Validators.required]],
      email: ['', [Validators.required]],
      id_number: ['', [Validators.required]],
      business_mobile: ['', [Validators.required]],
      first_name: ['', [Validators.required]],
      second_name: ['', [Validators.required]],
      last_name: ['', [Validators.required]],
      super_agent: ['', [Validators.required]],
      postal_address: ['', [Validators.required]],
      referees_contacts: ['', [Validators.required]],
      business_category: ['', [Validators.required]],
      agent_type: ['', [Validators.required]],
      ward: ['', [Validators.required]]
    });

  }
  initEditAgent(agent){
    this.isAddMode=false;
    this.isExisting =true;
    this.agents.id=agent.id;
    console.log(agent,"agent id ................")
    console.log(this.agents.id,"agent id ................")

    this.validationform = this.formBuilder.group({
      location :new FormControl(agent.location, Validators.required),
      mobile :new FormControl(agent.mobile, Validators.required),
      branch :new FormControl(agent.branch, Validators.required),
      business_name :new FormControl(agent.business_name, Validators.required),

      email :new FormControl(agent.email, Validators.required),
      id_number :new FormControl(agent.id_number, Validators.required),
      business_mobile :new FormControl(agent.business_mobile, Validators.required),
      second_name :new FormControl(agent.second_name, Validators.required),
      last_name :new FormControl(agent.last_name, Validators.required),
      first_name :new FormControl(agent.first_name, Validators.required),
      postal_address :new FormControl(agent.postal_address, Validators.required),
      referees_contacts :new FormControl(agent.referees_contacts, Validators.required),
      business_category :new FormControl(agent.business_category, Validators.required),
      agent_type :new FormControl(agent.agent_type, Validators.required),
      ward :new FormControl(agent.ward, Validators.required)

    });

  }

  gtAgent(){
    this.isAddMode=false;
    this.agentSvc.gtAgent().subscribe(agent =>{
      // if(data){
      this.agents = agent;
      //this.blockUI.stop();
      /* }
       else{*/
      console.log(this.agents,"data.message");
      // this.blockUI.stop();
      //return this.toastr.info(data.message);
      //}
    },()=>{
      console.log("error fetching customers...");
      //this.blockUI.stop();
    })
  }


/*  private _fetchData() {
    this.agentsData = agentsData;
  }*/

  /**
   * Returns form
   */
  get form() {
    return this.validationform.controls;
  }
  /**
   * Modal Open
   * @param content modal content
   */
  openModal(content: any) {
    this.modalService.open(content, { centered: true });
  }
  updateAgent(){
    //this.agents.agent_names = this.validationform.get('agent_names').value;
    console.log( this.agents.id, " this.agents.userId")
    this.agents.location = this.validationform.get('location').value;
    this.agents.mobile = this.validationform.get('mobile').value;
    this.agents.branch = this.validationform.get('branch').value;
    this.agents.business_name = this.validationform.get('business_name').value;
    this.agents.email = this.validationform.get('email').value;
    this.agents.id_number = this.validationform.get('id_number').value;
    this.agents.business_mobile = this.validationform.get('business_mobile').value;
    this.agents.first_name = this.validationform.get('first_name').value;
    this.agents.second_name = this.validationform.get('second_name').value;
    this.agents.last_name = this.validationform.get('last_name').value;
    //this.agents.super_agent = this.validationform.get('super_agent').value;
    this.agents.postal_address = this.validationform.get('postal_address').value;
    this.agents.referees_contacts = this.validationform.get('referees_contacts').value;
    this.agents.business_category = this.validationform.get('business_category').value;
   // this.agents.agent_type = this.validationform.get('agent_type').value;
    this.agents.ward = this.validationform.get('ward').value;
    const agent1 ={
     'id':this.agents.id,
     'location': this.agents.location,
      'mobile':  this.agents.mobile,
      'branch': this.agents.branch,
      'business_name': this.agents.business_name,
      'email': this.agents.email,
      'id_number': this.agents.id_number,
      'business_mobile': this.agents.business_mobile,
      'first_name': this.agents.first_name,
      'second_name': this.agents.second_name,
      'last_name': this.agents.last_name,
      //'': this.agents.super_agent,
      'postal_address': this.agents.postal_address,
      'referees_contacts': this.agents.referees_contacts,
      'business_category': this.agents.business_category,

      'ward': this.agents.ward
    }


    console.log(agent1, "$$$$$$$$$$$$$$$$")
    console.log(this.agents.id, "this.agents.id")
    this.agentSvc.updateAgent(agent1).subscribe((response) => {
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
        this.validationform = this.formBuilder.group({
          agent_names: '',
          location: '',
          mobile	: '',
          branch	: '',
          business_name: '',
          email	: '',
          id_number	: '',
          business_mobile: '',
          first_name: '',
          second_name: '',
          last_name: '',
          super_agent: '',
          postal_address: '',
          referees_contacts: '',
          business_category: '',
          agent_type	: '',
          ward: '',

        });

        //logger.info("Great! The user information was saved succesfully")
        this.modalService.dismissAll();

        this.gtAgent();
        this.isAddMode = true;
        //alert(response.respMessage);
        return this.toastr.success('Great! The Agent information was updated succesfully"', ' Success!', { timeOut: 3000 });


      }else{
        return this.toastr.error('Great! The user information was updated succesfully"', ' Error!', { timeOut: 3000 });

      }
      this.submitted = true;
    });


  }
  cancel() {
    this.gtAgent();
    this.isAddMode = true;
    this.isExisting =true;

  }
  Delete(){

  }

  /**
   * save the contacts data
   */
  saveAgent() {
    this.agents = this.validationform.value;
   this.agents.agent_names = this.validationform.get('agent_names').value;
    this.agents.location = this.validationform.get('location').value;
    this.agents.mobile = this.validationform.get('mobile').value;
    this.agents.branch = this.validationform.get('branch').value;
    this.agents.business_name = this.validationform.get('business_name').value;
    this.agents.email = this.validationform.get('email').value;
    this.agents.id_number = this.validationform.get('id_number').value;
    this.agents.business_mobile = this.validationform.get('business_mobile').value;
    this.agents.first_name = this.validationform.get('first_name').value;
    this.agents.second_name = this.validationform.get('second_name').value;
    this.agents.last_name = this.validationform.get('last_name').value;
    this.agents.super_agent = this.validationform.get('super_agent').value;
    this.agents.postal_address = this.validationform.get('postal_address').value;
    this.agents.referees_contacts = this.validationform.get('referees_contacts').value;
    this.agents.business_category = this.validationform.get('business_category').value;
    this.agents.agent_type = this.validationform.get('agent_type').value;
    this.agents.ward = this.validationform.get('ward').value;
    const session=localStorage.getItem('currentUser');

    this.sessionId=JSON.parse(session);

    console.log(this.sessionId.entity.userId,"this.users1");
    console.log(this.sessionId.entity,"this.users1");

    this.agents.maker=this.sessionId.entity.userId;
    console.log(this.agents.maker, "this.users1.createdBy")
    console.log(this.agents, "++++++++++++++++++++++++++++")

    this.agentSvc.addAgent(this.agents).subscribe((response) => {
      this.response = response;
      console.log(this.response.status,"response")
      if (this.response.status===200) {
    //if (this.validationform.valid) {
     /* this.agentsData.push({
        agent_names,
        location,
        mobile	,
        branch	,
        business_name,
        email	,
        id_number	,
        business_mobile,
        first_name,
        second_name,
        last_name,
        super_agent,
        postal_address,
        referees_contacts,
        business_category,
        agent_type	,
        ward

      });*/
      this.validationform = this.formBuilder.group({
        agent_names: '',
        location: '',
        mobile	: '',
        branch	: '',
        business_name: '',
        email	: '',
        id_number	: '',
        business_mobile: '',
        first_name: '',
        second_name: '',
        last_name: '',
        super_agent: '',
        postal_address: '',
        referees_contacts: '',
        business_category: '',
        agent_type	: '',
        ward: '',

      });
      this.modalService.dismissAll();
   this.gtAgent();
        return this.toastr.success('Great! The Agent information was saved successfully"', ' Success!', { timeOut: 3000 });

    }else{
        return this.toastr.error('Exception Occuredd', ' Error!', { timeOut: 3000 });

      }
        this.submitted = true;
      });
  }

}
