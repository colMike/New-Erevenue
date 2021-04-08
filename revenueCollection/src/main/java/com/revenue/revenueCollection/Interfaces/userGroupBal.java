package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.UserGroup;
import com.revenue.revenueCollection.Models.UserGroupRights;

import java.util.List;
import java.util.Optional;

public interface userGroupBal {
    List<UserGroup> getGroups();
    List<UserGroup> userGroups();
    Optional<UserGroup> getUserGroup(Long id);
    UserGroup addGroup(UserGroup userGroup);
    //UserGroup updateUserGroup(UserGroup userGroup);
    List<UserGroupRights> getGroupRights(Long id, Long id2, Long id3);
    List<UserGroupRights> getUserGroupRights();

    List<UserGroup> getRolesToApprove();

    List<UserGroup> getRolesToApproveDelete();

    ResponseMessage approveRoles(UserGroup userGroup);

    ResponseMessage deleteRole(UserGroup userGroup);

    ResponseMessage approveDeleteRole(UserGroup users);
}
