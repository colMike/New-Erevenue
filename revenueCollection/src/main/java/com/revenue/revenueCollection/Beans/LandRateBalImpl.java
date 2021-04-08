package com.revenue.revenueCollection.Beans;

import com.google.gson.Gson;
import com.revenue.revenueCollection.Dao.AuditTrailDao;
import com.revenue.revenueCollection.Dao.LandRateDao;
import com.revenue.revenueCollection.Dao.PermitTypeDao;

import com.revenue.revenueCollection.Dao.UserDao;
import com.revenue.revenueCollection.Interfaces.LandRateBal;
import com.revenue.revenueCollection.Models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class LandRateBalImpl implements LandRateBal {
    Gson gson = new Gson();
    @Autowired
    LandRateDao landRateDao;
            @Autowired
    AuditTrailDao auditTrailDao;

            @Autowired
           PermitTypeDao permitTypeDao;
    @Autowired
    UserDao userDao;

    @Override
    public ResponseMessage registerLandRate(LandRate landRate) {
        Audit_trail auditTrail = new Audit_trail();
        try {


            System.out.println("customer " + landRate);







            PermitType permitType = permitTypeDao.findById(landRate.permitTypeId).orElseThrow(NullPointerException::new);

            landRate.setFee(permitType.getPermitFee());
            landRate.setAppliedOn(new Timestamp(new Date().getTime()));
            auditTrail.setAction("Apply  landRate");
           // auditTrail.setCreatedBy(Integer.parseInt(landRate.getCreatedBy()));
            auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));
            landRate.setApproved("N");

            if (landRate.mpesaCode!=null){
                landRate.setPaidStatus("paid");
                landRate.setPaidDate(new Timestamp(new Date().getTime()));
                landRate.setApproved("V");
            }
            String jsonString = gson.toJson(landRate);
            //landRate.setCreate_json(jsonString);

            landRateDao.save(landRate);
            auditTrailDao.save(auditTrail);
            return new ResponseMessage(200, "landRate Applied Successfully");




        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public List<LandRate> viewLandRateDetails() {
        List<LandRate> landRates= landRateDao.findAll();
        for(int i=0; i<landRates.size();i++){
            Users users = userDao.findById(landRates.get(i).getApprovedBy()).orElseThrow(NullPointerException::new);

            System.out.println(landRates.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(landRates.get(i).getApproved().equals("N")){
                landRates.get(i).setApproved("Pending Approval");
            }else {
                landRates.get(i).setApproved("Approved");
            }
            landRates.get(i).setPaidUser(users.getUserName());
        }
        return landRateDao.findAll();
    }

    @Override
    public ResponseMessage deleteLandRate(LandRate LandRate) {
        return null;
    }

    @Override
    public ResponseMessage approveLandRate(LandRate landRate) {
        try {
            System.out.println("&&&&&&&&" + landRate);
            if (landRate.id !=0) {
                LandRate permit1 = landRateDao.findById(landRate.id).orElseThrow(NullPointerException::new);
                permit1.setApproved(landRate.getApproved());
                System.out.println(landRate.getApprovedBy() +"stoooop");
                permit1.setApprovedBy(landRate.getApprovedBy());
                permit1.setApprovedOn(new Timestamp(new Date().getTime()));

                Audit_trail auditTrail = new Audit_trail();
                if(landRate.getApproved().equals('V')) {
                    auditTrail.setAction("Approve landRate");
                }else{
                    auditTrail.setAction("Reject2 landRate");
                }
                auditTrail.setCreatedBy(permit1.getApprovedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

                auditTrailDao.save(auditTrail);
                landRateDao.save(permit1);
                return new ResponseMessage(200,"landRate updated Successfully");

            }
            return new ResponseMessage(201,"permir update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public ResponseMessage approveDeleteLandRate(LandRate LandRate) {
        return null;
    }

    @Override
    public List<LandRate> getLandRateToApprove() {
        List<LandRate> landRates= landRateDao.getPermitToApprove();
        for(int i=0; i<landRates.size();i++){
            System.out.println(landRates.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(landRates.get(i).getApproved().equals("N")){
                landRates.get(i).setApproved("Pending Approval");
            }else {
                landRates.get(i).setApproved("Approved");
            }
        }
        return landRateDao.getPermitToApprove();
    }

    @Override
    public List<LandRate> getLandRateToApproveDelete() {
        return null;
    }

    @Override
    public ResponseMessage updateLandRate(LandRate LandRate) {
        return null;
    }

    @Override
    public List<LandRate> viewLandRateDetailsToRenew() {
        List<LandRate> landRates= landRateDao.findAll();
        for(int i=0; i<landRates.size();i++){
            Users users = userDao.findById(landRates.get(i).getApprovedBy()).orElseThrow(NullPointerException::new);

            System.out.println(landRates.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(landRates.get(i).getApproved().equals("N")){
                landRates.get(i).setApproved("Pending Approval");
            }else {
                landRates.get(i).setApproved("Approved");
            }
            landRates.get(i).setPaidUser(users.getUserName());
        }
        return landRateDao.findAllToRenew();
    }

    @Override
    public ResponseMessage renewLand(LandRate landRate) {
        try{


            LandRate landRate1 = landRateDao.findById(landRate.landId).orElseThrow(NullPointerException::new);
            landRate1.setStatus(landRate.getStatus());
            //landRate1.setAppType(permit.getAppType());
            landRate1.setValidity(landRate.getValidity());
            //landRate1.setExpiryDate(permit.getExpiryDate());
            landRateDao.save(landRate1);
            return new ResponseMessage(200,
                    "land Renewed Successfully");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(404,
                    "Exception Occurred");
        }
    }
}
