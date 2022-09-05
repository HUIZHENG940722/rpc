package com.ethan.course.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @Author zhenghui
 * @Description 基于JSON序列化实现
 * @Date 2022/9/4
 */
public class JSONEncoder implements Encoder{
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
