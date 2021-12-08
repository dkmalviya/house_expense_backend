package com.appkode.house.repository;

import com.appkode.house.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findAllByHouseNumberAndSocietyNameAndPinCode(String houseNumber, String societyName, String pinCode);

}
