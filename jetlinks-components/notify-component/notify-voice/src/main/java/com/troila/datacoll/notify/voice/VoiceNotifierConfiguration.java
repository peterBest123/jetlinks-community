package com.troila.datacoll.notify.voice;

import com.troila.datacoll.notify.voice.aliyun.AliyunNotifierProvider;
import com.troila.datacoll.notify.template.TemplateManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VoiceNotifierConfiguration {


    @Bean
    @ConditionalOnBean(TemplateManager.class)
    public AliyunNotifierProvider aliyunNotifierProvider(TemplateManager templateManager) {
        return new AliyunNotifierProvider(templateManager);
    }

}
