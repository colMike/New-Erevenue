package com.revenue.revenueCollection.WebService;

import com.revenue.revenueCollection.Interfaces.PermitBal;
import com.revenue.revenueCollection.Interfaces.UserBal;
import com.revenue.revenueCollection.Models.Permit;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping(path="/api/PermitService/")
public class PermitService {
    @Autowired
    private PermitBal permitBal;
    @GetMapping(path="/viewPermit",produces = "application/json")
    public List<Permit> getAllPermits() {
        return permitBal.viewPermitDetails();
        //return Response.status(200).entity(apps).build();

    }
    @GetMapping(path="/viewPermitToApprove",produces = "application/json")
    public List<Permit> getAllPermitsToApprove() {
        return permitBal.getPermitToApprove();
        //return Response.status(200).entity(apps).build();

    }

    @GetMapping(path="/viewPermitToRenew",produces = "application/json")
    public List<Permit> getAllPermitsToRenew() {

        System.out.println("start>>>>>>>>>>>");
        return permitBal.getPermitToRenew();
        //return Response.status(200).entity(apps).build();

    }

    @PostMapping(path="/addPermit",consumes = "application/json",produces = "application/json")
    public Response addPermit(@Valid @RequestBody Permit permit){

        ResponseMessage response = permitBal.registerPermit(permit);
        return Response.status(200).entity(response).build();
    }
    @PostMapping(path="/renewPermit",consumes = "application/json",produces = "application/json")
    public Response renewPermit(@Valid @RequestBody Permit permit){

        ResponseMessage response = permitBal.renewPermit(permit);
        return Response.status(200).entity(response).build();
    }


    @PostMapping(path="/approvePermit",consumes = "application/json",produces = "application/json")
    public Response approvePermit(@Valid @RequestBody Permit permit){

        ResponseMessage response = permitBal.approvePermit(permit);
        return Response.status(200).entity(response).build();
    }
}
