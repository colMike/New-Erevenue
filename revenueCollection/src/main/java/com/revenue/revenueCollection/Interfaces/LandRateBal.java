package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.LandRate;
import com.revenue.revenueCollection.Models.ResponseMessage;

import javax.ejb.Local;
import java.util.List;

@Local
public interface LandRateBal {
    ResponseMessage registerLandRate(LandRate LandRate);
    List<LandRate> viewLandRateDetails();

    ResponseMessage deleteLandRate(LandRate LandRate);
    ResponseMessage approveLandRate(LandRate LandRate);
    ResponseMessage approveDeleteLandRate(LandRate LandRate);

    List<LandRate> getLandRateToApprove();
    List<LandRate> getLandRateToApproveDelete();

    ResponseMessage updateLandRate(LandRate LandRate);
    ResponseMessage renewLand(LandRate LandRate);

    List<LandRate> viewLandRateDetailsToRenew();
}
