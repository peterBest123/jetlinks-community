package com.troila.datacoll.gateway.external;

import com.troila.datacoll.gateway.external.socket.MessagingRequest;
import lombok.*;
import org.hswebframework.web.authorization.Authentication;
import com.troila.datacoll.ValueObject;

import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeRequest implements ValueObject {

    private String id;

    private String topic;

    private Map<String, Object> parameter;

    private Authentication authentication;

    @Override
    public Map<String, Object> values() {
        return parameter;
    }


    public static SubscribeRequest of(MessagingRequest request,
                                      Authentication authentication) {
        return SubscribeRequest.builder()
            .id(request.getId())
            .topic(request.getTopic())
            .parameter(request.getParameter())
            .authentication(authentication)
            .build();

    }
}
