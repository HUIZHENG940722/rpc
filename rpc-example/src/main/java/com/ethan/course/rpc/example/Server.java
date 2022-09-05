package com.ethan.course.rpc.example;

import com.ethan.course.rpc.server.RpcServer;
import com.ethan.course.rpc.server.RpcServerConfig;

/**
 * @Author zhenghui
 * @Description 服务器
 * @Date 2022/9/5
 */
public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer(new RpcServerConfig());
        server.register(CalcService.class, new CalcServiceImpl());
        server.start();
    }
}
