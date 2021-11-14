package com.appkode.house.repository;

import com.appkode.house.model.entity.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile,Long> {
    Boolean existsByMobile(String mobile);
    UserProfile findByEmail(String email);

}
