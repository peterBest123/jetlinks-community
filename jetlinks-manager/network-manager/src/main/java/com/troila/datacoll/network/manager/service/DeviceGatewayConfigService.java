package com.troila.datacoll.network.manager.service;

import com.troila.datacoll.gateway.supports.DeviceGatewayProperties;
import com.troila.datacoll.gateway.supports.DeviceGatewayPropertiesManager;
import org.hswebframework.web.bean.FastBeanCopier;
import org.hswebframework.web.exception.NotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeviceGatewayConfigService implements DeviceGatewayPropertiesManager {


    private final DeviceGatewayService deviceGatewayService;

    public DeviceGatewayConfigService(DeviceGatewayService deviceGatewayService) {
        this.deviceGatewayService = deviceGatewayService;
    }

    @Override
    public Mono<DeviceGatewayProperties> getProperties(String id) {

        return deviceGatewayService
            .findById(id)
            .switchIfEmpty(Mono.error(()->new NotFoundException("该设备网关不存在")))
            .map(deviceGatewayEntity -> {
                DeviceGatewayProperties properties = new DeviceGatewayProperties();
                FastBeanCopier.copy(deviceGatewayEntity, properties);
                return properties;
            });
    }


}
