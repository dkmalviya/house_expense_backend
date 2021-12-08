package com.appkode.house.converter.house;

import com.appkode.house.entity.House;
import com.appkode.house.model.response.house.HouseResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class HouseResponseConverter  implements Function<House, HouseResponse> {

    @Override
    public HouseResponse apply(House house) {
        HouseResponse houseResponse = new HouseResponse();
        houseResponse.setHouseName(house.getHouseName());
        houseResponse.setHouseNumber(house.getAddress().getHouseNumber());
        houseResponse.setBuildingName(house.getAddress().getBuildingName());
        houseResponse.setStreet(house.getAddress().getStreet());
        houseResponse.setArea(house.getAddress().getArea());
        houseResponse.setSocietyName(house.getAddress().getSocietyName());
        houseResponse.setLandmark(house.getAddress().getLandmark());
        houseResponse.setCity(house.getAddress().getCity());
        houseResponse.setPinCode(house.getAddress().getPinCode());
        houseResponse.setAddressId(house.getAddress().getId());
        return houseResponse;
    }
}
