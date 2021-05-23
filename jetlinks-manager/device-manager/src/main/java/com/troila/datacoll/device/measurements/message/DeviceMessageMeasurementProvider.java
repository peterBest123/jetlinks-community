package com.troila.datacoll.device.measurements.message;

import com.troila.datacoll.dashboard.supports.StaticMeasurementProvider;
import com.troila.datacoll.gateway.annotation.Subscribe;
import com.troila.datacoll.micrometer.MeterRegistryManager;
import com.troila.datacoll.timeseries.TimeSeriesManager;
import io.micrometer.core.instrument.MeterRegistry;
import org.jetlinks.core.device.DeviceRegistry;
import org.jetlinks.core.event.EventBus;
import org.jetlinks.core.message.DeviceMessage;
import com.troila.datacoll.device.measurements.DeviceDashboardDefinition;
import com.troila.datacoll.device.measurements.DeviceObjectDefinition;
import com.troila.datacoll.device.timeseries.DeviceTimeSeriesMetric;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeviceMessageMeasurementProvider extends StaticMeasurementProvider {

    MeterRegistry registry;

    public DeviceMessageMeasurementProvider(EventBus eventBus,
                                            MeterRegistryManager registryManager,
                                            DeviceRegistry deviceRegistry,
                                            TimeSeriesManager timeSeriesManager) {
        super(DeviceDashboardDefinition.instance, DeviceObjectDefinition.message);

        registry = registryManager.getMeterRegister(DeviceTimeSeriesMetric.deviceMetrics().getId(),
            "target", "msgType", "productId");

        addMeasurement(new DeviceMessageMeasurement(eventBus, deviceRegistry, timeSeriesManager));

    }

    @Subscribe("/device/*/*/message/**")
    public Mono<Void> incrementMessage(DeviceMessage message) {
        return Mono.fromRunnable(() -> {
            registry
                .counter("message-count", convertTags(message))
                .increment();
        });
    }

    static final String[] empty = new String[0];

    private String[] convertTags(DeviceMessage message) {
        if (message == null) {
            return empty;
        }
        return new String[]{
            "productId", message.getHeader("productId").map(String::valueOf).orElse("unknown")
        };
    }
}
