package com.appkode.house.services;

import com.appkode.house.model.request.expense_category.ExpenseCategoryRequest;
import com.appkode.house.model.request.expense_category.ExpenseSubCategoryRequest;
import com.appkode.house.model.request.expense_category.FavoriteExpenseRequest;
import com.appkode.house.model.response.expense_category.ExpenseCategoryResponse;
import com.appkode.house.model.response.expense_category.ExpenseSubCategoryDetailsResponse;
import com.appkode.house.model.response.expense_category.ExpenseSubCategoryResponse;
import com.appkode.house.model.response.expense_category.FavoriteExpenseResponse;

import java.util.List;

public interface ExpenseCategoryService {


    List<ExpenseCategoryResponse> findAllExpenseCategory();
    ExpenseCategoryResponse addExpenseCategory(ExpenseCategoryRequest expenseCategoryRequest);
    Boolean isExpenseCategoryExists(String name);
    boolean deleteExpenseCategory(Long id);


    //Sub Category Services

    ExpenseSubCategoryResponse findAllSubCategory(Long categoryId);
    ExpenseSubCategoryDetailsResponse addExpenseSubCategory(ExpenseSubCategoryRequest expenseSubCategoryRequest);
    Boolean isExpenseSubCategoryExists(String name);



    //Favorite Expenses

    List<FavoriteExpenseResponse> findAllFavoriteExpense();
    List<FavoriteExpenseResponse> findAllFavoriteDailyNeeds();
    List<FavoriteExpenseResponse> addFavouriteExpense(List<FavoriteExpenseRequest> favoriteExpenseRequests);



}
