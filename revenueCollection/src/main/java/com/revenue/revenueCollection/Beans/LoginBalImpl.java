package com.revenue.revenueCollection.Beans;

import com.revenue.revenueCollection.Dao.AuditTrailDao;
import com.revenue.revenueCollection.Dao.UserDao;
import com.revenue.revenueCollection.Interfaces.loginBal;
import com.revenue.revenueCollection.Models.Audit_trail;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.Users;
import com.revenue.revenueCollection.Utility.AES;
import com.revenue.revenueCollection.Utility.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class LoginBalImpl implements loginBal {
    @Autowired
    UserDao userDao;
    @Autowired
    AuditTrailDao auditTrailDao;
    @Override
    public LoginUser logIn(String username, String pwd) {
        Users users = new Users();
        try {
            System.out.println(username +"username");
            System.out.println(pwd+"users.getUserPwd()");
            System.out.println(username+"users.getUserName()");
            if ((pwd !=null && !pwd.isEmpty()) && (username!=null && !username.isEmpty())) {
                Users user2 = userDao.findByUsernameAndPassword(username, AES.encrypt(pwd));
                System.out.println(AES.decrypt(user2.getUserPwd() )+ "@@@@@@@@@@@@@@@@@@@@@");
                System.out.println(user2.getUserName() + "@@@@@@@@@@@@@@@@@@@@@");
                System.out.println(user2.getUserId() + "getUserId2");
                System.out.println(pwd + "==============================");
                System.out.println(username + "==============================");

                if (pwd.equals(AES.decrypt(user2.getUserPwd())) && username.equals(user2.getUserName())) {
                    System.out.println(user2.getUserPwd() + "################");
                    user2.setUserId(user2.getUserId());
                    System.out.println(user2.getUserId() +"here 1");
                    Audit_trail auditTrail = new Audit_trail();
                    auditTrail.setAction(" User Login");
                    auditTrail.setCreatedBy(user2.getUserId());

                    auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));


                    auditTrailDao.save(auditTrail);
                    return new LoginUser(user2.getUserId(),user2.getGroupId(),user2.getUserName(), 200);
                } else {
                    //return new ResponseMessage(201, "Invalid Credentials");
                    return new LoginUser(201);
                }
            }
            //return new ResponseMessage(203, "Login Failure");
            return new LoginUser(202);
        } catch (Exception e) {
            e.printStackTrace();
            return new LoginUser(404);

        }
    }
}
