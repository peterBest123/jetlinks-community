package com.troila.datacoll.gateway.monitor.measurements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.troila.datacoll.dashboard.DashboardDefinition;

@AllArgsConstructor
@Getter
public enum  GatewayDashboardDefinition implements DashboardDefinition {
    gatewayMonitor("网关监控")

    ;

    private String name;

    @Override
    public String getId() {
        return name();
    }
}
