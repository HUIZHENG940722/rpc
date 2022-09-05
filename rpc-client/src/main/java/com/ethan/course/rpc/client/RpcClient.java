package com.ethan.course.rpc.client;

import com.ethan.course.rpc.codec.Decoder;
import com.ethan.course.rpc.codec.Encoder;
import com.ethan.course.rpc.common.utils.ReflectionUtils;
import lombok.Data;

import java.lang.reflect.Proxy;

/**
 * @Author zhenghui
 * @Description RPC客户端
 * @Date 2022/9/4
 */
@Data
public class RpcClient {

    private RpcClientConfig config;

    private Encoder encoder;

    private Decoder decoder;

    private TransportSelector selector;

    public RpcClient(RpcClientConfig config) {
        this.config = config;

        this.encoder = ReflectionUtils.newInstance(this.config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(this.config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(this.config.getTransportSelectorClass());

        this.selector.init(config.getServers(), config.getConnectCount(), config.getTransportClientClass());
    }

    public <T> T getProxy(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] {clazz},
            new RemoteInvoker(clazz, encoder, decoder, selector));
    }
}
