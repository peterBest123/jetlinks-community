package com.troila.datacoll.elastic.search.service;

import com.troila.datacoll.timeseries.query.AggregationQueryParam;
import reactor.core.publisher.Flux;

import java.util.Map;

/**
 * @author bsetfeng
 * @since 1.0
 **/
public interface AggregationService {

    Flux<Map<String, Object>> aggregation(String[] index, AggregationQueryParam queryParam);

}
