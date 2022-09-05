package com.ethan.course.rpc.server;

import com.ethan.course.rpc.common.utils.ReflectionUtils;
import com.ethan.course.rpc.proto.Request;
import com.ethan.course.rpc.proto.ServiceDescriptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zhenghui
 * @Description 服务管理类
 * @Date 2022/9/4
 */
public class ServiceManager {

    private Map<ServiceDescriptor, ServiceInstance> services = new HashMap<>();

    public ServiceManager() {
        this.services = new ConcurrentHashMap<>();
    }

    public <T> void register(Class<T> interfaceClass, T bean) {
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for (Method method : methods) {
            ServiceInstance sis = new ServiceInstance(bean, method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass, method);
            services.put(sdp, sis);
        }
    }

    public ServiceInstance lookup(Request request) {
        ServiceDescriptor sdp = request.getServiceDescriptor();
        return services.get(sdp);
    }
}
