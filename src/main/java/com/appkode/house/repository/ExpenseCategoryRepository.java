package com.appkode.house.repository;

import com.appkode.house.entity.ExpenseCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseCategoryRepository extends CrudRepository<ExpenseCategory,Long> {

    Boolean existsByExpenseCategoryName(String name);




}
