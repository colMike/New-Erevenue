package com.revenue.revenueCollection.Utility;

public class LoginUser {
    public int resetId;
    public int userId;
    public int groupId;
    public int respCode;
    public String username;
    public String respMessage;
    public LoginUser(int userId,int groupId, int respCode) {
        this.groupId=groupId;
        this.userId = userId;
        this.respCode = respCode;
    }

    public LoginUser(int userId,int groupId,String username, int respCode) {
        this.groupId=groupId;
        this.userId = userId;
        this.respCode = respCode;
        this.username=username;
    }





    public LoginUser(int respCode, String respMessage) {
        this.respCode = respCode;
        this.respMessage = respMessage;
    }

    public LoginUser(int respCode) {
        this.respCode = respCode;
    }

    public LoginUser() {
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getResetId() {
        return resetId;
    }

    public void setResetId(int resetId) {
        this.resetId = resetId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getRespMessage() {
        return respMessage;
    }

    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }
}
