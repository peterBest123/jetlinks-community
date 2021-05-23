package com.troila.datacoll.notify.template;


import com.troila.datacoll.notify.NotifierProvider;

import java.io.Serializable;

/**
 * 通知模版,不同的服务商{@link NotifierProvider},{@link TemplateProvider}需要实现不同的模版
 *
 * @author zhouhao
 * @version 1.0
 * @since 1.0
 */
public interface Template extends Serializable {

}
