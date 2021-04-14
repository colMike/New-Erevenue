package com.revenue.revenueCollection.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class DeviceReg {
  @Id @GeneratedValue public int id;

  public String device_imei;

  public int createdBy;
  public Timestamp createdOn;

  public String active;

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

  public String getActive() {
    return active;
  }

  public void setActive(String active) {
    this.active = active;
  }
}
