package com.troila.datacoll.logging.controller;

import com.troila.datacoll.logging.system.SerializableSystemLog;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hswebframework.web.api.crud.entity.PagerResult;
import org.hswebframework.web.api.crud.entity.QueryOperation;
import org.hswebframework.web.api.crud.entity.QueryParamEntity;
import org.hswebframework.web.authorization.annotation.QueryAction;
import org.hswebframework.web.authorization.annotation.Resource;
import com.troila.datacoll.logging.service.SystemLoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author bsetfeng
 * @since 1.0
 **/
@RestController
@RequestMapping("/logger/system")
@Resource(id="system-logger",name = "系统日志")
@Tag(name = "日志管理")
public class SystemLoggerController {

    @Autowired
    private SystemLoggerService loggerService;

    @GetMapping("/_query")
    @QueryAction
    @QueryOperation(summary = "查询系统日志")
    public Mono<PagerResult<SerializableSystemLog>> getSystemLogger(@Parameter(hidden = true) QueryParamEntity queryParam) {
        return loggerService.getSystemLogger(queryParam);
    }


}