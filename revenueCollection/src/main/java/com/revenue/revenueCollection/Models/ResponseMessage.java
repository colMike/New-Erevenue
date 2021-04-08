package com.revenue.revenueCollection.Models;


import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

public class ResponseMessage   {
    boolean status;
    String  respMessage;
     int userId;
    int respCode;
    private HashSet<MenuHeaderMaster> user;
    public ResponseMessage() {

    }
    public ResponseMessage(int respCode, String respMessage) {
        this.respCode = respCode;
        this.respMessage = respMessage;
    }
    public ResponseMessage(int respCode, String respMessage,  HashSet<MenuHeaderMaster>  user) {
        this.respCode = respCode;
        this.respMessage = respMessage;
        this.user=  user;
    }

   /* public ResponseMessage(int respCode, String no_rights_found, HashSet<MenuHeaderMaster> menuHeaderMasters) {
    }*/

    public HashSet<MenuHeaderMaster> getUser() {
        return user;
    }

    public void setUser(HashSet<MenuHeaderMaster> user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRespMessage() {
        return respMessage;
    }

    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }
}
