package com.troila.datacoll.gateway.spring;

import org.jetlinks.core.event.TopicPayload;
import reactor.core.publisher.Mono;

public interface MessageListener {

    Mono<Void> onMessage(TopicPayload message);

}
