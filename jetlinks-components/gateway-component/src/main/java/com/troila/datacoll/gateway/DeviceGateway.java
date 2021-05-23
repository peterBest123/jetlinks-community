package com.troila.datacoll.gateway;

import com.troila.datacoll.network.DefaultNetworkType;
import org.jetlinks.core.message.Message;
import org.jetlinks.core.message.codec.Transport;
import com.troila.datacoll.network.NetworkType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 设备网关,用于统一管理设备连接,状态以及消息收发
 *
 * @author zhouhao
 * @version 1.0
 * @since 1.0
 */
public interface DeviceGateway {

    /**
     * @return 网关ID
     */
    String getId();

    /**
     * @return 传输协议
     * @see org.jetlinks.core.message.codec.DefaultTransport
     */
    Transport getTransport();

    /**
     * @return 网络类型
     * @see DefaultNetworkType
     */
    NetworkType getNetworkType();

    /**
     * 订阅来自设备到消息,关闭网关时不会结束流.
     *
     * @return 设备消息流
     */
    Flux<Message> onMessage();

    /**
     * 启动网关
     *
     * @return 启动结果
     */
    Mono<Void> startup();

    /**
     * 暂停网关,暂停后停止处理设备消息.
     *
     * @return 暂停结果
     */
    Mono<Void> pause();

    /**
     * 关闭网关
     *
     * @return 关闭结果
     */
    Mono<Void> shutdown();

    default boolean isAlive() {
        return true;
    }
}
