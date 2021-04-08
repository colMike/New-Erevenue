package com.revenue.revenueCollection.WebService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


import com.revenue.revenueCollection.Interfaces.menuHeaderBal;
import com.revenue.revenueCollection.Models.MenuHeaderMaster;
import com.revenue.revenueCollection.Models.ResponseMessage;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api/menuService/")
public class MenuService {
	@Autowired
	private menuHeaderBal headerService;
	
	@GetMapping("/menulist")
	public ResponseEntity<?> getHeaderMenus() {
		Collection<MenuHeaderMaster> menus = headerService.getMenuHeaders();
		
		if(menus.isEmpty()) {
			return new ResponseEntity<>(new ResponseMessage(404,
					"no districts found"
					), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new ResponseMessage(200,
				 "menus found"
				),HttpStatus.OK);
	}
	
	@GetMapping(path = "/menulist/group",produces = "application/json")
	public ResponseEntity<?> getGroupMenus(
			@RequestParam(value="groupId") Long groupId) {

		List<MenuHeaderMaster> menus =headerService.getGroupMenus(groupId);
        System.out.println(menus.toString()+ "menu @@@@@@@@@@@@");
		
		if(menus.isEmpty()) {
			return new ResponseEntity<>(new ResponseMessage(404,
					"no rights found",  new HashSet<>(menus)), HttpStatus.OK);
		}

		return new ResponseEntity<>(new ResponseMessage(200,
				 "rights found",
				 new HashSet<>(menus)),HttpStatus.OK);
	}
}
