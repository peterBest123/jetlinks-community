package com.troila.datacoll.notify.manager.subscriber;

import reactor.core.publisher.Flux;

public interface Subscriber {

    Flux<Notify> subscribe();
}
