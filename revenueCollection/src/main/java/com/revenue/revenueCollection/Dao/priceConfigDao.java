package com.revenue.revenueCollection.Dao;


import com.revenue.revenueCollection.Models.Users;
import com.revenue.revenueCollection.Models.priceConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface priceConfigDao  extends JpaRepository<priceConfig,Integer> {
  //  @Query("  select u from priceConfig u where u.approved='V' and (u.deleted='U'  or u.deleted IS NULL)")
    @Query(nativeQuery = true,value = "\n" +
            "  select u.active,u.id,sc.sub_county_name as subCountyName,p.service_name as serviceName,ct.car_type_name as CarTypeName,u.approved,u.approved_by,u.approved_on,u.car_type_id,u.count\n" +
            "      ,u.create_json\n" +
            "      ,u.created_by\n" +
            "      ,u.created_on\n" +
            "      ,u.deleted\n" +
            "      ,u.deleted_by\n" +
            "      ,u.deleted_on\n" +
            "      ,u.fee\n" +
            "      ,u.remarks\n" +
            "      ,u.resp_code\n" +
            "      ,u.service_id\n" +
            "      ,u.sub_county_id\n" +
            "      ,u.update_json from price_config u inner join parking p on p.service_id=u.service_id \n" +
            "\t  inner join sub_county sc on sc.sub_county_id=u.sub_county_id inner join car_type ct on ct.car_type_id=u.car_type_id  where u.approved='V' and (u.deleted='U'  or u.deleted IS NULL)\n")
    List<priceConfig> findAllPrices();
    @Query("select u from priceConfig u where u.approved='N'")
    List<priceConfig> findPriceToApprove();
    @Query("select u from priceConfig u where u.deleted='D'")
    List<priceConfig> findPriceToApproveDelete();

}
