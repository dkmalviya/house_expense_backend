package com.appkode.house.model.response.income_source;

import com.appkode.house.model.dto.UserProfileDto;
import com.appkode.house.model.response.house.HouseResponse;
import lombok.Data;

import java.util.List;
@Data
public class IncomeSourceResponse {

    private Long incomeSourceId;
    private String incomeSourceName;
}
