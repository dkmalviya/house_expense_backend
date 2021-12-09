package com.appkode.house.repository;

import com.appkode.house.entity.Address;
import com.appkode.house.entity.House;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HouseRepository extends CrudRepository<House, Long> {

    List<House> findAllByAddress(Address address);

    @Query("FROM House AS hs LEFT JOIN hs.address AS add WHERE add.id = ?1")
    House findByAddressId(Long addressId);

}
