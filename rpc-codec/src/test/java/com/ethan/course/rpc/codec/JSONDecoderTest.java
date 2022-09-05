package com.ethan.course.rpc.codec;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author zhenghui
 * @Description
 * @Date 2022/9/4
 */
public class JSONDecoderTest {

    @Test
    public void testDecode() {
        Decoder decoder = new JSONDecoder();
        TestBean testBean = new TestBean().setName("ethan").setAge(18);
        Encoder encoder = new JSONEncoder();
        byte[] encode = encoder.encode(testBean);
        TestBean decode = decoder.decode(encode, TestBean.class);
        Assert.assertEquals(testBean.getName(), decode.getName());
        Assert.assertEquals(testBean.getAge(), decode.getAge());
    }
}