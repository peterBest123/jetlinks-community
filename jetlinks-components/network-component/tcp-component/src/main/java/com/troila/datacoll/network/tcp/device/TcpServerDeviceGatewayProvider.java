package com.troila.datacoll.network.tcp.device;

import com.troila.datacoll.gateway.DeviceGateway;
import com.troila.datacoll.gateway.supports.DeviceGatewayProperties;
import com.troila.datacoll.gateway.supports.DeviceGatewayProvider;
import com.troila.datacoll.network.tcp.server.TcpServer;
import org.jetlinks.core.ProtocolSupports;
import org.jetlinks.core.device.DeviceRegistry;
import org.jetlinks.core.server.session.DeviceSessionManager;
import com.troila.datacoll.network.DefaultNetworkType;
import com.troila.datacoll.network.NetworkManager;
import com.troila.datacoll.network.NetworkType;
import org.jetlinks.supports.server.DecodedClientMessageHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import reactor.core.publisher.Mono;

@Component
public class TcpServerDeviceGatewayProvider implements DeviceGatewayProvider {

    private final NetworkManager networkManager;

    private final DeviceRegistry registry;

    private final DeviceSessionManager sessionManager;

    private final DecodedClientMessageHandler messageHandler;

    private final ProtocolSupports protocolSupports;


    public TcpServerDeviceGatewayProvider(NetworkManager networkManager,
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
        return "tcp-server-gateway";
    }

    @Override
    public String getName() {
        return "TCP 透传接入";
    }

    @Override
    public NetworkType getNetworkType() {
        return DefaultNetworkType.TCP_SERVER;
    }

    @Override
    public Mono<DeviceGateway> createDeviceGateway(DeviceGatewayProperties properties) {
        return networkManager
            .<TcpServer>getNetwork(getNetworkType(), properties.getNetworkId())
            .map(mqttServer -> {
                String protocol = (String) properties.getConfiguration().get("protocol");

                Assert.hasText(protocol,"protocol can not be empty");

               return new TcpServerDeviceGateway(properties.getId(),
                    protocol,
                    protocolSupports,
                    registry,
                    messageHandler,
                    sessionManager,
                    mqttServer
                );
            });
    }
}