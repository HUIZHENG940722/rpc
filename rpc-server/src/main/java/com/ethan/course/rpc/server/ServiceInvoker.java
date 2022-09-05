package com.ethan.course.rpc.server;

import com.ethan.course.rpc.common.utils.ReflectionUtils;
import com.ethan.course.rpc.proto.Request;

/**
 * @Author zhenghui
 * @Description 服务实例调用类
 * @Date 2022/9/4
 */
public class ServiceInvoker {

    public Object invoke(ServiceInstance serviceInstance, Request request) {
        return ReflectionUtils.invoke(serviceInstance.getTarget(), serviceInstance.getMethod(),
            request.getParameters());
    }
}
