package com.troila.datacoll.network;

import reactor.core.publisher.Mono;

public interface NetworkConfigManager {

    Mono<NetworkProperties> getConfig(NetworkType networkType, String id);

}
