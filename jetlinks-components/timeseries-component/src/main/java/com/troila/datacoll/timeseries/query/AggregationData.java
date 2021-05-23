package com.troila.datacoll.timeseries.query;


import com.troila.datacoll.ValueObject;

import java.util.Map;
import java.util.Optional;

public interface AggregationData extends ValueObject {

    Map<String, Object> asMap();

    @Override
    default Optional<Object> get(String name) {
        return Optional.ofNullable(asMap().get(name));
    }

    @Override
    default Map<String, Object> values() {
        return asMap();
    }

    static AggregationData of(Map<String, Object> map) {
        return () -> map;
    }
}
