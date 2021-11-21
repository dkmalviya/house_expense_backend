package com.appkode.house.repository;

import com.appkode.house.entity.Credential;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CredentialRepository extends CrudRepository<Credential,Long> {
    Credential findAllByIdAndUserId(Long credentialId, Long userId);
    List<Credential> findAllByUserId(Long userId);

}
