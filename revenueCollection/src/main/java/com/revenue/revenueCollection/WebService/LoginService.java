package com.revenue.revenueCollection.WebService;


import com.revenue.revenueCollection.Interfaces.UserBal;
import com.revenue.revenueCollection.Interfaces.loginBal;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.Users;
import com.revenue.revenueCollection.Utility.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping(path="/api/LoginService/")
public class LoginService {
    @Autowired
    private loginBal loginBal;

    @PostMapping(path="/authenticate",consumes = "application/json",produces = "application/json")
    public Response login(@Valid @RequestBody Users user){
         System.out.println(user.getUserName()+"$$$$$$$$$$$$$$$");
        System.out.println(user.getUserPwd()+"+++++++++++++++");
        System.out.println(user.getUserId()+"+++++++++blaaaaaaaaaaaaaa++++++");
        try {
            System.out.println("username####"+user.userName);


            LoginUser loginUser = loginBal.logIn(user.getUserName(),user.getUserPwd());
            System.out.println(loginUser.getUserId() +"@@@@@@@@@@@@@@@@@@@@@@@");
            loginUser.setUserId(loginUser.getUserId());

            return Response.status(loginUser.respCode).entity(loginUser).build();


        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(404).entity(null).build();
        }

       /* LoginUser responseMessage = new LoginUser();
                if(loginBal.logIn(user.getUserName(),user.getUserPwd()) !=null){
           // responseMessage.setStatus(true);
            responseMessage.setUserId(responseMessage.getUserId());

            responseMessage.setRespMessage("Success");
            responseMessage.setRespCode(200);

        }else{

                    //responseMessage.setStatus(false);
                    responseMessage.setRespMessage("fail");
                    responseMessage.setRespCode(201);


                }
        //return Response.status(200).entity(response).build();
        return responseMessage;*/
    }
}
