package com.troila.datacoll.network.mqtt.gateway.device;

import com.troila.datacoll.gateway.DeviceGateway;
import com.troila.datacoll.gateway.supports.DeviceGatewayProperties;
import com.troila.datacoll.gateway.supports.DeviceGatewayProvider;
import com.troila.datacoll.network.DefaultNetworkType;
import com.troila.datacoll.network.NetworkManager;
import com.troila.datacoll.network.NetworkType;
import org.jetlinks.core.ProtocolSupports;
import org.jetlinks.core.device.DeviceRegistry;
import org.jetlinks.core.server.session.DeviceSessionManager;
import com.troila.datacoll.network.mqtt.server.MqttServer;
import org.jetlinks.supports.server.DecodedClientMessageHandler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MqttServerDeviceGatewayProvider implements DeviceGatewayProvider {

    private final NetworkManager networkManager;

    private final DeviceRegistry registry;

    private final DeviceSessionManager sessionManager;

    private final DecodedClientMessageHandler messageHandler;

    private final ProtocolSupports protocolSupports;

    public MqttServerDeviceGatewayProvider(NetworkManager networkManager,
                                           DeviceRegistry registry,
                                           DeviceSessionManager sessionManager,
                                           DecodedClientMessageHandler messageHandler,
                                           ProtocolSupports protocolSupports) {
        this.networkManager = networkManager;
        this.registry = registry;
        this.sessionManager = sessionManager;
        this.messageHandler = messageHandler;
        this.protocolSupports = protocolSupports;
    }

    @Override
    public String getId() {
        return "mqtt-server-gateway";
    }

    @Override
    public String getName() {
        return "MQTT直连接入";
    }

    @Override
    public NetworkType getNetworkType() {
        return DefaultNetworkType.MQTT_SERVER;
    }

    @Override
    public Mono<DeviceGateway> createDeviceGateway(DeviceGatewayProperties properties) {

        return networkManager
            .<MqttServer>getNetwork(getNetworkType(), properties.getNetworkId())
            .map(mqttServer -> new MqttServerDeviceGateway(
                properties.getId(),
                registry,
                sessionManager,
                mqttServer,
                messageHandler,
                properties.getString("protocol")
                    .map(id -> Mono.defer(() -> protocolSupports.getProtocol(id)))
                    .orElse(Mono.empty())
            ));
    }
}
