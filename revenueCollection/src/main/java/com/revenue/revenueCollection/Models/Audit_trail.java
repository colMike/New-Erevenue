package com.revenue.revenueCollection.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@TableGenerator(name = "Audit_trail")
public class Audit_trail {
    @Id
    @GeneratedValue
    @Column(name="audit_id")
     public int id;
     public  int entry_id;
    // public String user_id;
    public String action;
    public String model;
    public String model_id;
    public String field;
    public String old_value;
    public String new_value;
    public int createdBy;
    public Timestamp createdOn;
    public String remarks;

    @Transient
    private String createdName;



    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }


    public int getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(int entry_id) {
        this.entry_id = entry_id;
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel_id() {
        return model_id;
    }

    public void setModel_id(String model_id) {
        this.model_id = model_id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOld_value() {
        return old_value;
    }

    public void setOld_value(String old_value) {
        this.old_value = old_value;
    }

    public String getNew_value() {
        return new_value;
    }

    public void setNew_value(String new_value) {
        this.new_value = new_value;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int created) {
        this.createdBy = created;
    }
}
