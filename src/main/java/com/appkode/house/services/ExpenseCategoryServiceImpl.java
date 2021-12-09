package com.appkode.house.services;


import com.appkode.house.converter.expesne_category.ExpenseCategoryResponseConverter;
import com.appkode.house.converter.expesne_category.ExpenseSubCategoryResponseListConverter;
import com.appkode.house.converter.expesne_category.FavoriteExpenseResponseConverter;
import com.appkode.house.entity.ExpenseCategory;
import com.appkode.house.entity.ExpenseSubCategory;
import com.appkode.house.entity.FavoriteExpense;
import com.appkode.house.entity.User;
import com.appkode.house.error.exception.InvalidArgumentException;
import com.appkode.house.error.exception.ResourceNotFoundException;
import com.appkode.house.model.dto.expense.ExpenseSubCategoryDto;
import com.appkode.house.model.request.expense_category.ExpenseCategoryRequest;
import com.appkode.house.model.request.expense_category.ExpenseSubCategoryRequest;
import com.appkode.house.model.request.expense_category.FavoriteExpenseRequest;
import com.appkode.house.model.response.expense_category.ExpenseCategoryResponse;
import com.appkode.house.model.response.expense_category.ExpenseSubCategoryDetailsResponse;
import com.appkode.house.model.response.expense_category.ExpenseSubCategoryResponse;
import com.appkode.house.model.response.expense_category.FavoriteExpenseResponse;
import com.appkode.house.repository.ExpenseCategoryRepository;
import com.appkode.house.repository.ExpenseSubCategoryRepository;
import com.appkode.house.repository.FavoriteExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {


    private final ExpenseCategoryRepository expenseCategoryRepository;
    private final ExpenseSubCategoryRepository expenseSubCategoryRepository;
    private final UserProfileService userProfileService;

    private final ExpenseCategoryResponseConverter expenseCategoryResponseConverter;
    private final ExpenseSubCategoryResponseListConverter expenseSubCategoryResponseConverter;

    private final FavoriteExpenseRepository favoriteExpenseRepository;
    private final FavoriteExpenseResponseConverter favoriteExpenseResponseConverter;


    public ExpenseCategoryServiceImpl(ExpenseCategoryRepository expenseCategoryRepository, ExpenseSubCategoryRepository expenseSubCategoryRepository, UserProfileService userProfileService, ExpenseCategoryResponseConverter expenseCategoryResponseConverter, ExpenseSubCategoryResponseListConverter expenseSubCategoryResponseConverter, FavoriteExpenseRepository favoriteExpenseRepository, FavoriteExpenseResponseConverter favoriteExpenseResponseConverter) {
        this.expenseCategoryRepository = expenseCategoryRepository;
        this.expenseSubCategoryRepository = expenseSubCategoryRepository;
        this.userProfileService = userProfileService;
        this.expenseCategoryResponseConverter = expenseCategoryResponseConverter;
        this.expenseSubCategoryResponseConverter = expenseSubCategoryResponseConverter;
        this.favoriteExpenseRepository = favoriteExpenseRepository;
        this.favoriteExpenseResponseConverter = favoriteExpenseResponseConverter;
    }


    @Override
    public List<ExpenseCategoryResponse> findAllExpenseCategory() {

        List<ExpenseCategoryResponse> expenseCategoryResponses = new ArrayList<>();

        Iterable<ExpenseCategory> expenseCategories = expenseCategoryRepository.findAll();

        for (ExpenseCategory expenseCategory : expenseCategories) {
            ExpenseCategoryResponse expenseCategoryResponseTemp = expenseCategoryResponseConverter.apply(expenseCategory);
            expenseCategoryResponses.add(expenseCategoryResponseTemp);

        }


        return expenseCategoryResponses;

    }

    @Override
    public ExpenseCategoryResponse addExpenseCategory(ExpenseCategoryRequest expenseCategoryRequest) {
        Boolean expenseCategoryExists = isExpenseCategoryExists(expenseCategoryRequest.getExpenseCategoryName());
        if (expenseCategoryExists) {
            throw new InvalidArgumentException("Expense Category already Exists");
        }
        User user = userProfileService.getUser();
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setExpenseCategoryName(expenseCategoryRequest.getExpenseCategoryName());
        expenseCategory.setDescription(expenseCategoryRequest.getDescription());
        expenseCategory.setCreatedBy(user.getId());
        expenseCategory.setUpdatedBy(user.getId());
        ExpenseCategory expenseCategoryResult = expenseCategoryRepository.save(expenseCategory);

        return expenseCategoryResponseConverter.apply(expenseCategoryResult);

    }

    @Override
    public Boolean isExpenseCategoryExists(String name) {
        return expenseCategoryRepository.existsByExpenseCategoryName(name);
    }

    @Override
    public boolean deleteExpenseCategory(Long id) {
        return false;
    }

    @Override
    public ExpenseSubCategoryResponse findAllSubCategory(Long categoryId) {
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Expense category not available."));

        final List<ExpenseSubCategoryDto> subCategoryList = expenseSubCategoryResponseConverter.apply(expenseCategory.getExpenseSubCategoryList());
        ExpenseSubCategoryResponse expenseSubCategoryResponse = new ExpenseSubCategoryResponse();
        expenseSubCategoryResponse.setExpenseCategoryId(expenseCategory.getId());
        expenseSubCategoryResponse.setExpenseCategoryName(expenseCategory.getExpenseCategoryName());
        expenseSubCategoryResponse.setDescription(expenseCategory.getDescription());
        expenseSubCategoryResponse.setExpenseSubCategoryDtoList(subCategoryList);
        return expenseSubCategoryResponse;
    }

    @Override
    public ExpenseSubCategoryDetailsResponse addExpenseSubCategory(ExpenseSubCategoryRequest expenseSubCategoryRequest) {
        Boolean subCategoryExists = expenseSubCategoryRepository.existsByExpenseSubCategoryName(expenseSubCategoryRequest.getExpenseSubCategoryName());


        if (subCategoryExists) {
            throw new InvalidArgumentException("Expense Subcategory already Exists");
        }

        User user = userProfileService.getUser();
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(expenseSubCategoryRequest.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Expense Category Not Found"));
        ExpenseSubCategory expenseSubCategory = new ExpenseSubCategory();

        expenseSubCategory.setExpenseSubCategoryName(expenseSubCategoryRequest.getExpenseSubCategoryName());
        expenseSubCategory.setExpenseCategory(expenseCategory);
        expenseSubCategory.setDescription(expenseSubCategoryRequest.getDescription());
        expenseSubCategory.setCreatedBy(user.getId());
        expenseSubCategory.setUpdatedBy(user.getId());
        ExpenseSubCategory expenseSubCategoryResult = expenseSubCategoryRepository.save(expenseSubCategory);

        ExpenseSubCategoryDetailsResponse expenseSubCategoryDetailsResponse = new ExpenseSubCategoryDetailsResponse();
        expenseSubCategoryDetailsResponse.setExpenseSubCategoryName(expenseSubCategoryResult.getExpenseSubCategoryName());
        expenseSubCategoryDetailsResponse.setExpenseSubCategoryId(expenseSubCategoryResult.getId());
        expenseSubCategoryDetailsResponse.setExpenseCategoryId(expenseSubCategoryResult.getExpenseCategory().getId());
        expenseSubCategoryDetailsResponse.setExpenseCategoryName(expenseSubCategoryResult.getExpenseCategory().getExpenseCategoryName());
        expenseSubCategoryDetailsResponse.setDescription(expenseSubCategoryResult.getDescription());
        return expenseSubCategoryDetailsResponse;

    }

    @Override
    public Boolean isExpenseSubCategoryExists(String name) {
        return expenseSubCategoryRepository.existsByExpenseSubCategoryName(name);
    }


    //Favorite Expense methods
    @Override
    public List<FavoriteExpenseResponse> findAllFavoriteExpense() {
        User user = userProfileService.getUser();

        final List<FavoriteExpense> allFavoriteExpenses = favoriteExpenseRepository.findAllFavoriteExpenseByUserId(user.getId());

        final List<FavoriteExpenseResponse> favoriteExpenseResponses = favoriteExpenseResponseConverter.apply(allFavoriteExpenses);
        return favoriteExpenseResponses;
    }

    @Override
    public List<FavoriteExpenseResponse> findAllFavoriteDailyNeeds() {

        User user = userProfileService.getUser();

        final List<FavoriteExpense> allFavoriteExpenses = favoriteExpenseRepository.findAllFavoriteExpenseByUserIdAndIsDailyNeed(user.getId(), true);

        final List<FavoriteExpenseResponse> favoriteExpenseResponses = favoriteExpenseResponseConverter.apply(allFavoriteExpenses);
        return favoriteExpenseResponses;

    }

    @Override
    public List<FavoriteExpenseResponse> addFavouriteExpense(List<FavoriteExpenseRequest> favoriteExpenseRequests) {
        final User user = userProfileService.getUser();

        final List<FavoriteExpense> existingFavoriteExpenses = favoriteExpenseRepository.findAllFavoriteExpenseByUserId(user.getId());
        for (FavoriteExpenseRequest favoriteExpenseRequest : favoriteExpenseRequests) {

            final ExpenseSubCategory expenseSubCategory = expenseSubCategoryRepository.findById(favoriteExpenseRequest.getExpenseSubCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Expnese Subcategory not found"));
            FavoriteExpense favoriteExpense = new FavoriteExpense();
            favoriteExpense.setExpenseSubCategory(expenseSubCategory);
            favoriteExpense.setIsDailyNeed(favoriteExpenseRequest.getIsDailyNeed());
            favoriteExpense.setUserId(user.getId());

            Boolean favoriteExist = isFavoriteExist(favoriteExpense,
                    existingFavoriteExpenses,
                    user.getId());

            if (!favoriteExist) {
                favoriteExpenseRepository.save(favoriteExpense);
            }

        }

        final List<FavoriteExpense> favoriteExpenses = favoriteExpenseRepository.findAllFavoriteExpenseByUserId(user.getId());
        List<FavoriteExpenseResponse> favoriteExpenseResponses = favoriteExpenseResponseConverter.apply(favoriteExpenses);
        return favoriteExpenseResponses;


    }

    private Boolean isFavoriteExist(FavoriteExpense favoriteExpense, List<FavoriteExpense> existingFavoriteExpenses, Long userId) {
        for (FavoriteExpense expense : existingFavoriteExpenses) {

            if ((expense.getExpenseSubCategory().getId() == favoriteExpense.getExpenseSubCategory().getId() && expense.getUserId() == userId)) {
                return true;
            }
        }
        return false;
    }


}
