package com.revenue.revenueCollection.WebService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.revenue.revenueCollection.Beans.UserGroupBalImpl;
import com.revenue.revenueCollection.Interfaces.userGroupBal;
import com.revenue.revenueCollection.Models.*;
import com.revenue.revenueCollection.Utility.GlobalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.Response;


@RestController
@RequestMapping(path="/api/userGroupService/")
public class UserGroupService {
	
	@Autowired
	private userGroupBal userGroupService;
	
	/**
	 * user groups
	 * @return
	 */
	@GetMapping(path="/usergroups",produces = "application/json")
	public ResponseEntity<?> getUserGroups() {
		List<UserGroup> userGroups =userGroupService.userGroups();
		
		if(userGroups.isEmpty()) {
			return new ResponseEntity<>(new ResponseMessage(404,
					 "cannot find usergroups"),HttpStatus.NOT_FOUND );
		}
		
		return new ResponseEntity<>(new ResponseMessage(200,  "usergroups"),HttpStatus.OK);
	}
	@GetMapping(path="/getGroups",produces = "application/json")
	public ResponseEntity<?> getGroups() {
		List<UserGroup> userGroups =userGroupService.getGroups();

		if(userGroups.isEmpty()) {
			return new ResponseEntity<>(new ResponseMessage(404,
					"cannot find usergroups"),HttpStatus.NOT_FOUND );
		}

		return new ResponseEntity<>(new GlobalResponse(GlobalResponse.APIV,"000", true, "usergroups",
				new HashSet<>(userGroups)),HttpStatus.OK);	}
	
	/**
	 * user group
	 * @param id
	 * @return
	 */
	@GetMapping(path="/usergroups/usergroup",produces = "application/json")
	public ResponseEntity<?> userGroup(
			@RequestParam(value="id") Long id) {
		
		Optional<UserGroup> group = userGroupService.getUserGroup(id);
		
		if(group ==null) {
			return new ResponseEntity<>(new ResponseMessage(404,
					"group id"+ id+ "does not exist"),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ResponseMessage(
				200,"group"),HttpStatus.OK);
	}
	
	@PostMapping(path="/usergroups/assignrights",consumes = "application/json",produces = "application/json")
	public ResponseEntity<?> addUserGroup(
			@Validated @RequestBody UserGroup userGroup) {
		userGroup = userGroupService.addGroup(userGroup);

		 System.out.println(userGroup.getId() +"%%%%%%%%%%%%%%%%%%%%%%%%%");
		if(userGroup ==null) {
			return new ResponseEntity<>(new ResponseMessage(203,
					"failed to save user groups"),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ResponseMessage(201,  "Great Information saved Successfully"),HttpStatus.OK);
	}
	
	@GetMapping(path="/usergroups/gtUserGroups" ,produces = "application/json")
	public ResponseEntity<?> getUserGroup() {
		try {
		List<UserGroup> groups = userGroupService.userGroups();
		List<UserGroupExtra> rts = new ArrayList<UserGroupExtra>();
		if(groups.isEmpty()) {
			return new ResponseEntity<>(new ResponseMessage(404,
				"cannot find usergroups"),HttpStatus.NOT_FOUND );
		}
		for (UserGroup group: groups) {
			UserGroupExtra obj = new UserGroupExtra();
			obj.setId(group.getId());

			obj.setActive(group.isActive());
			obj.setCreatedBy(group.getCreatedBy());
			obj.setGroupCode(group.getGroupCode());
			obj.setGroupName(group.getGroupName());
			List<UserGroupRights> rights=userGroupService.getGroupRights(group.getId(),group.getId(),group.getId());

			obj.setRights(rights);


			rts.add(obj);
			for(int i=0;i<rights.size();i++){
				System.out.println(rights.get(i).getRightId() +"ere+++++++++++++++++++++++++++++++++");
				System.out.println(rights.get(i).getAllowAdd() +"######################");
			}
			System.out.println(rts +"ere+++++++++++++++++++++++++++++++++");
		}
			return new ResponseEntity<>(new GlobalResponse(GlobalResponse.APIV,"000", true, "usergroups",
					new HashSet<>(rts)),HttpStatus.OK);
		} catch (Exception e) {
			GlobalResponse resp = new GlobalResponse("404","error processing request",false,GlobalResponse.APIV);
			e.printStackTrace();
			return new ResponseEntity<>(resp, HttpStatus.OK);
		}
	}
	
	@GetMapping(path="/usergroups/gtRights", produces = "application/json")
	public ResponseEntity<?> getUserGroupRights() {
		try {
		List<UserGroupRights> userGroups =userGroupService.getUserGroupRights();
		
		if(userGroups.isEmpty()) {
			return new ResponseEntity<>(new GlobalResponse(GlobalResponse.APIV,"404",
					false, "cannot find usergroups",
					new HashSet<>(userGroups)),HttpStatus.NOT_FOUND );
		}

			return new ResponseEntity<>(new GlobalResponse(GlobalResponse.APIV,"000", true, "usergroups",
					new HashSet<>(userGroups)),HttpStatus.OK);
		} catch (Exception e) {
			GlobalResponse resp = new GlobalResponse("404","error processing request",false,GlobalResponse.APIV);
			e.printStackTrace();
			return new ResponseEntity<>(resp, HttpStatus.OK);
		}
	}

	@GetMapping(path="/viewRolesToApprove",produces = "application/json")
	public List<UserGroup> getRolesToapprove() {
		return userGroupService.getRolesToApprove();
		//return Response.status(200).entity(apps).build();

	}
	@GetMapping(path="/viewRolesToApproveDelete",produces = "application/json")
	public List<UserGroup> getRolesToApproveDelete() {
		return userGroupService.getRolesToApproveDelete();
		//return Response.status(200).entity(apps).build();

	}
	@PutMapping(path="/approveRoles" ,consumes = "application/json",produces = "application/json")
	public Response approveRoles(@Valid @RequestBody UserGroup userGroup) {
		
		ResponseMessage response = userGroupService.approveRoles(userGroup);

		return Response.status(200).entity(response).build();
	}
	@PutMapping(path="/deleteRoles" ,consumes = "application/json",produces = "application/json")
	public Response deleteRoles(@Valid @RequestBody UserGroup userGroup) {

		ResponseMessage response = userGroupService.deleteRole(userGroup);
		
		return Response.status(200).entity(response).build();
	}
	@PutMapping(path="/approveDeleteRoles" ,consumes = "application/json",produces = "application/json")
	public Response approveDeleteRoles(@Valid @RequestBody UserGroup users) {
		
		ResponseMessage response = userGroupService.approveDeleteRole(users);
		
		return Response.status(200).entity(response).build();
	}
	
}
