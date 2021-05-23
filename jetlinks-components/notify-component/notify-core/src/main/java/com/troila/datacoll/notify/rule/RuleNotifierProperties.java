package com.troila.datacoll.notify.rule;

import lombok.Getter;
import lombok.Setter;
import com.troila.datacoll.notify.DefaultNotifyType;
import org.springframework.util.Assert;

@Getter
@Setter
public class RuleNotifierProperties {

    private DefaultNotifyType notifyType;

    private String notifierId;

    private String templateId;

    public void validate() {
        Assert.notNull(notifyType,"notifyType can not be null");
        Assert.hasText(notifierId,"notifierId can not be empty");
        Assert.hasText(templateId,"templateId can not be empty");

    }
}
