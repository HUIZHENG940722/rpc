package com.ethan.course.rpc.proto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author zhenghui
 * @Description 表示网络传输的一个端点
 * @Date 2022/9/3
 */
@Data
@ToString
@AllArgsConstructor
@Accessors(chain = true)
public class Peer {

    /**
     * IP
     */
    private String host;

    /**
     * 端口
     */
    private Integer port;
}
