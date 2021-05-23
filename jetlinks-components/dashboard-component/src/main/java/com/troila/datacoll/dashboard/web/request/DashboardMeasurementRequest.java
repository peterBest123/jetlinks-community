package com.troila.datacoll.dashboard.web.request;

import com.troila.datacoll.dashboard.web.response.DashboardMeasurementResponse;
import lombok.Getter;
import lombok.Setter;
import com.troila.datacoll.dashboard.Dashboard;
import com.troila.datacoll.dashboard.DashboardDefinition;
import com.troila.datacoll.dashboard.DimensionDefinition;
import com.troila.datacoll.dashboard.MeasurementDefinition;

import java.util.Map;

/**
 * 仪表盘指标数据请求
 *
 * @author zhouhao
 * @since 1.0
 */
@Getter
@Setter
public class DashboardMeasurementRequest {

    /**
     * 分组
     * @see DashboardMeasurementResponse#getGroup()
     */
    private String group;

    /**
     * 仪表盘,如: device
     * @see Dashboard#getDefinition()
     */
    private String dashboard;

    /**
     * 仪表对象,如: device1
     * @see  DashboardDefinition#getId()
     */
    private String object;

    /**
     * 指标,如: 属性ID
     * @see  MeasurementDefinition#getId()
     */
    private String measurement;

    /**
     * 维度
     * @see DimensionDefinition#getId()
     */
    private String dimension;

    /**
     * 查询参数
     */
    private Map<String, Object> params;

}
