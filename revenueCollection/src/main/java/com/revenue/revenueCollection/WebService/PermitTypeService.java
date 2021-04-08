package com.revenue.revenueCollection.WebService;

import com.revenue.revenueCollection.Interfaces.PermitTypeBal;
import com.revenue.revenueCollection.Models.Permit;
import com.revenue.revenueCollection.Models.PermitType;
import com.revenue.revenueCollection.Models.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping(path="/api/PermitTypeService/")
public class PermitTypeService {
    @Autowired
    PermitTypeBal permitTypeBal;

    @GetMapping(path="/viewPermitType",produces = "application/json")
    public List<PermitType> getAllPermitType() {
        return permitTypeBal.GetAllPermitTypes();
        //return Response.status(200).entity(apps).build();

    }


    @PostMapping(path="/addPermitType",consumes = "application/json",produces = "application/json")
    public Response addPermit(@Valid @RequestBody PermitType permit){

        ResponseMessage response = permitTypeBal.addPermitType(permit);
        return Response.status(200).entity(response).build();
    }
}
