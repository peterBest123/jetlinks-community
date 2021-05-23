package com.troila.datacoll.dashboard;

import com.troila.datacoll.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class MeasurementParameter implements ValueObject {
    private Map<String, Object> params = new HashMap<>();

    public Optional<Object> get(String name) {
        return Optional.ofNullable(params).map(p -> p.get(name));
    }

    @Override
    public Map<String, Object> values() {
        return params;
    }
}
