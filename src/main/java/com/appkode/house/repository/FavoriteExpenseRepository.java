package com.appkode.house.repository;

import com.appkode.house.entity.FavoriteExpense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FavoriteExpenseRepository extends CrudRepository<FavoriteExpense,Long> {

    List<FavoriteExpense> findAllFavoriteExpenseByUserId(Long userId);
    /*
    Not Worked :(
    //SELECT CAST(CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END AS BIT) FROM `favorites` AS `fe` LEFT JOIN `expense_sub_category` AS `esc` WHERE `fe`.`userId` = 1 and `fe`.`expenseSubcategoryid`=2;

    @Query("SELECT CAST(CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END AS BIT) FROM FavoriteExpense AS fe LEFT JOIN fe.expenseSubCategory AS esc WHERE fe.userid = ?1 and esc.id=?2;")
    Boolean existsByUserIdAndSubCategoryId(Long userId,Long SubCategoryId);

    Workend in mysql
    SELECT CAST(CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END AS BIT) FROM `favorites` AS `fe` LEFT JOIN `expense_sub_category` AS `esc` WHERE `fe`.`userId` = 1 and `fe`.`expenseSubcategoryid`=2;

    */

        List<FavoriteExpense> findAllFavoriteExpenseByUserIdAndIsDailyNeed(Long userId, Boolean isDailyNeed);

}
