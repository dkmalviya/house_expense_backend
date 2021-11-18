package com.appkode.house.converter.expesne_category;
import com.appkode.house.entity.ExpenseSubCategory;
import com.appkode.house.model.dto.expense.ExpenseSubCategoryDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


@Component
public class ExpenseSubCategoryResponseListConverter implements Function<List<ExpenseSubCategory>, List<ExpenseSubCategoryDto>> {

   /* @Override
    public ExpenseSubCategoryResponse apply(ExpenseCategory expenseCategory) {
        ExpenseSubCategoryResponse expenseCategoryResponse = new ExpenseSubCategoryResponse();
        expenseCategoryResponse.setExpenseCategoryId(expenseCategory.getId());
        expenseCategoryResponse.setExpenseCategoryName(expenseCategory.getExpenseCategoryName());
        expenseCategoryResponse.setDescription(expenseCategory.getDescription());


        expenseCategoryResponse.setExpenseSubCategoryDtoList(expenseCategory.getExpenseSubCategoryList()
                .stream()
                .map(subCategory -> ExpenseSubCategoryDto
                        .builder()
                        .expenseSubCategoryId(subCategory.getId())
                        .expenseSubCategoryName(subCategory.getExpenseSubCategoryName())
                        .description(subCategory.getDescription())
                        .build())
                .collect(Collectors.toList()));
        return expenseCategoryResponse;
    }*/

    @Override
    public List<ExpenseSubCategoryDto> apply(List<ExpenseSubCategory> expenseSubCategories) {
        List<ExpenseSubCategoryDto> expenseSubCategoryDto = new ArrayList<>();
        for (ExpenseSubCategory expenseSubCategoryTemp:expenseSubCategories             ) {
            expenseSubCategoryDto.add(new ExpenseSubCategoryDto(expenseSubCategoryTemp.getId(),expenseSubCategoryTemp.getExpenseSubCategoryName(),expenseSubCategoryTemp.getDescription()));
        }


        return expenseSubCategoryDto;
    }
}
