package com.troila.datacoll.network.tcp.parser;

import com.troila.datacoll.ValueObject;

public interface PayloadParserBuilderStrategy {
    PayloadParserType getType();

    PayloadParser build(ValueObject config);
}
