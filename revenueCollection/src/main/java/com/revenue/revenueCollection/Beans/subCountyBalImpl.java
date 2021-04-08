package com.revenue.revenueCollection.Beans;

import com.google.gson.Gson;
import com.revenue.revenueCollection.Dao.AuditTrailDao;
import com.revenue.revenueCollection.Dao.SubCountyDao;
import com.revenue.revenueCollection.Interfaces.subCountyBal;
import com.revenue.revenueCollection.Models.Audit_trail;
import com.revenue.revenueCollection.Models.Parking;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.SubCounty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class subCountyBalImpl implements subCountyBal {
    Gson gson = new Gson();
    @Autowired
    SubCountyDao subCountyDao;
    @Autowired
    AuditTrailDao auditTrailDao;


    @Override
    public ResponseMessage RegisterSubCounty(SubCounty subCounty) {
        try {
            System.out.print("customer "+ subCounty);

            if (subCounty !=null) {
                subCounty.setApproved("N");

                subCounty.setCreatedOn(new Timestamp(new Date().getTime()));
                Audit_trail auditTrail = new Audit_trail();
                auditTrail.setAction("Register subCounty");
                auditTrail.setCreatedBy(subCounty.getCreatedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

                String jsonString = gson.toJson(subCounty);
                subCounty.setCreateJson(jsonString);
                auditTrailDao.save(auditTrail);
                subCountyDao.save(subCounty);
                return new ResponseMessage(200,"subCounty Registered Successfully");
            }

            return new ResponseMessage(201,"Failed to Register subCounty");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public ResponseMessage UpdateSubCounty(SubCounty subCounty) {
        try {
            System.out.println("&&&&&&&&" + subCounty);
            if (subCounty.subCountyId !=0) {
                SubCounty subCounty1 = subCountyDao.findById(subCounty.subCountyId).orElseThrow(NullPointerException::new);



                subCounty1.setSubCountyName(subCounty.getSubCountyName());

                subCounty1.setActive(subCounty.isActive());

                Audit_trail auditTrail = new Audit_trail();
                subCounty1.setApproved("N");
                auditTrail.setAction("Update subCounty");
                auditTrail.setCreatedBy(subCounty1.getCreatedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));
                String jsonString = gson.toJson(subCounty1);
                subCounty1.setUpdateJson(jsonString);
                auditTrailDao.save(auditTrail);
                subCountyDao.save(subCounty1);
                return new ResponseMessage(200,"SubCounty updated Successfully");

            }
            return new ResponseMessage(201,"SubCounty update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }

    }

    @Override
    public List<SubCounty> GetAllSubCounties() {
        return subCountyDao.findAll();
    }
}
