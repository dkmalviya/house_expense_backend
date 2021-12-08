package com.appkode.house.services;

import com.appkode.house.converter.house.HouseResponseConverter;
import com.appkode.house.entity.Address;
import com.appkode.house.entity.House;
import com.appkode.house.entity.User;
import com.appkode.house.error.exception.ResourceNotFoundException;
import com.appkode.house.model.request.house.HouseRequest;
import com.appkode.house.model.request.house.HouseSearchRequest;
import com.appkode.house.model.request.house_member.HouseMemberSearchRequest;
import com.appkode.house.model.response.house.HouseResponse;
import com.appkode.house.model.response.user.UserProfileResponse;
import com.appkode.house.repository.AddressRepository;
import com.appkode.house.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseAddressServiceImpl implements HouseAddressService {


    private final AddressRepository addressRepository;
    private final HouseRepository houseRepository;
    private final HouseResponseConverter houseResponseConverter;


    @Autowired
    public HouseAddressServiceImpl(AddressRepository addressRepository, HouseRepository houseRepository,  HouseResponseConverter houseResponseConverter) {
        this.addressRepository = addressRepository;
        this.houseRepository = houseRepository;
        this.houseResponseConverter = houseResponseConverter;

    }


    @Override
    public List<HouseResponse> getHouseByHouseNumberAndSocietyNameAndPinCode(HouseSearchRequest houseSearchRequest) {

        List<Address> addressList = addressRepository.findAllByHouseNumberAndSocietyNameAndPinCode(houseSearchRequest.getHouseNumber(), houseSearchRequest.getSocietyName(), houseSearchRequest.getPinCode());
        System.out.println(addressList);
        List<House> houses = new ArrayList<>();
        List<HouseResponse> houseResponseList = new ArrayList<>();

        for (Address address : addressList) {
            List<House> allByAddress = houseRepository.findAllByAddress(address);
            houses.addAll(allByAddress);
        }

        for (House house : houses) {
            final HouseResponse houseResponse = houseResponseConverter.apply(house);
            houseResponseList.add(houseResponse);
        }

        return houseResponseList;
    }

    @Override
    public HouseResponse findHouseByHouseId(Long houseId) {

        House house = houseRepository.findById(houseId).orElseThrow(() -> new ResourceNotFoundException("Invalid house id"));

        return houseResponseConverter.apply(house);
    }

    @Override
    public HouseResponse updateHouseAddress(HouseRequest houseId) {
        return null;
    }

    @Override
    public HouseResponse createHouseAddress(HouseRequest houseRequest) {

        System.out.println(houseRequest);

        Address address = new Address();
        address.setHouseNumber(houseRequest.getHouseNumber());
        address.setBuildingName(houseRequest.getBuildingName());
        address.setStreet(houseRequest.getStreet());
        address.setArea(houseRequest.getArea());
        address.setLandmark(houseRequest.getLandmark());
        address.setCity(houseRequest.getCity());
        address.setSocietyName(houseRequest.getSocietyName());
        address.setPinCode(houseRequest.getPinCode());

        System.out.println(address);

        House house = new House();
        house.setHouseName(houseRequest.getHouseName());
        house.setAddress(address);
        House resultHouse = houseRepository.save(house);
        return houseResponseConverter.apply(resultHouse);
    }




    @Override
    public boolean houseAddressExists(HouseSearchRequest houseSearchRequest) {
        List<Address> addressList = addressRepository.findAllByHouseNumberAndSocietyNameAndPinCode(houseSearchRequest.getHouseNumber(), houseSearchRequest.getSocietyName(), houseSearchRequest.getPinCode());
        System.out.println(addressList);

        if (addressList.isEmpty()) {
            return false;
        }
        return true;
    }


}
