package com.ethan.course.rpc.transport;

import com.ethan.course.rpc.proto.Peer;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author zhenghui
 * @Description 客户端协议实现
 * @Date 2022/9/4
 */
public class HttpTransportClient implements TransportClient {

    private String url;


    @Override
    public void connect(Peer peer) {
        this.url = "http://" + peer.getHost() + ":" + peer.getPort();
    }

    @Override
    public InputStream write(InputStream data) {
        try {
            HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.setUseCaches(false);
            httpConn.setRequestMethod("POST");
            httpConn.connect();
            IOUtils.copy(data, httpConn.getOutputStream());
            int resultCode = httpConn.getResponseCode();
            if (resultCode == HttpURLConnection.HTTP_OK) {
                return httpConn.getInputStream();
            } else {
                return httpConn.getErrorStream();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() {

    }
}
