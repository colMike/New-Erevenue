package com.revenue.revenueCollection.WebService;

import com.revenue.revenueCollection.Interfaces.CustomerBal;

import com.revenue.revenueCollection.Models.*;
import com.revenue.revenueCollection.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping(value="/api/CustomerService/")
public class CustomerService {
    @Autowired
    private CustomerBal customerBal;






    @GetMapping(path="/viewCustomers",produces = "application/json")
    public List<Customer> getAllCustomers() {
        return customerBal.viewCustomerDetails();
    }


    @GetMapping(path="/viewCustomersToApprove",produces = "application/json")
    public List<Customer> getCustomerToapprove() {
        return customerBal.getCustomerToApprove();
        //return Response.status(200).entity(apps).build();

    }
    @GetMapping(path="/viewCustomersToApproveDelete",produces = "application/json")
    public List<Customer> getCustomersToApproveDelete() {
        return customerBal.getCustomerToApproveDelete();
        //return Response.status(200).entity(apps).build();

    }
    
    @PostMapping("/addCustomers")
    public Response addCustomer(@Valid @RequestBody Customer customer){

        ResponseMessage response = customerBal.registerCustomer(customer);
        return Response.status(200).entity(response).build();
    }

    @PutMapping(value = "/updateCustomer",consumes = "application/json",produces = "application/json")
    public Response updateCustomerDetails(
                                       @Valid @RequestBody Customer customer) {

        ResponseMessage response = customerBal.updateCustomer(customer);
        return Response.status(200).entity(response).build();
    }



    @PutMapping(path="/approveCustomer" ,consumes = "application/json",produces = "application/json")
    public Response approveCustomer(@Valid @RequestBody Customer customers) {
       
        ResponseMessage response = customerBal.approveCustomer(customers);

        return Response.status(200).entity(response).build();
    }
    @PutMapping(path="/deleteCustomer" ,consumes = "application/json",produces = "application/json")
    public Response deleteCustomer(@Valid @RequestBody Customer Customers) {
        ResponseMessage response = customerBal.deleteCustomer(Customers);
        return Response.status(200).entity(response).build();
    }
    @PutMapping(path="/approveDeleteCustomer" ,consumes = "application/json",produces = "application/json")
    public Response approveDeleteCustomer(@Valid @RequestBody Customer Customers) {
        ResponseMessage response = customerBal.approveDeleteCustomer(Customers);
        return Response.status(200).entity(response).build();
    }
}
