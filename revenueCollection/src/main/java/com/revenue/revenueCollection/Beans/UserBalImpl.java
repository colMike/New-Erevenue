package com.revenue.revenueCollection.Beans;

import com.google.gson.Gson;
import com.revenue.revenueCollection.Dao.AgentDao;
import com.revenue.revenueCollection.Dao.AuditTrailDao;
import com.revenue.revenueCollection.Dao.UserDao;
import com.revenue.revenueCollection.Interfaces.UserBal;
import com.revenue.revenueCollection.Models.*;
import com.revenue.revenueCollection.Utility.AES;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ejb.Stateless;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Component
public class UserBalImpl implements UserBal {
    Gson gson = new Gson();
    @Autowired
    UserDao userDao;
    @Autowired
    AuditTrailDao auditTrailDao;




    @Override
    public ResponseMessage registerUser(Users users) {
        Audit_trail auditTrail = new Audit_trail();
        try {
            System.out.print("customer "+ users);
            if (users !=null) {
                users.setUserPwd(AES.encrypt(AES.randomPassword()));
                users.setApproved("N");
                users.setCreatedOn(new Timestamp(new Date().getTime()));
                auditTrail.setAction("Register User");
                auditTrail.setCreatedBy(users.getCreatedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));
                users.setUserFullName(users.getFirstname()+ " "+users.getSecondname()+ " "+users.getLastname());
                users.setUserName((users.getFirstname().concat(users.getLastname().substring(0,1))));
                System.out.println(users.getUserName() +"333333");
                String jsonString = gson.toJson(users);
                users.setCreateJson(jsonString);

                userDao.save(users);
                auditTrailDao.save(auditTrail);
                return new ResponseMessage(200,"User Registered Successfully");
            }

            return new ResponseMessage(201,"Failed to User");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public List<Users> viewUserDetails() {

        List<Users> users1= userDao.findAll();
          for(int i=0; i<users1.size();i++){
              System.out.println(users1.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
              if(users1.get(i).getApproved().equals("N")){
                  users1.get(i).setApproved("Pending Approval");
              }else {
                  users1.get(i).setApproved("Approved");
              }
          }

           return userDao.findAll();

    }

    @Override
    public ResponseMessage deleteUsers(Users users) {
        try {
            System.out.println("&&&&&&&&" + users);
            if (users.userId !=0) {
                Users users1 = userDao.findById(users.userId).orElseThrow(NullPointerException::new);
                users1.setDeleted(users.getDeleted());
                System.out.println(users.getDeletedBy());
                users1.setDeletedBy(users.getDeletedBy());
                users1.setRemarks(users.getRemarks());
                users1.setDeletedOn(new Timestamp(new Date().getTime()));

                Audit_trail auditTrail = new Audit_trail();

                auditTrail.setAction("Delete User");
                auditTrail.setCreatedBy(users.getDeletedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));
                auditTrail.setRemarks(users.getRemarks());
                auditTrailDao.save(auditTrail);
                userDao.save(users1);

                return new ResponseMessage(200,"User updated Successfully");

            }
            return new ResponseMessage(201,"user update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public ResponseMessage approveUsers(Users users) {
        try {
            System.out.println("&&&&&&&&" + users);
            if (users.userId !=0) {
                Users users1 = userDao.findById(users.userId).orElseThrow(NullPointerException::new);
                users1.setApproved(users.getApproved());
                System.out.println(users.getApprovedBy() +"stoooop");
                users1.setApprovedBy(users.getApprovedBy());
                users1.setApprovedOn(new Timestamp(new Date().getTime()));

                Audit_trail auditTrail = new Audit_trail();
               if(users.getApproved().equals('V')) {
                   auditTrail.setAction("Approve User");
               }else{
                   auditTrail.setAction("Reject2 User");
               }
                auditTrail.setCreatedBy(users1.getApprovedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

                auditTrailDao.save(auditTrail);
                userDao.save(users1);
                return new ResponseMessage(200,"User updated Successfully");

            }
            return new ResponseMessage(201,"user update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public ResponseMessage approveDeleteUsers(Users users) {
        try {
            System.out.println("&&&&&&&&" + users);
            if (users.userId !=0) {
                Users users1 = userDao.findById(users.userId).orElseThrow(NullPointerException::new);
                users1.setDeleted(users.getDeleted());

                Audit_trail auditTrail = new Audit_trail();

                auditTrail.setAction("Approve Delete User");
                auditTrail.setCreatedBy(users1.getDeletedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

                auditTrailDao.save(auditTrail);
                userDao.save(users1);
                return new ResponseMessage(200,"User updated Successfully");

            }
            return new ResponseMessage(201,"user update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }

    }

    @Override
    public List<Users> getUsersToApprove() {
        List<Users> users1= userDao.findUsersToApprove();
        for(int i=0; i<users1.size();i++){
            System.out.println(users1.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(users1.get(i).getApproved().equals("N")){
                users1.get(i).setApproved("Pending Approval");
            }else {
                users1.get(i).setApproved("Approved");
            }
        }
                return userDao.findUsersToApprove();
    }

    @Override
    public List<Users> getUsersToApproveDelete() {
        List<Users> users1= userDao.findUsersToApproveDelete();
        for(int i=0; i<users1.size();i++){
            System.out.println(users1.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(users1.get(i).getApproved().equals("N")){
                users1.get(i).setApproved("Pending Approval");
            }else {
                users1.get(i).setApproved("Approved");
            }
        }
        return userDao.findUsersToApproveDelete();
    }

    @Override
    public List<UserGroupType> getUserGroupType() {
        return userDao.findGroupType();
    }


    @Override
    public ResponseMessage updateUser(Users users) {
        try {
            System.out.println("&&&&&&&&" + users);
            if (users.userId !=0) {
                Users users1 = userDao.findById(users.userId).orElseThrow(NullPointerException::new);


                users1.setUserEmail(users.getUserEmail());
                users1.setFirstname(users.getFirstname());
                users1.setSecondname(users.getSecondname());
                users1.setAddress(users.getAddress());
                users1.setLastname(users.getLastname());
                users1.setActive(users.isActive());
                users1.setUserNationalId(users.getUserNationalId());
                users1.setUserPhone(users.getUserPhone());

                Audit_trail auditTrail = new Audit_trail();
                users1.setApproved("N");
                auditTrail.setAction("Update User");
                auditTrail.setCreatedBy(users1.getCreatedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));
                String jsonString = gson.toJson(users1);
                users1.setUpdateJson(jsonString);
                auditTrailDao.save(auditTrail);
                userDao.save(users1);
                return new ResponseMessage(200,"User updated Successfully");

            }
            return new ResponseMessage(201,"user update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }

    }
}
