package com.revenue.revenueCollection.Beans;

import com.google.gson.Gson;
import com.revenue.revenueCollection.Dao.*;
import com.revenue.revenueCollection.Interfaces.ParkingBal;
import com.revenue.revenueCollection.Models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Component
public class ParkingBalImpl implements ParkingBal {
    Gson gson = new Gson();
    @Autowired
    ParkingDao parkingDao;
    @Autowired
    AuditTrailDao auditTrailDao;
    @Autowired
    priceConfigDao priceDao;

    @Autowired
    carTypeDao carDao;
    @Override
    public ResponseMessage RegisterParking(Parking service) {
        try {
            System.out.print("customer "+ service);

            if (service !=null) {
                service.setApproved("N");

                service.setCreatedOn(new Timestamp(new Date().getTime()));
                Audit_trail auditTrail = new Audit_trail();
                auditTrail.setAction("Register service");
                auditTrail.setCreatedBy(service.getCreatedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

                String jsonString = gson.toJson(service);
                service.setCreateJson(jsonString);
                auditTrailDao.save(auditTrail);
                parkingDao.save(service);
                return new ResponseMessage(200,"service Registered Successfully");
            }

            return new ResponseMessage(201,"Failed to Register Service");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }

    }

    @Override
    public ResponseMessage updateParking(Parking service) {
        try {
            System.out.println("&&&&&&&&" + service);
            if (service.serviceId !=0) {
                Parking service1 = parkingDao.findById(service.serviceId).orElseThrow(NullPointerException::new);


                service1.setServiceCode(service.getServiceCode());
                service1.setServiceName(service.getServiceName());
   
                service1.setActive(service.isActive());
           
                Audit_trail auditTrail = new Audit_trail();
                service1.setApproved("N");
                auditTrail.setAction("Update Service");
                auditTrail.setCreatedBy(service1.getCreatedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));
                String jsonString = gson.toJson(service1);
                service1.setUpdatedJson(jsonString);
                auditTrailDao.save(auditTrail);
                parkingDao.save(service1);
                return new ResponseMessage(200,"Parking updated Successfully");

            }
            return new ResponseMessage(201,"Parking update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }

    }
    

    @Override
    public List<Parking> GetAllParking() {
        List<Parking> parking1= parkingDao.findAll();
        for(int i=0; i<parking1.size();i++){
            System.out.println(parking1.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(parking1.get(i).getApproved().equals("N")){
                parking1.get(i).setApproved("Pending Approval");
            }else {
                parking1.get(i).setApproved("Approved");
            }
        }

        return parkingDao.findAll();
    }

    @Override
    public List<priceConfig> getParkingToApprove() {
       return priceDao.findPriceToApprove();
    }

    @Override
    public List<priceConfig> getParkingToApproveDelete() {
        return priceDao.findPriceToApproveDelete();
    }

    @Override
    public ResponseMessage approveParking(priceConfig parking) {
        try {
            System.out.println("&&&&&&&&" + parking);
            if (parking.id !=0) {
                priceConfig parking1 = priceDao.findById(parking.id).orElseThrow(NullPointerException::new);
                parking1.setApproved(parking.getApproved());
                System.out.println(parking.getApprovedBy() +"stoooop");
                parking1.setApprovedBy(parking.getApprovedBy());
                parking1.setApprovedOn(new Timestamp(new Date().getTime()));

                Audit_trail auditTrail = new Audit_trail();
                if(parking.getApproved().equals('V')) {
                    auditTrail.setAction("Approve price config");
                }else{
                    auditTrail.setAction("Reject2 price config");
                }
                auditTrail.setCreatedBy(parking1.getApprovedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

                auditTrailDao.save(auditTrail);
                priceDao.save(parking1);
                return new ResponseMessage(200,"Price updated Successfully");

            }
            return new ResponseMessage(201,"Price update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public ResponseMessage deleteParking(priceConfig parking) {
        try {
            System.out.println("&&&&&&&&" + parking);
            if (parking.id !=0) {
                priceConfig parking1 = priceDao.findById(parking.id).orElseThrow(NullPointerException::new);
                parking1.setDeleted(parking.getDeleted());
                System.out.println(parking.getDeletedBy());
                parking1.setDeletedBy(parking.getDeletedBy());
                parking1.setRemarks(parking.getRemarks());
                parking1.setDeletedOn(new Timestamp(new Date().getTime()));

                Audit_trail auditTrail = new Audit_trail();

                auditTrail.setAction("Delete User");
                auditTrail.setCreatedBy(parking.getDeletedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));
                auditTrail.setRemarks(parking.getRemarks());
                auditTrailDao.save(auditTrail);
                priceDao.save(parking1);

                return new ResponseMessage(200,"User updated Successfully");

            }
            return new ResponseMessage(201,"user update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public ResponseMessage approveDeleteParking(priceConfig parking) {
        try {
            System.out.println("&&&&&&&&" + parking);
            if (parking.id !=0) {
                priceConfig parking1 = priceDao.findById(parking.id).orElseThrow(NullPointerException::new);
                parking1.setDeleted(parking.getDeleted());

                Audit_trail auditTrail = new Audit_trail();

                auditTrail.setAction("Approve Delete Price config");
                auditTrail.setCreatedBy(parking1.getDeletedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

                auditTrailDao.save(auditTrail);
                priceDao.save(parking1);
                return new ResponseMessage(200,"User updated Successfully");

            }
            return new ResponseMessage(201,"user update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public List<priceConfig> GetAllPriceConfig() {
        List<priceConfig> price1= priceDao.findAllPrices();
        priceConfig  parking= new priceConfig();
        parking.setServiceName(parking.getServiceName());
        parking.setSubcountyName(parking.getSubcountyName());
        parking.setCarTypeName(parking.getCarTypeName());
        parking.setApproved(parking.getApproved());


        for(int i=0; i<price1.size();i++){
            System.out.println(price1.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            System.out.println(price1.get(i).getServiceName()+"service NAme");
            if(price1.get(i).getApproved().equals("N")){
                price1.get(i).setApproved("Pending Approval");
            }else {
                price1.get(i).setApproved("Approved");
            }
        }
        price1.add(parking);
      return priceDao.findAllPrices();
    }

    @Override
    public List<CarType> GetAllCarTypes() {
        return carDao.findAll();
    }

    @Override
    public ResponseMessage RegisterPriceConfig(priceConfig priceConfig) {
        try {
            System.out.print("customer "+ priceConfig);

            if (priceConfig !=null) {
                priceConfig.setApproved("N");

                priceConfig.setCreatedOn(new Timestamp(new Date().getTime()));
                Audit_trail auditTrail = new Audit_trail();
                auditTrail.setAction("Add priceConfig");
                auditTrail.setCreatedBy(priceConfig.getCreatedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

                String jsonString = gson.toJson(priceConfig);
                priceConfig.setCreate_Json(jsonString);
                auditTrailDao.save(auditTrail);
                priceDao.save(priceConfig);
                return new ResponseMessage(200,"Price Configured Successfully");
            }

            return new ResponseMessage(201,"Failed to Configure");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }

    }

    @Override
    public ResponseMessage updatePriceConfig(priceConfig priceConfig) {
        try {
            System.out.println("&&&&&&&&" + priceConfig);
            if (priceConfig.id !=0) {
                priceConfig service1 = priceDao.findById(priceConfig.id).orElseThrow(NullPointerException::new);


                //service1.setCarType(service.getServiceCode());
                service1.setFee(priceConfig.getFee());
                service1.setActive(priceConfig.getActive());

                //service1.set(service.isActive());

                Audit_trail auditTrail = new Audit_trail();
                service1.setApproved("N");
                auditTrail.setAction("Update Service");
                auditTrail.setCreatedBy(service1.getCreatedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));
                String jsonString = gson.toJson(service1);
                service1.setUpdate_json(jsonString);
                auditTrailDao.save(auditTrail);
                priceDao.save(service1);
                return new ResponseMessage(200,"Price Config updated Successfully");

            }
            return new ResponseMessage(201,"Parking update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }

    }

    @Override
    public ResponseMessage RegisterCarType(CarType carType) {
        try {
            System.out.print("customer "+ carType);

            if (carType !=null) {
                carType.setApproved("N");

                carType.setCreatedOn(new Timestamp(new Date().getTime()));
                Audit_trail auditTrail = new Audit_trail();
                auditTrail.setAction("Add priceConfig");
                auditTrail.setCreatedBy(carType.getCreatedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

                String jsonString = gson.toJson(carType);
                carType.setCreate_Json(jsonString);
                auditTrailDao.save(auditTrail);
                carDao.save(carType);
                return new ResponseMessage(200,"Car type saved Successfully");
            }

            return new ResponseMessage(201,"Failed !!");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public ResponseMessage updateCarType(CarType carType) {
        try {
            System.out.println("&&&&&&&&" + carType);
            if (carType.carTypeId !=0) {
                CarType service1 = carDao.findById(carType.carTypeId).orElseThrow(NullPointerException::new);


                //service1.setCarType(service.getServiceCode());
                service1.setCarTypeName(carType.getCarTypeName());

                //service1.set(service.isActive());

                Audit_trail auditTrail = new Audit_trail();
                service1.setApproved("N");
                auditTrail.setAction("Update Service");
                auditTrail.setCreatedBy(service1.getCreatedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));
                String jsonString = gson.toJson(service1);
                service1.setUpdate_json(jsonString);
                auditTrailDao.save(auditTrail);
                carDao.save(service1);
                return new ResponseMessage(200,"Car Type updated Successfully");

            }
            return new ResponseMessage(201," Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }
}
