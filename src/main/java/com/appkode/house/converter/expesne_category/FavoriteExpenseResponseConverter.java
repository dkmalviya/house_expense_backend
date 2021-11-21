package com.appkode.house.converter.expesne_category;

import com.appkode.house.entity.FavoriteExpense;
import com.appkode.house.model.response.expense_category.FavoriteExpenseResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class FavoriteExpenseResponseConverter implements Function<List<FavoriteExpense> , List<FavoriteExpenseResponse> > {
    @Override
    public List<FavoriteExpenseResponse> apply(List<FavoriteExpense> favoriteExpenses) {

        List<FavoriteExpenseResponse> favoriteExpenseResponses=new ArrayList<>();


        for (FavoriteExpense favoriteExpense: favoriteExpenses) {
            FavoriteExpenseResponse favoriteExpenseResponse = new FavoriteExpenseResponse();
            favoriteExpenseResponse.setFavoriteId(favoriteExpense.getId());
            favoriteExpenseResponse.setExpenseCategoryId(favoriteExpense.getExpenseSubCategory().getExpenseCategory().getId());
            favoriteExpenseResponse.setExpenseCategoryName(favoriteExpense.getExpenseSubCategory().getExpenseCategory().getExpenseCategoryName());
            favoriteExpenseResponse.setExpenseSubCategoryId(favoriteExpense.getExpenseSubCategory().getId());
            favoriteExpenseResponse.setExpenseSubCategoryName(favoriteExpense.getExpenseSubCategory().getExpenseSubCategoryName());
            favoriteExpenseResponse.setDescription(favoriteExpense.getExpenseSubCategory().getDescription());
            favoriteExpenseResponse.setIsDailyNeed(favoriteExpense.getIsDailyNeed());

            favoriteExpenseResponses.add(favoriteExpenseResponse);
        }

        return favoriteExpenseResponses;
    }
}
