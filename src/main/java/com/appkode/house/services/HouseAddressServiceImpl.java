package com.appkode.house.services;

import com.appkode.house.converter.house.HouseResponseConverter;
import com.appkode.house.entity.Address;
import com.appkode.house.entity.House;
import com.appkode.house.error.exception.ResourceNotFoundException;
import com.appkode.house.model.request.house.HouseRequest;
import com.appkode.house.model.request.house.HouseSearchRequest;
import com.appkode.house.model.response.house.HouseResponse;
import com.appkode.house.repository.AddressRepository;
import com.appkode.house.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class HouseAddressServiceImpl implements HouseAddressService{


    private final AddressRepository addressRepository;
    private final HouseRepository houseRepository;
    private final HouseResponseConverter houseResponseConverter;



    @Autowired
    public HouseAddressServiceImpl( AddressRepository addressRepository, HouseRepository houseRepository, HouseResponseConverter houseResponseConverter) {
        this.addressRepository = addressRepository;
        this.houseRepository = houseRepository;
        this.houseResponseConverter = houseResponseConverter;

    }


    @Override
    public List<HouseResponse> getHouseWhitHoneNumberAndCity(String houseNumber, String city) {
        return null;
    }

    @Override
    public HouseResponse findHouseByHouseId(Long houseId) {

       House house= houseRepository.findById(houseId).orElseThrow(() -> new ResourceNotFoundException("Invalid house id"));

        return houseResponseConverter.apply(house);
    }

    @Override
    public HouseResponse updateHouseAddress(HouseRequest houseId) {
        return null;
    }

    @Override
    public HouseResponse createHouseAddress(HouseRequest houseRequest) {

        Address address=new Address();
        address.setHouseNumber(houseRequest.getHouseNumber());
        address.setBuildingName(houseRequest.getBuildingName());
        address.setStreet(houseRequest.getStreet());
        address.setArea(houseRequest.getArea());
        address.setLandmark(houseRequest.getLandmark());
        address.setCity(houseRequest.getCity());
        address.setPinCode(houseRequest.getPinCode());
        House house=new House();
        house.setHouseName(houseRequest.getHouseName());
        house.setAddress(address);
        House resultHouse=houseRepository.save(house);
        return houseResponseConverter.apply(resultHouse);
    }

    @Override
    public boolean houseAddressExists(HouseSearchRequest houseSearchRequest) {
        Address arr=addressRepository.findByHouseNumberAndBuildingNameAndAreaAndCity(houseSearchRequest.getHouseNumber(),houseSearchRequest.getBuildingName(),houseSearchRequest.getArea(),houseSearchRequest.getCity());
        System.out.println(arr);

        if(Objects.isNull(arr)){
            return false;
        }
        return true;
    }


}
