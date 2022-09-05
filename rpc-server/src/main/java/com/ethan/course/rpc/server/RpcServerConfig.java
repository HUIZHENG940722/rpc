package com.ethan.course.rpc.server;

import com.ethan.course.rpc.codec.Decoder;
import com.ethan.course.rpc.codec.Encoder;
import com.ethan.course.rpc.codec.JSONDecoder;
import com.ethan.course.rpc.codec.JSONEncoder;
import com.ethan.course.rpc.transport.HttpTransportServer;
import com.ethan.course.rpc.transport.TransportServer;
import lombok.Data;

/**
 * @Author zhenghui
 * @Description server配置
 * @Date 2022/9/4
 */
@Data
public class RpcServerConfig {

    private Class<? extends TransportServer> transportServerClass = HttpTransportServer.class;

    private Class<? extends Encoder> encoderClass = JSONEncoder.class;

    private Class<? extends Decoder> decoderClass = JSONDecoder.class;

    private Integer port = 3000;
}
