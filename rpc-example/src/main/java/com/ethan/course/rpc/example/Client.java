package com.ethan.course.rpc.example;

import com.ethan.course.rpc.client.RpcClient;
import com.ethan.course.rpc.client.RpcClientConfig;

/**
 * @Author zhenghui
 * @Description 客户端
 * @Date 2022/9/5
 */
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient(new RpcClientConfig());
        CalcService proxy = client.getProxy(CalcService.class);
        int add = proxy.add(1, 2);
        int minus = proxy.minus(10, 8);
        System.out.println(add);
        System.out.println(minus);
    }
}
