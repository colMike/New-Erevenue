package com.revenue.revenueCollection.Dao;

import java.util.Collection;
import java.util.List;

import com.revenue.revenueCollection.Models.MenuHeaderMaster;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuHeaderRepository extends CrudRepository<MenuHeaderMaster, Long>{
	Collection<MenuHeaderMaster> findAll();
	
	@Query("SELECT c FROM MenuHeaderMaster c inner join fetch c.menus o "
			+ "inner join fetch o.groups g inner join g.rights s  "
			+ "where g.id=?1 and s.rightId=o.id and s.AllowView=1 order by c.headerPos asc")

/*@Query("\tselect c from MenuHeaderMaster c inner join RightMaster rm on rm.right_headerid=c.id\n" +
		"\t\tinner join use ur on ur.right_id=rm.id inner join usergroupsmaster ug on ug.id=ur.group_id\n" +
		"\t\twhere ur.group_id=?1")*/
public List<MenuHeaderMaster> getAll(@Param("rightId") Long groupId);

}
