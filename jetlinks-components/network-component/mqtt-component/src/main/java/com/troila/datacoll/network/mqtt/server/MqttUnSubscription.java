package com.troila.datacoll.network.mqtt.server;

import io.vertx.mqtt.messages.MqttUnsubscribeMessage;

public interface MqttUnSubscription {

    MqttUnsubscribeMessage getMessage();

    void acknowledge();

}
