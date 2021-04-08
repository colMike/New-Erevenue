package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.Audit_trail;
import com.revenue.revenueCollection.Models.ResponseMessage;

import javax.ejb.Local;
import java.util.List;
@Local
public interface AuditTrailBal {
    ResponseMessage registerAudit_trail(Audit_trail Audit_trail);
    List<Audit_trail> viewAudit_trailDetails();
    ResponseMessage updateAudit_trail(Audit_trail Audit_trail,int auditId);
}
