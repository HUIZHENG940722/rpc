package com.ethan.course.rpc.server;

import com.ethan.course.rpc.common.utils.ReflectionUtils;
import com.ethan.course.rpc.proto.Request;
import com.ethan.course.rpc.proto.ServiceDescriptor;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.lang.reflect.Method;

import static org.junit.Assert.assertNotNull;

/**
 * @Author zhenghui
 * @Description
 * @Date 2022/9/4
 */
@FixMethodOrder(MethodSorters.JVM)
public class ServiceManagerTest {

    private ServiceManager serviceManager;

    @Before
    public void setUp() throws Exception {
        serviceManager = new ServiceManager();
        TestInterface bean = new TestClass();
        serviceManager.register(TestInterface.class, bean);
    }

    @Test
    public void register() {
        TestInterface bean = new TestClass();
        serviceManager.register(TestInterface.class, bean);
    }

    @Test
    public void lookup() {
        Method publicMethod = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, publicMethod);
        Request request = new Request();
        request.setServiceDescriptor(sdp);
        ServiceInstance sis = serviceManager.lookup(request);
        assertNotNull(sis);
    }
}