package com.revenue.revenueCollection.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@TableGenerator(name = "Agents")
public class Agent implements Serializable {
    @Id
    @GeneratedValue
    public int id;
    public int agent_id	;
    public String agent_names;
    public String location	;
    public String mobile	;
    public String device_number	;
    public String updateJson;
    public String createJson;
    public String creationStatus;


    public String approved	;
    public String sale_code	;
    public String branch	;
    public String business_name	;
    public String branch_code	;
    public String email	;
    public String id_number	;
    public String business_mobile	;
    public String rejected	;
    public String deleted	;
    public String remarks;


    public String first_name;
    public String second_name;
    public String last_name;
    public Timestamp maker_date	;
    public int maker	;
    public int checker	;
    public Timestamp checker_date	;

    public int 	deletedBy	;

    public String pin	;
    public int	reworked;
    public String reworked_by	;
    public String super_agent	;
    public String rework_remarks	;
    public int  reworked_on	;
    public int first_login	;
    public String postal_address;
    public String referees_contacts;

    public Timestamp deleted_on	;
    public String business_category	;
    public String checker_remarks;
    public String customer_no	;
    public String session_id;
    public String agent_type	;
    public int  active	;
    public String language	;
    public String channel;
    public int region	;
    public String recruited_by;
    public int group_id	;
    public int district	;
    public String ward	;
    public int promoter_id	;

    public String getCreationStatus() {
        return creationStatus;
    }

    public void setCreationStatus(String creationStatus) {
        this.creationStatus = creationStatus;
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

    public int getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(int deletedBy) {
        this.deletedBy = deletedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public String getAgent_names() {
        return agent_names;
    }

    public void setAgent_names(String agent_names) {
        this.agent_names = agent_names;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDevice_number() {
        return device_number;
    }

    public void setDevice_number(String device_number) {
        this.device_number = device_number;
    }



    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getSale_code() {
        return sale_code;
    }

    public void setSale_code(String sale_code) {
        this.sale_code = sale_code;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getBusiness_mobile() {
        return business_mobile;
    }

    public void setBusiness_mobile(String business_mobile) {
        this.business_mobile = business_mobile;
    }

    public String getRejected() {
        return rejected;
    }

    public void setRejected(String rejected) {
        this.rejected = rejected;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Timestamp getMaker_date() {
        return maker_date;
    }

    public void setMaker_date(Timestamp maker_date) {
        this.maker_date = maker_date;
    }

    public int getMaker() {
        return maker;
    }

    public void setMaker(int maker) {
        this.maker = maker;
    }

    public int getChecker() {
        return checker;
    }

    public void setChecker(int checker) {
        this.checker = checker;
    }

    public Timestamp getChecker_date() {
        return checker_date;
    }

    public void setChecker_date(Timestamp checker_date) {
        this.checker_date = checker_date;
    }




    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getReworked() {
        return reworked;
    }

    public void setReworked(int reworked) {
        this.reworked = reworked;
    }

    public String getReworked_by() {
        return reworked_by;
    }

    public void setReworked_by(String reworked_by) {
        this.reworked_by = reworked_by;
    }

    public String getSuper_agent() {
        return super_agent;
    }

    public void setSuper_agent(String super_agent) {
        this.super_agent = super_agent;
    }

    public String getRework_remarks() {
        return rework_remarks;
    }

    public void setRework_remarks(String rework_remarks) {
        this.rework_remarks = rework_remarks;
    }

    public int getReworked_on() {
        return reworked_on;
    }

    public void setReworked_on(int reworked_on) {
        this.reworked_on = reworked_on;
    }

    public int getFirst_login() {
        return first_login;
    }

    public void setFirst_login(int first_login) {
        this.first_login = first_login;
    }

    public String getPostal_address() {
        return postal_address;
    }

    public void setPostal_address(String postal_address) {
        this.postal_address = postal_address;
    }

    public String getReferees_contacts() {
        return referees_contacts;
    }

    public void setReferees_contacts(String referees_contacts) {
        this.referees_contacts = referees_contacts;
    }

    public Timestamp getDeleted_on() {
        return deleted_on;
    }

    public void setDeleted_on(Timestamp deleted_on) {
        this.deleted_on = deleted_on;
    }

    public String getBusiness_category() {
        return business_category;
    }

    public void setBusiness_category(String business_category) {
        this.business_category = business_category;
    }

    public String getChecker_remarks() {
        return checker_remarks;
    }

    public void setChecker_remarks(String checker_remarks) {
        this.checker_remarks = checker_remarks;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getAgent_type() {
        return agent_type;
    }

    public void setAgent_type(String agent_type) {
        this.agent_type = agent_type;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public String getRecruited_by() {
        return recruited_by;
    }

    public void setRecruited_by(String recruited_by) {
        this.recruited_by = recruited_by;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public int getPromoter_id() {
        return promoter_id;
    }

    public void setPromoter_id(int promoter_id) {
        this.promoter_id = promoter_id;
    }


}
