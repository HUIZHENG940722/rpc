package com.ethan.course.rpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.lang.reflect.Method;

/**
 * @Author zhenghui
 * @Description 服务实例
 * @Date 2022/9/4
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class ServiceInstance {

    private Object target;

    private Method method;
}
