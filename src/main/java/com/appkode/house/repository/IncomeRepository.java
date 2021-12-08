package com.appkode.house.repository;

import com.appkode.house.entity.Income;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IncomeRepository extends CrudRepository<Income,Long> {

    List<Income> findAllIncomeByUserId(Long userId);
    List<Income> findAllIncomeByUserIdAndCreditDateBetween(Long userId, Date montStartDate, Date monthEndDate);





}
