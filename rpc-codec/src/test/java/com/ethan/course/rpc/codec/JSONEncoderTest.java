package com.ethan.course.rpc.codec;


import org.junit.Assert;
import org.junit.Test;

/**
 * @Author zhenghui
 * @Description
 * @Date 2022/9/4
 */
public class JSONEncoderTest {

    @Test
    public void encode() {
        TestBean testBean = new TestBean().setName("ethan").setAge(18);
        Encoder encoder = new JSONEncoder();
        byte[] bytes = encoder.encode(testBean);
        Assert.assertNotNull(bytes);
    }
}