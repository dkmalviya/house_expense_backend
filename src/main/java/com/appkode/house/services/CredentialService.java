package com.appkode.house.services;

import com.appkode.house.model.request.credential.CredentialRequest;
import com.appkode.house.model.response.credential.CredentialResponse;

import java.util.List;

public interface CredentialService {

    List<CredentialResponse> getAllCredentials();
    Boolean addCredential(CredentialRequest credentialRequest);
    Boolean updateCredential(CredentialRequest credentialRequest);
    Boolean removeCredential(Long credentialId);
}
