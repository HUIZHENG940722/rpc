package com.ethan.course.rpc.transport;

/**
 * @Author zhenghui
 * @Description 服务端协议：1、启动、监听；2、接受请求；3、关闭监听
 * @Date 2022/9/4
 */
public interface TransportServer {

    /**
     * 初始化
     *
     * @param port
     * @param handler
     */
    void init(int port, RequestHandler handler);

    /**
     * 启动监听
     */
    void start();

    /**
     * 关闭监听
     */
    void stop();
}
