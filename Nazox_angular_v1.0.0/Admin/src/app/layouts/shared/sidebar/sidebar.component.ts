import { Component, OnInit, ViewChild, ElementRef, AfterViewInit } from '@angular/core';
import MetisMenu from 'metismenujs/dist/metismenujs';

//import { Router, NavigationEnd } from '@angular/router';
import {Router, ActivatedRoute, NavigationEnd} from '@angular/router';
import {NgbNavModule, NgbDropdownModule, NgbTooltipModule, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { EventService } from '../../../core/services/event.service';


import { MENU } from './menu';
import { MenuItem } from './menu.model';
import {MySharedService} from "../../../pages/services/sharedService";
import {element} from "protractor";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit, AfterViewInit {
  showMenu = '';
  showSubMenu = '';
  menu: any = { collection: [{ headerClass: '' }], menus: [] };
  public sidebarnavItems: any[];

  //menu: any
  path:any;
  icon:any;
  extralink:any;
  rightDisplayName:any;
  submenus:any;
  session:any;
  sessionId:any;

  menuItems = [];

  @ViewChild('sideMenu') sideMenu: ElementRef;

  constructor(private eventService: EventService, private router: Router,  private globalService: MySharedService,
              private modalService: NgbModal,  private dropdownservice:NgbDropdownModule, private route: ActivatedRoute) {
    router.events.forEach((event) => {
     /* if (event instanceof NavigationEnd) {
        this._activateMenuDropdown();
      }*/
    });
  }

  ngOnInit(): void {
   // console.log(this.globalService.setRights())
    /*const session=localStorage.getItem('ucred');

    const sessionId=JSON.parse(session);
    console.log(sessionId.groupId,"start 1?");
      this.sidebarnavItems = sessionId.groupId.sort((a, b) => a.title - b.headerPos);
*/



    this.initialize();
  }
  addActiveClass(element: any) {
    if (element === this.showSubMenu) {
      this.showSubMenu = '0';
    } else {
      this.showSubMenu = element;
    }
  }


  ngAfterViewInit() {
    this.menu = new MetisMenu(this.sideMenu.nativeElement);
    console.log(this.menu,"this menu")

   // this._activateMenuDropdown();
  }

  /**
   * remove active and mm-active class
   */
  _removeAllClass(className) {
    const els = document.getElementsByClassName(className);
    while (els[0]) {
      els[0].classList.remove(className);
    }
  }

  /**
   * Activate the parent dropdown
   */
  _activateMenuDropdown() {
/*    this._removeAllClass('mm-active');
    this._removeAllClass('mm-show');*/
    const links = document.getElementsByClassName('side-nav-link-ref');
    console.log(links,"FFFFFFFFFFF")
    let menuItemEl = null;

    const paths = [];
    // tslint:disable-next-line: prefer-for-of
    console.log(links, "links")
    for (let i = 0; i < links.length; i++) {
      // tslint:disable-next-line: no-string-literal
      console.log("step 1");
      paths.push(links[i]['pathname']);
    }
    const itemIndex = paths.indexOf(window.location.pathname);
    console.log("step 2",itemIndex);
    if (itemIndex === -1) {
      console.log("step 3");
      const strIndex = window.location.pathname.lastIndexOf('/');
      console.log("step 3 1",strIndex);
      const item = window.location.pathname.substr(0, strIndex).toString();
      menuItemEl = links[paths.indexOf(item)];
      console.log("step 3",menuItemEl);
    } else {
      menuItemEl = links[itemIndex];
    }
    console.log("step kati kati",menuItemEl);
    if (menuItemEl) {
      menuItemEl.classList.add('active');
      const parentEl = menuItemEl.parentElement;
      console.log("step 4");
      if (parentEl) {
        parentEl.classList.add('mm-active');
        console.log("step 5");
        const parent2El = parentEl.parentElement.closest('ul');
        if (parent2El && parent2El.id !== 'side-menu') {
          console.log("step 1");
          parent2El.classList.add('mm-show');
          const parent3El = parent2El.parentElement;

          if (parent3El && parent3El.id !== 'side-menu') {
            parent3El.classList.add('mm-active');
            const childAnchor = parent3El.querySelector('.has-arrow');
            const childDropdown = parent3El.querySelector('.has-dropdown');

            if (childAnchor) { childAnchor.classList.add('mm-active'); }
            if (childDropdown) { childDropdown.classList.add('mm-active'); }

            const parent4El = parent3El.parentElement;
            if (parent4El && parent4El.id !== 'side-menu') {
              parent4El.classList.add('mm-show');
              const parent5El = parent4El.parentElement;
              if (parent5El && parent5El.id !== 'side-menu') {
                parent5El.classList.add('mm-active');
                const childanchor = parent5El.querySelector('.is-parent');
                if (childanchor && parent5El.id !== 'side-menu') { childanchor.classList.add('mm-active'); }
              }
            }
          }
        }
      }
    }
  }

  /**
   * Initialize
   */
  initialize(): void {
    this.session=localStorage.getItem('ucred');
    console.log(JSON.parse(this.session),"tumesaidika?");

    this.sessionId=JSON.parse(this.session);

    console.log(this.sessionId.groupId, "step 1")
    for(let i=0;i<this.sessionId.groupId.length;i++) {
      console.log(this.sessionId.groupId[i].menus, "this.session.groupId;");
     this.submenus= this.sessionId.groupId[i].menus

      console.log( this.submenus, " this.submenus")
      for(let i=0;i<this.submenus.length;i++) {
       /* this.path=this.submenus[i].path;
        this.rightDisplayName=this.submenus[i].rightDisplayName;
        this.icon=this.submenus[i].icon;
          this.extralink=this.submenus[i].extralink;*/
        console.log(this.path, " this.path")
        console.log(this.rightDisplayName, " this.rightDisplayName")
        console.log(this.submenus[i].path, " this.submenus")
      }
    }
    console.log(MENU,"menu items")
    for(let i=0;i<MENU.length;i++){
      console.log(MENU[i].label,"Labels")
      if(MENU[i].label === undefined){

        MENU.splice(i--,1);



      }else{
        console.log("faima")
      }
    }

    console.log(MENU,"something here")

    //console.log(JSON.parse(this.sessionId), "this.sessionId")
    //this.menuItems =this.sessionId.groupId;
    this.sidebarnavItems =this.sessionId.groupId.sort((a, b) => a.headerPos - b.headerPos);
    console.log(this.sidebarnavItems, "this.sidebarnavItems")

  }
  addExpandClass(element: any) {
    if (element === this.showMenu) {
      this.showMenu = '0';
    } else {
      this.showMenu = element;
    }
  }
  /**
   * Returns true or false if given menu item has child or not
   * @param item menuItem
   */
  hasItems(item: MenuItem) {
    return item.subItems !== undefined ? item.subItems.length > 0 : false;
  }

  /**
   * Change the layout onclick
   * @param layout Change the layout
   */
  changeLayout(layout: string) {
    this.eventService.broadcast('changeLayout', layout);
  }

  /**
   * Light sidebar
   */
  lightSidebar() {
    document.body.setAttribute('data-sidebar', 'light');
    document.body.setAttribute('data-topbar', 'dark');
    document.body.removeAttribute('data-sidebar-size');
    document.body.removeAttribute('data-layout-size');
    document.body.removeAttribute('data-keep-enlarged');
    document.body.classList.remove('vertical-collpsed');
  }

  /**
   * Compact sidebar
   */
  compactSidebar() {
    document.body.setAttribute('data-sidebar-size', 'small');
    document.body.setAttribute('data-sidebar', 'dark');
    document.body.removeAttribute('data-topbar');
    document.body.removeAttribute('data-layout-size');
    document.body.removeAttribute('data-keep-enlarged');
    document.body.classList.remove('sidebar-enable');
    document.body.classList.remove('vertical-collpsed');
  }

  /**
   * Icon sidebar
   */
  iconSidebar() {
    document.body.classList.add('sidebar-enable');
    document.body.classList.add('vertical-collpsed');
    document.body.setAttribute('data-sidebar', 'dark');
    document.body.removeAttribute('data-layout-size');
    document.body.removeAttribute('data-keep-enlarged');
    document.body.removeAttribute('data-topbar');
  }

  /**
   * Boxed layout
   */
  boxedLayout() {
    document.body.setAttribute('data-keep-enlarged', 'true');
    document.body.setAttribute('data-layout-size', 'boxed');
    document.body.setAttribute('data-sidebar', 'dark');
    document.body.classList.add('vertical-collpsed');
    document.body.classList.remove('sidebar-enable');
    document.body.removeAttribute('data-topbar');
  }


  /**
   * Colored sidebar
   */
  coloredSidebar() {
    document.body.setAttribute('data-sidebar', 'colored');
    document.body.removeAttribute('data-sidebar-size');
    document.body.removeAttribute('data-layout-size');
    document.body.classList.remove('vertical-collpsed');
    document.body.removeAttribute('data-topbar');
  }

}
