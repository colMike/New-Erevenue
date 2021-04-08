package com.revenue.revenueCollection.Dao;


import com.revenue.revenueCollection.GenericDao.GenericDao;
import com.revenue.revenueCollection.Models.Agent;
import com.revenue.revenueCollection.Models.Customer;
import com.revenue.revenueCollection.Models.UserGroupType;
import com.revenue.revenueCollection.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


public interface UserDao extends JpaRepository<Users,Integer> {
     @Query("select u from Users u where u.userName=?1 and u.userPwd=?2  ")
    Users findByUsernameAndPassword(String username, String password);
    @Query("select u from Users u where u.approved='V' and (u.deleted='U'  or u.deleted IS NULL)")
    List<Users> findAll();
    @Query("select u from Users u where u.approved='N'")
    List<Users> findUsersToApprove();
    @Query("select u from Users u where u.deleted='D'")
    List<Users> findUsersToApproveDelete();
    @Query("select u from UserGroupType u ")
    List<UserGroupType> findGroupType();
}
