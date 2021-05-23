package com.troila.datacoll.dashboard.web.response;

import lombok.Getter;
import lombok.Setter;
import org.jetlinks.core.metadata.ConfigMetadata;
import org.jetlinks.core.metadata.DataType;
import com.troila.datacoll.dashboard.MeasurementDimension;

@Getter
@Setter
public class DimensionInfo {
    private String id;

    private String name;

    private DataType type;

    private ConfigMetadata params;

    private boolean realTime;

    public static DimensionInfo of(MeasurementDimension dimension) {
        DimensionInfo dimensionInfo = new DimensionInfo();
        dimensionInfo.setId(dimension.getDefinition().getId());
        dimensionInfo.setName(dimension.getDefinition().getName());
        dimensionInfo.setParams(dimension.getParams());
        dimensionInfo.setType(dimension.getValueType());
        dimensionInfo.setRealTime(dimension.isRealTime());
        return dimensionInfo;
    }
}
