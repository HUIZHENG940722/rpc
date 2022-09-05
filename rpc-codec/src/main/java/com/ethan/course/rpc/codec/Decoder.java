package com.ethan.course.rpc.codec;

/**
 * @Author zhenghui
 * @Description 反序列化接口
 * @Date 2022/9/4
 */
public interface Decoder {
    <T> T decode(byte[] bytes, Class<T> clazz);
}
