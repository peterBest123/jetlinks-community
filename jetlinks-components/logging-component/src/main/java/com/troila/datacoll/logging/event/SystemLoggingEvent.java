package com.troila.datacoll.logging.event;

import com.troila.datacoll.logging.system.SerializableSystemLog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SystemLoggingEvent {
    SerializableSystemLog log;
}
