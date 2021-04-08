package com.revenue.revenueCollection.Dao;

import com.revenue.revenueCollection.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceDao extends JpaRepository<Device_linking,Integer> {
    @Query(nativeQuery =true, value = "select u.id\n" +
            ",u.active\n" +
            ",u.agent_code\n" +
            ",u.agent_id\n" +
            ",u.approved\n" +
            ",u.approved_by\n" +
            ",u.approved_on\n" +
            ",u.block_remark\n" +
            ",u.block_time\n" +
            ",u.checker_remarks\n" +
            ",u.created_by\n" +
            ",u.created_on\n" +
            ",u.decline_don\n" +
            ",u.declined\n" +
            ",u.declined_by\n" +
            ",u.declined_on\n" +
            ",u.deleted\n" +
            ",u.deleted_by\n" +
            ",u.deleted_on\n" +
            ",u.device_imei\n" +
            ",u.device_mobile\n" +
            ",u.first_login\n" +
            ",u.logged_in\n" +
            ",u.operator_msisdn\n" +
            ",u.pin\n" +
            ",u.promoter_id\n" +
            ",u.remarks\n" +
            ",u.reworked\n" +
            ",u.reworked_by\n" +
            ",u.reworked_on\n" +
            ",u.session_id\n" +
            ",u.trials,u.device_imei,u.user_id,u.issued_by,u.active,us.user_full_name as userFullName from Device_linking u inner join users us on us.user_id=u.user_id ")
    List<Device_linking> findAll();
    @Query("select u from Users u where u.userGroupTypeId=1 and u.userId not in(select d.userId from Device_linking  d where d.userId=u.userId)")
    List<Users> getPosUsers();
    @Query("select u from DeviceReg u where u.device_imei not in(select d.device_imei from Device_linking  d where d.userId is not null)")
    List<DeviceReg> getDevicesToIssue();

    /*@Query("select u from Device_linking u where u.agent_id is not null")
    List<Device_linking> findAll();*/
}
