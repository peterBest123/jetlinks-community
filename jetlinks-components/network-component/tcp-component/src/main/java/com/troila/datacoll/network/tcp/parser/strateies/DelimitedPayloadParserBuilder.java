package com.troila.datacoll.network.tcp.parser.strateies;

import com.troila.datacoll.ValueObject;
import io.vertx.core.parsetools.RecordParser;
import org.apache.commons.lang.StringEscapeUtils;
import com.troila.datacoll.network.tcp.parser.PayloadParserType;

public class DelimitedPayloadParserBuilder extends VertxPayloadParserBuilder {
    @Override
    public PayloadParserType getType() {
        return PayloadParserType.DELIMITED;
    }

    @Override
    protected RecordParser createParser(ValueObject config) {

        return RecordParser.newDelimited(StringEscapeUtils.unescapeJava(config.getString("delimited")
                .orElseThrow(() -> new IllegalArgumentException("delimited can not be null"))));
    }


}
