package com.troila.datacoll.device.measurements;

import com.troila.datacoll.dashboard.MeasurementDefinition;
import lombok.AllArgsConstructor;
import org.jetlinks.core.metadata.Metadata;

@AllArgsConstructor(staticName = "of")
public class MetadataMeasurementDefinition implements MeasurementDefinition {

    Metadata metadata;

    @Override
    public String getId() {
        return metadata.getId();
    }

    @Override
    public String getName() {
        return metadata.getName();
    }
}
