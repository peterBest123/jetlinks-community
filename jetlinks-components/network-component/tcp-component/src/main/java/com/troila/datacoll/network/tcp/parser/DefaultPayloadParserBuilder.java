package com.troila.datacoll.network.tcp.parser;

import com.troila.datacoll.ValueObject;
import com.troila.datacoll.network.tcp.parser.strateies.DelimitedPayloadParserBuilder;
import com.troila.datacoll.network.tcp.parser.strateies.DirectPayloadParserBuilder;
import com.troila.datacoll.network.tcp.parser.strateies.FixLengthPayloadParserBuilder;
import com.troila.datacoll.network.tcp.parser.strateies.ScriptPayloadParserBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DefaultPayloadParserBuilder implements PayloadParserBuilder, BeanPostProcessor {

    private Map<PayloadParserType, PayloadParserBuilderStrategy> strategyMap = new ConcurrentHashMap<>();

    public DefaultPayloadParserBuilder(){
        register(new FixLengthPayloadParserBuilder());
        register(new DelimitedPayloadParserBuilder());
        register(new ScriptPayloadParserBuilder());
        register(new DirectPayloadParserBuilder());
    }
    @Override
    public PayloadParser build(PayloadParserType type, ValueObject configuration) {
        return Optional.ofNullable(strategyMap.get(type))
                .map(builder -> builder.build(configuration))
                .orElseThrow(() -> new UnsupportedOperationException("unsupported parser:" + type));
    }

    public void register(PayloadParserBuilderStrategy strategy) {
        strategyMap.put(strategy.getType(), strategy);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PayloadParserBuilderStrategy) {
            register(((PayloadParserBuilderStrategy) bean));
        }
        return bean;
    }
}