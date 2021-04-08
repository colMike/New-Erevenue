package com.revenue.revenueCollection.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@TableGenerator(name = "Customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    public int id;
    public String customer_no;
    public String customername;
    public String phonenumber;
    public String email;

    public String deleted;
    public Timestamp approvedOn;
    public int approvedBy;
    public int createdBy;

    public String mwallet_ac1	;
    public String accounts	;
    public String account_name;
    public String identification_id	;
    public String linked_accounttype	;
    public String maker	;
    public String remarks;
    public String checker	;
    public String checker_remarks;
    public String link_date	;
    public String approved	;
    public String rejected	;
    public int deleted_by	;
    public Timestamp deleted_on	;
    public int delinked	;
    public int  	approve_linking	;
    public String account_to_delink	;
    public String cbs_customer_name;
    public String cbs_customer_number;
    public int group_id	;
    public String updateJson;
    public String createJson;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Timestamp getApprovedOn() {
        return approvedOn;
    }

    public void setApprovedOn(Timestamp approvedOn) {
        this.approvedOn = approvedOn;
    }

    public int getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(int approvedBy) {
        this.approvedBy = approvedBy;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getMwallet_ac1() {
        return mwallet_ac1;
    }

    public void setMwallet_ac1(String mwallet_ac1) {
        this.mwallet_ac1 = mwallet_ac1;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getIdentification_id() {
        return identification_id;
    }

    public void setIdentification_id(String identification_id) {
        this.identification_id = identification_id;
    }

    public String getLinked_accounttype() {
        return linked_accounttype;
    }

    public void setLinked_accounttype(String linked_accounttype) {
        this.linked_accounttype = linked_accounttype;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getChecker_remarks() {
        return checker_remarks;
    }

    public void setChecker_remarks(String checker_remarks) {
        this.checker_remarks = checker_remarks;
    }

    public String getLink_date() {
        return link_date;
    }

    public void setLink_date(String link_date) {
        this.link_date = link_date;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getRejected() {
        return rejected;
    }

    public void setRejected(String rejected) {
        this.rejected = rejected;
    }

    public int getDeleted_by() {
        return deleted_by;
    }

    public void setDeleted_by(int deleted_by) {
        this.deleted_by = deleted_by;
    }

    public Timestamp getDeleted_on() {
        return deleted_on;
    }

    public void setDeleted_on(Timestamp deleted_on) {
        this.deleted_on = deleted_on;
    }

    public int getDelinked() {
        return delinked;
    }

    public void setDelinked(int delinked) {
        this.delinked = delinked;
    }

    public int getApprove_linking() {
        return approve_linking;
    }

    public void setApprove_linking(int approve_linking) {
        this.approve_linking = approve_linking;
    }

    public String getAccount_to_delink() {
        return account_to_delink;
    }

    public void setAccount_to_delink(String account_to_delink) {
        this.account_to_delink = account_to_delink;
    }

    public String getCbs_customer_name() {
        return cbs_customer_name;
    }

    public void setCbs_customer_name(String cbs_customer_name) {
        this.cbs_customer_name = cbs_customer_name;
    }

    public String getCbs_customer_number() {
        return cbs_customer_number;
    }

    public void setCbs_customer_number(String cbs_customer_number) {
        this.cbs_customer_number = cbs_customer_number;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getUpdateJson() {
        return updateJson;
    }

    public void setUpdateJson(String updateJson) {
        this.updateJson = updateJson;
    }

    public String getCreateJson() {
        return createJson;
    }

    public void setCreateJson(String createJson) {
        this.createJson = createJson;
    }
}
