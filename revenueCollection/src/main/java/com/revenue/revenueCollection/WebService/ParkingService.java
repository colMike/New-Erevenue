package com.revenue.revenueCollection.WebService;

import com.revenue.revenueCollection.Interfaces.ParkingBal;

import com.revenue.revenueCollection.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.List;
@RestController
@RequestMapping(path="/api/ParkingService/")
public class ParkingService {

    @Autowired
    private ParkingBal parkingBal;




    @GetMapping(path="/viewPriceConfig",produces = "application/json")
    public List<priceConfig> getAllPriceConfig() {
        return parkingBal.GetAllPriceConfig();
        //return Response.status(200).entity(apps).build();

    }
    @GetMapping(path="/viewCartype",produces = "application/json")
    public List<CarType> getAllCarType() {
        return parkingBal.GetAllCarTypes();
        //return Response.status(200).entity(apps).build();

    }
    @GetMapping(path="/viewParking",produces = "application/json")
    public List<Parking> getAllParking() {
        return parkingBal.GetAllParking();
        //return Response.status(200).entity(apps).build();

    }
    @GetMapping(path="/viewParkingToApprove",produces = "application/json")
    public List<priceConfig> getParkingToapprove() {
        return parkingBal.getParkingToApprove();
        //return Response.status(200).entity(apps).build();

    }
    @GetMapping(path="/viewParkingToApproveDelete",produces = "application/json")
    public List<priceConfig> getParkingToApproveDelete() {
        return parkingBal.getParkingToApproveDelete();
        //return Response.status(200).entity(apps).build();

    }
    @PostMapping(path="/addPriceConfig",consumes = "application/json",produces = "application/json")
    public Response addPriceConfig(@Valid @RequestBody priceConfig price){

        ResponseMessage response = parkingBal.RegisterPriceConfig(price);
        return Response.status(200).entity(response).build();
    }

    @PutMapping(path="/updatePriceConfig",consumes = "application/json",produces = "application/json")
    public Response updatePriceConfig(@Valid @RequestBody priceConfig price){

        ResponseMessage response = parkingBal.updatePriceConfig(price);
        return Response.status(200).entity(response).build();
    }
    @PostMapping(path="/addCarType",consumes = "application/json",produces = "application/json")
    public Response addCarType(@Valid @RequestBody CarType carType){

        ResponseMessage response = parkingBal.RegisterCarType(carType);
        return Response.status(200).entity(response).build();
    }
    @PutMapping(path="/updateCarType",consumes = "application/json",produces = "application/json")
    public Response updateCarType(@Valid @RequestBody CarType carType){

        ResponseMessage response = parkingBal.updateCarType(carType);
        return Response.status(200).entity(response).build();
    }


    @PostMapping(path="/addParking",consumes = "application/json",produces = "application/json")
    public Response addParking(@Valid @RequestBody Parking parking){

        ResponseMessage response = parkingBal.RegisterParking(parking);
        return Response.status(200).entity(response).build();
    }

    @PutMapping(path="/updateParking" ,consumes = "application/json",produces = "application/json")
    public Response updateParkingDetails(@Valid @RequestBody Parking parking) {
        System.out.println(parking.serviceId +"$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        ResponseMessage response = parkingBal.updateParking(parking);
        System.out.println(parking.serviceId +"$$$$$$$$$$$$");
        return Response.status(200).entity(response).build();
    }
    @PutMapping(path="/approveparking" ,consumes = "application/json",produces = "application/json")
    public Response approveparking(@Valid @RequestBody priceConfig Parking) {
        System.out.println(Parking.serviceId +"$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        ResponseMessage response = parkingBal.approveParking(Parking);
        System.out.println(Parking.serviceId +"$$$$$$$$$$$$");
        return Response.status(200).entity(response).build();
    }
    @PutMapping(path="/deleteparking" ,consumes = "application/json",produces = "application/json")
    public Response deleteparking(@Valid @RequestBody priceConfig Parking) {
        System.out.println(Parking.serviceId +"$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        ResponseMessage response = parkingBal.deleteParking(Parking);
        System.out.println(Parking.serviceId +"$$$$$$$$$$$$");
        return Response.status(200).entity(response).build();
    }
    @PutMapping(path="/approveDeleteparking" ,consumes = "application/json",produces = "application/json")
    public Response approveDeleteparking(@Valid @RequestBody priceConfig Parking) {
        System.out.println(Parking.serviceId +"$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        ResponseMessage response = parkingBal.approveDeleteParking(Parking);
        System.out.println(Parking.serviceId +"$$$$$$$$$$$$");
        return Response.status(200).entity(response).build();
    }
}
