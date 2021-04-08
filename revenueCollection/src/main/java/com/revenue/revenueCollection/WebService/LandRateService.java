package com.revenue.revenueCollection.WebService;

import com.revenue.revenueCollection.Interfaces.LandRateBal;

import com.revenue.revenueCollection.Models.LandRate;
import com.revenue.revenueCollection.Models.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping(path="/api/LandService/")
public class LandRateService {

    @Autowired
    private LandRateBal landRateBal;
    @GetMapping(path="/viewLand",produces = "application/json")
    public List<LandRate> getAllLands() {
        return landRateBal.viewLandRateDetails();
        //return Response.status(200).entity(apps).build();

    }
    @GetMapping(path="/viewLandToRenew",produces = "application/json")
    public List<LandRate> getAllLandsToRenew() {
        return landRateBal.viewLandRateDetailsToRenew();
        //return Response.status(200).entity(apps).build();

    }
    @GetMapping(path="/viewLandToApprove",produces = "application/json")
    public List<LandRate> getAllLandsToApprove() {
        return landRateBal.getLandRateToApprove();
        //return Response.status(200).entity(apps).build();

    }


    @PostMapping(path="/addLand",consumes = "application/json",produces = "application/json")
    public Response addLand(@Valid @RequestBody LandRate landRate){

        ResponseMessage response = landRateBal.registerLandRate(landRate);
        return Response.status(200).entity(response).build();
    }
    @PostMapping(path="/renewLand",consumes = "application/json",produces = "application/json")
    public Response renewLand(@Valid @RequestBody LandRate landRate){

        ResponseMessage response = landRateBal.renewLand(landRate);
        return Response.status(200).entity(response).build();
    }

    @PostMapping(path="/approveLand",consumes = "application/json",produces = "application/json")
    public Response approveLand(@Valid @RequestBody LandRate landRate){

        ResponseMessage response = landRateBal.approveLandRate(landRate);
        return Response.status(200).entity(response).build();
    }
}
