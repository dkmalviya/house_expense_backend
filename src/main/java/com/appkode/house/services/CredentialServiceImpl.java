package com.appkode.house.services;

import com.appkode.house.converter.credential.CredentialResponseConverter;
import com.appkode.house.entity.Credential;
import com.appkode.house.entity.User;
import com.appkode.house.model.request.credential.CredentialRequest;
import com.appkode.house.model.response.credential.CredentialResponse;
import com.appkode.house.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class CredentialServiceImpl implements CredentialService {

    private final CredentialResponseConverter credentialResponseConverter;
    private final UserProfileService userProfileService;
    private final CredentialRepository credentialRepository;

    @Autowired
    public CredentialServiceImpl(CredentialResponseConverter credentialResponseConverter, UserProfileService userProfileService, CredentialRepository credentialRepository) {
        this.credentialResponseConverter = credentialResponseConverter;
        this.userProfileService = userProfileService;
        this.credentialRepository = credentialRepository;
    }

    @Override
    public List<CredentialResponse> getAllCredentials() {

        User user = userProfileService.getUser();
        List<Credential> credentials = credentialRepository.findAllByUserId(user.getId());
        List<CredentialResponse> credentialResponseList = credentialResponseConverter.apply(credentials);
        return credentialResponseList;


    }

    @Override
    public Boolean addCredential(CredentialRequest credentialRequest) {
        User user = userProfileService.getUser();
        Credential credential = new Credential();
        credential.setAccountCategory(credentialRequest.getAccountCategory());
        credential.setAccountName(credentialRequest.getAccountName());
        credential.setPin(credentialRequest.getPin());
        credential.setUserId(user.getId());
        credential.setPrimaryPassword(credentialRequest.getPrimaryPassword());
        credential.setSecondaryPassword(credentialRequest.getSecondaryPassword());
        credential.setRecoveryEmail(credentialRequest.getRecoveryEmail());
        credential.setUserName(credentialRequest.getUserName());
        credential.setCreatedBy(user.getId());
        credential.setUpdatedBy(user.getId());
        final Credential credentialResult = credentialRepository.save(credential);
        return !Objects.isNull(credentialResult);

    }

    @Override
    public Boolean updateCredential(CredentialRequest credentialRequest) {
        User user = userProfileService.getUser();
        Credential credential = credentialRepository.findAllByIdAndUserId(credentialRequest.getCredentialId(), user.getId());
        credential.setAccountCategory(credentialRequest.getAccountCategory());
        credential.setAccountName(credentialRequest.getAccountName());
        credential.setPin(credentialRequest.getPin());
        credential.setUserId(user.getId());
        credential.setPrimaryPassword(credentialRequest.getPrimaryPassword());
        credential.setSecondaryPassword(credentialRequest.getSecondaryPassword());
        credential.setRecoveryEmail(credentialRequest.getRecoveryEmail());
        credential.setUserName(credentialRequest.getUserName());
        credential.setCreatedBy(user.getId());
        credential.setUpdatedBy(user.getId());
        final Credential credentialResult = credentialRepository.save(credential);
        return !Objects.isNull(credentialResult);

    }

    @Override
    public Boolean removeCredential(Long credentialId) {
        User user = userProfileService.getUser();
        Credential credential = credentialRepository.findAllByIdAndUserId(credentialId, user.getId());
        if (Objects.isNull(credential)) {
            return false;
        }
        credentialRepository.delete(credential);
        return true;
    }
}
