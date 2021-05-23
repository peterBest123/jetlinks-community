package com.troila.datacoll.elastic.search.index.strategies;

import com.troila.datacoll.elastic.search.service.reactive.ReactiveElasticsearchClient;
import com.troila.datacoll.elastic.search.index.ElasticSearchIndexMetadata;
import com.troila.datacoll.elastic.search.index.ElasticSearchIndexProperties;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DirectElasticSearchIndexStrategy extends AbstractElasticSearchIndexStrategy {

    public DirectElasticSearchIndexStrategy(ReactiveElasticsearchClient client, ElasticSearchIndexProperties properties) {
        super("direct", client, properties);
    }

    @Override
    public String getIndexForSave(String index) {
        return wrapIndex(index);
    }

    @Override
    public String getIndexForSearch(String index) {
        return wrapIndex(index);
    }

    @Override
    public Mono<Void> putIndex(ElasticSearchIndexMetadata metadata) {
        return doPutIndex(metadata, false);
    }

    @Override
    public Mono<ElasticSearchIndexMetadata> loadIndexMetadata(String index) {
        return doLoadIndexMetadata(index);
    }

}
