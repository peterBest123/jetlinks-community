package com.troila.datacoll.network.tcp.client;

import com.troila.datacoll.ValueObject;
import com.troila.datacoll.network.tcp.parser.PayloadParserType;
import io.vertx.core.net.NetClientOptions;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TcpClientProperties implements ValueObject {

    private String id;

    private int port;

    private String host;

    private String certId;

    private boolean ssl;

    private PayloadParserType parserType;

    private Map<String, Object> parserConfiguration = new HashMap<>();

    private NetClientOptions options;

    private boolean enabled;

    @Override
    public Map<String, Object> values() {
        return parserConfiguration;
    }
}
