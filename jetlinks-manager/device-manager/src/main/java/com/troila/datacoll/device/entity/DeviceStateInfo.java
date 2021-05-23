package com.troila.datacoll.device.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.troila.datacoll.device.enums.DeviceState;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class DeviceStateInfo {
    private String deviceId;

    private DeviceState state;
}
