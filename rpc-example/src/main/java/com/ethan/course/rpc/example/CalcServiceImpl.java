package com.ethan.course.rpc.example;

/**
 * @Author zhenghui
 * @Description RPC计算服务实现类
 * @Date 2022/9/5
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}
