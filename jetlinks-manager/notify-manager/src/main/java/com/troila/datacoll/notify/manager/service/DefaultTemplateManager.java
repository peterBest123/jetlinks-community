package com.troila.datacoll.notify.manager.service;

import com.troila.datacoll.notify.NotifyType;
import com.troila.datacoll.notify.template.AbstractTemplateManager;
import com.troila.datacoll.notify.template.TemplateProperties;
import com.troila.datacoll.notify.template.TemplateProvider;
import lombok.extern.slf4j.Slf4j;
import com.troila.datacoll.notify.manager.entity.NotifyTemplateEntity;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class DefaultTemplateManager extends AbstractTemplateManager implements BeanPostProcessor {

    @Autowired
    private NotifyTemplateService templateService;

    @Override
    protected Mono<TemplateProperties> getProperties(NotifyType type, String id) {
        return templateService.findById(Mono.just(id))
                .map(NotifyTemplateEntity::toTemplateProperties);
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof TemplateProvider) {
            register(((TemplateProvider) bean));
        }
        return bean;
    }

}
