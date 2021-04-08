 export interface MenuItem {
   sessionId?:any;
    id?: number;
    path?:String;
    title?:String;
    extralink?:boolean;
    label?: string;
    icon?: string;
    link?: string;
    subItems?: any;
    isTitle?: boolean;
    badge?: any;
    parentId?: number;
    isLayout?: boolean;

}
