package com.revenue.revenueCollection.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
@Entity
public class PermitType {
    @Id
    @GeneratedValue
    public int permitTypeId;
    public String permitTypeCode;
    public String permitTypeName;
    public String permitType;
    public double permitFee;
    public boolean active;
    public int createdBy;
    public Timestamp createdOn;

    public int getPermitTypeId() {
        return permitTypeId;
    }

    public void setPermitTypeId(int permitTypeId) {
        this.permitTypeId = permitTypeId;
    }

    public String getPermitTypeCode() {
        return permitTypeCode;
    }

    public void setPermitTypeCode(String permitTypeCode) {
        this.permitTypeCode = permitTypeCode;
    }

    public String getPermitTypeName() {
        return permitTypeName;
    }

    public void setPermitTypeName(String permitTypeName) {
        this.permitTypeName = permitTypeName;
    }

    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public double getPermitFee() {
        return permitFee;
    }

    public void setPermitFee(double permitFee) {
        this.permitFee = permitFee;
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

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }
}
