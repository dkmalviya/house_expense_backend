package com.appkode.house.repository;

import com.appkode.house.entity.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HouseRepository extends CrudRepository<House,Long > {
}
