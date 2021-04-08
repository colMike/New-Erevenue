package com.revenue.revenueCollection.Beans;


import com.revenue.revenueCollection.Dao.AuditTrailDao;
import com.revenue.revenueCollection.Interfaces.AuditTrailBal;
import com.revenue.revenueCollection.Models.Account;
import com.revenue.revenueCollection.Models.Audit_trail;
import com.revenue.revenueCollection.Models.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AuditTrailBalImpl implements AuditTrailBal {
    @Autowired
    AuditTrailDao auditTrailDao ;
    
    @Override
    public ResponseMessage registerAudit_trail(Audit_trail Audit_trail) {
        try {
            System.out.print("customer "+ Audit_trail);
            if (Audit_trail !=null) {
                auditTrailDao.save(Audit_trail);
                return new ResponseMessage(200,"Audit_trail Registered Successfully");
            }

            return new ResponseMessage(201,"Failed to Audit_trail Customer");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public List<Audit_trail> viewAudit_trailDetails() {
        return auditTrailDao.findAll();
    }

    @Override
    public ResponseMessage updateAudit_trail(Audit_trail audit_trail, int auditId) {
        try{
            if(auditId!=0) {
                System.out.println("&&&&&&&&" + auditId);
                Audit_trail audit1 = auditTrailDao.findById(auditId).orElseThrow(NullPointerException::new);


                audit1.setAction(audit_trail.getAction());
                auditTrailDao.save(audit1);
                return new ResponseMessage(200,"Audit updated Successfully");

            }
            return new ResponseMessage(201,"Audit updated failed");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }
    }

