package com.revenue.revenueCollection.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "Customer_validation")
public class Customer_validation {
    @Id
    @GeneratedValue
public int ID;
public String CUSTOMERNAME	;
    public String EMAIL	;
public String PHONENUMBER	;
public String LANG	;
public String PIN	;
public String FIRSTLOGIN	;
public String ACTIVE	;
public String REGISTERED	;
public String CSTDELETE	;
public String REGDATE	;
public String ALERTENABLED	;
public String REMARK	;
public String UNIQUEID;
public String MENUXML	;
public String MWALLETXML	;
public String TRIALS	;	
public String CUSTOMERNO	;
public String ALERTSMATRIX	;
public String ALIAS	;
public String PINCHANGE	;
public String CLOSEACCOUNT	;	
public String CLOSEACCOUNT1	;
public String CLOSED	;	
public String PINRESETREMARK	;
public String UNBLOCKREMARK	;
public String CLOSEREMARK	;
public String SACCOID	;
public String ACTIVATIONDATE	;
public String RESET	;	
public String AGENTNUMBER	;
public String IMSI	;
public String CLOSEDBY	;
public String BLOCKEDTIME	;
public String BLOCKEDBY	;
public String UNBLOCKEDBY	;
public String IMSI_UNBLOCKEDBY	;
public String IMSI_UNBLOCKEDON	;
public String IMSIUNBLOCK_REMARKS	;
public String IMSIUB_APPROVEDBY	;
public String IMSIUB_APPROVEDON	;
public String IMSIUB_APPROVALREMARKS	;
public String APPROVEIMSIUNBLOCK	;	
public String UNBLOCKTYPE	;
public String APPROVED	;
public String APPROVEDBY1	;
public String APPROVEDBY2	;
public String REJECTED	;

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCUSTOMERNAME() {
        return CUSTOMERNAME;
    }

    public void setCUSTOMERNAME(String CUSTOMERNAME) {
        this.CUSTOMERNAME = CUSTOMERNAME;
    }

    public String getPHONENUMBER() {
        return PHONENUMBER;
    }

    public void setPHONENUMBER(String PHONENUMBER) {
        this.PHONENUMBER = PHONENUMBER;
    }

    public String getLANG() {
        return LANG;
    }

    public void setLANG(String LANG) {
        this.LANG = LANG;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getFIRSTLOGIN() {
        return FIRSTLOGIN;
    }

    public void setFIRSTLOGIN(String FIRSTLOGIN) {
        this.FIRSTLOGIN = FIRSTLOGIN;
    }

    public String getACTIVE() {
        return ACTIVE;
    }

    public void setACTIVE(String ACTIVE) {
        this.ACTIVE = ACTIVE;
    }

    public String getREGISTERED() {
        return REGISTERED;
    }

    public void setREGISTERED(String REGISTERED) {
        this.REGISTERED = REGISTERED;
    }

    public String getCSTDELETE() {
        return CSTDELETE;
    }

    public void setCSTDELETE(String CSTDELETE) {
        this.CSTDELETE = CSTDELETE;
    }

    public String getREGDATE() {
        return REGDATE;
    }

    public void setREGDATE(String REGDATE) {
        this.REGDATE = REGDATE;
    }

    public String getALERTENABLED() {
        return ALERTENABLED;
    }

    public void setALERTENABLED(String ALERTENABLED) {
        this.ALERTENABLED = ALERTENABLED;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public String getUNIQUEID() {
        return UNIQUEID;
    }

    public void setUNIQUEID(String UNIQUEID) {
        this.UNIQUEID = UNIQUEID;
    }

    public String getMENUXML() {
        return MENUXML;
    }

    public void setMENUXML(String MENUXML) {
        this.MENUXML = MENUXML;
    }

    public String getMWALLETXML() {
        return MWALLETXML;
    }

    public void setMWALLETXML(String MWALLETXML) {
        this.MWALLETXML = MWALLETXML;
    }

    public String getTRIALS() {
        return TRIALS;
    }

    public void setTRIALS(String TRIALS) {
        this.TRIALS = TRIALS;
    }

    public String getCUSTOMERNO() {
        return CUSTOMERNO;
    }

    public void setCUSTOMERNO(String CUSTOMERNO) {
        this.CUSTOMERNO = CUSTOMERNO;
    }

    public String getALERTSMATRIX() {
        return ALERTSMATRIX;
    }

    public void setALERTSMATRIX(String ALERTSMATRIX) {
        this.ALERTSMATRIX = ALERTSMATRIX;
    }

    public String getALIAS() {
        return ALIAS;
    }

    public void setALIAS(String ALIAS) {
        this.ALIAS = ALIAS;
    }

    public String getPINCHANGE() {
        return PINCHANGE;
    }

    public void setPINCHANGE(String PINCHANGE) {
        this.PINCHANGE = PINCHANGE;
    }

    public String getCLOSEACCOUNT() {
        return CLOSEACCOUNT;
    }

    public void setCLOSEACCOUNT(String CLOSEACCOUNT) {
        this.CLOSEACCOUNT = CLOSEACCOUNT;
    }

    public String getCLOSEACCOUNT1() {
        return CLOSEACCOUNT1;
    }

    public void setCLOSEACCOUNT1(String CLOSEACCOUNT1) {
        this.CLOSEACCOUNT1 = CLOSEACCOUNT1;
    }

    public String getCLOSED() {
        return CLOSED;
    }

    public void setCLOSED(String CLOSED) {
        this.CLOSED = CLOSED;
    }

    public String getPINRESETREMARK() {
        return PINRESETREMARK;
    }

    public void setPINRESETREMARK(String PINRESETREMARK) {
        this.PINRESETREMARK = PINRESETREMARK;
    }

    public String getUNBLOCKREMARK() {
        return UNBLOCKREMARK;
    }

    public void setUNBLOCKREMARK(String UNBLOCKREMARK) {
        this.UNBLOCKREMARK = UNBLOCKREMARK;
    }

    public String getCLOSEREMARK() {
        return CLOSEREMARK;
    }

    public void setCLOSEREMARK(String CLOSEREMARK) {
        this.CLOSEREMARK = CLOSEREMARK;
    }

    public String getSACCOID() {
        return SACCOID;
    }

    public void setSACCOID(String SACCOID) {
        this.SACCOID = SACCOID;
    }

    public String getACTIVATIONDATE() {
        return ACTIVATIONDATE;
    }

    public void setACTIVATIONDATE(String ACTIVATIONDATE) {
        this.ACTIVATIONDATE = ACTIVATIONDATE;
    }

    public String getRESET() {
        return RESET;
    }

    public void setRESET(String RESET) {
        this.RESET = RESET;
    }

    public String getAGENTNUMBER() {
        return AGENTNUMBER;
    }

    public void setAGENTNUMBER(String AGENTNUMBER) {
        this.AGENTNUMBER = AGENTNUMBER;
    }

    public String getIMSI() {
        return IMSI;
    }

    public void setIMSI(String IMSI) {
        this.IMSI = IMSI;
    }

    public String getCLOSEDBY() {
        return CLOSEDBY;
    }

    public void setCLOSEDBY(String CLOSEDBY) {
        this.CLOSEDBY = CLOSEDBY;
    }

    public String getBLOCKEDTIME() {
        return BLOCKEDTIME;
    }

    public void setBLOCKEDTIME(String BLOCKEDTIME) {
        this.BLOCKEDTIME = BLOCKEDTIME;
    }

    public String getBLOCKEDBY() {
        return BLOCKEDBY;
    }

    public void setBLOCKEDBY(String BLOCKEDBY) {
        this.BLOCKEDBY = BLOCKEDBY;
    }

    public String getUNBLOCKEDBY() {
        return UNBLOCKEDBY;
    }

    public void setUNBLOCKEDBY(String UNBLOCKEDBY) {
        this.UNBLOCKEDBY = UNBLOCKEDBY;
    }

    public String getIMSI_UNBLOCKEDBY() {
        return IMSI_UNBLOCKEDBY;
    }

    public void setIMSI_UNBLOCKEDBY(String IMSI_UNBLOCKEDBY) {
        this.IMSI_UNBLOCKEDBY = IMSI_UNBLOCKEDBY;
    }

    public String getIMSI_UNBLOCKEDON() {
        return IMSI_UNBLOCKEDON;
    }

    public void setIMSI_UNBLOCKEDON(String IMSI_UNBLOCKEDON) {
        this.IMSI_UNBLOCKEDON = IMSI_UNBLOCKEDON;
    }

    public String getIMSIUNBLOCK_REMARKS() {
        return IMSIUNBLOCK_REMARKS;
    }

    public void setIMSIUNBLOCK_REMARKS(String IMSIUNBLOCK_REMARKS) {
        this.IMSIUNBLOCK_REMARKS = IMSIUNBLOCK_REMARKS;
    }

    public String getIMSIUB_APPROVEDBY() {
        return IMSIUB_APPROVEDBY;
    }

    public void setIMSIUB_APPROVEDBY(String IMSIUB_APPROVEDBY) {
        this.IMSIUB_APPROVEDBY = IMSIUB_APPROVEDBY;
    }

    public String getIMSIUB_APPROVEDON() {
        return IMSIUB_APPROVEDON;
    }

    public void setIMSIUB_APPROVEDON(String IMSIUB_APPROVEDON) {
        this.IMSIUB_APPROVEDON = IMSIUB_APPROVEDON;
    }

    public String getIMSIUB_APPROVALREMARKS() {
        return IMSIUB_APPROVALREMARKS;
    }

    public void setIMSIUB_APPROVALREMARKS(String IMSIUB_APPROVALREMARKS) {
        this.IMSIUB_APPROVALREMARKS = IMSIUB_APPROVALREMARKS;
    }

    public String getAPPROVEIMSIUNBLOCK() {
        return APPROVEIMSIUNBLOCK;
    }

    public void setAPPROVEIMSIUNBLOCK(String APPROVEIMSIUNBLOCK) {
        this.APPROVEIMSIUNBLOCK = APPROVEIMSIUNBLOCK;
    }

    public String getUNBLOCKTYPE() {
        return UNBLOCKTYPE;
    }

    public void setUNBLOCKTYPE(String UNBLOCKTYPE) {
        this.UNBLOCKTYPE = UNBLOCKTYPE;
    }

    public String getAPPROVED() {
        return APPROVED;
    }

    public void setAPPROVED(String APPROVED) {
        this.APPROVED = APPROVED;
    }

    public String getAPPROVEDBY1() {
        return APPROVEDBY1;
    }

    public void setAPPROVEDBY1(String APPROVEDBY1) {
        this.APPROVEDBY1 = APPROVEDBY1;
    }

    public String getAPPROVEDBY2() {
        return APPROVEDBY2;
    }

    public void setAPPROVEDBY2(String APPROVEDBY2) {
        this.APPROVEDBY2 = APPROVEDBY2;
    }

    public String getREJECTED() {
        return REJECTED;
    }

    public void setREJECTED(String REJECTED) {
        this.REJECTED = REJECTED;
    }
}
