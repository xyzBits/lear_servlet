package com.learn.thread;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 缓冲区通过allocate()方法获取缓冲
 * <p>
 * 1 缓冲区数据有两个核心方法
 * put 将数据存到缓冲区
 * get 将数据从缓冲区取出
 * <p>
 * capacity 缓冲区最大存储的数据 容量，一旦声明，不能变
 * limit 缓冲区中可以操作的数据大小
 * position 位置，表示缓冲区中正在操作的数据的位置
 * <p>
 * mark 标记当前位置的position
 * <p>
 * allocate 非直接缓冲区，建立在jvm的内存中
 * allocateDirect 直接缓冲区，建立在操作系统的物理内存中
 */
public class NIOTest {

    @Test
    public void test003() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        System.out.println(buffer.isDirect());
    }



    @Test
    public void test002() {
        String str = "abcde";

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());
        buffer.flip();

        byte[] data = new byte[buffer.limit()];
        buffer.get(data, 0, 2);
        System.out.println(new String(data, 0, 2));
        System.out.println(buffer.position());

        buffer.mark();

        buffer.get(data, 2, 2);
        System.out.println(new String(data, 2, 2));
        System.out.println(buffer.position());

        if (buffer.hasRemaining()) {
            System.out.println(buffer.remaining());
        }
    }


    @Test
    public void test001() {
        String str = "abcde";

        // 1 分配一个指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("-------------allocate()-------------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        // 2 利用put()将数据存入缓冲区，进入写模式
        buffer.put(str.getBytes());

        System.out.println("-------------put()-------------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        // 3 切换数据读取模式
        buffer.flip();

        System.out.println("-------------flip()-------------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        // 4 利用get()读取缓冲区中的数据
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(new String(data, 0, data.length));

        System.out.println("-------------get()-------------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        // 5 rewind() 可重复读
        buffer.rewind();

        System.out.println("-------------rewind()-------------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        // 6 clear() 清空缓冲区，但是缓冲匀的数据还是，只是被遗忘
        // 只是将指针的值变了
        buffer.clear();

        System.out.println("-------------clear()-------------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println((char) buffer.get(1));

    }
}
