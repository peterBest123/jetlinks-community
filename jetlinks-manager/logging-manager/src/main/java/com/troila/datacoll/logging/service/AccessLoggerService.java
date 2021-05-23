package com.troila.datacoll.logging.service;


import com.troila.datacoll.elastic.search.service.ElasticSearchService;
import com.troila.datacoll.logging.access.SerializableAccessLog;
import com.troila.datacoll.logging.event.handler.LoggerIndexProvider;
import org.hswebframework.ezorm.core.param.QueryParam;
import org.hswebframework.web.api.crud.entity.PagerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @version 1.0
 **/
@Service
public class AccessLoggerService {

    @Autowired
    private ElasticSearchService searchService;

    public Mono<PagerResult<SerializableAccessLog>> getAccessLogger(QueryParam queryParam) {
        return searchService.queryPager(LoggerIndexProvider.ACCESS, queryParam, SerializableAccessLog.class);
    }

}
