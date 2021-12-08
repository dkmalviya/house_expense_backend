package com.appkode.house.services;

import com.appkode.house.model.request.dashboard.DashboardSummaryRequest;
import com.appkode.house.model.request.house_member.AddHouseMemberRequest;
import com.appkode.house.model.request.house_member.HouseMemberRequest;
import com.appkode.house.model.request.house_member.HouseMemberSearchRequest;
import com.appkode.house.model.response.house_member.HouseMemberResponse;

public interface DashboardSummaryService {

    HouseMemberResponse getDashboardSummaryByMonthAndYear(DashboardSummaryRequest dashboardSummaryRequest);

}
