package com.revenue.revenueCollection.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class LandRate {
    @Id
    @GeneratedValue
    public int id;
    public String plotNumber;
    public String mapSheetNumber;
    public String location;
    public String acreage;
    public String titleDeedNumber;
    public int permitTypeId;

    //owner details
    public String name;
    public String krapin;
    public String nationalIdNumber;
    public String createdBy;
    public String created_at;
    public int respCode;
    public int count;

    //land location details
    public int wardId;
    public int subCountyId;

    //details

    public int landId;
    public String landNo;
    public String approved;
    public int approvedBy;
    public Timestamp approvedOn;
    public String rejectReason;
    public String approvedUser;
    public String status;
    public String mpesaCode;
    public String paidStatus;
    public double fee;
    public double penalty;
    public int regId;
    public String regNo;
    public String applicant;
    public Timestamp appliedOn;
    public Timestamp paidDate;
    public int paidBy;
    public String paidUser;
    public int receiptBy;
    public int validity;
    public String permitUser;
    //public List<PermitYear> yearList;
    public int amendedBy;
    public int appliedFor;
    public int linkId;
    public String subCountyName;
    public String wardName;
    public String bankName;
    public String accNo;
    public String transNo;
    public String landType;
    public String permitNo;
    public String preLr;
    public String landTypeName;
    public String permitStatus;
    public double balance;
    public double amount;
    public String sublocation;
    public String address;
    public String phone;
    public String rates;
    public String arrears;
    public String total;
    public String titleNature;
    public String parcelNumber;
    public String blocknumber;
    public String code;

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }

    public String getMapSheetNumber() {
        return mapSheetNumber;
    }

    public void setMapSheetNumber(String mapSheetNumber) {
        this.mapSheetNumber = mapSheetNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getTitleDeedNumber() {
        return titleDeedNumber;
    }

    public void setTitleDeedNumber(String titleDeedNumber) {
        this.titleDeedNumber = titleDeedNumber;
    }

    public int getPermitTypeId() {
        return permitTypeId;
    }

    public void setPermitTypeId(int permitTypeId) {
        this.permitTypeId = permitTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKrapin() {
        return krapin;
    }

    public void setKrapin(String krapin) {
        this.krapin = krapin;
    }

    public String getNationalIdNumber() {
        return nationalIdNumber;
    }

    public void setNationalIdNumber(String nationalIdNumber) {
        this.nationalIdNumber = nationalIdNumber;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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

    public int getWardId() {
        return wardId;
    }

    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    public int getSubCountyId() {
        return subCountyId;
    }

    public void setSubCountyId(int subCountyId) {
        this.subCountyId = subCountyId;
    }

    public int getLandId() {
        return landId;
    }

    public void setLandId(int landId) {
        this.landId = landId;
    }

    public String getLandNo() {
        return landNo;
    }

    public void setLandNo(String landNo) {
        this.landNo = landNo;
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

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getApprovedUser() {
        return approvedUser;
    }

    public void setApprovedUser(String approvedUser) {
        this.approvedUser = approvedUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMpesaCode() {
        return mpesaCode;
    }

    public void setMpesaCode(String mpesaCode) {
        this.mpesaCode = mpesaCode;
    }

    public String getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Timestamp getAppliedOn() {
        return appliedOn;
    }

    public void setAppliedOn(Timestamp appliedOn) {
        this.appliedOn = appliedOn;
    }

    public Timestamp getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Timestamp paidDate) {
        this.paidDate = paidDate;
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

    public int getReceiptBy() {
        return receiptBy;
    }

    public void setReceiptBy(int receiptBy) {
        this.receiptBy = receiptBy;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public String getPermitUser() {
        return permitUser;
    }

    public void setPermitUser(String permitUser) {
        this.permitUser = permitUser;
    }

   /* public List<PermitYear> getYearList() {
        return yearList;
    }

    public void setYearList(List<PermitYear> yearList) {
        this.yearList = yearList;
    }*/

    public int getAmendedBy() {
        return amendedBy;
    }

    public void setAmendedBy(int amendedBy) {
        this.amendedBy = amendedBy;
    }

    public int getAppliedFor() {
        return appliedFor;
    }

    public void setAppliedFor(int appliedFor) {
        this.appliedFor = appliedFor;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public String getSubCountyName() {
        return subCountyName;
    }

    public void setSubCountyName(String subCountyName) {
        this.subCountyName = subCountyName;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
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

    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }

    public String getPermitNo() {
        return permitNo;
    }

    public void setPermitNo(String permitNo) {
        this.permitNo = permitNo;
    }

    public String getPreLr() {
        return preLr;
    }

    public void setPreLr(String preLr) {
        this.preLr = preLr;
    }

    public String getLandTypeName() {
        return landTypeName;
    }

    public void setLandTypeName(String landTypeName) {
        this.landTypeName = landTypeName;
    }

    public String getPermitStatus() {
        return permitStatus;
    }

    public void setPermitStatus(String permitStatus) {
        this.permitStatus = permitStatus;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSublocation() {
        return sublocation;
    }

    public void setSublocation(String sublocation) {
        this.sublocation = sublocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRates() {
        return rates;
    }

    public void setRates(String rates) {
        this.rates = rates;
    }

    public String getArrears() {
        return arrears;
    }

    public void setArrears(String arrears) {
        this.arrears = arrears;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTitleNature() {
        return titleNature;
    }

    public void setTitleNature(String titleNature) {
        this.titleNature = titleNature;
    }

    public String getParcelNumber() {
        return parcelNumber;
    }

    public void setParcelNumber(String parcelNumber) {
        this.parcelNumber = parcelNumber;
    }

    public String getBlocknumber() {
        return blocknumber;
    }

    public void setBlocknumber(String blocknumber) {
        this.blocknumber = blocknumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCreatedOn(Timestamp timestamp) {
    }
}
