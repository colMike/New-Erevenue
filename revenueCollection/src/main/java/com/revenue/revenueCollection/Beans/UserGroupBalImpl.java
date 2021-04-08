package com.revenue.revenueCollection.Beans;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.revenue.revenueCollection.Dao.AuditTrailDao;
import com.revenue.revenueCollection.Dao.UseGroupRepositories;
import com.revenue.revenueCollection.Interfaces.userGroupBal;
import com.revenue.revenueCollection.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.SqlConfig;

import javax.transaction.Transactional;


@Service
public class UserGroupBalImpl implements userGroupBal {

	@Autowired
	private UseGroupRepositories groupRepositories;
	@Autowired
	AuditTrailDao auditTrailDao;

	public List<UserGroup> userGroups() {
		return groupRepositories.findAll();
	}

	public List<UserGroup> getGroups() {
		return groupRepositories.getGroups();
	}

	public Optional<UserGroup> getUserGroup(Long id) {
		// TODO Auto-generated method stub

		return groupRepositories.findById(id);
	}

	public UserGroup addGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub

	/*	UserAssignedRights s2 = new UserAssignedRights();
		userGroup.addRight(s2);*/
		System.out.println(userGroup.getId() +"eeee");
		/*for (UserAssignedRights userAssignedRights: userGroup.getRights())
			userAssignedRights.setGroupId(userGroup);
		*/
		Long groupId=userGroup.getId();

if(userGroup.getId()!=0) {
	groupRepositories.deleteRights(userGroup);
}
       System.out.println(userGroup.getRights() +" user group rights");




		return groupRepositories.save(userGroup);
	}
	
	public List<UserGroupRights> getGroupRights(Long id, Long id2, Long id3) {
		// TODO Auto-generated method stub
		System.out.println(id +"####"+id2+"#######"+id3);
		return groupRepositories.getUserGroups(id,id2,id3);
	}

	public List<UserGroupRights> getUserGroupRights() {
		// TODO Auto-generated method stub
		return groupRepositories.getUserGroupRights();
	}

	@Override
	public List<UserGroup> getRolesToApprove() {
		List<UserGroup> users1= groupRepositories.findRolesToApprove();
		for(int i=0; i<users1.size();i++){
			System.out.println(users1.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
			if(users1.get(i).getApproved().equals("N")){
				users1.get(i).setApproved("Pending Approval");
			}else {
				users1.get(i).setApproved("Approved");
			}
		}
		return groupRepositories.findRolesToApprove();
	}

	@Override
	public List<UserGroup> getRolesToApproveDelete() {
		List<UserGroup> users1= groupRepositories.findRolesToApproveDelete();
		for(int i=0; i<users1.size();i++){
			System.out.println(users1.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
			if(users1.get(i).getApproved().equals("N")){
				users1.get(i).setApproved("Pending Approval");
			}else {
				users1.get(i).setApproved("Approved");
			}
		}
		return groupRepositories.findRolesToApproveDelete();
	}

	@Override
	public ResponseMessage approveRoles(UserGroup users) {
		try {
			System.out.println("&&&&&&&&" + users);
			if (users.id !=0) {
				UserGroup users1 = groupRepositories.findById(users.id).orElseThrow(NullPointerException::new);
				users1.setApproved(users.getApproved());
				System.out.println(users.getApprovedBy() +"stoooop");
				users1.setApprovedBy(users.getApprovedBy());
				users1.setApprovedOn(new Timestamp(new Date().getTime()));

				Audit_trail auditTrail = new Audit_trail();
				if(users.getApproved().equals('V')) {
					auditTrail.setAction("Approve Role");
				}else{
					auditTrail.setAction("Reject Role");
				}
				auditTrail.setCreatedBy(Integer.parseInt(users1.getApprovedBy()));
				auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

				auditTrailDao.save(auditTrail);
				groupRepositories.save(users1);
				return new ResponseMessage(200,"Role updated Successfully");

			}
			return new ResponseMessage(201,"Role update Failed");

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage(202,"Exception Occurred");

		}
	}

	@Override
	public ResponseMessage deleteRole(UserGroup users) {
		try {
			System.out.println("&&&&&&&&" + users);
			if (users.id !=0) {
				UserGroup users1 = groupRepositories.findById(users.id).orElseThrow(NullPointerException::new);
				users1.setDeleted(users.getDeleted());
				System.out.println(users.getDeletedBy());
				users1.setDeletedBy(users.getDeletedBy());
				users1.setRemarks(users.getRemarks());
				users1.setDeletedOn(new Timestamp(new Date().getTime()));

				Audit_trail auditTrail = new Audit_trail();

				auditTrail.setAction("Delete Role");
				auditTrail.setCreatedBy(Integer.parseInt(users.getDeletedBy()));
				auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));
				auditTrail.setRemarks(users.getRemarks());
				auditTrailDao.save(auditTrail);
				groupRepositories.save(users1);

				return new ResponseMessage(200,"Roles updated Successfully");

			}
			return new ResponseMessage(201,"Roles update Failed");

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage(202,"Exception Occurred");

		}
	}

	@Override
	public ResponseMessage approveDeleteRole(UserGroup users) {
		try {
			System.out.println("&&&&&&&&" + users);
			if (users.id !=0) {
				UserGroup users1 = groupRepositories.findById(users.id).orElseThrow(NullPointerException::new);
				users1.setDeleted(users.getDeleted());

				Audit_trail auditTrail = new Audit_trail();

				auditTrail.setAction("Approve Delete Role");
				auditTrail.setCreatedBy(Integer.parseInt(users1.getDeletedBy()));
				auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

				auditTrailDao.save(auditTrail);
				groupRepositories.save(users1);
				return new ResponseMessage(200,"Role updated Successfully");

			}
			return new ResponseMessage(201,"Role update Failed");

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage(202,"Exception Occurred");

		}
	}
}
