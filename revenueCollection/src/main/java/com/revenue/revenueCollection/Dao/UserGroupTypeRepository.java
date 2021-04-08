package com.revenue.revenueCollection.Dao;

import java.util.List;

import com.revenue.revenueCollection.Models.UserGroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserGroupTypeRepository extends JpaRepository<UserGroupType, Long>{
	List<UserGroupType> findAll();
}
