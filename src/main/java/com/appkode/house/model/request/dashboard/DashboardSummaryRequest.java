package com.appkode.house.model.request.dashboard;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardSummaryRequest {

    @Pattern(regexp = "^[0-9\\s]+$")
    @Size(min = 1, max = 2)
    private Long month;

    @Pattern(regexp = "^[0-9\\s]+$")
    @Size(min = 4, max = 4)
    private Long year;


}
