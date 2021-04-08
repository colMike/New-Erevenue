/**
 * 
 */
package com.revenue.revenueCollection.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @author FAIMA
 *
 */
@Entity
public class CarType {

	@Id
	@GeneratedValue
	public int carTypeId;
	public String carTypeName;
	public int count;
	public int respCode;
	public int createdBy;
	public Timestamp createdOn;
	public String approved;
	public int approvedBy;
	public Timestamp approvedOn;
	public String create_Json;
	public String update_json;

	public int getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(int carTypeId) {
		this.carTypeId = carTypeId;
	}

	public String getCarTypeName() {
		return carTypeName;
	}

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRespCode() {
		return respCode;
	}

	public void setRespCode(int respCode) {
		this.respCode = respCode;
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

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
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

	public String getCreate_Json() {
		return create_Json;
	}

	public void setCreate_Json(String create_Json) {
		this.create_Json = create_Json;
	}

	public String getUpdate_json() {
		return update_json;
	}

	public void setUpdate_json(String update_json) {
		this.update_json = update_json;
	}
}
