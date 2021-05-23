package com.troila.datacoll.gateway.monitor.measurements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.troila.datacoll.dashboard.ObjectDefinition;

@AllArgsConstructor
@Getter
public enum GatewayObjectDefinition implements ObjectDefinition {
    deviceGateway("设备网关"),

    ;

    private String name;

    @Override
    public String getId() {
        return name();
    }

}
