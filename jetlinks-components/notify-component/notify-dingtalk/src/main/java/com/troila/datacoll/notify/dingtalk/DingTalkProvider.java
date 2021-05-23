package com.troila.datacoll.notify.dingtalk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.troila.datacoll.notify.Provider;

@Getter
@AllArgsConstructor
public enum DingTalkProvider implements Provider {
    dingTalkMessage("钉钉消息通知")
    ;

    private String name;

    @Override
    public String getId() {
        return name();
    }

}
