package com.learn.thread;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 通道，用于源节点与目标节点的连接，
 * nio中负责缓冲区中的数据的传输，本身不存储在数，因此要配合缓冲区进行传输
 * FileChannel
 * SocketChannel
 * ServerSocketChannel
 * DatagramChannel
 * <p>
 * 获取通道
 * 1 java支持通道的道，getChannel
 * FileInputStream FileOutputStream
 * RandomAccessFile
 * <p>
 * Socket
 * ServerSocket
 * DatagramSoccket
 * <p>
 * 2 jdk 1.7 nio2 的针对各个通道提供了静态方法open
 * <p>
 * 3 jdk 1.7 Files newByteChanngel()方法
 */
public class ChannelTest {
    String src = "D:\\ubuntu\\learn\\cpp\\yellow\\143.mp4";
    String dest = "D:\\ubuntu\\learn\\cpp\\yellow\\143_copy1.mp4";


    // 通道之间的数据传输 transferTo transferFrom
    @Test
    public void test003() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get(src), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get(dest), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        //inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel, 0, inChannel.size());

        outChannel.close();
        inChannel.close();
    }

    // 使用直接缓冲区完成文件的复制  内存映射 文件
    @Test
    public void test002() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get(src), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get(dest), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        // 内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());


        // 直接对缓冲区的数据进行读写操作
        byte[] data = new byte[inMappedBuf.limit()];
        inMappedBuf.get(data);
        outMappedBuf.put(data);
        inChannel.close();
        outChannel.close();

    }


    // 利用通道完成文件的复制 非直接缓冲区
    @Test
    public void test001() throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);

        // 1 获取通道
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        // 2 分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 3 将通道中的数据存入缓冲区
        while (inChannel.read(buffer) != -1) {
            buffer.flip(); //切换到读取数据模式
            // 4 将缓冲区数据写入通道中
            outChannel.write(buffer);
            buffer.clear(); //清空缓冲区，进行下一次写入，读出
        }

        outChannel.close();
        inChannel.close();
        fos.close();
        fis.close();
    }
}
