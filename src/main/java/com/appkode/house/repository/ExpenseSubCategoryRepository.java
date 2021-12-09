package com.appkode.house.repository;

import com.appkode.house.entity.ExpenseSubCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExpenseSubCategoryRepository extends CrudRepository<ExpenseSubCategory, Long> {
    Boolean existsByExpenseSubCategoryName(String name);

}
