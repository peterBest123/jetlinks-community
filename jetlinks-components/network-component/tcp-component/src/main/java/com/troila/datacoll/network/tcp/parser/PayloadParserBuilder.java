package com.troila.datacoll.network.tcp.parser;

import com.troila.datacoll.ValueObject;

public interface PayloadParserBuilder {

    PayloadParser build(PayloadParserType type, ValueObject configuration);

}
