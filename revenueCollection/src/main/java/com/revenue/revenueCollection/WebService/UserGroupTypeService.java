package com.revenue.revenueCollection.WebService;

import java.util.Collection;
import java.util.HashSet;

import com.revenue.revenueCollection.Interfaces.userGroupTypeBal;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.UserGroupType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path="/api/UserGroupTypeService/")
public class UserGroupTypeService {
   @Autowired
   private userGroupTypeBal groupTypeService;
   
   @GetMapping(path="/usergrouptypes",produces = "application/json")
   public ResponseEntity<?> getGroupType() {
	   Collection<UserGroupType> groupTypes = groupTypeService.getGroupTypes();
	   
	   if(groupTypes.isEmpty()) {
		   return new ResponseEntity<>(new ResponseMessage(404,
				   "failed to find user group types"),HttpStatus.NOT_FOUND);
	   }
	   
	   return new ResponseEntity<>(new ResponseMessage(200,
			   "found user group types"),HttpStatus.OK);
	   
   }
}
