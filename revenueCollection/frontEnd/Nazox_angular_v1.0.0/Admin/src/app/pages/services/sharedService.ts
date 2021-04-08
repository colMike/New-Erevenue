import {Injectable} from "@angular/core";


@Injectable({ providedIn: 'root' })
export class MySharedService {
  username: string;
  isAuthenticated: boolean;
  rights: any;
  rightId: any;
  groupId: any;
  configs: any;
  // dataChange: Observable<any>;

  constructor() {
    //   this.dataChange = new Observable((observer:Observer) {
    //     this.dataChangeObserver = observer;
    //   });
  }

  setUsername(username) {
    this.username = username;
    //   this.dataChangeObserver.next(this.data);
  }

  setRightId(rightId) {
    this.rightId = rightId;
  }

  setGroupId(groupId) {
    this.groupId = groupId;
  }

  setRights(rights) {
    this.rights = rights;
  }

  setAuth(auth) {
    this.isAuthenticated = auth;
  }

  setConfigs(configs) {
    this.configs = configs;
  }
}
