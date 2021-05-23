package com.troila.datacoll.device.web.request;

import com.troila.datacoll.device.service.data.DeviceDataService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AggRequest {
    private List<DeviceDataService.DevicePropertyAggregation> columns;

    private DeviceDataService.AggregationRequest query;
}