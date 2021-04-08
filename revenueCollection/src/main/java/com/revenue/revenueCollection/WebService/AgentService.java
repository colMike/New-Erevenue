package com.revenue.revenueCollection.WebService;

import com.revenue.revenueCollection.Interfaces.AgentBal;
import com.revenue.revenueCollection.Models.Agent;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.List;
@RestController
@RequestMapping(value="/api/agentService/")
public class AgentService {
    @Autowired
    private AgentBal agentBal;






    @GetMapping(path="/viewAgents" ,produces = "application/json")
    public List<Agent> getAllAgents() {
        return agentBal.viewAgentDetails();
    }


    @GetMapping(path="/viewAgentsToApprove",produces = "application/json")
    public List<Agent> getAgentToapprove() {
        return agentBal.getAgentToApprove();
        //return Response.status(200).entity(apps).build();

    }
    @GetMapping(path="/viewAgentsToApproveDelete",produces = "application/json")
    public List<Agent> getUsersToApproveDelete() {
        return agentBal.getAgentToApproveDelete();
        //return Response.status(200).entity(apps).build();

    }



    @PostMapping(path = "/addAgents",consumes = "application/json",produces = "application/json")
    public Response addAgent(@Valid @RequestBody Agent agent){

        ResponseMessage response = agentBal.registerAgent(agent);
        return Response.status(200).entity(response).build();
    }

    @PutMapping(path = "/updateAgent",consumes = "application/json",produces = "application/json")
       public Response updateAgentDetails(
                                                 @Valid @RequestBody Agent agent) {
        System.out.println(agent.id +"**********************");

        ResponseMessage response = agentBal.updateAgent(agent);
        return Response.status(200).entity(response).build();
    }

    @PutMapping(path="/approveAgent" ,consumes = "application/json",produces = "application/json")
    public Response approveAgent(@Valid @RequestBody Agent agent) {
        System.out.println(agent.id +"**********************");

        ResponseMessage response = agentBal.approveAgent(agent);
        return Response.status(200).entity(response).build();
    }
    @PutMapping(path="/deleteAgent" ,consumes = "application/json",produces = "application/json")
    public Response deleteAgent(@Valid @RequestBody Agent agent) {
        System.out.println(agent.id +"**********************");

        ResponseMessage response = agentBal.deleteAgent(agent);
        return Response.status(200).entity(response).build();
    }
    @PutMapping(path="/approveDeleteAgent" ,consumes = "application/json",produces = "application/json")
    public Response approveDeleteAgent(@Valid @RequestBody Agent agent) {
        System.out.println(agent.id +"**********************");

        ResponseMessage response = agentBal.approveDeleteAgent(agent);
        return Response.status(200).entity(response).build();
    }



}
