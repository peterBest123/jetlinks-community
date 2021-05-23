package com.troila.datacoll.rule.engine.event.handler;

import com.troila.datacoll.elastic.search.service.ElasticSearchService;
import com.troila.datacoll.gateway.annotation.Subscribe;
import com.troila.datacoll.rule.engine.entity.RuleEngineExecuteEventInfo;
import lombok.extern.slf4j.Slf4j;
import org.jetlinks.core.event.TopicPayload;
import org.jetlinks.rule.engine.defaults.LogEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@Order(3)
public class RuleLogHandler {

    @Autowired
    private ElasticSearchService elasticSearchService;

    @Subscribe("/rule-engine/*/*/event/*")
    public Mono<Void> handleEvent(TopicPayload event) {

        return elasticSearchService.commit(RuleEngineLoggerIndexProvider.RULE_EVENT_LOG, RuleEngineExecuteEventInfo.of(event));
    }

    @Subscribe("/rule-engine/*/*/logger/*")
    public Mono<Void> handleLog(LogEvent event) {
        return elasticSearchService.commit(RuleEngineLoggerIndexProvider.RULE_LOG, event);
    }
}
