package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.Customer_validation;
import com.revenue.revenueCollection.Models.ResponseMessage;

import javax.ejb.Local;
import java.util.List;
@Local
public interface CustomerValidationBal {
    ResponseMessage registerCustomer_validation(Customer_validation Customer_validation);
    List<Customer_validation> viewCustomer_validationDetails();
    ResponseMessage updateCustomer_validation(Customer_validation Customer_validation,int custId);
}
