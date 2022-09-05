package com.ethan.course.rpc.proto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author zhenghui
 * @Description 表示RPC响应类
 * @Date 2022/9/3
 */
@Data
@Accessors(chain = true)
public class Response {

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应提示
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;
}
