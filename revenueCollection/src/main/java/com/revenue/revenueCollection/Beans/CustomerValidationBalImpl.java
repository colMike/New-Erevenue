package com.revenue.revenueCollection.Beans;


import com.revenue.revenueCollection.Dao.CustomerValidationDao;
import com.revenue.revenueCollection.Interfaces.CustomerValidationBal;
import com.revenue.revenueCollection.Models.Agent;
import com.revenue.revenueCollection.Models.Customer_validation;
import com.revenue.revenueCollection.Models.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerValidationBalImpl implements CustomerValidationBal {
    @Autowired
    CustomerValidationDao customerValidationDao ;
    @Override
    public ResponseMessage registerCustomer_validation(Customer_validation customer_validation) {
        try {
            System.out.print("customer "+ customer_validation);
            if (customer_validation !=null) {
                customerValidationDao.save(customer_validation);
                return new ResponseMessage(200,"customer_validation Registered Successfully");
            }

            return new ResponseMessage(201,"Failed to customer_validation Customer");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public List<Customer_validation> viewCustomer_validationDetails() {
        return customerValidationDao.findAll();
    }

    @Override
    public ResponseMessage updateCustomer_validation(Customer_validation customer_validation, int custId) {
        try {
            if(custId!=0) {
                System.out.println("&&&&&&&&" + custId);
                Customer_validation customer_validation1 = customerValidationDao.findById(custId).orElseThrow(NullPointerException::new);


                customer_validation1.setCUSTOMERNAME(customer_validation.getCUSTOMERNAME());
                customerValidationDao.save(customer_validation1);
                return new ResponseMessage(200,"Customer updated Successfully");

            }
            return new ResponseMessage(201,"Customer updated failed");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }
}
