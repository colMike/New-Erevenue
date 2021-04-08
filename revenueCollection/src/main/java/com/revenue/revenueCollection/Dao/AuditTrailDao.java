package com.revenue.revenueCollection.Dao;


import com.revenue.revenueCollection.Models.Audit_trail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuditTrailDao extends JpaRepository<Audit_trail,Integer> {
    @Query(nativeQuery=true, value="select a.audit_id,a.entry_id, model,model_id,field,old_value,new_value, a.action,a.created_on,a.remarks,(select  ur.user_name from users ur where ur.user_id=a.created_by) as created_by from audit_trail a inner join users u on u.user_id=a.created_by")
    List<Audit_trail> findAll();
}
