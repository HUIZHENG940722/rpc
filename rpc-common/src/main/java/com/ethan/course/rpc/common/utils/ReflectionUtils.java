package com.ethan.course.rpc.common.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhenghui
 * @Description 反射工具类
 * @Date 2022/9/3
 */
public class ReflectionUtils {

    /**
     * 根据class创建对象
     *
     * @param clazz 类对象
     * @param <T>
     * @return
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * 获取某个类的所有公共方法
     *
     * @param clazz 类对象
     * @return
     */
    public static Method[] getPublicMethods(Class clazz) {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        List<Method> methods = new ArrayList<>();
        for (Method method : declaredMethods) {
            if (Modifier.isPublic(method.getModifiers())) {
                methods.add(method);
            }
        }
        return methods.toArray(new Method[0]);
    }

    /**
     * 调用指定对象的指定方法
     *
     * @param obj    对象
     * @param method 方法
     * @param args   参数
     * @return
     */
    public static Object invoke(Object obj, Method method, Object... args) {
        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

    }
}
