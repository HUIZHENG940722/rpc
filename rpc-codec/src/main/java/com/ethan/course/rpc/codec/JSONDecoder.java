package com.ethan.course.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @Author zhenghui
 * @Description 基于JSON的反序列化实现
 * @Date 2022/9/4
 */
public class JSONDecoder implements Decoder {

    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}
