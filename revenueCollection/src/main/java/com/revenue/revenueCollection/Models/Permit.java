package com.revenue.revenueCollection.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Permit {
    @Id
    @GeneratedValue
    public int permitId;
    public int businessId;
    public String businessName;
    public int noOfEmployees;
    public int permitTypeId;
    public double permitFee;
    public String waterAccNo;
/*    public String create_json;
    public String update_json;*/
    public String approved;
    public String electricityAccNo;
    public int area;
    public String regNo;
    public String businessDesc;
    public String postalAdd;
    public String postalCode;
    public String email;
    public String fax;
    public String mobileNo;
    public String landLineNo;
    public int wardId;
    public String landZone;
    public String plotNo;
    public boolean active;
    public int createdBy;
    public int respCode;
    public int count;


    //Application Details
    public int appId;
    public String appNo;
    public String mpesaCode;
    public String businessNo;
    public String preSbp;
    public double fee;
    public boolean paid;
    public String vat;
    public Timestamp paidDate;
    public int appliedFor;
    public String appliedOn;
    public double penalty;
    public String appType;
    public String remarks;
    public String status;
    public String permitStatus;
    public String amountInWords;
    public int approvedBy;
    public Timestamp approvedOn;
    public int receiptBy;
    public String receiptOn;
    public String applicant;
    public String approvedUser;
    public String paidStatus;
    public String rejectReason;
    public int validity;
    public String expiryDate;
    public String permitNo;
    public String permitUser;
    public String permitQr;
    public String qr_image;
    public int paidBy;
    public String paidUser;
    public String nationalId;
    public int linkId;
    public Timestamp  createdOn;
    public String bankName;
    public String accNo;
    public String transNo;
    public String name;
    public int marketId;
    public int subcountyId;
    public String mktName;
    public String wardName;
    public String paymentMode;
    public String altMobileNo;
    public String building;
    public String  room;
    public String  applicantFax;
    public String  applicantMobile;
    public String  personalNumber;
    public String  personalAdd;
    public String  personalCode;
    public String PIN;

    public String getQr_image() {
        return qr_image;
    }

    public void setQr_image(String qr_image) {
        this.qr_image = qr_image;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String  otherActivity;

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getAltMobileNo() {
        return altMobileNo;
    }

    public void setAltMobileNo(String altMobileNo) {
        this.altMobileNo = altMobileNo;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getApplicantFax() {
        return applicantFax;
    }

    public void setApplicantFax(String applicantFax) {
        this.applicantFax = applicantFax;
    }

    public String getApplicantMobile() {
        return applicantMobile;
    }

    public void setApplicantMobile(String applicantMobile) {
        this.applicantMobile = applicantMobile;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getPersonalAdd() {
        return personalAdd;
    }

    public void setPersonalAdd(String personalAdd) {
        this.personalAdd = personalAdd;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getOtherActivity() {
        return otherActivity;
    }

    public void setOtherActivity(String otherActivity) {
        this.otherActivity = otherActivity;
    }

    /*  public String getCreate_json() {
        return create_json;
    }

    public void setCreate_json(String create_json) {
        this.create_json = create_json;
    }

    public String getUpdate_json() {
        return update_json;
    }

    public void setUpdate_json(String update_json) {
        this.update_json = update_json;
    }*/


    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public int getPermitId() {
        return permitId;
    }

    public void setPermitId(int permitId) {
        this.permitId = permitId;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setNoOfEmployees(int noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

    public int getPermitTypeId() {
        return permitTypeId;
    }

    public void setPermitTypeId(int permitTypeId) {
        this.permitTypeId = permitTypeId;
    }

    public double getPermitFee() {
        return permitFee;
    }

    public void setPermitFee(double permitFee) {
        this.permitFee = permitFee;
    }

    public String getWaterAccNo() {
        return waterAccNo;
    }

    public void setWaterAccNo(String waterAccNo) {
        this.waterAccNo = waterAccNo;
    }

    public String getElectricityAccNo() {
        return electricityAccNo;
    }

    public void setElectricityAccNo(String electricityAccNo) {
        this.electricityAccNo = electricityAccNo;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getBusinessDesc() {
        return businessDesc;
    }

    public void setBusinessDesc(String businessDesc) {
        this.businessDesc = businessDesc;
    }

    public String getPostalAdd() {
        return postalAdd;
    }

    public void setPostalAdd(String postalAdd) {
        this.postalAdd = postalAdd;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLandLineNo() {
        return landLineNo;
    }

    public void setLandLineNo(String landLineNo) {
        this.landLineNo = landLineNo;
    }

    public int getWardId() {
        return wardId;
    }

    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    public String getLandZone() {
        return landZone;
    }

    public void setLandZone(String landZone) {
        this.landZone = landZone;
    }

    public String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getMpesaCode() {
        return mpesaCode;
    }

    public void setMpesaCode(String mpesaCode) {
        this.mpesaCode = mpesaCode;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getPreSbp() {
        return preSbp;
    }

    public void setPreSbp(String preSbp) {
        this.preSbp = preSbp;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Timestamp getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Timestamp paidDate) {
        this.paidDate = paidDate;
    }

    public int getAppliedFor() {
        return appliedFor;
    }

    public void setAppliedFor(int appliedFor) {
        this.appliedFor = appliedFor;
    }

    public String getAppliedOn() {
        return appliedOn;
    }

    public void setAppliedOn(String appliedOn) {
        this.appliedOn = appliedOn;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPermitStatus() {
        return permitStatus;
    }

    public void setPermitStatus(String permitStatus) {
        this.permitStatus = permitStatus;
    }

    public String getAmountInWords() {
        return amountInWords;
    }

    public void setAmountInWords(String amountInWords) {
        this.amountInWords = amountInWords;
    }

    public int getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(int approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Timestamp getApprovedOn() {
        return approvedOn;
    }

    public void setApprovedOn(Timestamp approvedOn) {
        this.approvedOn = approvedOn;
    }

    public int getReceiptBy() {
        return receiptBy;
    }

    public void setReceiptBy(int receiptBy) {
        this.receiptBy = receiptBy;
    }

    public String getReceiptOn() {
        return receiptOn;
    }

    public void setReceiptOn(String receiptOn) {
        this.receiptOn = receiptOn;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApprovedUser() {
        return approvedUser;
    }

    public void setApprovedUser(String approvedUser) {
        this.approvedUser = approvedUser;
    }

    public String getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPermitNo() {
        return permitNo;
    }

    public void setPermitNo(String permitNo) {
        this.permitNo = permitNo;
    }

    public String getPermitUser() {
        return permitUser;
    }

    public void setPermitUser(String permitUser) {
        this.permitUser = permitUser;
    }

    public String getPermitQr() {
        return permitQr;
    }

    public void setPermitQr(String permitQr) {
        this.permitQr = permitQr;
    }

    public int getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(int paidBy) {
        this.paidBy = paidBy;
    }

    public String getPaidUser() {
        return paidUser;
    }

    public void setPaidUser(String paidUser) {
        this.paidUser = paidUser;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }

    public int getSubcountyId() {
        return subcountyId;
    }

    public void setSubcountyId(int subcountyId) {
        this.subcountyId = subcountyId;
    }

    public String getMktName() {
        return mktName;
    }

    public void setMktName(String mktName) {
        this.mktName = mktName;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
}
