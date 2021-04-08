package com.revenue.revenueCollection.Beans;

import com.google.gson.Gson;
import com.revenue.revenueCollection.Dao.AgentDao;
import com.revenue.revenueCollection.Dao.AuditTrailDao;
import com.revenue.revenueCollection.Dao.CustomerDao;
import com.revenue.revenueCollection.Interfaces.CustomerBal;
import com.revenue.revenueCollection.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Component
public class CustomerBalImpl implements CustomerBal {
    Gson gson = new Gson();
    @Autowired
    CustomerDao customerDao ;
    @Autowired
    AuditTrailDao auditTrailDao;


    @Override
    public ResponseMessage registerCustomer(Customer customer) {
        try {
            System.out.print("customer "+ customer.getId());
            if (customer.getId() ==0) {
                String jsonString = gson.toJson(customer);
                customer.setCreateJson(jsonString);
                customerDao.save(customer);
                return new ResponseMessage(200,"Customer Registered Successfully");
            }

            return new ResponseMessage(201,"Failed to Register Customer");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }


    }

    @Override
    public List<Customer> viewCustomerDetails() {
        List<Customer> customer1= customerDao.findAll();
        for(int i=0; i<customer1.size();i++){
            System.out.println(customer1.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(customer1.get(i).getApproved().equals("N")){
                customer1.get(i).setApproved("Pending Approval");
            }else {
                customer1.get(i).setApproved("Approved");
            }
        }

      return customerDao.findAll();
    }

    @Override
    public ResponseMessage updateCustomer(Customer customer) {
        try {
            if (customer.getId() != 0) {
                 System.out.println(customer.getId() +"customer.getID()");
                customerDao.findById(customer.getId()).orElseThrow(NullPointerException::new) ;
                System.out.println(customer.getCustomername());
                customer.setCustomername(customer.getCustomername());
                customer.setPhonenumber(customer.getPhonenumber());
                customer.setEmail(customer.getEmail());

                String jsonString = gson.toJson(customer);
                customer.setUpdateJson(jsonString);
                customerDao.save(customer);
                    customer.setApproved("N");
                customerDao.save(customer);
                Audit_trail auditTrail = new Audit_trail();
                auditTrail.setAction("Update Customer Details");
                auditTrail.setCreatedBy(customer.getCreatedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));
                auditTrailDao.save(auditTrail);
                return new ResponseMessage(200,"Customer updated Successfully");

            }

            return new ResponseMessage(201,"Customer update Failed");

        } catch (Exception e) {
             e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }


    }

    @Override
    public ResponseMessage deleteCustomer(Customer customer) {
        try {
            System.out.println("&&&&&&&&" + customer);
            if (customer.id !=0) {
               Customer customer1= customerDao.findById(customer.id).orElseThrow(NullPointerException::new) ;
                customer1.setDeleted(customer.getDeleted());
                System.out.println(customer.getDeleted_by() +"get deleted by");
                customer1.setDeleted_by(customer.getDeleted_by());
                customer1.setRemarks(customer.getRemarks());
                customer1.setDeleted_on(new Timestamp(new Date().getTime()));

                Audit_trail auditTrail = new Audit_trail();

                auditTrail.setAction("Delete Customer");
                auditTrail.setCreatedBy(customer1.getDeleted_by());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));
                auditTrail.setRemarks(customer1.getRemarks());
                auditTrailDao.save(auditTrail);
                customerDao.save(customer1);

                return new ResponseMessage(200,"User updated Successfully");

            }
            return new ResponseMessage(201,"user update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public ResponseMessage approveCustomer(Customer customer) {

        try {
            System.out.println("&&&&&&&&" + customer.id);
            if (customer.id !=0) {
                Customer customer1 = customerDao.findById(customer.id).orElseThrow(NullPointerException::new);
                customer1.setApproved(customer.getApproved());
                System.out.println(customer.getApprovedBy() +"stoooop");
                customer1.setApprovedBy(customer.getApprovedBy());
                customer1.setApprovedOn(new Timestamp(new Date().getTime()));

                Audit_trail auditTrail = new Audit_trail();
                if(customer.getApproved().equals('V')) {
                    auditTrail.setAction("Approve Customer");
                }else{
                    auditTrail.setAction("Reject Customer");
                }
                auditTrail.setCreatedBy(customer1.getApprovedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

                auditTrailDao.save(auditTrail);
                customerDao.save(customer1);
                return new ResponseMessage(200,"User updated Successfully");

            }
            return new ResponseMessage(201,"user update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public ResponseMessage approveDeleteCustomer(Customer customer) {
        try {
            System.out.println("&&&&&&&&" + customer);
            if (customer.id !=0) {
                Customer customer1 = customerDao.findById(customer.id).orElseThrow(NullPointerException::new);
                customer1.setDeleted(customer.getDeleted());

                Audit_trail auditTrail = new Audit_trail();

                auditTrail.setAction("Approve Delete Customer");
                auditTrail.setCreatedBy(customer1.getDeleted_by());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

                auditTrailDao.save(auditTrail);
                customerDao.save(customer1);
                return new ResponseMessage(200,"User updated Successfully");

            }
            return new ResponseMessage(201,"user update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }

    }

    @Override
    public List<Customer> getCustomerToApprove() {
        List<Customer> Customers1= customerDao.findCustomersToApprove();
        for(int i=0; i<Customers1.size();i++){
            System.out.println(Customers1.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(Customers1.get(i).getApproved().equals("N")){
                Customers1.get(i).setApproved("Pending Approval");
            }else {
                Customers1.get(i).setApproved("Approved");
            }
        }
        return customerDao.findCustomersToApprove();
    }

    @Override
    public List<Customer> getCustomerToApproveDelete()
    {
        List<Customer> Customers1= customerDao.findCustomersToApproveDelete();
        for(int i=0; i<Customers1.size();i++){
            System.out.println(Customers1.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(Customers1.get(i).getApproved().equals("N")){
                Customers1.get(i).setApproved("Pending Approval");
            }else {
                Customers1.get(i).setApproved("Approved");
            }
        }
        return customerDao.findCustomersToApproveDelete();
    }

}
