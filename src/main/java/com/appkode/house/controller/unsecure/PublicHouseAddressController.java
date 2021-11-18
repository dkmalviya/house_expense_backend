package com.appkode.house.controller.unsecure;

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

@RestController
public class PublicHouseAddressController extends PublicApiController {

    private final HouseAddressService houseAddressService;

    @Autowired
    public PublicHouseAddressController(HouseAddressService houseAddressService) {
        this.houseAddressService = houseAddressService;
    }

    @GetMapping(value = "/house/{id}")
    public ResponseEntity<HouseResponse> getHouse(@PathVariable Long id) {
        HouseResponse houseResponse = houseAddressService.findHouseByHouseId(id);
        System.out.println(houseResponse.toString());
        return new ResponseEntity<>(houseResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/addHouse")
    public ResponseEntity<HouseResponse> createHouse(@RequestBody @Valid HouseRequest houseRequest) {
        HouseResponse houseResponse = houseAddressService.createHouseAddress(houseRequest);
        System.out.println(houseResponse.toString());
        return new ResponseEntity<>(houseResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/searchHouse")
    public ResponseEntity<GenericResponse> searchHouse(@RequestBody @Valid HouseSearchRequest houseSearchRequest) {
        boolean isHouseExist = houseAddressService.houseAddressExists(houseSearchRequest);
        if (isHouseExist) {
            return new ResponseEntity<>(new GenericResponse(0, "Success", "House Already Exist"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new GenericResponse(99, "Failed", "No House available with this address"), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/updateHouse")
    public ResponseEntity<HouseResponse> updateUserHouse(@RequestBody @Valid HouseRequest houseRequest) {
        HouseResponse houseResponse = houseAddressService.updateHouseAddress(houseRequest);
        System.out.println(houseResponse.toString());
        return new ResponseEntity<>(houseResponse, HttpStatus.OK);
    }


}
