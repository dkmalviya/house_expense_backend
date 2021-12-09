package com.appkode.house.controller.secure;


import com.appkode.house.model.request.credential.CredentialRequest;
import com.appkode.house.model.response.credential.CredentialResponse;
import com.appkode.house.model.response.generic.GenericResponse;
import com.appkode.house.services.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credential")
public class CredentialController {
    private final CredentialService credentialService;


    @Autowired
    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }


    @GetMapping(value = "/getAllCredential")
    public ResponseEntity<List<CredentialResponse>> getAllReminder() {
        List<CredentialResponse> reminderResponseList = credentialService.getAllCredentials();
        return new ResponseEntity<>(reminderResponseList, HttpStatus.OK);
    }

    @PostMapping(value = "/addCredential")
    public ResponseEntity<GenericResponse> addCredential(@RequestBody CredentialRequest credentialRequest) {
        Boolean result = credentialService.addCredential(credentialRequest);
        if (result) {
            return new ResponseEntity<>(new GenericResponse(0, "Success", "Credential added successfully."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new GenericResponse(99, "Failed", "Unable to add Credential."), HttpStatus.OK);

        }
    }

    @PostMapping(value = "/updateCredential")
    public ResponseEntity<GenericResponse> updateCredential(@RequestBody CredentialRequest credentialRequest) {
        Boolean result = credentialService.updateCredential(credentialRequest);
        if (result) {
            return new ResponseEntity<>(new GenericResponse(0, "Success", "Credential updated successfully."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new GenericResponse(99, "Failed", "Unable to update Credential."), HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/removeCredential/{credentialId}")
    public ResponseEntity<GenericResponse> removeCredential(@PathVariable Long credentialId) {
        Boolean result = credentialService.removeCredential(credentialId);
        if (result) {
            return new ResponseEntity<>(new GenericResponse(0, "Success", "Credential deleted successfully."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new GenericResponse(99, "Failed", "Unable to delete Credential."), HttpStatus.OK);

        }
    }

}
