package com.revenue.revenueCollection.Beans;

import com.revenue.revenueCollection.Dao.AuditTrailDao;
import com.revenue.revenueCollection.Dao.SubCountyDao;
import com.revenue.revenueCollection.Dao.wardDao;
import com.revenue.revenueCollection.Interfaces.wardBal;
import com.revenue.revenueCollection.Interfaces.wardBal;
import com.revenue.revenueCollection.Models.Audit_trail;
import com.revenue.revenueCollection.Models.ResponseMessage;

import com.revenue.revenueCollection.Models.SubCounty;
import com.revenue.revenueCollection.Models.Ward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Component
public class WardBalImpl implements wardBal {

    @Autowired
    wardDao wDao;
    @Autowired
    AuditTrailDao auditTrailDao;
    @Autowired
    SubCountyDao subCountyDao;
    @Override
    public ResponseMessage UpdateWard(Ward ward) {
        try {
            System.out.print("customer "+ ward);

            if (ward !=null) {


                ward.setCreatedOn(new Timestamp(new Date().getTime()));
                Audit_trail auditTrail = new Audit_trail();
                auditTrail.setAction("Register ward");
                auditTrail.setCreatedBy(ward.getCreatedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

               /* String jsonString = gson.toJson(ward);
                ward.setCreateJson(jsonString);*/
                auditTrailDao.save(auditTrail);
                wDao.save(ward);
                return new ResponseMessage(200,"ward Registered Successfully");
            }

            return new ResponseMessage(201,"Failed to Register ward");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public List<Ward> GetAllWards() {
        return wDao.findAll();
    }

    @Override
    public List<SubCounty> GetActiveSubCounties() {
        return subCountyDao.findAll();
    }

    @Override
    public List<Ward> GetWardsBySubCounty(SubCounty subCountyId) {
         return wDao.GetWardsBySubCounty(subCountyId);
    }
}
