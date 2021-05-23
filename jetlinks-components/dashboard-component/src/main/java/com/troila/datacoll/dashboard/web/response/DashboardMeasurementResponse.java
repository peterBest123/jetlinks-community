package com.troila.datacoll.dashboard.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.troila.datacoll.dashboard.MeasurementValue;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class DashboardMeasurementResponse {

    private String group;

    private MeasurementValue data;


}
