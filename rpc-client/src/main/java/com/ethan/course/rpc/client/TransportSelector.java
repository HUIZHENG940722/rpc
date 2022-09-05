package com.ethan.course.rpc.client;

import com.ethan.course.rpc.proto.Peer;
import com.ethan.course.rpc.transport.TransportClient;

import java.util.List;

/**
 * @Author zhenghui
 * @Description 服务连接接口
 * @Date 2022/9/4
 */
public interface TransportSelector {

    /**
     * 初始化
     *
     * @param peers
     * @param count
     * @param clazz
     */
    void init(List<Peer> peers, int count, Class<? extends TransportClient> clazz);

    /**
     * 选择一个transport与servet做交互
     *
     * @return
     */
    TransportClient select();

    /**
     * 释放
     *
     * @param client
     */
    void release(TransportClient client);

    void close();
}
