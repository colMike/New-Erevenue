package com.revenue.revenueCollection.Interfaces;


import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.UserGroupType;
import com.revenue.revenueCollection.Models.Users;
import org.springframework.data.jpa.repository.Query;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserBal {
    ResponseMessage registerUser(Users users);
    List<Users> viewUserDetails();
    ResponseMessage deleteUsers(Users users);
    ResponseMessage approveUsers(Users users);
    ResponseMessage approveDeleteUsers(Users users);

    List<Users> getUsersToApprove();
    List<Users> getUsersToApproveDelete();
    List<UserGroupType> getUserGroupType();

 //   @Query(nativeQuery = true, value ="UPDATE users set userFullName=?,userEmail=?,active=?,userPhone=?,userNationalId=?  WHERE userId=?")
    ResponseMessage updateUser(Users users);

}
