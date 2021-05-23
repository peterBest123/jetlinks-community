package com.troila.datacoll.gateway;

import com.troila.datacoll.gateway.supports.DeviceGatewayProvider;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DeviceGatewayManager {

    Mono<DeviceGateway> getGateway(String id);

    Mono<Void> shutdown(String gatewayId);

    List<DeviceGatewayProvider> getProviders();
}
