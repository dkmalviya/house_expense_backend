package com.appkode.house.repository;

import com.appkode.house.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
    Address findByHouseNumberAndBuildingNameAndAreaAndCity(String houseNumber,String buildingName,String area,String city);

}
