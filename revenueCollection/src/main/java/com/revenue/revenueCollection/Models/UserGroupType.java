package com.revenue.revenueCollection.Models;

import javax.persistence.*;
import org.springframework.lang.Nullable;

import java.io.Serializable;

/**
 * 
 * @author faima
 *
 */

@Entity
public class UserGroupType implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;


	private String name;
	private int createdBy;
	
	protected UserGroupType() {
		super();
	}

	public UserGroupType(String name, int createdBy) {
		super();
		this.name = name;
		this.createdBy = createdBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
		
	
}
