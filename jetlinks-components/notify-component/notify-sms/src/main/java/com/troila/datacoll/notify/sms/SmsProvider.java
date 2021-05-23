package com.troila.datacoll.notify.sms;

import com.troila.datacoll.notify.Provider;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SmsProvider implements Provider {

    aliyunSms("阿里云短信服务")
    ;
    private final String name;

    @Override
    public String getId() {
        return name();
    }

}
