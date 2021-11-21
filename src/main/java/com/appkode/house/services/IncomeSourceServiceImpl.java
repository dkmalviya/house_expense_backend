package com.appkode.house.services;

import com.appkode.house.converter.income_source.IncomeSourceResponseConverter;
import com.appkode.house.entity.IncomeSource;
import com.appkode.house.entity.User;
import com.appkode.house.error.exception.InvalidArgumentException;
import com.appkode.house.model.request.income_source.IncomeSourceRequest;
import com.appkode.house.model.response.income_source.IncomeSourceResponse;
import com.appkode.house.repository.IncomeSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeSourceServiceImpl implements IncomeSourceService{

    private final IncomeSourceRepository incomeSourceRepository;
    private final IncomeSourceResponseConverter incomeSourceResponseConverter;

    private final  UserProfileService userProfileService;

    @Autowired
    public IncomeSourceServiceImpl(IncomeSourceRepository incomeSourceRepository, IncomeSourceResponseConverter incomeSourceResponseConverter, UserProfileService userProfileService) {
        this.incomeSourceRepository = incomeSourceRepository;
        this.incomeSourceResponseConverter = incomeSourceResponseConverter;
        this.userProfileService = userProfileService;
    }


    @Override
    public List<IncomeSourceResponse> findAllIncomeSource() {
        List<IncomeSourceResponse> incomeSourceResponses=new ArrayList<>();

        Iterable<IncomeSource> incomeSources = incomeSourceRepository.findAll();

        for (IncomeSource incomeSource:incomeSources) {
            IncomeSourceResponse incomeSourceResponseTemp = incomeSourceResponseConverter.apply(incomeSource);
            incomeSourceResponses.add(incomeSourceResponseTemp);
        }
        return incomeSourceResponses;
    }

    @Override
    public IncomeSourceResponse addIncomeSource(IncomeSourceRequest incomeSourceRequest) {
        Boolean incomeSourceExists = isIncomeSourceExists(incomeSourceRequest.getIncomeSourceName());
        if(incomeSourceExists){
            throw new InvalidArgumentException("Income Source already Exists");
        }
        User user = userProfileService.getUser();
        IncomeSource incomeSource=new IncomeSource();
        incomeSource.setIncomeSourceName(incomeSourceRequest.getIncomeSourceName());
        incomeSource.setCreatedBy(user.getId());
        incomeSource.setUpdatedBy(user.getId());
        IncomeSource resultIncomeSource = incomeSourceRepository.save(incomeSource);
        return incomeSourceResponseConverter.apply(resultIncomeSource);
    }

    @Override
    public Boolean isIncomeSourceExists(String name) {
        return incomeSourceRepository.existsByIncomeSourceName(name);
    }

    @Override
    public boolean deleteIncomeSource(Long id) {
        return false;
    }
}
