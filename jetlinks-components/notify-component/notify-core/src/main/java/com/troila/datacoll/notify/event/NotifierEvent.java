package com.troila.datacoll.notify.event;

import com.troila.datacoll.notify.template.Template;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hswebframework.utils.StringUtils;
import com.troila.datacoll.notify.NotifyType;
import com.troila.datacoll.notify.Provider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

@Getter
@Setter
@Builder
public class NotifierEvent {

    private boolean success;

    @Nullable
    private Throwable cause;

    @Nonnull
    private String notifierId;

    @Nonnull
    private NotifyType notifyType;

    @Nonnull
    private Provider provider;

    @Nullable
    private String templateId;

    @Nullable
    private Template template;

    @Nonnull
    private Map<String, Object> context;

    public SerializableNotifierEvent toSerializable() {
        return SerializableNotifierEvent.builder()
            .success(success)
            .notifierId(notifierId)
            .notifyType(notifyType.getId())
            .provider(provider.getId())
            .templateId(templateId)
            .template(template)
            .context(context)
            .cause(cause != null ? StringUtils.throwable2String(cause) : "")
            .errorType(cause != null ? cause.getClass().getName() : null)
            .build();
    }
}
