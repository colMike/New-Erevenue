package com.revenue.revenueCollection.WebService;

import java.util.HashSet;
import java.util.List;

import com.revenue.revenueCollection.Interfaces.rightMasterBal;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.RightMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api/rightMasterService/")
public class RIghtMasterService {
	
	@Autowired
	private rightMasterBal masterService;
	
	@GetMapping(value="/rightsmenulist",produces = "application/json")
	public ResponseEntity<?> getRights() {
		List<RightMaster> rights = masterService.getRights();
		
		if(rights.isEmpty()) {
			return new ResponseEntity<>(new ResponseMessage(
					404, "no rights found"),HttpStatus.OK);
			
			
		}
		return new ResponseEntity<>(new ResponseMessage(
				200,  "rights found"),HttpStatus.OK);
	}
}
