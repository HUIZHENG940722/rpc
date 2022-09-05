package com.ethan.course.rpc.codec;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author zhenghui
 * @Description 序列化测试类
 * @Date 2022/9/4
 */
@Data
@Accessors(chain = true)
public class TestBean {

    private String name;

    private Integer age;
}
