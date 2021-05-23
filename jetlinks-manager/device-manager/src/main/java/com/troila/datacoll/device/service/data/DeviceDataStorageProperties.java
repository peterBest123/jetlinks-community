package com.troila.datacoll.device.service.data;

import com.troila.datacoll.utils.MessageTypeMatcher;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jetlinks.device.storage")
@Getter
@Setter
public class DeviceDataStorageProperties {

    //默认数据存储策略,每个属性为一行数据
    private String defaultPolicy = "default-row";

    private Log log = new Log();

    @Getter
    @Setter
    public static class Log extends MessageTypeMatcher {

    }


}
