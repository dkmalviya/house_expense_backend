package com.appkode.house.controller.secure;

import com.appkode.house.model.request.expense_category.ExpenseCategoryRequest;
import com.appkode.house.model.request.expense_category.ExpenseSubCategoryRequest;
import com.appkode.house.model.request.expense_category.FavoriteExpenseRequest;
import com.appkode.house.model.response.expense_category.ExpenseCategoryResponse;
import com.appkode.house.model.response.expense_category.ExpenseSubCategoryDetailsResponse;
import com.appkode.house.model.response.expense_category.ExpenseSubCategoryResponse;
import com.appkode.house.model.response.expense_category.FavoriteExpenseResponse;
import com.appkode.house.services.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense/expenseCategory")
public class ExpenseCategoryController {
    private final ExpenseCategoryService expenseCategoryService;

    @Autowired
    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }

    @GetMapping(value = "/getAllExpenseCategory")
    public ResponseEntity<List<ExpenseCategoryResponse>> getAllIncomeSource() {
        List<ExpenseCategoryResponse> allExpenseCategory = expenseCategoryService.findAllExpenseCategory();

        return new ResponseEntity<>(allExpenseCategory, HttpStatus.OK);

    }

    @GetMapping(value = "/getAllExpenseSubCategory/{categoryId}")
    public ResponseEntity<ExpenseSubCategoryResponse> getAllExpenseSubCategory(@PathVariable Long categoryId) {
        ExpenseSubCategoryResponse allExpenseCategory = expenseCategoryService.findAllSubCategory(categoryId);

        return new ResponseEntity<>(allExpenseCategory, HttpStatus.OK);

    }


    @PostMapping(value = "/addExpenseCategory")
    public ResponseEntity<ExpenseCategoryResponse> getAllIncomeSource(@RequestBody ExpenseCategoryRequest expenseCategoryRequest) {
        ExpenseCategoryResponse expenseCategoryResponse = expenseCategoryService.addExpenseCategory(expenseCategoryRequest);

        return new ResponseEntity<>(expenseCategoryResponse, HttpStatus.OK);

    }

    @PostMapping(value = "/addExpenseSubCategory")
    public ResponseEntity<ExpenseSubCategoryDetailsResponse> getAllIncomeSource(@RequestBody ExpenseSubCategoryRequest expenseSubCategoryRequest) {
        ExpenseSubCategoryDetailsResponse expenseSubCategoryDetailsResponse = expenseCategoryService.addExpenseSubCategory(expenseSubCategoryRequest);

        return new ResponseEntity<>(expenseSubCategoryDetailsResponse, HttpStatus.OK);

    }


    @PostMapping(value = "/addFavoriteExpense")
    public ResponseEntity<List<FavoriteExpenseResponse>> addFavoriteExpense(@RequestBody List<FavoriteExpenseRequest> expenseRequest) {
        List<FavoriteExpenseResponse> favoriteExpenseResponses = expenseCategoryService.addFavouriteExpense(expenseRequest);
        return new ResponseEntity<>(favoriteExpenseResponses, HttpStatus.OK);
    }


    @GetMapping(value = "/getAllFavoriteExpense")
    public ResponseEntity<List<FavoriteExpenseResponse>> getAllFavoriteExpense() {
        List<FavoriteExpenseResponse> allFavoriteExpense = expenseCategoryService.findAllFavoriteExpense();

        return new ResponseEntity<>(allFavoriteExpense, HttpStatus.OK);

    }

    @GetMapping(value = "/getAllFavoriteDailyNeeds")
    public ResponseEntity<List<FavoriteExpenseResponse>> getAllFavoriteDailyNeeds() {
        List<FavoriteExpenseResponse> allFavoriteExpense = expenseCategoryService.findAllFavoriteDailyNeeds();
        return new ResponseEntity<>(allFavoriteExpense, HttpStatus.OK);

    }


}
