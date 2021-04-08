package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.Account;
import com.revenue.revenueCollection.Models.Agent;
import com.revenue.revenueCollection.Models.ResponseMessage;

import javax.ejb.Local;
import java.util.List;
@Local
public interface AccountBal {
    ResponseMessage registerAccount(Account account);
    List<Account> viewAccountDetails();
    ResponseMessage updateAccount(Account account,int agentId);
}
