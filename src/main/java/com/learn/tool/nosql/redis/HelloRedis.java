package com.learn.tool.nosql.redis;

import redis.clients.jedis.Jedis;

public class HelloRedis {
    public static void main(String[] args) {
        try {
            Jedis jr = new Jedis("localhost", 6379); //redis服务地址和端口号
            String key = "mKey";
            jr.set(key, "hello,redis!");
            String v = new String(jr.get(key));
            String k2 = "count";
            jr.incr(k2);
            jr.incr(k2);
            System.out.println(v);
            System.out.println(new String(jr.get(k2)));
        } catch (Exception e) {
// TODO: handle exception
        }
    }
}
