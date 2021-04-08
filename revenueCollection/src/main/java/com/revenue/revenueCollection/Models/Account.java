package com.revenue.revenueCollection.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
@Entity
@TableGenerator(name = "Accounts")
public class Account {
@Id
@GeneratedValue
@NotNull
public int ID;
public String BRANCH;
@NotNull
public String ACCOUNTNO;
public String ACCOUNTDESCRIPTION;
@NotNull
public String CUSTOMERNO;
public String CURRENCY	;
public String ACCOUNTCLASS	;
public String ALLOWDR	;
public String ALLOWCR;
public String BLOCKED;
public String STOPPED;
public String DORMANT;
public String ISJOINTACCOUNT	;
public Timestamp  OPENINGDATE	;
public String CHEQUEBOOKFACILITY;
public String ATMFACILITY;
public String ISFROZEN;
public Date TRXLIMITFROMDATE;
public Date TRXLIMITTODATE;
public String TRXLIMIT	;
public String CUSTOMERSTATUS	;
public String AUTHORIZATIONSTATUS	;
public String CREATEDBY	;
public Timestamp CREATEDON;	
public String	APPROVEDBY	;
public String APPROVEDON;
public String OPENINGBAL;
public String TODAYDR;
public String TODAYCR;
public String ACTUALBAL;
public String AVAILABLEBAL;
public String BLOCKEDAMOUNT;
public Date DRDATE;
   public  Date	CRDATE;	
   public  Date	DORMANCYDATE;
public int DORMANCYDAYS	;
public int ATMLIMIT;
public int MINBALANCE;
public String ACCOUNTSTATUS	;	
public Date MATURITYDATE;	
public String	INTERESTRATE	;	
public String EODPROCESSED	;
public String NEXTPROCESSINGDATE;
public String CONTRIBUTIONAMOUNT;
public String PAYMENTFREQUENCY;
public Date STARTDATE;	
public String 	RESERVEACCOUNTCOMMISSIONACCOUN	;
public String RESERVEACCOUNTINTERESTACCOUNT	;
public String RESERVEACCOUNTPARENTACCOUNT	;
public String PARENTACCOUNT	;
public Date LASTTRANSACTIONDATE;	
public String	PERIODDEBITS;
public String PERIODCREDITS;
public String OPENINGBAL_SOD;
public String OPENINGBAL_EOY;
public String APPROVED;
public String INVESTMENTTENURE	;
public String COMMISSIONPAID;
public String ISBOOKED;
public String ISBOOKEDBY	;
public String ACCOUNTTYPE	;
public String AVAILABLEPOINTS;
public String UNREGISTEREDCSTMS;
public String LEANAMOUNT;
public String SACCOID	;
public String SACCONAME	;
public String SACCOMEMBERNUMBER	;
public String INSTITUTIONTYPE	;
public String TEMPACCOUNTNO	;
public String UNBLOCKED;
public String BLOCKAMOUNTDATE;
public Date LAST_TRANSACTION_DATE;	
public String	BLOCKAMOUNTREMARK	;
public String SUBVALUE_ACTUAL;
public String PHONENUMBER;
public String SUBVALUE_AVAILABLE;
public String PARTIAL_REGISTRATION	;
public String GROUPACCOUNT;
public String TEMPLIMIT;	
public String LIMITSETBY	;
public String LIMITSETON;
public String LIMITAPPROVEDBY	;
public String LIMITAPPROVEDON;
public String LIMITREWORKEDBY	;
public String LIMITREWORKEDON;
public String LIMITREWORKED;	
public String LIMITREMARKS;
public String MEMOCODE;
public String MINBALINTEREST;	
public String INTACCRUALDATE;	;
public String INTPAYMENTDATE;	;
public String BLOCKEDCREDIT;	
public String BLOCKEDCREDITDATE;
public String BLOCKEDCREDITREMARK	;
public String BLOCKEDCREDITBY	;
public String UNBLOCKEDCREDIT;	
public String UNBLOCKEDCREDITBY;
public String UNBLOCKEDCREDITDATE;
public String UNBLOCKCREDITREMARK;
public String UNBLOCKCREDITAPPROVED;	
public String UNBLOCKCREDITCHEREMARK	;
public String LANG	;
public String BLOCKEDLOANAMOUNT;
public String PARTIAL_DORMANT	;	
public String PARTIAL_DORMANT_DAYS;
public String APPROVE_DORMANCY_RESET_BY;
public String APPROVE_DORMANCY_RESET_REMARKS;
public String DORMANCY_RESET_BY;
public String DORMANCY_RESET_REMARKS;
public String APPROVE_DORMANCY_RESET;
public String FULL_REG_DATE;
public String LOAN_CASHCOVER;
public String SIM_SWAP	;	
public String AC_OPERATIONS_BY;
public String AC_OPERATIONS_ON;
public String AC_OPERATIONS;	
public String SESSIONID;
public String REWORKED;	
public String REWORKEDBY;
public String REWORKEDON;
public String PROCESSED	;	
public String BUFFERVAL	;
public String FREEZEBY	;
public String FREEZEON	;
public String FREEZEAPPROVEBY	;
public String FREEZEAPPROVEON	;
public String CLOSEBBY	;
public String CLOSEON	;
public String APPROVECLOSEBY	;
public String APPROVECLOSEON	;
public String BLOCKEDAMOUNTON	;
public String BLOCKEDAMOUNTBY	;
public String APPROVEBLOCKEDAMOUNTON	;
public String APPROVEBLOCKEDAMOUNTBY	;
public String BLOCKEDBY	;
public String BLOCKEDON	;
public String APPROVEBLOCKBY	;
public String APPROVEBLOCKON	;
public String BLOCKEDAMOUNTBUFFER	;
public String AMOUNTUNBLOCKEDBY	;
public String AMOUNTUNBLOCKEDON	;
public String AMOUNTUNBLOCKEDAPPRBY	;
public String AMOUNTUNBLOCKEDAPPRON	;
public String LINKEDACCOUNT;	
public String LINKEDBY	;
public String LINKREQUEST	;	
public String LINKACCNAME	;
public String LASTCHARGEDATE;
public String MONTHLYCHARGETRIALS;	
public String CDSACCOUNT;
public String KYCVERIFIED;	
public String CHECKSUM;
public String GROUP_ID;

   public int getID() {
      return ID;
   }

   public void setID(int ID) {
      this.ID = ID;
   }

   public String getBRANCH() {
      return BRANCH;
   }

   public void setBRANCH(String BRANCH) {
      this.BRANCH = BRANCH;
   }

   public String getACCOUNTNO() {
      return ACCOUNTNO;
   }

   public void setACCOUNTNO(String ACCOUNTNO) {
      this.ACCOUNTNO = ACCOUNTNO;
   }

   public String getACCOUNTDESCRIPTION() {
      return ACCOUNTDESCRIPTION;
   }

   public void setACCOUNTDESCRIPTION(String ACCOUNTDESCRIPTION) {
      this.ACCOUNTDESCRIPTION = ACCOUNTDESCRIPTION;
   }

   public String getCUSTOMERNO() {
      return CUSTOMERNO;
   }

   public void setCUSTOMERNO(String CUSTOMERNO) {
      this.CUSTOMERNO = CUSTOMERNO;
   }

   public String getCURRENCY() {
      return CURRENCY;
   }

   public void setCURRENCY(String CURRENCY) {
      this.CURRENCY = CURRENCY;
   }

   public String getACCOUNTCLASS() {
      return ACCOUNTCLASS;
   }

   public void setACCOUNTCLASS(String ACCOUNTCLASS) {
      this.ACCOUNTCLASS = ACCOUNTCLASS;
   }

   public String getALLOWDR() {
      return ALLOWDR;
   }

   public void setALLOWDR(String ALLOWDR) {
      this.ALLOWDR = ALLOWDR;
   }

   public String getALLOWCR() {
      return ALLOWCR;
   }

   public void setALLOWCR(String ALLOWCR) {
      this.ALLOWCR = ALLOWCR;
   }

   public String getBLOCKED() {
      return BLOCKED;
   }

   public void setBLOCKED(String BLOCKED) {
      this.BLOCKED = BLOCKED;
   }

   public String getSTOPPED() {
      return STOPPED;
   }

   public void setSTOPPED(String STOPPED) {
      this.STOPPED = STOPPED;
   }

   public String getDORMANT() {
      return DORMANT;
   }

   public void setDORMANT(String DORMANT) {
      this.DORMANT = DORMANT;
   }

   public String getISJOINTACCOUNT() {
      return ISJOINTACCOUNT;
   }

   public void setISJOINTACCOUNT(String ISJOINTACCOUNT) {
      this.ISJOINTACCOUNT = ISJOINTACCOUNT;
   }

   public Timestamp getOPENINGDATE() {
      return OPENINGDATE;
   }

   public void setOPENINGDATE(Timestamp OPENINGDATE) {
      this.OPENINGDATE = OPENINGDATE;
   }

   public String getCHEQUEBOOKFACILITY() {
      return CHEQUEBOOKFACILITY;
   }

   public void setCHEQUEBOOKFACILITY(String CHEQUEBOOKFACILITY) {
      this.CHEQUEBOOKFACILITY = CHEQUEBOOKFACILITY;
   }

   public String getATMFACILITY() {
      return ATMFACILITY;
   }

   public void setATMFACILITY(String ATMFACILITY) {
      this.ATMFACILITY = ATMFACILITY;
   }

   public String getISFROZEN() {
      return ISFROZEN;
   }

   public void setISFROZEN(String ISFROZEN) {
      this.ISFROZEN = ISFROZEN;
   }

   public Date getTRXLIMITFROMDATE() {
      return TRXLIMITFROMDATE;
   }

   public void setTRXLIMITFROMDATE(Date TRXLIMITFROMDATE) {
      this.TRXLIMITFROMDATE = TRXLIMITFROMDATE;
   }

   public Date getTRXLIMITTODATE() {
      return TRXLIMITTODATE;
   }

   public void setTRXLIMITTODATE(Date TRXLIMITTODATE) {
      this.TRXLIMITTODATE = TRXLIMITTODATE;
   }

   public String getTRXLIMIT() {
      return TRXLIMIT;
   }

   public void setTRXLIMIT(String TRXLIMIT) {
      this.TRXLIMIT = TRXLIMIT;
   }

   public String getCUSTOMERSTATUS() {
      return CUSTOMERSTATUS;
   }

   public void setCUSTOMERSTATUS(String CUSTOMERSTATUS) {
      this.CUSTOMERSTATUS = CUSTOMERSTATUS;
   }

   public String getAUTHORIZATIONSTATUS() {
      return AUTHORIZATIONSTATUS;
   }

   public void setAUTHORIZATIONSTATUS(String AUTHORIZATIONSTATUS) {
      this.AUTHORIZATIONSTATUS = AUTHORIZATIONSTATUS;
   }

   public String getCREATEDBY() {
      return CREATEDBY;
   }

   public void setCREATEDBY(String CREATEDBY) {
      this.CREATEDBY = CREATEDBY;
   }

   public Timestamp getCREATEDON() {
      return CREATEDON;
   }

   public void setCREATEDON(Timestamp CREATEDON) {
      this.CREATEDON = CREATEDON;
   }

   public String getAPPROVEDBY() {
      return APPROVEDBY;
   }

   public void setAPPROVEDBY(String APPROVEDBY) {
      this.APPROVEDBY = APPROVEDBY;
   }

   public String getAPPROVEDON() {
      return APPROVEDON;
   }

   public void setAPPROVEDON(String APPROVEDON) {
      this.APPROVEDON = APPROVEDON;
   }

   public String getOPENINGBAL() {
      return OPENINGBAL;
   }

   public void setOPENINGBAL(String OPENINGBAL) {
      this.OPENINGBAL = OPENINGBAL;
   }

   public String getTODAYDR() {
      return TODAYDR;
   }

   public void setTODAYDR(String TODAYDR) {
      this.TODAYDR = TODAYDR;
   }

   public String getTODAYCR() {
      return TODAYCR;
   }

   public void setTODAYCR(String TODAYCR) {
      this.TODAYCR = TODAYCR;
   }

   public String getACTUALBAL() {
      return ACTUALBAL;
   }

   public void setACTUALBAL(String ACTUALBAL) {
      this.ACTUALBAL = ACTUALBAL;
   }

   public String getAVAILABLEBAL() {
      return AVAILABLEBAL;
   }

   public void setAVAILABLEBAL(String AVAILABLEBAL) {
      this.AVAILABLEBAL = AVAILABLEBAL;
   }

   public String getBLOCKEDAMOUNT() {
      return BLOCKEDAMOUNT;
   }

   public void setBLOCKEDAMOUNT(String BLOCKEDAMOUNT) {
      this.BLOCKEDAMOUNT = BLOCKEDAMOUNT;
   }

   public Date getDRDATE() {
      return DRDATE;
   }

   public void setDRDATE(Date DRDATE) {
      this.DRDATE = DRDATE;
   }

   public Date getCRDATE() {
      return CRDATE;
   }

   public void setCRDATE(Date CRDATE) {
      this.CRDATE = CRDATE;
   }

   public Date getDORMANCYDATE() {
      return DORMANCYDATE;
   }

   public void setDORMANCYDATE(Date DORMANCYDATE) {
      this.DORMANCYDATE = DORMANCYDATE;
   }

   public int getDORMANCYDAYS() {
      return DORMANCYDAYS;
   }

   public void setDORMANCYDAYS(int DORMANCYDAYS) {
      this.DORMANCYDAYS = DORMANCYDAYS;
   }

   public int getATMLIMIT() {
      return ATMLIMIT;
   }

   public void setATMLIMIT(int ATMLIMIT) {
      this.ATMLIMIT = ATMLIMIT;
   }

   public int getMINBALANCE() {
      return MINBALANCE;
   }

   public void setMINBALANCE(int MINBALANCE) {
      this.MINBALANCE = MINBALANCE;
   }

   public String getACCOUNTSTATUS() {
      return ACCOUNTSTATUS;
   }

   public void setACCOUNTSTATUS(String ACCOUNTSTATUS) {
      this.ACCOUNTSTATUS = ACCOUNTSTATUS;
   }

   public Date getMATURITYDATE() {
      return MATURITYDATE;
   }

   public void setMATURITYDATE(Date MATURITYDATE) {
      this.MATURITYDATE = MATURITYDATE;
   }

   public String getINTERESTRATE() {
      return INTERESTRATE;
   }

   public void setINTERESTRATE(String INTERESTRATE) {
      this.INTERESTRATE = INTERESTRATE;
   }

   public String getEODPROCESSED() {
      return EODPROCESSED;
   }

   public void setEODPROCESSED(String EODPROCESSED) {
      this.EODPROCESSED = EODPROCESSED;
   }

   public String getNEXTPROCESSINGDATE() {
      return NEXTPROCESSINGDATE;
   }

   public void setNEXTPROCESSINGDATE(String NEXTPROCESSINGDATE) {
      this.NEXTPROCESSINGDATE = NEXTPROCESSINGDATE;
   }

   public String getCONTRIBUTIONAMOUNT() {
      return CONTRIBUTIONAMOUNT;
   }

   public void setCONTRIBUTIONAMOUNT(String CONTRIBUTIONAMOUNT) {
      this.CONTRIBUTIONAMOUNT = CONTRIBUTIONAMOUNT;
   }

   public String getPAYMENTFREQUENCY() {
      return PAYMENTFREQUENCY;
   }

   public void setPAYMENTFREQUENCY(String PAYMENTFREQUENCY) {
      this.PAYMENTFREQUENCY = PAYMENTFREQUENCY;
   }

   public Date getSTARTDATE() {
      return STARTDATE;
   }

   public void setSTARTDATE(Date STARTDATE) {
      this.STARTDATE = STARTDATE;
   }

   public String getRESERVEACCOUNTCOMMISSIONACCOUN() {
      return RESERVEACCOUNTCOMMISSIONACCOUN;
   }

   public void setRESERVEACCOUNTCOMMISSIONACCOUN(String RESERVEACCOUNTCOMMISSIONACCOUN) {
      this.RESERVEACCOUNTCOMMISSIONACCOUN = RESERVEACCOUNTCOMMISSIONACCOUN;
   }

   public String getRESERVEACCOUNTINTERESTACCOUNT() {
      return RESERVEACCOUNTINTERESTACCOUNT;
   }

   public void setRESERVEACCOUNTINTERESTACCOUNT(String RESERVEACCOUNTINTERESTACCOUNT) {
      this.RESERVEACCOUNTINTERESTACCOUNT = RESERVEACCOUNTINTERESTACCOUNT;
   }

   public String getRESERVEACCOUNTPARENTACCOUNT() {
      return RESERVEACCOUNTPARENTACCOUNT;
   }

   public void setRESERVEACCOUNTPARENTACCOUNT(String RESERVEACCOUNTPARENTACCOUNT) {
      this.RESERVEACCOUNTPARENTACCOUNT = RESERVEACCOUNTPARENTACCOUNT;
   }

   public String getPARENTACCOUNT() {
      return PARENTACCOUNT;
   }

   public void setPARENTACCOUNT(String PARENTACCOUNT) {
      this.PARENTACCOUNT = PARENTACCOUNT;
   }

   public Date getLASTTRANSACTIONDATE() {
      return LASTTRANSACTIONDATE;
   }

   public void setLASTTRANSACTIONDATE(Date LASTTRANSACTIONDATE) {
      this.LASTTRANSACTIONDATE = LASTTRANSACTIONDATE;
   }

   public String getPERIODDEBITS() {
      return PERIODDEBITS;
   }

   public void setPERIODDEBITS(String PERIODDEBITS) {
      this.PERIODDEBITS = PERIODDEBITS;
   }

   public String getPERIODCREDITS() {
      return PERIODCREDITS;
   }

   public void setPERIODCREDITS(String PERIODCREDITS) {
      this.PERIODCREDITS = PERIODCREDITS;
   }

   public String getOPENINGBAL_SOD() {
      return OPENINGBAL_SOD;
   }

   public void setOPENINGBAL_SOD(String OPENINGBAL_SOD) {
      this.OPENINGBAL_SOD = OPENINGBAL_SOD;
   }

   public String getOPENINGBAL_EOY() {
      return OPENINGBAL_EOY;
   }

   public void setOPENINGBAL_EOY(String OPENINGBAL_EOY) {
      this.OPENINGBAL_EOY = OPENINGBAL_EOY;
   }

   public String getAPPROVED() {
      return APPROVED;
   }

   public void setAPPROVED(String APPROVED) {
      this.APPROVED = APPROVED;
   }

   public String getINVESTMENTTENURE() {
      return INVESTMENTTENURE;
   }

   public void setINVESTMENTTENURE(String INVESTMENTTENURE) {
      this.INVESTMENTTENURE = INVESTMENTTENURE;
   }

   public String getCOMMISSIONPAID() {
      return COMMISSIONPAID;
   }

   public void setCOMMISSIONPAID(String COMMISSIONPAID) {
      this.COMMISSIONPAID = COMMISSIONPAID;
   }

   public String getISBOOKED() {
      return ISBOOKED;
   }

   public void setISBOOKED(String ISBOOKED) {
      this.ISBOOKED = ISBOOKED;
   }

   public String getISBOOKEDBY() {
      return ISBOOKEDBY;
   }

   public void setISBOOKEDBY(String ISBOOKEDBY) {
      this.ISBOOKEDBY = ISBOOKEDBY;
   }

   public String getACCOUNTTYPE() {
      return ACCOUNTTYPE;
   }

   public void setACCOUNTTYPE(String ACCOUNTTYPE) {
      this.ACCOUNTTYPE = ACCOUNTTYPE;
   }

   public String getAVAILABLEPOINTS() {
      return AVAILABLEPOINTS;
   }

   public void setAVAILABLEPOINTS(String AVAILABLEPOINTS) {
      this.AVAILABLEPOINTS = AVAILABLEPOINTS;
   }

   public String getUNREGISTEREDCSTMS() {
      return UNREGISTEREDCSTMS;
   }

   public void setUNREGISTEREDCSTMS(String UNREGISTEREDCSTMS) {
      this.UNREGISTEREDCSTMS = UNREGISTEREDCSTMS;
   }

   public String getLEANAMOUNT() {
      return LEANAMOUNT;
   }

   public void setLEANAMOUNT(String LEANAMOUNT) {
      this.LEANAMOUNT = LEANAMOUNT;
   }

   public String getSACCOID() {
      return SACCOID;
   }

   public void setSACCOID(String SACCOID) {
      this.SACCOID = SACCOID;
   }

   public String getSACCONAME() {
      return SACCONAME;
   }

   public void setSACCONAME(String SACCONAME) {
      this.SACCONAME = SACCONAME;
   }

   public String getSACCOMEMBERNUMBER() {
      return SACCOMEMBERNUMBER;
   }

   public void setSACCOMEMBERNUMBER(String SACCOMEMBERNUMBER) {
      this.SACCOMEMBERNUMBER = SACCOMEMBERNUMBER;
   }

   public String getINSTITUTIONTYPE() {
      return INSTITUTIONTYPE;
   }

   public void setINSTITUTIONTYPE(String INSTITUTIONTYPE) {
      this.INSTITUTIONTYPE = INSTITUTIONTYPE;
   }

   public String getTEMPACCOUNTNO() {
      return TEMPACCOUNTNO;
   }

   public void setTEMPACCOUNTNO(String TEMPACCOUNTNO) {
      this.TEMPACCOUNTNO = TEMPACCOUNTNO;
   }

   public String getUNBLOCKED() {
      return UNBLOCKED;
   }

   public void setUNBLOCKED(String UNBLOCKED) {
      this.UNBLOCKED = UNBLOCKED;
   }

   public String getBLOCKAMOUNTDATE() {
      return BLOCKAMOUNTDATE;
   }

   public void setBLOCKAMOUNTDATE(String BLOCKAMOUNTDATE) {
      this.BLOCKAMOUNTDATE = BLOCKAMOUNTDATE;
   }

   public Date getLAST_TRANSACTION_DATE() {
      return LAST_TRANSACTION_DATE;
   }

   public void setLAST_TRANSACTION_DATE(Date LAST_TRANSACTION_DATE) {
      this.LAST_TRANSACTION_DATE = LAST_TRANSACTION_DATE;
   }

   public String getBLOCKAMOUNTREMARK() {
      return BLOCKAMOUNTREMARK;
   }

   public void setBLOCKAMOUNTREMARK(String BLOCKAMOUNTREMARK) {
      this.BLOCKAMOUNTREMARK = BLOCKAMOUNTREMARK;
   }

   public String getSUBVALUE_ACTUAL() {
      return SUBVALUE_ACTUAL;
   }

   public void setSUBVALUE_ACTUAL(String SUBVALUE_ACTUAL) {
      this.SUBVALUE_ACTUAL = SUBVALUE_ACTUAL;
   }

   public String getPHONENUMBER() {
      return PHONENUMBER;
   }

   public void setPHONENUMBER(String PHONENUMBER) {
      this.PHONENUMBER = PHONENUMBER;
   }

   public String getSUBVALUE_AVAILABLE() {
      return SUBVALUE_AVAILABLE;
   }

   public void setSUBVALUE_AVAILABLE(String SUBVALUE_AVAILABLE) {
      this.SUBVALUE_AVAILABLE = SUBVALUE_AVAILABLE;
   }

   public String getPARTIAL_REGISTRATION() {
      return PARTIAL_REGISTRATION;
   }

   public void setPARTIAL_REGISTRATION(String PARTIAL_REGISTRATION) {
      this.PARTIAL_REGISTRATION = PARTIAL_REGISTRATION;
   }

   public String getGROUPACCOUNT() {
      return GROUPACCOUNT;
   }

   public void setGROUPACCOUNT(String GROUPACCOUNT) {
      this.GROUPACCOUNT = GROUPACCOUNT;
   }

   public String getTEMPLIMIT() {
      return TEMPLIMIT;
   }

   public void setTEMPLIMIT(String TEMPLIMIT) {
      this.TEMPLIMIT = TEMPLIMIT;
   }

   public String getLIMITSETBY() {
      return LIMITSETBY;
   }

   public void setLIMITSETBY(String LIMITSETBY) {
      this.LIMITSETBY = LIMITSETBY;
   }

   public String getLIMITSETON() {
      return LIMITSETON;
   }

   public void setLIMITSETON(String LIMITSETON) {
      this.LIMITSETON = LIMITSETON;
   }

   public String getLIMITAPPROVEDBY() {
      return LIMITAPPROVEDBY;
   }

   public void setLIMITAPPROVEDBY(String LIMITAPPROVEDBY) {
      this.LIMITAPPROVEDBY = LIMITAPPROVEDBY;
   }

   public String getLIMITAPPROVEDON() {
      return LIMITAPPROVEDON;
   }

   public void setLIMITAPPROVEDON(String LIMITAPPROVEDON) {
      this.LIMITAPPROVEDON = LIMITAPPROVEDON;
   }

   public String getLIMITREWORKEDBY() {
      return LIMITREWORKEDBY;
   }

   public void setLIMITREWORKEDBY(String LIMITREWORKEDBY) {
      this.LIMITREWORKEDBY = LIMITREWORKEDBY;
   }

   public String getLIMITREWORKEDON() {
      return LIMITREWORKEDON;
   }

   public void setLIMITREWORKEDON(String LIMITREWORKEDON) {
      this.LIMITREWORKEDON = LIMITREWORKEDON;
   }

   public String getLIMITREWORKED() {
      return LIMITREWORKED;
   }

   public void setLIMITREWORKED(String LIMITREWORKED) {
      this.LIMITREWORKED = LIMITREWORKED;
   }

   public String getLIMITREMARKS() {
      return LIMITREMARKS;
   }

   public void setLIMITREMARKS(String LIMITREMARKS) {
      this.LIMITREMARKS = LIMITREMARKS;
   }

   public String getMEMOCODE() {
      return MEMOCODE;
   }

   public void setMEMOCODE(String MEMOCODE) {
      this.MEMOCODE = MEMOCODE;
   }

   public String getMINBALINTEREST() {
      return MINBALINTEREST;
   }

   public void setMINBALINTEREST(String MINBALINTEREST) {
      this.MINBALINTEREST = MINBALINTEREST;
   }

   public String getINTACCRUALDATE() {
      return INTACCRUALDATE;
   }

   public void setINTACCRUALDATE(String INTACCRUALDATE) {
      this.INTACCRUALDATE = INTACCRUALDATE;
   }

   public String getINTPAYMENTDATE() {
      return INTPAYMENTDATE;
   }

   public void setINTPAYMENTDATE(String INTPAYMENTDATE) {
      this.INTPAYMENTDATE = INTPAYMENTDATE;
   }

   public String getBLOCKEDCREDIT() {
      return BLOCKEDCREDIT;
   }

   public void setBLOCKEDCREDIT(String BLOCKEDCREDIT) {
      this.BLOCKEDCREDIT = BLOCKEDCREDIT;
   }

   public String getBLOCKEDCREDITDATE() {
      return BLOCKEDCREDITDATE;
   }

   public void setBLOCKEDCREDITDATE(String BLOCKEDCREDITDATE) {
      this.BLOCKEDCREDITDATE = BLOCKEDCREDITDATE;
   }

   public String getBLOCKEDCREDITREMARK() {
      return BLOCKEDCREDITREMARK;
   }

   public void setBLOCKEDCREDITREMARK(String BLOCKEDCREDITREMARK) {
      this.BLOCKEDCREDITREMARK = BLOCKEDCREDITREMARK;
   }

   public String getBLOCKEDCREDITBY() {
      return BLOCKEDCREDITBY;
   }

   public void setBLOCKEDCREDITBY(String BLOCKEDCREDITBY) {
      this.BLOCKEDCREDITBY = BLOCKEDCREDITBY;
   }

   public String getUNBLOCKEDCREDIT() {
      return UNBLOCKEDCREDIT;
   }

   public void setUNBLOCKEDCREDIT(String UNBLOCKEDCREDIT) {
      this.UNBLOCKEDCREDIT = UNBLOCKEDCREDIT;
   }

   public String getUNBLOCKEDCREDITBY() {
      return UNBLOCKEDCREDITBY;
   }

   public void setUNBLOCKEDCREDITBY(String UNBLOCKEDCREDITBY) {
      this.UNBLOCKEDCREDITBY = UNBLOCKEDCREDITBY;
   }

   public String getUNBLOCKEDCREDITDATE() {
      return UNBLOCKEDCREDITDATE;
   }

   public void setUNBLOCKEDCREDITDATE(String UNBLOCKEDCREDITDATE) {
      this.UNBLOCKEDCREDITDATE = UNBLOCKEDCREDITDATE;
   }

   public String getUNBLOCKCREDITREMARK() {
      return UNBLOCKCREDITREMARK;
   }

   public void setUNBLOCKCREDITREMARK(String UNBLOCKCREDITREMARK) {
      this.UNBLOCKCREDITREMARK = UNBLOCKCREDITREMARK;
   }

   public String getUNBLOCKCREDITAPPROVED() {
      return UNBLOCKCREDITAPPROVED;
   }

   public void setUNBLOCKCREDITAPPROVED(String UNBLOCKCREDITAPPROVED) {
      this.UNBLOCKCREDITAPPROVED = UNBLOCKCREDITAPPROVED;
   }

   public String getUNBLOCKCREDITCHEREMARK() {
      return UNBLOCKCREDITCHEREMARK;
   }

   public void setUNBLOCKCREDITCHEREMARK(String UNBLOCKCREDITCHEREMARK) {
      this.UNBLOCKCREDITCHEREMARK = UNBLOCKCREDITCHEREMARK;
   }

   public String getLANG() {
      return LANG;
   }

   public void setLANG(String LANG) {
      this.LANG = LANG;
   }

   public String getBLOCKEDLOANAMOUNT() {
      return BLOCKEDLOANAMOUNT;
   }

   public void setBLOCKEDLOANAMOUNT(String BLOCKEDLOANAMOUNT) {
      this.BLOCKEDLOANAMOUNT = BLOCKEDLOANAMOUNT;
   }

   public String getPARTIAL_DORMANT() {
      return PARTIAL_DORMANT;
   }

   public void setPARTIAL_DORMANT(String PARTIAL_DORMANT) {
      this.PARTIAL_DORMANT = PARTIAL_DORMANT;
   }

   public String getPARTIAL_DORMANT_DAYS() {
      return PARTIAL_DORMANT_DAYS;
   }

   public void setPARTIAL_DORMANT_DAYS(String PARTIAL_DORMANT_DAYS) {
      this.PARTIAL_DORMANT_DAYS = PARTIAL_DORMANT_DAYS;
   }

   public String getAPPROVE_DORMANCY_RESET_BY() {
      return APPROVE_DORMANCY_RESET_BY;
   }

   public void setAPPROVE_DORMANCY_RESET_BY(String APPROVE_DORMANCY_RESET_BY) {
      this.APPROVE_DORMANCY_RESET_BY = APPROVE_DORMANCY_RESET_BY;
   }

   public String getAPPROVE_DORMANCY_RESET_REMARKS() {
      return APPROVE_DORMANCY_RESET_REMARKS;
   }

   public void setAPPROVE_DORMANCY_RESET_REMARKS(String APPROVE_DORMANCY_RESET_REMARKS) {
      this.APPROVE_DORMANCY_RESET_REMARKS = APPROVE_DORMANCY_RESET_REMARKS;
   }

   public String getDORMANCY_RESET_BY() {
      return DORMANCY_RESET_BY;
   }

   public void setDORMANCY_RESET_BY(String DORMANCY_RESET_BY) {
      this.DORMANCY_RESET_BY = DORMANCY_RESET_BY;
   }

   public String getDORMANCY_RESET_REMARKS() {
      return DORMANCY_RESET_REMARKS;
   }

   public void setDORMANCY_RESET_REMARKS(String DORMANCY_RESET_REMARKS) {
      this.DORMANCY_RESET_REMARKS = DORMANCY_RESET_REMARKS;
   }

   public String getAPPROVE_DORMANCY_RESET() {
      return APPROVE_DORMANCY_RESET;
   }

   public void setAPPROVE_DORMANCY_RESET(String APPROVE_DORMANCY_RESET) {
      this.APPROVE_DORMANCY_RESET = APPROVE_DORMANCY_RESET;
   }

   public String getFULL_REG_DATE() {
      return FULL_REG_DATE;
   }

   public void setFULL_REG_DATE(String FULL_REG_DATE) {
      this.FULL_REG_DATE = FULL_REG_DATE;
   }

   public String getLOAN_CASHCOVER() {
      return LOAN_CASHCOVER;
   }

   public void setLOAN_CASHCOVER(String LOAN_CASHCOVER) {
      this.LOAN_CASHCOVER = LOAN_CASHCOVER;
   }

   public String getSIM_SWAP() {
      return SIM_SWAP;
   }

   public void setSIM_SWAP(String SIM_SWAP) {
      this.SIM_SWAP = SIM_SWAP;
   }

   public String getAC_OPERATIONS_BY() {
      return AC_OPERATIONS_BY;
   }

   public void setAC_OPERATIONS_BY(String AC_OPERATIONS_BY) {
      this.AC_OPERATIONS_BY = AC_OPERATIONS_BY;
   }

   public String getAC_OPERATIONS_ON() {
      return AC_OPERATIONS_ON;
   }

   public void setAC_OPERATIONS_ON(String AC_OPERATIONS_ON) {
      this.AC_OPERATIONS_ON = AC_OPERATIONS_ON;
   }

   public String getAC_OPERATIONS() {
      return AC_OPERATIONS;
   }

   public void setAC_OPERATIONS(String AC_OPERATIONS) {
      this.AC_OPERATIONS = AC_OPERATIONS;
   }

   public String getSESSIONID() {
      return SESSIONID;
   }

   public void setSESSIONID(String SESSIONID) {
      this.SESSIONID = SESSIONID;
   }

   public String getREWORKED() {
      return REWORKED;
   }

   public void setREWORKED(String REWORKED) {
      this.REWORKED = REWORKED;
   }

   public String getREWORKEDBY() {
      return REWORKEDBY;
   }

   public void setREWORKEDBY(String REWORKEDBY) {
      this.REWORKEDBY = REWORKEDBY;
   }

   public String getREWORKEDON() {
      return REWORKEDON;
   }

   public void setREWORKEDON(String REWORKEDON) {
      this.REWORKEDON = REWORKEDON;
   }

   public String getPROCESSED() {
      return PROCESSED;
   }

   public void setPROCESSED(String PROCESSED) {
      this.PROCESSED = PROCESSED;
   }

   public String getBUFFERVAL() {
      return BUFFERVAL;
   }

   public void setBUFFERVAL(String BUFFERVAL) {
      this.BUFFERVAL = BUFFERVAL;
   }

   public String getFREEZEBY() {
      return FREEZEBY;
   }

   public void setFREEZEBY(String FREEZEBY) {
      this.FREEZEBY = FREEZEBY;
   }

   public String getFREEZEON() {
      return FREEZEON;
   }

   public void setFREEZEON(String FREEZEON) {
      this.FREEZEON = FREEZEON;
   }

   public String getFREEZEAPPROVEBY() {
      return FREEZEAPPROVEBY;
   }

   public void setFREEZEAPPROVEBY(String FREEZEAPPROVEBY) {
      this.FREEZEAPPROVEBY = FREEZEAPPROVEBY;
   }

   public String getFREEZEAPPROVEON() {
      return FREEZEAPPROVEON;
   }

   public void setFREEZEAPPROVEON(String FREEZEAPPROVEON) {
      this.FREEZEAPPROVEON = FREEZEAPPROVEON;
   }

   public String getCLOSEBBY() {
      return CLOSEBBY;
   }

   public void setCLOSEBBY(String CLOSEBBY) {
      this.CLOSEBBY = CLOSEBBY;
   }

   public String getCLOSEON() {
      return CLOSEON;
   }

   public void setCLOSEON(String CLOSEON) {
      this.CLOSEON = CLOSEON;
   }

   public String getAPPROVECLOSEBY() {
      return APPROVECLOSEBY;
   }

   public void setAPPROVECLOSEBY(String APPROVECLOSEBY) {
      this.APPROVECLOSEBY = APPROVECLOSEBY;
   }

   public String getAPPROVECLOSEON() {
      return APPROVECLOSEON;
   }

   public void setAPPROVECLOSEON(String APPROVECLOSEON) {
      this.APPROVECLOSEON = APPROVECLOSEON;
   }

   public String getBLOCKEDAMOUNTON() {
      return BLOCKEDAMOUNTON;
   }

   public void setBLOCKEDAMOUNTON(String BLOCKEDAMOUNTON) {
      this.BLOCKEDAMOUNTON = BLOCKEDAMOUNTON;
   }

   public String getBLOCKEDAMOUNTBY() {
      return BLOCKEDAMOUNTBY;
   }

   public void setBLOCKEDAMOUNTBY(String BLOCKEDAMOUNTBY) {
      this.BLOCKEDAMOUNTBY = BLOCKEDAMOUNTBY;
   }

   public String getAPPROVEBLOCKEDAMOUNTON() {
      return APPROVEBLOCKEDAMOUNTON;
   }

   public void setAPPROVEBLOCKEDAMOUNTON(String APPROVEBLOCKEDAMOUNTON) {
      this.APPROVEBLOCKEDAMOUNTON = APPROVEBLOCKEDAMOUNTON;
   }

   public String getAPPROVEBLOCKEDAMOUNTBY() {
      return APPROVEBLOCKEDAMOUNTBY;
   }

   public void setAPPROVEBLOCKEDAMOUNTBY(String APPROVEBLOCKEDAMOUNTBY) {
      this.APPROVEBLOCKEDAMOUNTBY = APPROVEBLOCKEDAMOUNTBY;
   }

   public String getBLOCKEDBY() {
      return BLOCKEDBY;
   }

   public void setBLOCKEDBY(String BLOCKEDBY) {
      this.BLOCKEDBY = BLOCKEDBY;
   }

   public String getBLOCKEDON() {
      return BLOCKEDON;
   }

   public void setBLOCKEDON(String BLOCKEDON) {
      this.BLOCKEDON = BLOCKEDON;
   }

   public String getAPPROVEBLOCKBY() {
      return APPROVEBLOCKBY;
   }

   public void setAPPROVEBLOCKBY(String APPROVEBLOCKBY) {
      this.APPROVEBLOCKBY = APPROVEBLOCKBY;
   }

   public String getAPPROVEBLOCKON() {
      return APPROVEBLOCKON;
   }

   public void setAPPROVEBLOCKON(String APPROVEBLOCKON) {
      this.APPROVEBLOCKON = APPROVEBLOCKON;
   }

   public String getBLOCKEDAMOUNTBUFFER() {
      return BLOCKEDAMOUNTBUFFER;
   }

   public void setBLOCKEDAMOUNTBUFFER(String BLOCKEDAMOUNTBUFFER) {
      this.BLOCKEDAMOUNTBUFFER = BLOCKEDAMOUNTBUFFER;
   }

   public String getAMOUNTUNBLOCKEDBY() {
      return AMOUNTUNBLOCKEDBY;
   }

   public void setAMOUNTUNBLOCKEDBY(String AMOUNTUNBLOCKEDBY) {
      this.AMOUNTUNBLOCKEDBY = AMOUNTUNBLOCKEDBY;
   }

   public String getAMOUNTUNBLOCKEDON() {
      return AMOUNTUNBLOCKEDON;
   }

   public void setAMOUNTUNBLOCKEDON(String AMOUNTUNBLOCKEDON) {
      this.AMOUNTUNBLOCKEDON = AMOUNTUNBLOCKEDON;
   }

   public String getAMOUNTUNBLOCKEDAPPRBY() {
      return AMOUNTUNBLOCKEDAPPRBY;
   }

   public void setAMOUNTUNBLOCKEDAPPRBY(String AMOUNTUNBLOCKEDAPPRBY) {
      this.AMOUNTUNBLOCKEDAPPRBY = AMOUNTUNBLOCKEDAPPRBY;
   }

   public String getAMOUNTUNBLOCKEDAPPRON() {
      return AMOUNTUNBLOCKEDAPPRON;
   }

   public void setAMOUNTUNBLOCKEDAPPRON(String AMOUNTUNBLOCKEDAPPRON) {
      this.AMOUNTUNBLOCKEDAPPRON = AMOUNTUNBLOCKEDAPPRON;
   }

   public String getLINKEDACCOUNT() {
      return LINKEDACCOUNT;
   }

   public void setLINKEDACCOUNT(String LINKEDACCOUNT) {
      this.LINKEDACCOUNT = LINKEDACCOUNT;
   }

   public String getLINKEDBY() {
      return LINKEDBY;
   }

   public void setLINKEDBY(String LINKEDBY) {
      this.LINKEDBY = LINKEDBY;
   }

   public String getLINKREQUEST() {
      return LINKREQUEST;
   }

   public void setLINKREQUEST(String LINKREQUEST) {
      this.LINKREQUEST = LINKREQUEST;
   }

   public String getLINKACCNAME() {
      return LINKACCNAME;
   }

   public void setLINKACCNAME(String LINKACCNAME) {
      this.LINKACCNAME = LINKACCNAME;
   }

   public String getLASTCHARGEDATE() {
      return LASTCHARGEDATE;
   }

   public void setLASTCHARGEDATE(String LASTCHARGEDATE) {
      this.LASTCHARGEDATE = LASTCHARGEDATE;
   }

   public String getMONTHLYCHARGETRIALS() {
      return MONTHLYCHARGETRIALS;
   }

   public void setMONTHLYCHARGETRIALS(String MONTHLYCHARGETRIALS) {
      this.MONTHLYCHARGETRIALS = MONTHLYCHARGETRIALS;
   }

   public String getCDSACCOUNT() {
      return CDSACCOUNT;
   }

   public void setCDSACCOUNT(String CDSACCOUNT) {
      this.CDSACCOUNT = CDSACCOUNT;
   }

   public String getKYCVERIFIED() {
      return KYCVERIFIED;
   }

   public void setKYCVERIFIED(String KYCVERIFIED) {
      this.KYCVERIFIED = KYCVERIFIED;
   }

   public String getCHECKSUM() {
      return CHECKSUM;
   }

   public void setCHECKSUM(String CHECKSUM) {
      this.CHECKSUM = CHECKSUM;
   }

   public String getGROUP_ID() {
      return GROUP_ID;
   }

   public void setGROUP_ID(String GROUP_ID) {
      this.GROUP_ID = GROUP_ID;
   }
}
