package com.revenue.revenueCollection.WebService;


import com.revenue.revenueCollection.Interfaces.UserBal;

import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.UserGroupType;
import com.revenue.revenueCollection.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@RestController
@RequestMapping(path="/api/UserService/")

public class UserService {
    @Autowired
    private UserBal userBal;


    @GetMapping(path="/viewUsers",produces = "application/json")
    public List<Users> getAllUsers() {
       return userBal.viewUserDetails();
        //return Response.status(200).entity(apps).build();

    }
    @GetMapping(path="/viewUsersGroupType",produces = "application/json")
    public List<UserGroupType> getAllUsersGroupType() {
        return userBal.getUserGroupType();
        //return Response.status(200).entity(apps).build();

    }
    @GetMapping(path="/viewUsersToApprove",produces = "application/json")
    public List<Users> getUsersToapprove() {
        return userBal.getUsersToApprove();
        //return Response.status(200).entity(apps).build();

    }
    @GetMapping(path="/viewUsersToApproveDelete",produces = "application/json")
    public List<Users> getUsersToApproveDelete() {
        return userBal.getUsersToApproveDelete();
        //return Response.status(200).entity(apps).build();

    }



    @PostMapping(path="/addUsers",consumes = "application/json",produces = "application/json")
    public Response addusers(@Valid @RequestBody Users user){

        ResponseMessage response = userBal.registerUser(user);
        return Response.status(200).entity(response).build();
    }

    @PutMapping(path="/updateUsers" ,consumes = "application/json",produces = "application/json")
    public Response updateusersDetails(@Valid @RequestBody Users users) {
        System.out.println(users.userId +"$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        ResponseMessage response = userBal.updateUser(users);
        System.out.println(users.userId +"$$$$$$$$$$$$");
        return Response.status(200).entity(response).build();
    }
    @PutMapping(path="/approveUser" ,consumes = "application/json",produces = "application/json")
    public Response approveUser(@Valid @RequestBody Users users) {
        System.out.println(users.userId +"$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        ResponseMessage response = userBal.approveUsers(users);
        System.out.println(users.userId +"$$$$$$$$$$$$");
        return Response.status(200).entity(response).build();
    }
    @PutMapping(path="/deleteUser" ,consumes = "application/json",produces = "application/json")
    public Response deleteUser(@Valid @RequestBody Users users) {
        System.out.println(users.userId +"$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        ResponseMessage response = userBal.deleteUsers(users);
        System.out.println(users.userId +"$$$$$$$$$$$$");
        return Response.status(200).entity(response).build();
    }
    @PutMapping(path="/approveDeleteUser" ,consumes = "application/json",produces = "application/json")
    public Response approveDeleteUser(@Valid @RequestBody Users users) {
        System.out.println(users.userId +"$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        ResponseMessage response = userBal.approveDeleteUsers(users);
        System.out.println(users.userId +"$$$$$$$$$$$$");
        return Response.status(200).entity(response).build();
    }
}
