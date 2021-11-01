package com.appkode.UserService.repository;

import com.appkode.UserService.model.entity.User;
import com.appkode.UserService.model.entity.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}
