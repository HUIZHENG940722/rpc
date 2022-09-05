package com.ethan.course.rpc.proto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * @Author zhenghui
 * @Description 表示服务
 * @Date 2022/9/3
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ServiceDescriptor {

    /**
     * 类名
     */
    private String clazz;

    /**
     * 方法名
     */
    private String method;

    /**
     * 返回类型
     */
    private String returnType;

    /**
     * 参数列表
     */
    private String[] parameterTypes;

    public static ServiceDescriptor from(Class clazz, Method method) {
        ServiceDescriptor serviceDescriptor = new ServiceDescriptor()
            .setClazz(clazz.getName())
            .setMethod(method.getName())
            .setReturnType(method.getReturnType().getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        String[] parameters = new String[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            parameters[i] = parameterTypes[i].getName();
        }
        serviceDescriptor.setParameterTypes(parameters);
        return serviceDescriptor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceDescriptor)) return false;
        ServiceDescriptor that = (ServiceDescriptor) o;
        return clazz.equals(that.clazz) && method.equals(that.method) && returnType.equals(that.returnType) && Arrays.equals(parameterTypes, that.parameterTypes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(clazz, method, returnType);
        result = 31 * result + Arrays.hashCode(parameterTypes);
        return result;
    }
}
