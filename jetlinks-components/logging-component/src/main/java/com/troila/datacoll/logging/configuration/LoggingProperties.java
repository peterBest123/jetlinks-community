package com.troila.datacoll.logging.configuration;

import com.troila.datacoll.logging.access.SerializableAccessLog;
import com.troila.datacoll.logging.event.AccessLoggingEvent;
import com.troila.datacoll.logging.event.SystemLoggingEvent;
import com.troila.datacoll.logging.logback.SystemLoggingAppender;
import lombok.Getter;
import lombok.Setter;
import com.troila.datacoll.logging.system.SerializableSystemLog;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.*;

@ConfigurationProperties(prefix = "jetlinks.logging")
@Getter
@Setter
public class LoggingProperties {

    /**
     * 系统日志
     *
     * @see lombok.extern.slf4j.Slf4j
     * @see org.slf4j.Logger
     * @see SystemLoggingAppender
     * @see SerializableSystemLog
     * @see SystemLoggingEvent
     */
    @Getter
    @Setter
    private SystemLoggingProperties system = new SystemLoggingProperties();

    /**
     * 访问日志
     *
     * @see org.hswebframework.web.logging.AccessLogger
     * @see org.hswebframework.web.loggin.aop.EnableAccessLogger
     * @see AccessLoggingEvent
     * @see SerializableAccessLog
     */
    @Setter
    @Getter
    private AccessLoggingProperties access = new AccessLoggingProperties();

    @Getter
    @Setter
    public static class SystemLoggingProperties {
        /**
         * 系统日志上下文,通常用于在日志中标识当前服务等
         *
         * @see org.hswebframework.web.logger.ReactiveLogger#mdc(String, String)
         * @see org.slf4j.MDC
         */
        private Map<String, String> context = new HashMap<>();

    }

    @Getter
    @Setter
    public static class AccessLoggingProperties {
        //指定按path过滤日志
        private List<String> pathExcludes = new ArrayList<>();
    }

}
