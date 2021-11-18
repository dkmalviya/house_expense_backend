package com.appkode.house.repository;


import com.appkode.house.entity.PasswordForgotToken;
import com.appkode.house.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordForgotTokenRepository extends CrudRepository<PasswordForgotToken, Long> {
    Optional<PasswordForgotToken> findByToken(String token);

    Optional<PasswordForgotToken> findByUser(User user);
}