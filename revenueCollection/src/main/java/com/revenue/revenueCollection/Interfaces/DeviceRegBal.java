package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.DeviceReg;
import com.revenue.revenueCollection.Models.Device_linking;
import com.revenue.revenueCollection.Models.ResponseMessage;

import javax.ejb.Local;
import java.util.List;
@Local
public interface DeviceRegBal {
    ResponseMessage registerDevice(DeviceReg deviceReg);
    List<DeviceReg> viewDevice();
}
