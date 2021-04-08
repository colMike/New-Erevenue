package com.revenue.revenueCollection.Models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author faima
 *
 */

@Entity
@Table(name="rightsmaster")
public class RightMaster implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	
	 @Column(name="AllowView",columnDefinition="tinyint")
	 private boolean  allowView=false;
	 
	 @Column(name="AllowAdd",columnDefinition="tinyint")
     private boolean allowAdd=false;	
	 
	 @Column(name="AllowEdit",columnDefinition="tinyint")
	 private boolean allowEdit=false;	 
	 
	 @Column(name="AllowDelete",columnDefinition="tinyint")
	 private boolean allowDelete=false;	
	 
	 @Column(name="RightViewName")
     private String path;
	 
	 @ManyToOne
	 @JoinColumn(name = "RightHeaderID")
     private MenuHeaderMaster rightHeaderID;
	 
	 @Column(name="RightDisplayName")
     private String rightDisplayName;
	 
	 @Column(name="RightIconCss")	 
     private String icon;
	 
	 @Column(name="CreatedBy")
     private int createdBy;
	 
	 @Column(name="RightClass")
	 private String rightClass;
	 
	 @Column(name="ExtraLInk",columnDefinition="tinyint")
	 private boolean extralink=false;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "userassignedrights", joinColumns = @JoinColumn(name = "rightId"), inverseJoinColumns = @JoinColumn(name = "group_id"))
	private Set<UserGroup> groups;
	 
	 protected RightMaster() {
		 super();
	 }

	public RightMaster(boolean allowView, boolean allowAdd, boolean allowEdit, boolean allowDelete, String path,
			MenuHeaderMaster rightHeaderID, String rightDisplayName, String icon, int createdBy, String rightClass,
			boolean extralink) {
		super();
		this.allowView = allowView;
		this.allowAdd = allowAdd;
		this.allowEdit = allowEdit;
		this.allowDelete = allowDelete;
		this.path = path;
		this.rightHeaderID = rightHeaderID;
		this.rightDisplayName = rightDisplayName;
		this.icon = icon;
		this.createdBy = createdBy;
		this.rightClass = rightClass;
		this.extralink = extralink;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<UserGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<UserGroup> groups) {
		this.groups = groups;
	}

	public boolean isAllowView() {
		return allowView;
	}

	public void setAllowView(boolean allowView) {
		this.allowView = allowView;
	}

	public boolean isAllowAdd() {
		return allowAdd;
	}

	public void setAllowAdd(boolean allowAdd) {
		this.allowAdd = allowAdd;
	}

	public boolean isAllowEdit() {
		return allowEdit;
	}

	public void setAllowEdit(boolean allowEdit) {
		this.allowEdit = allowEdit;
	}

	public boolean isAllowDelete() {
		return allowDelete;
	}

	public void setAllowDelete(boolean allowDelete) {
		this.allowDelete = allowDelete;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@JsonIgnore
	public MenuHeaderMaster getRightHeaderID() {
		return rightHeaderID;
	}

	public void setRightHeaderID(MenuHeaderMaster rightHeaderID) {
		this.rightHeaderID = rightHeaderID;
	}

	public String getRightDisplayName() {
		return rightDisplayName;
	}

	public void setRightDisplayName(String rightDisplayName) {
		rightDisplayName = rightDisplayName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getRightClass() {
		return rightClass;
	}

	public void setRightClass(String rightClass) {
		this.rightClass = rightClass;
	}

	public boolean isExtralink() {
		return extralink;
	}

	public void setExtralink(boolean extralink) {
		this.extralink = extralink;
	}
	 
	 
}
