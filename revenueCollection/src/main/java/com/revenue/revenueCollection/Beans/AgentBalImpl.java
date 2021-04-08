package com.revenue.revenueCollection.Beans;

import com.google.gson.Gson;
import com.revenue.revenueCollection.Dao.AgentDao;
import com.revenue.revenueCollection.Dao.AuditTrailDao;
import com.revenue.revenueCollection.Interfaces.AgentBal;
import com.revenue.revenueCollection.Models.Agent;
import com.revenue.revenueCollection.Models.Audit_trail;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class AgentBalImpl implements AgentBal {
    Gson gson = new Gson();
     @Autowired
    AgentDao agentDao;
    @Autowired
    AuditTrailDao auditTrailDao;



    @Override
    public ResponseMessage registerAgent(Agent agent) {
        try {
            System.out.print("customer "+ agent);

            if (agent !=null) {
                agent.setApproved("N");

                agent.setMaker_date(new Timestamp(new Date().getTime()));
                Audit_trail auditTrail = new Audit_trail();
                auditTrail.setAction("Register Agent");
                auditTrail.setCreatedBy(agent.getMaker());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

                String jsonString = gson.toJson(agent);
                agent.setCreateJson(jsonString);
                auditTrailDao.save(auditTrail);
                agentDao.save(agent);
                return new ResponseMessage(200,"Agent Registered Successfully");
            }

            return new ResponseMessage(201,"Failed to Agent Customer");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }

    }

    @Override
    public List<Agent> viewAgentDetails() {
        List<Agent> agents= agentDao.findAll();
        for(int i=0; i<agents.size();i++){
            System.out.println(agents.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(agents.get(i).getApproved().equals("N")){
                agents.get(i).setApproved("Pending Approval");
            }else {
                agents.get(i).setApproved("Approved");
            }
        }

        return agentDao.findAll();
    }

    @Override
    public ResponseMessage updateAgent(Agent agent) {
try {
    if(agent.id!=0) {
        System.out.println("&&&&&&&&" + agent.id);
        Agent agent1 = agentDao.findById(agent.id).orElseThrow(NullPointerException::new);
        agent1.setLocation(agent.getLocation());
        agent1.setWard(agent.getWard());
        agent1.setBusiness_category(agent.getBusiness_category());
        agent1.setReferees_contacts(agent.getReferees_contacts());
        agent1.setPostal_address(agent.getPostal_address());
        agent1.setLast_name(agent.getLast_name());
        agent1.setSecond_name(agent.getSecond_name());
        agent1.setFirst_name(agent.getFirst_name());
        agent1.setBusiness_mobile(agent.getBusiness_mobile());
        agent1.setId_number(agent.getId_number());
        agent1.setEmail(agent.getEmail());
        agent1.setBusiness_name(agent.getBusiness_name());
        agent1.setMobile(agent.getMobile());
        agent1.setBranch(agent.getBranch());
        agent1.setApproved("N");
        String jsonString = gson.toJson(agent1);
        agent1.setUpdateJson(jsonString);

        Audit_trail auditTrail = new Audit_trail();
        auditTrail.setAction("Update Agent Details");
        auditTrail.setCreatedBy(agent.getMaker());
        auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));


        auditTrailDao.save(auditTrail);


        agentDao.save(agent1);
        return new ResponseMessage(200,"Agent updated Successfully");

    }
    return new ResponseMessage(201,"Agent updated failed");

}catch (Exception e){
    e.printStackTrace();
    return new ResponseMessage(202,"Exception Occurred");

}


    }

    @Override
    public ResponseMessage deleteAgent(Agent agent) {
        try {
            Users users = new Users();
            if(agent.id!=0) {
                System.out.println("&&&&&&&&" + agent.id);
                Agent agent1 = agentDao.findById(agent.id).orElseThrow(NullPointerException::new);
                agent1.setDeleted(agent.getDeleted());
                agent1.setDeletedBy(agent.getDeletedBy());
                agent1.setRemarks(agent.getRemarks());
                agent.setDeleted_on(new java.sql.Timestamp(
                        new java.util.Date().getTime()));

                Audit_trail auditTrail = new Audit_trail();
                auditTrail.setAction("delete Agent Details");
                auditTrail.setCreatedBy(agent.getDeletedBy());
                auditTrail.setRemarks(agent.getRemarks());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));


                auditTrailDao.save(auditTrail);
                agentDao.save(agent1);
                return new ResponseMessage(200,"Agent updated Successfully");

            }
            return new ResponseMessage(201,"Agent updated failed");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public ResponseMessage approveAgent(Agent agent) {
        try {
            if(agent.id!=0) {
                Users user  = new Users();
                System.out.println("&&&&&&&&" + agent.id);
                Agent agent1 = agentDao.findById(agent.id).orElseThrow(NullPointerException::new);
                agent1.setApproved(agent.getApproved());
                agent1.setChecker(user.getUserId());
                agent1.setChecker_date(new Timestamp(new Date().getTime()));

                Audit_trail auditTrail = new Audit_trail();
                auditTrail.setAction("Approve Agent Details");
                auditTrail.setCreatedBy(user.getUserId());

                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));


                auditTrailDao.save(auditTrail);
                agentDao.save(agent1);
                return new ResponseMessage(200,"Agent updated Successfully");

            }
            return new ResponseMessage(201,"Agent updated failed");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public ResponseMessage approveDeleteAgent(Agent agent) {
        try {
            if(agent.id!=0) {
                System.out.println("&&&&&&&&" + agent.id);
                Agent agent1 = agentDao.findById(agent.id).orElseThrow(NullPointerException::new);
                agent1.setDeleted(agent.getDeleted());

                Audit_trail auditTrail = new Audit_trail();
                auditTrail.setAction("Approve delete Details");
                auditTrail.setCreatedBy(agent.getMaker());

                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));


                auditTrailDao.save(auditTrail);
                agentDao.save(agent1);
                return new ResponseMessage(200,"Agent updated Successfully");

            }
            return new ResponseMessage(201,"Agent updated failed");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public List<Agent> getAgentToApprove() {
        List<Agent> agents= agentDao.findAgentToApprove();
        for(int i=0; i<agents.size();i++){
            System.out.println(agents.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(agents.get(i).getApproved().equals("N")){
                agents.get(i).setApproved("Pending Approval");
            }else {
                agents.get(i).setApproved("Approved");
            }
        }

        return agentDao.findAgentToApprove();
    }

    @Override
    public List<Agent> getAgentToApproveDelete() {
        List<Agent> agents= agentDao.findAgentToApproveDelete();
        for(int i=0; i<agents.size();i++){
            System.out.println(agents.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(agents.get(i).getApproved().equals("N")){
                agents.get(i).setApproved("Pending Approval");
            }else {
                agents.get(i).setApproved("Approved");
            }
        }

        return agentDao.findAgentToApproveDelete();
    }


}
