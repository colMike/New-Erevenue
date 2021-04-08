package com.revenue.revenueCollection.Models;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@TableGenerator(name = "Device_linking")
public class Device_linking {
    @Id
    @GeneratedValue
 public int id	;
    public String device_imei;
    public String device_mobile;
    @Transient
    public String userFullName;
    public int  userId	;
    public String  pin	;
    public String created_by;
    public String issuedBy;
    public Timestamp created_on	;;
public String approved_by;
public Timestamp approved_on	;
public int approved;
public int deleted	;
public String deleted_by;
public Timestamp deleted_on	;
public int declined	;
public String declined_by;
public Timestamp decline_don	;
public String remarks;
public String checker_remarks;
public int first_login	;

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public boolean isActive() {
        return active;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Timestamp declined_on	;

    public String agent_code	;
    public boolean  active	;
    public Timestamp block_time	;
    public String  block_remark;;


    public int logged_in	;
    public int trials	; 

    public Timestamp reworked_on	;
    public String reworked_by	;
    public String reworked	;
    public String session_id	;
    public String operator_msisdn	;
    public int  promoter_id	;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevice_imei() {
        return device_imei;
    }

    public void setDevice_imei(String device_imei) {
        this.device_imei = device_imei;
    }

    public String getDevice_mobile() {
        return device_mobile;
    }

    public void setDevice_mobile(String device_mobile) {
        this.device_mobile = device_mobile;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Timestamp getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Timestamp created_on) {
        this.created_on = created_on;
    }

    public String getApproved_by() {
        return approved_by;
    }

    public void setApproved_by(String approved_by) {
        this.approved_by = approved_by;
    }

    public Timestamp getApproved_on() {
        return approved_on;
    }

    public void setApproved_on(Timestamp approved_on) {
        this.approved_on = approved_on;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String getDeleted_by() {
        return deleted_by;
    }

    public void setDeleted_by(String deleted_by) {
        this.deleted_by = deleted_by;
    }

    public Timestamp getDeleted_on() {
        return deleted_on;
    }

    public void setDeleted_on(Timestamp deleted_on) {
        this.deleted_on = deleted_on;
    }

    public int getDeclined() {
        return declined;
    }

    public void setDeclined(int declined) {
        this.declined = declined;
    }

    public String getDeclined_by() {
        return declined_by;
    }

    public void setDeclined_by(String declined_by) {
        this.declined_by = declined_by;
    }

    public Timestamp getDecline_don() {
        return decline_don;
    }

    public void setDecline_don(Timestamp decline_don) {
        this.decline_don = decline_don;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getChecker_remarks() {
        return checker_remarks;
    }

    public void setChecker_remarks(String checker_remarks) {
        this.checker_remarks = checker_remarks;
    }

    public int getFirst_login() {
        return first_login;
    }

    public void setFirst_login(int first_login) {
        this.first_login = first_login;
    }

    public Timestamp getDeclined_on() {
        return declined_on;
    }

    public void setDeclined_on(Timestamp declined_on) {
        this.declined_on = declined_on;
    }

    public String getAgent_code() {
        return agent_code;
    }

    public void setAgent_code(String agent_code) {
        this.agent_code = agent_code;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getBlock_time() {
        return block_time;
    }

    public void setBlock_time(Timestamp block_time) {
        this.block_time = block_time;
    }

    public String getBlock_remark() {
        return block_remark;
    }

    public void setBlock_remark(String block_remark) {
        this.block_remark = block_remark;
    }

    public int getLogged_in() {
        return logged_in;
    }

    public void setLogged_in(int logged_in) {
        this.logged_in = logged_in;
    }

    public int getTrials() {
        return trials;
    }

    public void setTrials(int trials) {
        this.trials = trials;
    }

    public Timestamp getReworked_on() {
        return reworked_on;
    }

    public void setReworked_on(Timestamp reworked_on) {
        this.reworked_on = reworked_on;
    }

    public String getReworked_by() {
        return reworked_by;
    }

    public void setReworked_by(String reworked_by) {
        this.reworked_by = reworked_by;
    }

    public String getReworked() {
        return reworked;
    }

    public void setReworked(String reworked) {
        this.reworked = reworked;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getOperator_msisdn() {
        return operator_msisdn;
    }

    public void setOperator_msisdn(String operator_msisdn) {
        this.operator_msisdn = operator_msisdn;
    }

    public int getPromoter_id() {
        return promoter_id;
    }

    public void setPromoter_id(int promoter_id) {
        this.promoter_id = promoter_id;
    }
}
