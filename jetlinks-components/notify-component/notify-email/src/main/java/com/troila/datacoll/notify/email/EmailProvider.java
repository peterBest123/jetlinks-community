package com.troila.datacoll.notify.email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.troila.datacoll.notify.Provider;

@Getter
@AllArgsConstructor
public enum EmailProvider implements Provider {

    embedded("默认")
    ;

    private String name;

    @Override
    public String getId() {
        return name();
    }
}
