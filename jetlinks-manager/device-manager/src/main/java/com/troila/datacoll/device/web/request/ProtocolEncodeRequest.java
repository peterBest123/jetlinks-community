package com.troila.datacoll.device.web.request;

import com.troila.datacoll.device.entity.ProtocolSupportEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProtocolEncodeRequest {

    ProtocolSupportEntity entity;

    ProtocolEncodePayload request;


}
