package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.*;

import javax.ejb.Local;
import java.util.List;

public interface CustomerBal {
    ResponseMessage registerCustomer(Customer customer);
    List<Customer> viewCustomerDetails();
    ResponseMessage updateCustomer(Customer customer);
    ResponseMessage deleteCustomer(Customer customer);
    ResponseMessage approveCustomer(Customer customer);
    ResponseMessage approveDeleteCustomer(Customer customer);

    List<Customer> getCustomerToApprove();
    List<Customer> getCustomerToApproveDelete();

}
