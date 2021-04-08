package com.revenue.revenueCollection.WebService;


import com.revenue.revenueCollection.Interfaces.AuditTrailBal;
import com.revenue.revenueCollection.Models.Audit_trail;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Utility.GlobalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping(value="/api/AuditTrailService/")
public class AuditTrailService {
    @Autowired
    private AuditTrailBal auditTrailBal;






    @GetMapping(path="/viewAudit_trails",produces = "application/json")
    public List<Audit_trail>  getAllAudit_trails() {

               return    auditTrailBal.viewAudit_trailDetails();



    }



    @PostMapping("/addAudit_trails")
    public Response addAudit_trail(@Valid @RequestBody Audit_trail Audit_trail){

        ResponseMessage response = auditTrailBal.registerAudit_trail(Audit_trail);
        return Response.status(200).entity(response).build();
    }

    @PutMapping("/updateAudit_trail/{Audit_trail_id}")
    public Response updateAudit_trailDetails(@PathVariable(value = "Audit_trail_id") int Audit_trailId,
                                         @Valid @RequestBody Audit_trail Audit_trail) {

        ResponseMessage response = auditTrailBal.updateAudit_trail(Audit_trail,Audit_trailId);
        return Response.status(200).entity(response).build();
    }
}
