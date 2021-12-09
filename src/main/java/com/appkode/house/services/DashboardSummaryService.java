package com.appkode.house.services;

import com.appkode.house.model.request.dashboard.DashboardSummaryRequest;
import com.appkode.house.model.response.house_member.HouseMemberResponse;

public interface DashboardSummaryService {

    HouseMemberResponse getDashboardSummaryByMonthAndYear(DashboardSummaryRequest dashboardSummaryRequest);

}
