package com.learn.javabasic.thread.sxtdemo.net.httpserver.demo3;

import com.google.learn.javabasic.thread.sxtdemo.net.tcp.weichat.version2.CloseUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";

    // 存储头信息
    private StringBuilder headerInfo;

    // 正文
    private StringBuilder content;

    // 存储正文长度
    private int len = 0;

    private BufferedWriter bw;

    private Response() {
        this.headerInfo = new StringBuilder();
        this.content = new StringBuilder();
        this.len = 0;
    }

    public Response(OutputStream os) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));

    }

    public Response(Socket client) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            //e.printStackTrace();
            headerInfo = null;
        }

    }

    /**
     * 构建正文  + 回车
     */

    public Response println(String info) {
        content.append(info).append(CRLF);
        len += (info + CRLF).getBytes().length;
        return this;
    }

    public void pushToClient(int code) throws IOException {
        if (headerInfo == null) {
            code = 500;
        }
        createHeaderInfo(code);
        bw.append(headerInfo.toString());

        bw.append(content.toString());
        bw.flush();
    }

    public void close() {
        CloseUtil.closeAll(bw);
    }


    /**
     * 构建响应头
     */
    private void createHeaderInfo(int code) {

        // 1 HTTP协议的版本 状态码 描述
        headerInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);

        switch (code) {
            case 200:
                headerInfo.append("OK");
                break;
            case 404:
                headerInfo.append("NOT FOUND");
                break;
            case 500:
                headerInfo.append("SERVER ERROR");
                break;
            default:
                break;
        }
        headerInfo.append(CRLF);

        // 2 头信息 响应头
        headerInfo.append("Server:bjsxt Server/0.0.1").append(CRLF);
        headerInfo.append("Date:").append(new Date()).append(CRLF);
        headerInfo.append("Content-type:text/html;charset=GBK").append(CRLF);

        //正文长度
        headerInfo.append("Content-Length:").append(len).append(CRLF);
        headerInfo.append(CRLF);
    }
}
