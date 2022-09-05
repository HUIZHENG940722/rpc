package com.ethan.course.rpc.example;

/**
 * @Author zhenghui
 * @Description RPC的计算服务
 * @Date 2022/9/5
 */
public interface CalcService {
    int add(int a, int b);

    int minus(int a, int b);
}
