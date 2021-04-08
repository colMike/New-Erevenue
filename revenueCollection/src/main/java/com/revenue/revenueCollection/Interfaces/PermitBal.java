package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.Permit;
import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.Permit;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PermitBal {
    ResponseMessage registerPermit(Permit permit);
    List<Permit> viewPermitDetails();

    ResponseMessage deletePermit(Permit permit);
    ResponseMessage approvePermit(Permit permit);
    ResponseMessage approveDeletePermit(Permit permit);

    List<Permit> getPermitToApprove();
    List<Permit> getPermitToApproveDelete();

    ResponseMessage updatePermit(Permit permit);

    ResponseMessage renewPermit(Permit permit);

    List<Permit> getPermitToRenew();
}
