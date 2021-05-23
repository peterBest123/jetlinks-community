package com.troila.datacoll.notify.event;

import com.troila.datacoll.notify.template.Template;
import lombok.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SerializableNotifierEvent {

    private boolean success;

    @Nullable
    private String errorType;

    @Nullable
    private String cause;

    @Nonnull
    private String notifierId;

    @Nonnull
    private String notifyType;

    @Nonnull
    private String provider;

    @Nullable
    private String templateId;

    @Nullable
    private Template template;

    @Nonnull
    private Map<String,Object> context;
}
