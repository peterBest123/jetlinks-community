package com.troila.datacoll.gateway.monitor.measurements;

import com.troila.datacoll.timeseries.TimeSeriesManager;
import com.troila.datacoll.timeseries.query.Aggregation;
import com.troila.datacoll.dashboard.supports.StaticMeasurementProvider;
import org.springframework.stereotype.Component;

import static com.troila.datacoll.dashboard.MeasurementDefinition.*;

@Component
public class DeviceGatewayMeasurementProvider extends StaticMeasurementProvider {

    public DeviceGatewayMeasurementProvider(TimeSeriesManager timeSeriesManager) {
        super(GatewayDashboardDefinition.gatewayMonitor, GatewayObjectDefinition.deviceGateway);

        addMeasurement(new DeviceGatewayMeasurement(of("connection", "连接数"), "value", Aggregation.MAX, timeSeriesManager));

        addMeasurement(new DeviceGatewayMeasurement(of("connected", "创建连接数"), "count", Aggregation.SUM, timeSeriesManager));
        addMeasurement(new DeviceGatewayMeasurement(of("rejected", "拒绝连接数"), "count", Aggregation.SUM, timeSeriesManager));
        addMeasurement(new DeviceGatewayMeasurement(of("disconnected", "断开连接数"), "count", Aggregation.SUM, timeSeriesManager));
        addMeasurement(new DeviceGatewayMeasurement(of("received_message", "接收消息数"), "count", Aggregation.SUM, timeSeriesManager));
        addMeasurement(new DeviceGatewayMeasurement(of("sent_message", "发送消息数"), "count", Aggregation.SUM, timeSeriesManager));
    }
}
