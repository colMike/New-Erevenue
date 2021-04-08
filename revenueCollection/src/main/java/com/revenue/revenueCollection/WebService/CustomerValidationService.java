package com.revenue.revenueCollection.WebService;


import com.revenue.revenueCollection.Interfaces.CustomerValidationBal;
import com.revenue.revenueCollection.Models.Customer_validation;
import com.revenue.revenueCollection.Models.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping(value="/api/CustomerValidationService/")
public class CustomerValidationService {
    @Autowired
    private CustomerValidationBal customerValidationBal;






    @GetMapping("/viewCustomer_validations")
    public List<Customer_validation> getAllCustomer_validations() {
        return customerValidationBal.viewCustomer_validationDetails();
    }



    @PostMapping("/addCustomer_validations")
    public Response addCustomer_validation(@Valid @RequestBody Customer_validation Customer_validation){

        ResponseMessage response = customerValidationBal.registerCustomer_validation(Customer_validation);
        return Response.status(200).entity(response).build();
    }

    @PutMapping("/updateCustomer_validation/{Customer_validation_id}")
    public Response updateCustomer_validationDetails(@PathVariable(value = "Customer_validation_id") int Customer_validationId,
                                       @Valid @RequestBody Customer_validation Customer_validation) {

        ResponseMessage response = customerValidationBal.updateCustomer_validation(Customer_validation,Customer_validationId);
        return Response.status(200).entity(response).build();
    }

}
