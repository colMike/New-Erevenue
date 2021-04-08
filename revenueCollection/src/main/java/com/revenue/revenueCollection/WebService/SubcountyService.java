package com.revenue.revenueCollection.WebService;

import com.revenue.revenueCollection.Interfaces.subCountyBal;
import com.revenue.revenueCollection.Interfaces.wardBal;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.SubCounty;
import com.revenue.revenueCollection.Models.Users;
import com.revenue.revenueCollection.Models.Ward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping(path="/api/SubcountyService/")
public class SubcountyService {

    @Autowired
    private subCountyBal subBal;
    @Autowired
    private wardBal wardb;
    @GetMapping(path="/viewWard",produces = "application/json")
    public List<Ward> getAllWard() {
        return wardb.GetAllWards();
        //return Response.status(200).entity(apps).build();

    }
    @GetMapping(path="/gtWardsBySubCounty/",produces = "application/json")

    public Response GetWardsBySubCounty(SubCounty subCounty) {
        System.out.println(subCounty.subCountyId+  "subCountyId");
        List<Ward> apps = wardb.GetWardsBySubCounty(subCounty);
        return Response.status(200).entity(apps).build();
    }//

    @PostMapping(path="/addWard",consumes = "application/json",produces = "application/json")
    public Response addWard(@Valid @RequestBody Ward ward){

        ResponseMessage response = wardb.UpdateWard(ward);
        return Response.status(200).entity(response).build();
    }

    @GetMapping(path="/viewSubCounty",produces = "application/json")
    public List<SubCounty> getAllSubCounty() {
        return subBal.GetAllSubCounties();
        //return Response.status(200).entity(apps).build();

    }

    @PostMapping(path="/addSubcounty",consumes = "application/json",produces = "application/json")
    public Response addSubCounty(@Valid @RequestBody SubCounty subCounty){

        ResponseMessage response = subBal.RegisterSubCounty(subCounty);
        return Response.status(200).entity(response).build();
    }
    @PutMapping(path="/updateSubcounty",consumes = "application/json",produces = "application/json")
    public Response updateSubcounty(@Valid @RequestBody SubCounty subCounty){

        ResponseMessage response = subBal.UpdateSubCounty(subCounty);
        return Response.status(200).entity(response).build();
    }
}
