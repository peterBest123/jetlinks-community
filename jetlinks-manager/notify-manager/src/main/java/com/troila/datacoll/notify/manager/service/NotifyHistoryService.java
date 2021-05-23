package com.troila.datacoll.notify.manager.service;

import com.troila.datacoll.gateway.annotation.Subscribe;
import com.troila.datacoll.notify.event.SerializableNotifierEvent;
import org.hswebframework.web.crud.service.GenericReactiveCrudService;
import com.troila.datacoll.notify.manager.entity.NotifyHistoryEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
public class NotifyHistoryService extends GenericReactiveCrudService<NotifyHistoryEntity, String> {


    @Subscribe("/notify/**")
    @Transactional(propagation = Propagation.NEVER)
    public Mono<Void> handleNotify(SerializableNotifierEvent event) {
        return insert(Mono.just(NotifyHistoryEntity.of(event))).then();
    }

}
