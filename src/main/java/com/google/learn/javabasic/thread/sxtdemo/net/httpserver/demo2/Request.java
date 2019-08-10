package com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Request {
    // 请求方式
    private String method;

    //请求资源
    private String url;

    //请求参数
    private Map<String, List<String>> parameterMapValue;

    // 内部
    private static final String CRLF = "\r\n";
    private InputStream is;
    private String requestInfo;

    public Request() {
        method = "";
        url = "";
        parameterMapValue = new HashMap<>();
        requestInfo = "";
    }

    public Request(InputStream is) {
        this();
        this.is = is;

        try {
            byte[] data = new byte[1024 * 1024 * 2];
            int len = is.read(data);
            System.out.println(len + " =========");
            requestInfo = new String(data, 0, len);
            System.out.println(requestInfo);
            parseRequestInfo();
        } catch (IOException e) {
            //e.printStackTrace();
            return;
        }
    }

    /**
     * 分析请求信息
     */
    private void parseRequestInfo() {
        if ((requestInfo == null) || ((requestInfo = requestInfo.trim()).equals(""))) {
            return;
        }

        /**
         * ======================================
         * 从信息的首行分解出：请求方式 请求路径  请求参数  get可能 存在
         * GET /index.html?uname=dongfang&pwd=12334 HTTP/1.1
         *
         * 如果为post方式，请求参数可能在最后正文中
         *
         * ======================================
         */

        String paramString = ""; //请求参数
        String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
        int idx = requestInfo.indexOf("/");
        this.method = firstLine.substring(0, idx).trim();

        String urlStr = firstLine.substring(idx, firstLine.indexOf("HTTP/")).trim();

        if (this.method.equalsIgnoreCase("post")) {
            this.url = urlStr;
            paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
        } else if (this.method.equalsIgnoreCase("get")) {
            if (urlStr.contains("?")) { // 是否存在参数
                String[] urlArray = urlStr.split("\\?");
                this.url = urlArray[0];
                paramString = urlArray[1]; //请求参数发
            } else {
                this.url = urlStr;
            }
        }

     /*   System.out.println(urlStr);
        System.out.println(paramString);*/

        // 不存在请求参数
        if (paramString.equals("")) {
            return;
        }

        parseParams(paramString);
    }

    private void parseParams(String paramString) {
        // 分割字符串
        StringTokenizer tokenizer = new StringTokenizer(paramString, "&");
        while (tokenizer.hasMoreTokens()) {
            String keyValue = tokenizer.nextToken();
            String[] keyValues = keyValue.split("=");
            if (keyValues.length == 1) {
                keyValues = Arrays.copyOf(keyValues, 2);
                keyValues[1] = null;
            }

            String key = keyValues[0].trim();
            String value = (keyValues[1] == null) ? null : decode(keyValues[1].trim(), "UTF-8");
            //System.out.println(key + "==========");
            //System.out.println(value + "==========");
            //转换成map
            if (!parameterMapValue.containsKey(key)) {
                parameterMapValue.put(key, new ArrayList<String>());
            }

            List<String> values = parameterMapValue.get(key);
            values.add(value);
        }
    }

    /**
     * 根据页面的name获取单个的值
     *
     * @param name
     * @return
     */
    public String getParameter(String name) {
        String[] values = getParameterValues(name);
        if (values == null) {
            return null;
        }
        return values[0];
    }

    public String[] getParameterValues(String name) {
        List<String> values = null;
        if ((values = parameterMapValue.get(name)) == null) {
            return null;
        } else {
            return values.toArray(new String[0]);
        }
    }

    public static void main(String[] args) {
        String params = "uname=dongfang&pwd=12334&fav=0&fav=1&fav=2";
        Request request = new Request();
        request.parseParams(params);
        System.out.println(Arrays.toString(request.getParameterValues("fav")));
    }

    private String decode(String value, String charSet) {
        try {
            return URLDecoder.decode(value, charSet);
        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();
        }
        return null;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
