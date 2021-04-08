package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Utility.LoginUser;

import javax.ejb.Local;

@Local
public interface loginBal {
    public LoginUser logIn(String username, String pwd);
}
