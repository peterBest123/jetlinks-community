package com.troila.datacoll.rule.engine.event.handler;

import com.troila.datacoll.elastic.search.index.ElasticIndex;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author bsetfeng
 * @since 1.0
 **/
@Getter
@AllArgsConstructor
public enum RuleEngineLoggerIndexProvider implements ElasticIndex {

    RULE_LOG("rule-engine-execute-log", "_doc"),
    RULE_EVENT_LOG("rule-engine-execute-event", "_doc");

    private String index;

    private String type;
}
