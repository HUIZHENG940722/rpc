package com.ethan.course.rpc.common.utils;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Author zhenghui
 * @Description
 * @Date 2022/9/4
 */
public class ReflectionUtilsTest {

    @Test
    public void testNewInstance() {
        TestClass testClass = ReflectionUtils.newInstance(TestClass.class);
        Assert.assertNotNull(testClass);
    }

    @Test
    public void testGetPublicMethods() {
        Method[] publicMethods = ReflectionUtils.getPublicMethods(TestClass.class);
        Assert.assertEquals(1, publicMethods.length);
        String name = publicMethods[0].getName();
        Assert.assertEquals("b", name);
    }

    @Test
    public void testInvoke() {
        Method[] publicMethods = ReflectionUtils.getPublicMethods(TestClass.class);
        Method b = publicMethods[0];
        TestClass testClas = new TestClass();
        Object invoke = ReflectionUtils.invoke(testClas, b);
        Assert.assertEquals("b", invoke);
    }
}