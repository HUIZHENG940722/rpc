package com.ethan.course.rpc.server;

import com.ethan.course.rpc.codec.Decoder;
import com.ethan.course.rpc.codec.Encoder;
import com.ethan.course.rpc.common.utils.ReflectionUtils;
import com.ethan.course.rpc.proto.Request;
import com.ethan.course.rpc.proto.Response;
import com.ethan.course.rpc.transport.RequestHandler;
import com.ethan.course.rpc.transport.TransportServer;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * @Author zhenghui
 * @Description RPC服务类
 * @Date 2022/9/4
 */
@Slf4j
public class RpcServer {

    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;

    private ServiceInvoker serviceInvoker;

    public RpcServer(RpcServerConfig config) {
        this.config = config;
        this.net = ReflectionUtils.newInstance(config.getTransportServerClass());
        this.net.init(config.getPort(), handler);
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    /**
     * 把RPC注册到服务器中
     *
     * @param interfaceClass RPC接口
     * @param bean           RPC接口对应的实现类
     * @param <T>
     */
    public <T> void register(Class<T> interfaceClass, T bean) {
        serviceManager.register(interfaceClass, bean);
    }

    /**
     * 开启网络监听
     */
    public void start() {
        this.net.start();
    }

    public void stop() {
        this.net.stop();
    }

    private RequestHandler handler = new RequestHandler() {

        @Override
        public void onRequest(ServletInputStream inputStream, ServletOutputStream outputStream) {
            Response resp = new Response();
            try {
                byte[] inBytes = IOUtils.readFully(inputStream, inputStream.available());
                Request req = decoder.decode(inBytes, Request.class);
                ServiceInstance instance = serviceManager.lookup(req);
                Object ret = serviceInvoker.invoke(instance, req);
                resp.setData(ret);
            } catch (IOException e) {
                log.warn(e.getMessage(), e);
                resp.setCode(1);
                resp.setMessage("RpcServer got error：" + e.getClass().getName() + ":" + e.getMessage());
            } finally {
                try {
                    byte[] outBytes = encoder.encode(resp);
                    outputStream.write(outBytes);
                } catch (IOException e) {
                    log.warn(e.getMessage(), e);
                }
            }
        }
    };
}
