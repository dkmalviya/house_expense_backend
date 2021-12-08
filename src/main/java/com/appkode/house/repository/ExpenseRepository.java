package com.appkode.house.repository;

import com.appkode.house.entity.Expense;
import com.appkode.house.entity.Income;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense,Long> {

    List<Expense> findAllExpenseByUserIdAndIsDeleted(Long userId,Boolean isDeleted);
    List<Expense> findAllExpenseByUserIdAndIsDeletedAndExpenseDateBetween(Long userId,Boolean isDeleted, Date montStartDate, Date monthEndDate);
    List<Expense> findAllExpenseByIsDeletedAndExpenseDateBetweenAndUserIdIn(Boolean isDeleted, Date montStartDate, Date monthEndDate,List<Long>ids);





}
