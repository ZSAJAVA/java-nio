package com.itheima.nio;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/15 - 17:30
 */

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 1通道（Channel） 用于源节点和目标节点的链接。在java NIO 中负责缓冲区的数据传输。
 * 本身不存储数据，配合缓冲区使用
 * <p>
 * Java 为  Channel  接口提供的最主要实现类如下：
 * • FileChannel：用于读取、写入、映射和操作文件的通道。
 * • DatagramChannel：通过 UDP 读写网络中的数据通道。
 * • SocketChannel：通过 TCP 读写网络中的数据。
 * • ServerSocketChannel：可以监听新进来的 TCP 连接，对每一个新进来
 * 的连接都会创建一个 SocketChannel。
 * <p>
 * 获取通道的一种方式是对支持通道的对象调用
 * getChannel() 方法。支持通道的类如下：
 *  FileInputStream
 *  FileOutputStream
 *  RandomAccessFile
 *  DatagramSocket
 *  Socket
 *  ServerSocket
 * 获取通道的其他方式是使用 Files 类的静态方法 newByteChannel() 获
 * 取字节通道。或者通过通道的静态方法 open() 打开并返回指定通道。
 *
 *
 *
 *
 * 通道之间数据传输
 * transferFrom（）
 * transferTo（）
 *
 *
 *
 *  五、分散(Scatter)与聚集(Gather)
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
 *
 *
 *
 * 六、字符集：Charset
 * 编码：字符串 -> 字节数组
 * 解码：字节数组  -> 字符串
 */
public class TestChannel {

    //字符集
    @Test
    public void test6() throws IOException{
        Charset cs1 = Charset.forName("GBK");

        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();

        //获取解码器
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("尚硅谷威武！");
        cBuf.flip();

        //编码
        ByteBuffer bBuf = ce.encode(cBuf);

        for (int i = 0; i < 12; i++) {
            System.out.println(bBuf.get());
        }

        //解码
        bBuf.flip();
        CharBuffer cBuf2 = cd.decode(bBuf);
        System.out.println(cBuf2.toString());

        System.out.println("------------------------------------------------------");

        Charset cs2 = Charset.forName("GBK");
        bBuf.flip();
        CharBuffer cBuf3 = cs2.decode(bBuf);
        System.out.println(cBuf3.toString());
    }


    //分散和聚集
    @Test
    public void test4() throws IOException{
        RandomAccessFile raf1 = new RandomAccessFile("1.txt", "rw");

        //1. 获取通道
        FileChannel channel1 = raf1.getChannel();

        //2. 分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        //3. 分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel1.read(bufs);

        for (ByteBuffer byteBuffer : bufs) {
            byteBuffer.flip();
        }

        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("-----------------");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        //4. 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("2.txt", "rw");
        FileChannel channel2 = raf2.getChannel();

        channel2.write(bufs);
    }


    //通道之间的数据传输(直接缓冲区)
    @Test
    public void test3() throws IOException {

        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("4.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

        //inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.transferFrom(inChannel,0,inChannel.size());

        inChannel.close();
        outChannel.close();
    }



    //使用直接缓冲区完成文件的复制(内存映射文件)
    @Test
    public void test2() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

        //内存映射文件

        MappedByteBuffer inMapBuffer = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapBuffer = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据操作

        byte[] dst = new byte[inMapBuffer.limit()];

        inMapBuffer.get(dst);
        outMapBuffer.put(dst);

        inChannel.close();
        outChannel.close();

    }

    //利用通道完成文件复制(非直接缓冲区)
    @Test
    public void test1() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel fisChannel = null;
        FileChannel fosChannel = null;
        try {
            fis = new FileInputStream("1.jpg");
            fos = new FileOutputStream("2.jpg");

            //获取通道
            fisChannel = fis.getChannel();
            fosChannel = fos.getChannel();
            //分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //将通道的数据存到缓冲区
            while (fisChannel.read(buffer) != -1) {

                buffer.flip();//切换到读取模式
                //将缓冲区的数据写到通道
                fosChannel.write(buffer);
                buffer.clear();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fosChannel != null) {

                try {
                    fosChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fisChannel != null) {
                try {
                    fisChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }


    }


}
