package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.DeviceReg;
import com.revenue.revenueCollection.Models.Device_linking;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.Users;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DeviceBal {
    ResponseMessage registerDevice_linking(Device_linking Device_linking);
    List<Device_linking> viewDevice_linkingDetails();
    ResponseMessage updateDevice_linking(Device_linking Device_linking,int deviceId);

    List<Users>  getPosUsers();

    List<DeviceReg>  getDevicesToIssue();
}
