package com.ethan.course.rpc.proto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author zhenghui
 * @Description 表示PRC请求
 * @Date 2022/9/3
 */
@Data
@Accessors(chain = true)
public class Request {

    /**
     * 请求服务
     */
    private ServiceDescriptor serviceDescriptor;

    /**
     * 参数列表
     */
    private Object[] parameters;
}
