package com.troila.datacoll.notify.wechat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.troila.datacoll.notify.Provider;

@Getter
@AllArgsConstructor
public enum WechatProvider implements Provider {
    corpMessage("微信企业消息通知")
    ;

    private String name;

    @Override
    public String getId() {
        return name();
    }

}
