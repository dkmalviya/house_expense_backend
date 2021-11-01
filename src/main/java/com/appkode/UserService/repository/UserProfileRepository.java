package com.appkode.UserService.repository;

import com.appkode.UserService.model.entity.UserProfile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserProfileRepository extends CrudRepository<UserProfile,Long> {

}
