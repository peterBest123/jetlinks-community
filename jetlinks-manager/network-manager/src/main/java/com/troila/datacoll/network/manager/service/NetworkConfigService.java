package com.troila.datacoll.network.manager.service;

import com.troila.datacoll.network.NetworkConfigManager;
import com.troila.datacoll.network.NetworkProperties;
import com.troila.datacoll.network.NetworkType;
import org.hswebframework.ezorm.rdb.mapping.defaults.SaveResult;
import org.hswebframework.web.crud.service.GenericReactiveCrudService;
import com.troila.datacoll.network.manager.enums.NetworkConfigState;
import com.troila.datacoll.network.manager.entity.NetworkConfigEntity;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author zhouhao
 * @since 1.0
 **/
@Service
public class NetworkConfigService extends GenericReactiveCrudService<NetworkConfigEntity, String> implements NetworkConfigManager {

    @Override
    public Mono<NetworkProperties> getConfig(NetworkType networkType, String id) {
        return findById(id)
                .map(NetworkConfigEntity::toNetworkProperties);
    }

    @Override
    public Mono<SaveResult> save(Publisher<NetworkConfigEntity> entityPublisher) {
        return super.save(
            Flux.from(entityPublisher)
                .doOnNext(entity -> {
                    if (StringUtils.isEmpty(entity.getId())) {
                        entity.setState(NetworkConfigState.disabled);
                    } else {
                        entity.setState(null);
                    }
                }));
    }

    @Override
    public Mono<Integer> insert(Publisher<NetworkConfigEntity> entityPublisher) {
        return super.insert(
                Flux.from(entityPublisher)
                        .doOnNext(entity -> entity.setState(NetworkConfigState.disabled)));
    }
}
