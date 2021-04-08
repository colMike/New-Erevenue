package com.revenue.revenueCollection.Dao;

import java.util.List;
import java.util.Optional;

import com.revenue.revenueCollection.Models.UserAssignedRights;
import com.revenue.revenueCollection.Models.UserGroup;
import com.revenue.revenueCollection.Models.UserGroupRights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;


public interface UseGroupRepositories extends JpaRepository<UserGroup, Long>{
	List<UserGroup> findAll();
	@Query("select  u from UserGroup u")
	List<UserGroup> getGroups();
	Optional<UserGroup> findById(@Param("id") Long id);
	
	@Query(nativeQuery=true, value="SELECT  UR.right_id as rightId,RM.right_display_name as rightName,  " +
	"       (CASE UR.allow_view WHEN 1 THEN 'true' else 'false' end) AS allowView, " +
	"       (CASE UR.allow_add WHEN 1 THEN 'true' else 'false' end) AS allowAdd, " +
	"       (CASE UR.allow_edit WHEN 1 THEN 'true' else 'false' end) AS allowEdit, " +
	"       (CASE UR.allow_delete WHEN 1 THEN 'true' else 'false' end) AS allowDelete " +
	"        FROM USERGROUPSMASTER GR " + 
	"        INNER JOIN USERASSIGNEDRIGHTS UR ON UR.group_id = GR.ID " +
	"        RIGHT JOIN  RIGHTSMASTER RM  ON RM.ID=UR.right_id " +
	"        WHERE GR.ID=?1 " +
	"        UNION ALL " + 
	"        SELECT RM.ID as rightId,RM.right_display_name as rightName,'false' as allowView,  " +
	"        'false' as allowAdd, 'false' as allowEdit,'false' as allowDelete " + 
	"          FROM USERGROUPSMASTER GM ,RIGHTSMASTER RM " + 
	"          WHERE GM.ID=?2 AND RM.ID NOT IN (SELECT ASR.right_id  FROM USERASSIGNEDRIGHTS ASR WHERE ASR.group_id = ?3) order by UR.right_id asc ")
	List<UserGroupRights> getUserGroups(Long id, Long id2, Long id3);
	
	@Query(nativeQuery=true, value="SELECT ID as rightId, right_display_name as rightName,"
			+ " 'false' as allowView, 'false' as allowAdd, 'false' as allowEdit,"
			+ "  'false' as allowDelete FROM RIGHTSMASTER order by ID asc ")
	List<UserGroupRights> getUserGroupRights();
	@Transactional
	@Modifying
	@Query( "delete from UserAssignedRights u where u.GroupId=?1")

	void  deleteRights(@Param("group_id") UserGroup groupId);
	@Query("select u from UserGroup u where u.approved='N'")
	List<UserGroup> findRolesToApprove();
	@Query("select u from UserGroup u where u.deleted='D'")
	List<UserGroup> findRolesToApproveDelete();
}
