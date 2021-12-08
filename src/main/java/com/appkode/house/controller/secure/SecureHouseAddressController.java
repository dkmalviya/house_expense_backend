package com.appkode.house.controller.secure;

import com.appkode.house.model.request.house.HouseRequest;
import com.appkode.house.model.request.house.HouseSearchRequest;
import com.appkode.house.model.response.generic.GenericResponse;
import com.appkode.house.model.response.house.HouseResponse;
import com.appkode.house.services.HouseAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/house")
public class SecureHouseAddressController {

    private final HouseAddressService houseAddressService;

    @Autowired
    public SecureHouseAddressController(HouseAddressService houseAddressService) {
        this.houseAddressService = houseAddressService;
    }


    @PostMapping(value = "/searchHouse")
    public ResponseEntity<List<HouseResponse>> searchHouse(@RequestBody @Valid HouseSearchRequest houseSearchRequest) {
        List<HouseResponse> houseResponseList = houseAddressService.getHouseByHouseNumberAndSocietyNameAndPinCode(houseSearchRequest);
        return new ResponseEntity<>(houseResponseList, HttpStatus.OK);
    }
}




