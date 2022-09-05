package com.ethan.course.rpc.codec;

/**
 * @Author zhenghui
 * @Description 序列化接口
 * @Date 2022/9/4
 */
public interface Encoder {
    byte[] encode(Object obj);
}
