
package com.revenue.revenueCollection.Models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.revenue.revenueCollection.Models.RightMaster;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="usergroupsmaster")
public class UserGroup  implements  Serializable {
	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue
	public Long id;

	@Column(name="GroupCode")
	private String groupCode;
	@Column(name="GroupName")
	private String groupName;
	@Column(name="GroupTypeID")
	private int groupTypeID;
	@Column(name="Active")
	private boolean active;
	@Column(name="CreatedBy")
	private int createdBy;
	public String deleted;

	public String approved;
	public String approvedBy;
	public Timestamp approvedOn;
	public String deletedBy;
	public Timestamp deletedOn;
	public String remarks;

	@ManyToMany(mappedBy = "groups")
	@JsonBackReference
	private Set<RightMaster> roles;


	@OneToMany(fetch = FetchType.EAGER, mappedBy="GroupId", cascade = CascadeType.ALL, orphanRemoval = true )
	@JsonManagedReference
	private List<UserAssignedRights> rights;

	protected UserGroup() {
		super();
	}

	public UserGroup(String groupCode, String groupName, int groupTypeID, boolean active, int createdBy,
					 List<UserAssignedRights> rights) {
		super();
		this.groupCode = groupCode;
		this.groupName = groupName;
		this.groupTypeID = groupTypeID;
		this.active = active;
		this.createdBy = createdBy;
		this.rights = rights;
	}

	public Long
	getId() {
		return id;
	}

	public String getDeleted() {
		return deleted;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Timestamp getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(Timestamp approvedOn) {
		this.approvedOn = approvedOn;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Timestamp getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(Timestamp deletedOn) {
		this.deletedOn = deletedOn;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupTypeID() {
		return groupTypeID;
	}

	public void setGroupTypeID(int groupTypeID) {
		this.groupTypeID = groupTypeID;
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

	public List<UserAssignedRights> getRights() {
		return rights;
	}

	public void addRight(UserAssignedRights right) {
		right.setGroupId(this);
		rights.add(right);
	}

	public void removeRight(UserAssignedRights rights) {
		rights.setGroupId(null);
		this.rights.remove(rights);
	}

	public void removeAllRights() {
		rights.forEach(rights -> rights.setGroupId(null));
		this.rights.clear();
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setRoles(Set<RightMaster> roles) {
		this.roles = roles;
	}

	public void setRights(List<UserAssignedRights> rights) {
		this.rights = rights;
	}

	public Set<RightMaster> getRoles() {
		return roles;
	}




}
