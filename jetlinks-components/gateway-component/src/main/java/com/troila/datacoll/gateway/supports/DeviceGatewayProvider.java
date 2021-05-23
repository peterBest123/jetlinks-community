package com.troila.datacoll.gateway.supports;

import com.troila.datacoll.gateway.DeviceGateway;
import com.troila.datacoll.network.NetworkType;
import reactor.core.publisher.Mono;

public interface DeviceGatewayProvider {

    String getId();

    String getName();

    NetworkType getNetworkType();

    Mono<DeviceGateway> createDeviceGateway(DeviceGatewayProperties properties);

}
