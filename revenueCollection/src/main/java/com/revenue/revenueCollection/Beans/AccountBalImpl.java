package com.revenue.revenueCollection.Beans;

import com.revenue.revenueCollection.Dao.AccountDao;

import com.revenue.revenueCollection.Interfaces.AccountBal;
import com.revenue.revenueCollection.Models.Account;

import com.revenue.revenueCollection.Models.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class  AccountBalImpl implements AccountBal {
    @Autowired
    AccountDao accountDao ;
    @Override
    public ResponseMessage registerAccount(Account account) {
        try {
            System.out.print("customer "+ account);
            if (account !=null) {
                accountDao.save(account);
                return new ResponseMessage(200,"account Registered Successfully");
            }

            return new ResponseMessage(201,"Failed to Register Account");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public List<Account> viewAccountDetails() {
        return accountDao.findAll();
    }

    @Override
    public ResponseMessage updateAccount(Account account, int accountId) {
        try{
        if(accountId!=0) {
            System.out.println("&&&&&&&&" + accountId);
            Account account1 = accountDao.findById(accountId).orElseThrow(NullPointerException::new);


            account1.setAUTHORIZATIONSTATUS(account.getAUTHORIZATIONSTATUS());
            accountDao.save(account1);
            return new ResponseMessage(200,"account updated Successfully");

        }
        return new ResponseMessage(201,"account updated failed");

    }catch (Exception e){
        e.printStackTrace();
        return new ResponseMessage(202,"Exception Occurred");

    }
    }
}
