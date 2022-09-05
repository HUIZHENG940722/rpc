package com.ethan.course.rpc.transport;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletOutputStream;

/**
 * @Author zhenghui
 * @Description 处理网络请求
 * @Date 2022/9/4
 */
public interface RequestHandler {
    void onRequest(ServletInputStream inputStream, ServletOutputStream outputStream);
}
