package com.appkode.house.services;

import com.appkode.house.converter.income.IncomeResponseConverter;
import com.appkode.house.entity.Income;
import com.appkode.house.entity.IncomeSource;
import com.appkode.house.entity.User;
import com.appkode.house.error.exception.ResourceNotFoundException;
import com.appkode.house.model.request.generic.SearchByDateRequest;
import com.appkode.house.model.request.income.IncomeRequest;
import com.appkode.house.model.response.income.IncomeResponse;
import com.appkode.house.repository.IncomeRepository;
import com.appkode.house.repository.IncomeSourceRepository;
import com.appkode.house.utils.UtilFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {


    private final IncomeRepository incomeRepository;
    private final IncomeSourceRepository incomeSourceRepository;
    private final UserProfileService userProfileService;
    private final IncomeResponseConverter incomeResponseConverter;


    @Autowired
    public IncomeServiceImpl(IncomeRepository incomeRepository, IncomeSourceRepository incomeSourceRepository, UserProfileService userProfileService, IncomeResponseConverter incomeResponseConverter) {
        this.incomeRepository = incomeRepository;
        this.incomeSourceRepository = incomeSourceRepository;
        this.userProfileService = userProfileService;
        this.incomeResponseConverter = incomeResponseConverter;
    }

    @Override
    public List<IncomeResponse> findAllMyIncome() {

        final User user = userProfileService.getUser();

        List<Income> allIncomeByUserId = incomeRepository.findAllIncomeByUserId(user.getId());

        return null;
    }


    @Override
    public Double getTotalIncomeByMonth(SearchByDateRequest searchByDateRequest) {
        Double totalAmount = 0.0;
        final User user = userProfileService.getUser();
        List<Income> allIncomeByUserId = incomeRepository.findAllIncomeByUserIdAndCreditDateBetween(user.getId(), UtilFunction.startDateOfMonth(searchByDateRequest.getSearchDate()), UtilFunction.endDateOfMonth(searchByDateRequest.getSearchDate()));
        for (Income income : allIncomeByUserId) {
            totalAmount += income.getAmount();
        }

        return totalAmount;
    }

    @Override
    public List<IncomeResponse> findAllMyIncomeByMonth(SearchByDateRequest searchByDateRequest) {
        final User user = userProfileService.getUser();

        System.out.println(UtilFunction.startDateOfMonth(searchByDateRequest.getSearchDate()) + " , " + UtilFunction.endDateOfMonth(searchByDateRequest.getSearchDate()));
        List<Income> allIncomeByUserId = incomeRepository.findAllIncomeByUserIdAndCreditDateBetween(user.getId(), UtilFunction.startDateOfMonth(searchByDateRequest.getSearchDate()), UtilFunction.endDateOfMonth(searchByDateRequest.getSearchDate()));
        List<IncomeResponse> incomeResponseList = new ArrayList<>();
        for (Income income : allIncomeByUserId) {

            IncomeResponse incomeResponseTemp = incomeResponseConverter.apply(income);
            incomeResponseList.add(incomeResponseTemp);

        }
        return incomeResponseList;
    }

    @Override
    public IncomeResponse addIncome(IncomeRequest incomeRequest) {
        final User user = userProfileService.getUser();

        IncomeSource incomeSource = incomeSourceRepository.findById(incomeRequest.getIncomeSourceId()).orElseThrow(() -> new ResourceNotFoundException("Income Category not found"));


        Income income = new Income();
        income.setIncomeSource(incomeSource);
        income.setAmount(incomeRequest.getAmount());
        income.setCreditDate(UtilFunction.dateFromString1(incomeRequest.getCreditDate()));
        income.setComment(incomeRequest.getComment());
        income.setIsConsiderAsHouseIncome(incomeRequest.getIsConsiderAsHouseIncome());
        income.setCreatedBy(user.getId());
        income.setMode(incomeRequest.getMode());
        income.setUpdatedBy(user.getId());
        income.setUserId(user.getId());

        final Income incomeTemp = incomeRepository.save(income);


        final IncomeResponse incomeResponse = incomeResponseConverter.apply(incomeTemp);

        return incomeResponse;
    }

    @Override
    public boolean deleteIncome(Long incomeId) {
        Income income = incomeRepository.findById(incomeId).orElseThrow(() -> new ResourceNotFoundException("Income Id not found"));
        incomeRepository.delete(income);
        return true;
    }
}
