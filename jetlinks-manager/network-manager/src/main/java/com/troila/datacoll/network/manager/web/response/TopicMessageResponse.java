package com.troila.datacoll.network.manager.web.response;

import com.troila.datacoll.gateway.TopicMessage;
import lombok.Getter;
import lombok.Setter;

import java.nio.charset.StandardCharsets;

@Getter
@Setter
public class TopicMessageResponse {

    private String topic;

    private Object message;

    public static TopicMessageResponse of(TopicMessage topicMessage) {
        TopicMessageResponse response = new TopicMessageResponse();
        response.setTopic(topicMessage.getTopic());
        response.setMessage(topicMessage.getMessage().getPayload().toString(StandardCharsets.UTF_8));
        return response;
    }

    public TopicMessage toTopicMessage() {
        return TopicMessage.of(this.topic, this.message);
    }

}
