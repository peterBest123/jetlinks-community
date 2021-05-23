package com.troila.datacoll.notify.manager.service;

import org.hswebframework.web.crud.service.GenericReactiveCacheSupportCrudService;
import com.troila.datacoll.notify.manager.entity.NotifyConfigEntity;
import org.springframework.stereotype.Service;

@Service
public class NotifyConfigService extends GenericReactiveCacheSupportCrudService<NotifyConfigEntity, String> {

    @Override
    public String getCacheName() {
        return "notify_config";
    }
}
