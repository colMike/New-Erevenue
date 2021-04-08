package com.revenue.revenueCollection.Beans;

import java.util.Collection;
import java.util.List;

import com.revenue.revenueCollection.Dao.MenuHeaderRepository;
import com.revenue.revenueCollection.Interfaces.menuHeaderBal;
import com.revenue.revenueCollection.Models.MenuHeaderMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Component
public class MenuHeaderBalImpl implements menuHeaderBal {
	
	@Autowired
	private MenuHeaderRepository headerRepository;


	public Collection<MenuHeaderMaster> getMenuHeaders() {
		return headerRepository.findAll();
	}

	public List<MenuHeaderMaster> getGroupMenus(Long groupId) {
		// TODO Auto-generated method stub
		return headerRepository.getAll(groupId);
	}
}
