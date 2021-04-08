import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrls: ['./roles.component.scss']
})
export class RolesComponent implements OnInit {
   admintitle:any;
   customertitle:any;
   agenttitle:any;
   session:any;
   sessionId:any;


  constructor() { }

  ngOnInit(): void {

  }
getRoles(){
  this.session=localStorage.getItem('ucred');
  console.log(JSON.parse(this.session),"tumesaidika?");
  this.sessionId=JSON.parse(this.session);
  for(let i=0;i<this.sessionId.groupId.length;i++) {
    this.admintitle=this.sessionId.groupId[0].title;
    this.customertitle=this.sessionId.groupId[1].title;
    /*  if(sessionId.groupId[2] === 'undefined'){
        agenttitle='';
      }else{
        agenttitle=sessionId.groupId[2].title;
      }*/

    console.log(this.sessionId.groupId[i].title, "sessionId")

  }
}
}
