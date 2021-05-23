package com.troila.datacoll.device.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.troila.datacoll.device.enums.DeviceState;

/**
 * @author bsetfeng
 * @since 1.0
 **/
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
public class DeviceRunInfo {

    private long onlineTime;

    private long offlineTime;

    //设备状态
    private DeviceState state;

    private String metadata;

    //设备型号ID
    private String productId;
}
