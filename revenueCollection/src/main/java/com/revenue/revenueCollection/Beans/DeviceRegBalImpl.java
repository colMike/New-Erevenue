package com.revenue.revenueCollection.Beans;

import com.revenue.revenueCollection.Dao.DeviceRegDao;
import com.revenue.revenueCollection.Interfaces.DeviceBal;
import com.revenue.revenueCollection.Interfaces.DeviceRegBal;
import com.revenue.revenueCollection.Models.DeviceReg;
import com.revenue.revenueCollection.Models.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class DeviceRegBalImpl implements DeviceRegBal {
    @Autowired
    DeviceRegDao deviceRegDao;
    @Override
    public ResponseMessage registerDevice(DeviceReg deviceReg) {
        try {
            System.out.print("customer "+ deviceReg);
            if (deviceReg !=null) {
                deviceReg.setCreatedOn(new Timestamp(new Date().getTime()));
                deviceRegDao.save(deviceReg);
                return new ResponseMessage(200,"device Registered Successfully");
            }

            return new ResponseMessage(201,"Failed ");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public List<DeviceReg> viewDevice() {
        return deviceRegDao.findAll();
    }
}
