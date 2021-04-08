package com.revenue.revenueCollection.Beans;


import com.revenue.revenueCollection.Dao.DeviceDao;
import com.revenue.revenueCollection.Dao.UserDao;
import com.revenue.revenueCollection.Interfaces.DeviceBal;
import com.revenue.revenueCollection.Models.DeviceReg;
import com.revenue.revenueCollection.Models.Device_linking;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class DeviceBalImpl implements DeviceBal {
    @Autowired
    DeviceDao deviceDao;
    @Autowired
    UserDao userDao;
    @Override
    public ResponseMessage registerDevice_linking(Device_linking device_linking) {
        try {
            System.out.print("customer "+ device_linking);
            if (device_linking !=null) {
                device_linking.setCreated_on(new Timestamp(new Date().getTime()));
                deviceDao.save(device_linking);
                return new ResponseMessage(200,"device_linking Registered Successfully");
            }

            return new ResponseMessage(201,"Failed to device_linking Customer");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public List<Device_linking> viewDevice_linkingDetails() {
        List<Device_linking> device1= deviceDao.findAll();

        for(int i=0; i<device1.size();i++){
            Optional<Users> users= userDao.findById(Integer.valueOf(device1.get(i).getUserId()));
            System.out.println(users.get().getUserFullName()+"&&&&&&&&&&&&&&&&&&");
            device1.get(i).setUserFullName(users.get().getUserFullName());
            System.out.println(device1.get(i).getActive()+"&&&&&&&&&&&&&&&&&&");
            System.out.println(device1.get(i).getUserFullName()+"&&&&&&&&&&&&&&&&&&");
            if(device1.get(i).getActive()){
                device1.get(i).setActive(Boolean.parseBoolean("Active"));
            }else {
                device1.get(i).setActive(Boolean.parseBoolean("Inactive"));
            }
        }

        return deviceDao.findAll();
    }

    @Override
    public ResponseMessage updateDevice_linking(Device_linking device_linking, int deviceId) {
        try {
            if(deviceId!=0) {
                System.out.println("&&&&&&&&" + deviceId);
                Device_linking device_linking1 = deviceDao.findById(deviceId).orElseThrow(NullPointerException::new);


                device_linking1.setPin(device_linking.getPin());
                deviceDao.save(device_linking1);
                return new ResponseMessage(200,"Device updated Successfully");

            }
            return new ResponseMessage(201,"Device updated failed");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public List<Users> getPosUsers() {
        return deviceDao.getPosUsers();
    }

    @Override
    public List<DeviceReg> getDevicesToIssue() {
        return deviceDao.getDevicesToIssue();
    }
}
