package com.appkode.house.converter.credential;

import com.appkode.house.entity.Credential;
import com.appkode.house.model.response.credential.CredentialResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class CredentialResponseConverter implements Function<List<Credential>, List<CredentialResponse>> {
    @Override
    public List<CredentialResponse> apply(List<Credential> credentials) {
        List<CredentialResponse> credentialResponseList = new ArrayList<>();
        for (Credential credential : credentials) {
            CredentialResponse credentialResponse = new CredentialResponse();
            credentialResponse.setCredentialId(credential.getId());
            credentialResponse.setAccountName(credential.getAccountName());
            credentialResponse.setAccountCategory(credential.getAccountCategory());
            credentialResponse.setUserName(credential.getUserName());
            credentialResponse.setPrimaryPassword(credential.getPrimaryPassword());
            credentialResponse.setSecondaryPassword(credential.getSecondaryPassword());
            credentialResponse.setPin(credential.getPin());
            credentialResponse.setRecoveryEmail(credential.getRecoveryEmail());
            credentialResponseList.add(credentialResponse);
        }

        return credentialResponseList;
    }
}
