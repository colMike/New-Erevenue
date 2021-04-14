package com.revenue.revenueCollection.WebService;

import com.revenue.revenueCollection.Interfaces.DeviceBal;
import com.revenue.revenueCollection.Interfaces.DeviceRegBal;
import com.revenue.revenueCollection.Models.DeviceReg;
import com.revenue.revenueCollection.Models.Device_linking;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.Users;
import com.revenue.revenueCollection.Utility.GlobalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping(value = "/api/Device_linkingService/")
public class DeviceService {
  @Autowired private DeviceBal deviceBal;
  @Autowired private DeviceRegBal deviceRegBal;

  @GetMapping("/viewDevice_linking")
  public ResponseEntity<?> getAllCustomers() {

    List<Device_linking> deviceIssue = deviceBal.viewDevice_linkingDetails();

    if (deviceIssue.isEmpty()) {
      return new ResponseEntity<>(
          new GlobalResponse(
              GlobalResponse.APIV, "404", true, "NOT FOUND", new HashSet<>(deviceIssue)),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(
        new GlobalResponse(
            GlobalResponse.APIV, "000", true, "usergroups", new HashSet<>(deviceIssue)),
        HttpStatus.OK);
  }

  @PostMapping("/addDevice_linking")
  public Response addCustomer(@Valid @RequestBody Device_linking device) {

    ResponseMessage response = deviceBal.registerDevice_linking(device);
    return Response.status(200).entity(response).build();
  }

  @GetMapping("/viewDevice")
  public List<DeviceReg> getAllDevices() {
    return deviceRegBal.viewDevice();
  }

  @PostMapping("/addDevice")
  public Response addDevice(@Valid @RequestBody DeviceReg device) {

//    DeviceReg newDevice = deviceRegBal.getDeviceByDeviceImei(device.DeviceImei);

//    if (newDevice != null) return Response.status(204).entity(newDevice).build();

    ResponseMessage response = deviceRegBal.registerDevice(device);
    return Response.status(200).entity(response).build();
  }

  @GetMapping("/getPosUsers")
  public List<Users> getPosusers() {
    return deviceBal.getPosUsers();
  }

  @GetMapping("/getDevicesToIssue")
  public List<DeviceReg> getDeviceToIssue() {

    return deviceBal.getDevicesToIssue();
  }

  @PutMapping("/updateDevice_linking/{device_id}")
  public Response updateCustomerDetails(
      @PathVariable(value = "device_id") int device_id,
      @Valid @RequestBody Device_linking Device_linking) {

    ResponseMessage response = deviceBal.updateDevice_linking(Device_linking, device_id);
    return Response.status(200).entity(response).build();
  }
}
