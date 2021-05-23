package com.troila.datacoll.logging.event.handler;

import com.troila.datacoll.elastic.search.index.ElasticIndex;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author bsetfeng
 * @since 1.0
 **/
@Getter
@AllArgsConstructor
public enum LoggerIndexProvider implements ElasticIndex {

    ACCESS("access_logger"),
    SYSTEM("system_logger");

    private String index;
}
