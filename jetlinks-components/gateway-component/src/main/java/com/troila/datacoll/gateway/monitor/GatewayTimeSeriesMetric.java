package com.troila.datacoll.gateway.monitor;

import com.troila.datacoll.timeseries.TimeSeriesMetric;

public interface GatewayTimeSeriesMetric {

    String deviceGatewayMetric = "device_gateway_monitor";

    static TimeSeriesMetric deviceGatewayMetric(){
        return TimeSeriesMetric.of(deviceGatewayMetric);
    }
}
