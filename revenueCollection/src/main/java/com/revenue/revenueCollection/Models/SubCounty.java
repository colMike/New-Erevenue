/**
 * 
 */
package com.revenue.revenueCollection.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @author Faima
 *
 */
@Entity
public class SubCounty {
    @Id
    @GeneratedValue
	public int subCountyId;
	public String subCountyCode;
	public String subCountyName;
	public boolean active;
	public String status;
	public int createdBy;
	public int respCode;
	public int count;
	public String approved;
	public int approvedBy;
	public Timestamp approvedOn;
	public Timestamp createdOn;
	public double serviceValue;
	public String createJson;
	public String updateJson;

	public String getCreateJson() {
		return createJson;
	}

	public void setCreateJson(String createJson) {
		this.createJson = createJson;
	}

	public String getUpdateJson() {
		return updateJson;
	}

	public void setUpdateJson(String updateJson) {
		this.updateJson = updateJson;
	}

	public int getSubCountyId() {
		return subCountyId;
	}

	public void setSubCountyId(int subCountyId) {
		this.subCountyId = subCountyId;
	}

	public String getSubCountyCode() {
		return subCountyCode;
	}

	public void setSubCountyCode(String subCountyCode) {
		this.subCountyCode = subCountyCode;
	}

	public String getSubCountyName() {
		return subCountyName;
	}

	public void setSubCountyName(String subCountyName) {
		this.subCountyName = subCountyName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public double getServiceValue() {
		return serviceValue;
	}

	public void setServiceValue(double serviceValue) {
		this.serviceValue = serviceValue;
	}

	public SubCounty(int subCountyId, String subCountyCode,
					 String subCountyName, boolean active, int respCode,
					 int count, String status) {
		super();
		this.subCountyId = subCountyId;
		this.subCountyCode = subCountyCode;
		this.subCountyName = subCountyName;
		this.active = active;
		this.respCode = respCode;
		this.count = count;
		this.status=status;
	}
	public SubCounty() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubCounty(int subCountyId, String subCountyName) {
		super();
		this.subCountyId = subCountyId;
		this.subCountyName = subCountyName;
	}
}
