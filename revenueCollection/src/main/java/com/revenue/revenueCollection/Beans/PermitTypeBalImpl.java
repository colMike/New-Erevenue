package com.revenue.revenueCollection.Beans;

import com.revenue.revenueCollection.Dao.AuditTrailDao;
import com.revenue.revenueCollection.Dao.PermitTypeDao;
import com.revenue.revenueCollection.Interfaces.PermitTypeBal;
import com.revenue.revenueCollection.Models.Audit_trail;
import com.revenue.revenueCollection.Models.PermitType;
import com.revenue.revenueCollection.Models.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class PermitTypeBalImpl implements PermitTypeBal {

    @Autowired
    PermitTypeDao permitTypeDao;
    @Autowired
    AuditTrailDao auditTrailDao;
    @Override
    public ResponseMessage addPermitType(PermitType permitType) {
        Audit_trail auditTrail = new Audit_trail();
        try {
            System.out.print("customer "+ permitType);
            if (permitType !=null) {

                permitType.setCreatedOn(new Timestamp(new Date().getTime()));
                auditTrail.setAction("Register Permit");
                auditTrail.setCreatedBy(permitType.getCreatedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));





                permitTypeDao.save(permitType);
                auditTrailDao.save(auditTrail);
                return new ResponseMessage(200,"Permit Type Applied Successfully");
            }

            return new ResponseMessage(201,"Failed ");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public List<PermitType> GetAllPermitTypes() {
        return permitTypeDao.findAll();
    }
}
