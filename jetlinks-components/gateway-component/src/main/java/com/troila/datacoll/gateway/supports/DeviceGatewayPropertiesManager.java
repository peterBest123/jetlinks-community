package com.troila.datacoll.gateway.supports;

import reactor.core.publisher.Mono;

public interface DeviceGatewayPropertiesManager {

    Mono<DeviceGatewayProperties> getProperties(String id);


}
