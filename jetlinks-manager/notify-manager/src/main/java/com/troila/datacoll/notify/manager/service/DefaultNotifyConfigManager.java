package com.troila.datacoll.notify.manager.service;

import com.troila.datacoll.notify.NotifierProperties;
import com.troila.datacoll.notify.NotifyConfigManager;
import com.troila.datacoll.notify.NotifyType;
import com.troila.datacoll.notify.manager.entity.NotifyConfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.Nonnull;

@Service
public class DefaultNotifyConfigManager implements NotifyConfigManager {

    @Autowired
    private NotifyConfigService configService;

    @Nonnull
    @Override
    public Mono<NotifierProperties> getNotifyConfig(@Nonnull NotifyType notifyType, @Nonnull String configId) {
        return configService.findById(configId)
                .map(NotifyConfigEntity::toProperties);
    }
}
