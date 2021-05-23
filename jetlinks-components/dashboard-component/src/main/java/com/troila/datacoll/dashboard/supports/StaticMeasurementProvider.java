package com.troila.datacoll.dashboard.supports;

import lombok.Getter;
import com.troila.datacoll.dashboard.DashboardDefinition;
import com.troila.datacoll.dashboard.Measurement;
import com.troila.datacoll.dashboard.ObjectDefinition;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class StaticMeasurementProvider implements MeasurementProvider {

    private Map<String, Measurement> measurements = new ConcurrentHashMap<>();

    @Getter
    private DashboardDefinition dashboardDefinition;
    @Getter
    private ObjectDefinition objectDefinition;

    public StaticMeasurementProvider(DashboardDefinition dashboardDefinition,
                                     ObjectDefinition objectDefinition) {
        this.dashboardDefinition = dashboardDefinition;
        this.objectDefinition = objectDefinition;
    }

    protected void addMeasurement(Measurement measurement) {
        measurements.put(measurement.getDefinition().getId(), measurement);
    }

    @Override
    public Flux<Measurement> getMeasurements() {
        return Flux.fromIterable(measurements.values());
    }

    @Override
    public Mono<Measurement> getMeasurement(String id) {
        return Mono.justOrEmpty(measurements.get(id));
    }
}
