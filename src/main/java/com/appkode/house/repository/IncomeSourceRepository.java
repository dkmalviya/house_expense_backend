package com.appkode.house.repository;

import com.appkode.house.entity.IncomeSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeSourceRepository extends CrudRepository<IncomeSource, Long> {

    Boolean existsByIncomeSourceName(String name);

}
