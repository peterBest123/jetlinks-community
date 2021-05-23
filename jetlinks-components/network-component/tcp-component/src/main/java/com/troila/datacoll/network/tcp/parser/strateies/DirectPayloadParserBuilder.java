package com.troila.datacoll.network.tcp.parser.strateies;

import com.troila.datacoll.ValueObject;
import lombok.SneakyThrows;
import com.troila.datacoll.network.tcp.parser.DirectRecordParser;
import com.troila.datacoll.network.tcp.parser.PayloadParser;
import com.troila.datacoll.network.tcp.parser.PayloadParserBuilderStrategy;
import com.troila.datacoll.network.tcp.parser.PayloadParserType;

public class DirectPayloadParserBuilder implements PayloadParserBuilderStrategy {

    @Override
    public PayloadParserType getType() {
        return PayloadParserType.DIRECT;
    }

    @Override
    @SneakyThrows
    public PayloadParser build(ValueObject config) {
        return new DirectRecordParser();
    }
}
