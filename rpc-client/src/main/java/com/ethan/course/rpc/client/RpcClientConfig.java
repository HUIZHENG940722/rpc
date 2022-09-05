package com.ethan.course.rpc.client;

import com.ethan.course.rpc.codec.Decoder;
import com.ethan.course.rpc.codec.Encoder;
import com.ethan.course.rpc.codec.JSONDecoder;
import com.ethan.course.rpc.codec.JSONEncoder;
import com.ethan.course.rpc.proto.Peer;
import com.ethan.course.rpc.transport.HttpTransportClient;
import com.ethan.course.rpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @Author zhenghui
 * @Description 客户端配置
 * @Date 2022/9/4
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClientClass = HttpTransportClient.class;

    private Class<? extends Encoder> encoderClass = JSONEncoder.class;

    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> transportSelectorClass = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1", 3000));
}
