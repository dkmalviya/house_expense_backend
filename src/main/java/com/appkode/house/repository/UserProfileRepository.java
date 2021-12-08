package com.appkode.house.repository;

import com.appkode.house.entity.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile,Long> {
    Boolean existsByMobile(String mobile);
    UserProfile findByEmail(String email);
    UserProfile findByMobile(String mobileNumber);

    @Query("select up.firstName from UserProfile up where up.userId = ?1")
    String findUserNameByUserId(Long userId);


}
