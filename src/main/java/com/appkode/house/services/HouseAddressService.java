package com.appkode.house.services;


import com.appkode.house.model.request.house.HouseRequest;
import com.appkode.house.model.request.house.HouseSearchRequest;
import com.appkode.house.model.response.house.HouseResponse;

import java.util.List;

public interface HouseAddressService {


    List<HouseResponse> getHouseByHouseNumberAndSocietyNameAndPinCode(HouseSearchRequest houseSearchRequest);

    HouseResponse findHouseByHouseId(Long houseId);

    HouseResponse updateHouseAddress(HouseRequest houseId);

    HouseResponse createHouseAddress(HouseRequest houseRequest);

    boolean houseAddressExists(HouseSearchRequest houseSearchRequest);


}
