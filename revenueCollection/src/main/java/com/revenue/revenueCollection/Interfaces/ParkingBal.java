package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.CarType;
import com.revenue.revenueCollection.Models.Parking;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.priceConfig;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ParkingBal {
    ResponseMessage RegisterParking(Parking service);
    ResponseMessage updateParking(Parking service);

    List<Parking> GetAllParking();

    List<priceConfig> getParkingToApprove();

    List<priceConfig> getParkingToApproveDelete();

    ResponseMessage approveParking(priceConfig parking);

    ResponseMessage deleteParking(priceConfig parking);

    ResponseMessage approveDeleteParking(priceConfig parking);
    List<priceConfig> GetAllPriceConfig();
    List<CarType> GetAllCarTypes();

    ResponseMessage RegisterPriceConfig(priceConfig priceConfig);
    ResponseMessage updatePriceConfig(priceConfig priceConfig);

    ResponseMessage RegisterCarType(CarType carType);
    ResponseMessage updateCarType(CarType carType);


}
