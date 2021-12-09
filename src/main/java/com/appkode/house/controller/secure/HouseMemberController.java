package com.appkode.house.controller.secure;

import com.appkode.house.error.exception.ResourceNotFoundException;
import com.appkode.house.model.request.house_member.AddHouseMemberRequest;
import com.appkode.house.model.request.house_member.HouseMemberRequest;
import com.appkode.house.model.request.house_member.HouseMemberSearchRequest;
import com.appkode.house.model.response.generic.GenericResponse;
import com.appkode.house.model.response.house_member.HouseMemberResponse;
import com.appkode.house.services.HouseMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api/house/member")
public class HouseMemberController {

    private final HouseMemberService houseMemberService;

    @Autowired
    public HouseMemberController(HouseMemberService houseMemberService) {
        this.houseMemberService = houseMemberService;
    }


    @PostMapping(value = "/addMember")
    public ResponseEntity<GenericResponse> addMember(@RequestBody AddHouseMemberRequest addHouseMemberRequest) {

        System.out.println(addHouseMemberRequest);

        boolean addMemberStatus = houseMemberService.addHouseMember(addHouseMemberRequest);
        if (addMemberStatus) {

            return new ResponseEntity<>(new GenericResponse(0, "Success", "Member added successfully."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new GenericResponse(99, "Failed", "Unable to add member."), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/getAllMembers/{id}")
    public ResponseEntity<HouseMemberResponse> getHouseMembers(@PathVariable Long id) {
        HouseMemberResponse houseMember = houseMemberService.getAllHouseMember(id);

        return new ResponseEntity<>(houseMember, HttpStatus.OK);

    }

    @GetMapping(value = "/getAllActiveMembers/{id}")
    public ResponseEntity<HouseMemberResponse> getAllActiveMembers(@PathVariable Long id) {
        HouseMemberResponse houseMember = houseMemberService.getAllActiveHouseMember(id);
        return new ResponseEntity<>(houseMember, HttpStatus.OK);
    }

    @PostMapping(value = "/updateMemberStatus")
    public ResponseEntity<GenericResponse> updateStatus(@RequestBody HouseMemberRequest houseMemberRequest) {
        Boolean status = houseMemberService.updateStatusOfMember(houseMemberRequest);
        if (status) {
            return new ResponseEntity<>(new GenericResponse(0, "Success", "User status change to " + houseMemberRequest.getStatus()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new GenericResponse(99, "Failed", "Unable to change status of member "), HttpStatus.OK);

    }

    @PostMapping(value = "/updateAdminOfHouse")
    public ResponseEntity<GenericResponse> updateAdminOfHouse(@RequestBody HouseMemberRequest houseMemberRequest) {
        Boolean status = houseMemberService.updateAdminOfHouse(houseMemberRequest);
        if (status) {
            return new ResponseEntity<>(new GenericResponse(0, "Success", "House admin successfully updated."), HttpStatus.OK);
        }
        return new ResponseEntity<>(new GenericResponse(99, "Failed", "Unable to update admin of house."), HttpStatus.OK);

    }


    @PostMapping(value = "/searchHouseByMembersMobileNumber")
    public ResponseEntity<HouseMemberResponse> searchHouseByMembersMobileNumber(@RequestBody @Valid HouseMemberSearchRequest houseMemberSearchRequest) {
        HouseMemberResponse houseResponse = houseMemberService.searchHouseByMembersMobileNumber(houseMemberSearchRequest);

        if (Objects.isNull(houseResponse)) {
            throw new ResourceNotFoundException("House not found");
        }
        return new ResponseEntity<>(houseResponse, HttpStatus.OK);
    }


}
