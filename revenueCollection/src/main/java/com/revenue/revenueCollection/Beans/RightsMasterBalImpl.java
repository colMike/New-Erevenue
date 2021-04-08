package com.revenue.revenueCollection.Beans;

import java.util.List;

import com.revenue.revenueCollection.Dao.RightsMasterRepository;
import com.revenue.revenueCollection.Interfaces.rightMasterBal;
import com.revenue.revenueCollection.Models.RightMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class RightsMasterBalImpl implements rightMasterBal {

	 @Autowired
	 private RightsMasterRepository masterRepository;
	 
	 public List<RightMaster> getRights() {
		 return masterRepository.findAll();
	 }
 }
