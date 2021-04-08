package com.revenue.revenueCollection.Beans;

import java.util.List;

import com.revenue.revenueCollection.Dao.UserGroupTypeRepository;
import com.revenue.revenueCollection.Interfaces.userGroupTypeBal;
import com.revenue.revenueCollection.Models.UserGroupType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserGroupTypeBalImpl implements userGroupTypeBal {
  @Autowired
  private UserGroupTypeRepository groupTypeRepository;
  
  public List<UserGroupType> getGroupTypes() {
	  return groupTypeRepository.findAll();
  }
  
}
