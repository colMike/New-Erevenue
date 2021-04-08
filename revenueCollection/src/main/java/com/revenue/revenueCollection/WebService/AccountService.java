package com.revenue.revenueCollection.WebService;

import com.revenue.revenueCollection.Interfaces.AccountBal;

import com.revenue.revenueCollection.Models.Account;
import com.revenue.revenueCollection.Models.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping(value="/api/AccountService/")
public class AccountService {

    @Autowired
    private AccountBal accountBal;






    @GetMapping("/viewAccounts")
    public List<Account> getAllAccounts() {
        return accountBal.viewAccountDetails();
    }



    @PostMapping("/addAccounts")
    public Response addAccount(@Valid @RequestBody Account Account){

        ResponseMessage response = accountBal.registerAccount(Account);
        return Response.status(200).entity(response).build();
    }

    @PutMapping("/updateAccount/{Account_id}")
    public Response updateAccountDetails(@PathVariable(value = "Account_id") int AccountId,
                                       @Valid @RequestBody Account Account) {

        ResponseMessage response = accountBal.updateAccount(Account,AccountId);
        return Response.status(200).entity(response).build();
    }

}
