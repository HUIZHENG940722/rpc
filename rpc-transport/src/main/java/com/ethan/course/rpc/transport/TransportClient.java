package com.ethan.course.rpc.transport;

import com.ethan.course.rpc.proto.Peer;

import java.io.InputStream;

/**
 * @Author zhenghui
 * @Description 客户端协议：1、创建连接；2、发送数据，并且等待响应；3、关闭连接
 * @Date 2022/9/4
 */
public interface TransportClient {

    /**
     * 连接
     *
     * @param peer
     */
    void connect(Peer peer);

    /**
     * 发送数据
     *
     * @param data
     * @return
     */
    InputStream write(InputStream data);

    /**
     * 关闭
     */
    void close();
}
