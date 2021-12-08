package com.appkode.house.services;


import com.appkode.house.converter.expense.ExpenseResponseConverter;
import com.appkode.house.entity.Expense;
import com.appkode.house.entity.ExpenseSubCategory;
import com.appkode.house.entity.HouseMember;
import com.appkode.house.entity.User;
import com.appkode.house.error.exception.ResourceNotFoundException;
import com.appkode.house.model.request.expense.ExpenseRequest;
import com.appkode.house.model.request.generic.SearchByDateRequest;
import com.appkode.house.model.response.expense.ExpenseResponse;
import com.appkode.house.repository.ExpenseRepository;
import com.appkode.house.repository.ExpenseSubCategoryRepository;
import com.appkode.house.repository.HouseMemberRepository;
import com.appkode.house.utils.UtilFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseSubCategoryRepository expenseSubCategoryRepository;
    private final UserProfileService userProfileService;
    private final ExpenseResponseConverter expenseResponseConverter;
    private final HouseMemberRepository houseMemberRepository;


    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, ExpenseSubCategoryRepository expenseSubCategoryRepository, UserProfileService userProfileService, ExpenseResponseConverter expenseResponseConverter, HouseMemberRepository houseMemberRepository) {
        this.expenseRepository = expenseRepository;
        this.expenseSubCategoryRepository = expenseSubCategoryRepository;
        this.userProfileService = userProfileService;
        this.expenseResponseConverter = expenseResponseConverter;
        this.houseMemberRepository = houseMemberRepository;
    }

    @Override
    public Double getTotalExpenseByMonth(SearchByDateRequest searchByDateRequest) {
        Double totalAmount = 0.0;
        final User user = userProfileService.getUser();
        List<Expense> allExpenses = expenseRepository.findAllExpenseByUserIdAndIsDeletedAndExpenseDateBetween(user.getId(), false, UtilFunction.startDateOfMonth(searchByDateRequest.getSearchDate()), UtilFunction.endDateOfMonth(searchByDateRequest.getSearchDate()));
        for (Expense expense : allExpenses) {
            totalAmount += expense.getAmount();
        }

        return totalAmount;
    }

    @Override
    public List<ExpenseResponse> findAllMyExpenseByMonth(SearchByDateRequest searchByDateRequest) {

        final User user = userProfileService.getUser();

        System.out.println(UtilFunction.startDateOfMonth(searchByDateRequest.getSearchDate()) + " , " + UtilFunction.endDateOfMonth(searchByDateRequest.getSearchDate()));
        List<Expense> allExpenses = expenseRepository.findAllExpenseByUserIdAndIsDeletedAndExpenseDateBetween(user.getId(), false, UtilFunction.startDateOfMonth(searchByDateRequest.getSearchDate()), UtilFunction.endDateOfMonth(searchByDateRequest.getSearchDate()));
        List<ExpenseResponse> expenseResponseList = new ArrayList<>();
        for (Expense expense : allExpenses) {
            ExpenseResponse expenseResponseTemp = expenseResponseConverter.apply(expense);

            String userName=userProfileService.getUserName(expense.getUserId());
            System.out.println("UserName"+userName);
            expenseResponseTemp.setCreatedBy(userName);
            expenseResponseTemp.setCreatedById(expense.getUserId());
            expenseResponseList.add(expenseResponseTemp);
        }
        return expenseResponseList;

    }

    @Override
    public List<ExpenseResponse> findAllHouseExpenseByMonth(SearchByDateRequest searchByDateRequest) {

        final User user = userProfileService.getUser();

        final Long houseIdByUserId = houseMemberRepository.findHouseIdByUserId(user.getId());

        final List<Long> ids = houseMemberRepository.findAllActiveUserIdsByHouseId(houseIdByUserId);


        System.out.println("ids"+ids.toString());

        System.out.println(UtilFunction.startDateOfMonth(searchByDateRequest.getSearchDate()) + " , " + UtilFunction.endDateOfMonth(searchByDateRequest.getSearchDate()));
        List<Expense> allExpenses = expenseRepository.findAllExpenseByIsDeletedAndExpenseDateBetweenAndUserIdIn(false, UtilFunction.startDateOfMonth(searchByDateRequest.getSearchDate()), UtilFunction.endDateOfMonth(searchByDateRequest.getSearchDate()),ids);
        List<ExpenseResponse> expenseResponseList = new ArrayList<>();
        for (Expense expense : allExpenses) {
            ExpenseResponse expenseResponseTemp = expenseResponseConverter.apply(expense);
            String userName=userProfileService.getUserName(expense.getUserId());
            System.out.println("UserName"+userName);
            expenseResponseTemp.setCreatedBy(userName);
            expenseResponseTemp.setCreatedById(expense.getUserId());
            expenseResponseList.add(expenseResponseTemp);
        }
        return expenseResponseList;

    }

    @Override
    public ExpenseResponse addExpense(ExpenseRequest expenseRequest) {
        final User user = userProfileService.getUser();

        ExpenseSubCategory expenseSubCategory = expenseSubCategoryRepository.findById(expenseRequest.getExpenseSubCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Expense Category not found"));

        Expense expense = new Expense();
        expense.setExpenseSubCategory(expenseSubCategory);
        expense.setAmount(expenseRequest.getAmount());
        expense.setExpenseDate(UtilFunction.dateFromString1(expenseRequest.getExpenseDate()));
        expense.setComment(expenseRequest.getComment());
        expense.setExpenseType(expenseRequest.getExpenseType());
        expense.setExpenseName(expenseRequest.getExpenseName());
        expense.setCurrency("INR");
        expense.setExpenseInvoice(expenseRequest.getExpenseInvoice());
        expense.setIsHouseExpense(expenseRequest.getIsHouseExpense());
        expense.setMode(expenseRequest.getMode());
        expense.setIsDeleted(false);
        expense.setUserId(user.getId());
        expense.setCreatedBy(user.getId());
        expense.setUpdatedBy(user.getId());

        final Expense expenseTemp = expenseRepository.save(expense);
        final ExpenseResponse expenseResponse = expenseResponseConverter.apply(expenseTemp);

        return expenseResponse;
    }

    @Override
    public boolean deleteExpense(Long expenseId) {
        final User user = userProfileService.getUser();
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new ResourceNotFoundException("Expense Id not found"));
        expense.setIsDeleted(true);
        expense.setUpdatedBy(user.getId());
        expenseRepository.save(expense);
        return true;
    }
}
