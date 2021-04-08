package com.revenue.revenueCollection.Dao;



import com.revenue.revenueCollection.GenericDao.GenericDao;
import com.revenue.revenueCollection.Models.Agent;
import com.revenue.revenueCollection.Models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


public interface AgentDao extends JpaRepository<Agent,Integer> {
    @Query("select u from Agent u where u.approved='V' and (u.deleted='U'  or u.deleted IS NULL)")
    List<Agent> findAll();
    @Query("select u from Agent u where u.approved='N'")
    List<Agent> findAgentToApprove();
    @Query("select u from Agent u where u.deleted='D'")
    List<Agent> findAgentToApproveDelete();


}
