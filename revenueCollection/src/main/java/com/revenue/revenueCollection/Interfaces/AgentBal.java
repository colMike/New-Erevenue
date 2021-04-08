package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.Agent;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.Agent;

import javax.ejb.Local;
import java.util.List;
@Local
public interface AgentBal {
    ResponseMessage registerAgent(Agent agent);
    List<Agent> viewAgentDetails();
    ResponseMessage updateAgent(Agent agent);
    ResponseMessage deleteAgent(Agent agent);
    ResponseMessage approveAgent(Agent agent);
    ResponseMessage approveDeleteAgent(Agent agent);

    List<Agent> getAgentToApprove();
    List<Agent> getAgentToApproveDelete();


   // boolean deleteAgent(Agent agent, int agentId);
}
