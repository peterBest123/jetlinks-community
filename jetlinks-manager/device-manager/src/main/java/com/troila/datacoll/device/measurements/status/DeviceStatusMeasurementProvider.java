package com.troila.datacoll.device.measurements.status;

import com.troila.datacoll.dashboard.supports.StaticMeasurementProvider;
import com.troila.datacoll.gateway.annotation.Subscribe;
import com.troila.datacoll.micrometer.MeterRegistryManager;
import com.troila.datacoll.timeseries.TimeSeriesManager;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.jetlinks.core.event.EventBus;
import org.jetlinks.core.message.DeviceMessage;
import com.troila.datacoll.device.measurements.DeviceDashboardDefinition;
import com.troila.datacoll.device.measurements.DeviceObjectDefinition;
import com.troila.datacoll.device.service.LocalDeviceInstanceService;
import com.troila.datacoll.device.timeseries.DeviceTimeSeriesMetric;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Function;

@Component
public class DeviceStatusMeasurementProvider extends StaticMeasurementProvider {

    private MeterRegistry registry;

    Map<String, LongAdder> productCounts = new ConcurrentHashMap<>();

    Function<String, LongAdder> counterAdder = productId ->
        productCounts.computeIfAbsent(productId, __id -> {
            LongAdder adder = new LongAdder();
            Gauge.builder("online-count", adder, LongAdder::sum)
                .tag("productId", __id)
                .register(registry);
            return adder;
        });

    public DeviceStatusMeasurementProvider(MeterRegistryManager registryManager,
                                           LocalDeviceInstanceService instanceService,
                                           TimeSeriesManager timeSeriesManager,
                                           EventBus eventBus) {
        super(DeviceDashboardDefinition.instance, DeviceObjectDefinition.status);

        addMeasurement(new DeviceStatusChangeMeasurement(timeSeriesManager, eventBus));

        addMeasurement(new DeviceStatusRecordMeasurement(instanceService, timeSeriesManager));

        registry = registryManager.getMeterRegister(DeviceTimeSeriesMetric.deviceMetrics().getId(),
            "target", "msgType", "productId");
    }

    @Subscribe("/device/*/*/online")
    public Mono<Void> incrementOnline(DeviceMessage msg){
        return Mono.fromRunnable(()->{
            String productId = parseProductId(msg);
            counterAdder.apply(productId).increment();
            registry
                .counter("online", "productId", productId)
                .increment();
        });
    }

    @Subscribe("/device/*/*/offline")
    public Mono<Void> incrementOffline(DeviceMessage msg){
        return Mono.fromRunnable(()->{
            String productId = parseProductId(msg);
           // counterAdder.apply(productId).decrement();
            registry
                .counter("offline", "productId", productId)
                .increment();
        });
    }

    private String parseProductId(DeviceMessage msg) {
        return msg
            .getHeader("productId")
            .map(String::valueOf)
            .orElse("unknown");
    }
}
