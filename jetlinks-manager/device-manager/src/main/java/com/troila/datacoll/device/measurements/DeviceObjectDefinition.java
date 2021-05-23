package com.troila.datacoll.device.measurements;

import com.troila.datacoll.dashboard.ObjectDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeviceObjectDefinition implements ObjectDefinition {
    status("设备状态"),
    message("设备消息");

    @Override
    public String getId() {
        return name();
    }

    private String name;
}
