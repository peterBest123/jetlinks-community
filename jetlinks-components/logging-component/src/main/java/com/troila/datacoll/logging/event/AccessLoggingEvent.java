package com.troila.datacoll.logging.event;

import com.troila.datacoll.logging.access.SerializableAccessLog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccessLoggingEvent {
    SerializableAccessLog log;
}
