package com.revenue.revenueCollection.Models;

public interface UserGroupRights {
	  Long getRightId();
	  String getRightName();
	  boolean getAllowView();
	  boolean getAllowAdd();
	  boolean getAllowEdit();
	  boolean getAllowDelete();
}
