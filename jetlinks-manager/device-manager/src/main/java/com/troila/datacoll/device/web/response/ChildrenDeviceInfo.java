package com.troila.datacoll.device.web.response;

import com.troila.datacoll.device.entity.DeviceInstanceEntity;
import com.troila.datacoll.device.enums.DeviceState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChildrenDeviceInfo {

    private String id;

    private String name;

    private String description;

    private DeviceState state;

    public static ChildrenDeviceInfo of(DeviceInstanceEntity instance){
        ChildrenDeviceInfo deviceInfo=new ChildrenDeviceInfo();
        deviceInfo.setId(instance.getId());
        deviceInfo.setName(instance.getName());
        deviceInfo.setState(instance.getState());
        deviceInfo.setDescription(instance.getDescribe());

        return deviceInfo;
    }
}
