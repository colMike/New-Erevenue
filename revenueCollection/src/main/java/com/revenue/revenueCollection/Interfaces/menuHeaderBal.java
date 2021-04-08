package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.MenuHeaderMaster;

import javax.ejb.Local;
import java.util.Collection;
import java.util.List;
@Local
public interface menuHeaderBal {
    Collection<MenuHeaderMaster> getMenuHeaders();
    List<MenuHeaderMaster> getGroupMenus(Long groupId);
}
