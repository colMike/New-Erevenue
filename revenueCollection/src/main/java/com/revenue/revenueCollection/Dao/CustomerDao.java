package com.revenue.revenueCollection.Dao;


import com.revenue.revenueCollection.GenericDao.GenericDao;
import com.revenue.revenueCollection.Models.Agent;
import com.revenue.revenueCollection.Models.Customer;
import com.revenue.revenueCollection.Models.Customer_validation;
import com.revenue.revenueCollection.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


public interface CustomerDao  extends JpaRepository<Customer,Integer> {


   
    @Query("select u from Customer u where u.approved='V' and (u.deleted='U'  or u.deleted IS NULL or u.deleted='')")
    List<Customer> findAll();
    @Query("select u from Customer u where u.approved='N'")
    List<Customer> findCustomersToApprove();
    @Query("select u from Customer u where u.deleted='D'")
    List<Customer> findCustomersToApproveDelete();



}
