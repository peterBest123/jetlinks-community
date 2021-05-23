package com.troila.datacoll.notify.template;

import org.jetlinks.core.metadata.ConfigMetadata;
import com.troila.datacoll.notify.NotifyType;
import com.troila.datacoll.notify.Provider;
import reactor.core.publisher.Mono;

public interface TemplateProvider {

    NotifyType getType();

    Provider getProvider();

    Mono<? extends Template> createTemplate(TemplateProperties properties);

    default ConfigMetadata getTemplateConfigMetadata() {
        return null;
    }
}
