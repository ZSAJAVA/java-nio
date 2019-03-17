package com.itheima.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/15 - 15:47
 */

/**
 * 直接缓冲区和非直接缓冲区
 *
 * 1，非直接缓冲区通过allocate（）方法分配缓冲区 将缓冲区建立在JVM内存中
 *
 * 2，直接缓冲区通过allocateDirect（） 方法分配缓冲区，将缓冲区建立在物理内存中，提高效率
 *
 *
 */
public class TestBuffer {


    @Test
    public void test3(){
        //直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        System.out.println(buffer.isDirect());//判断是否是直接缓冲区

    }


    @Test
    public void test2(){

        String str = "abcde";

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put(str.getBytes());

        buffer.flip();

        byte[] dst = new byte[buffer.limit()];

        buffer.get(dst,0,2);

        System.out.println(new String(dst,0,2));

        System.out.println(buffer.position());


        buffer.mark();//标记

        buffer.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println(buffer.position());


        buffer.reset();//回到mark标记的位置

        System.out.println(buffer.position());


        //判断缓冲区是否还有数据
        if (buffer.hasRemaining()){

            //如果有就获取缓冲区可操作的数量
            System.out.println(buffer.remaining());

        }






    }

    @Test
    public void test1(){

        String str = "abcde";

        //1，分配一个指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("==========allocate(1024)==============");
        System.out.println(buffer.position());//位置表示缓冲区正在操作的位置
        System.out.println(buffer.limit());//界限 表示缓冲区可以操作数据的大小（limit后面的数据不能读写）
        System.out.println(buffer.capacity());//缓冲区的容量

        //2，利用put（） 存入数据到缓冲区中
        buffer.put(str.getBytes());

        System.out.println("-----------put()----------------");
        System.out.println(buffer.position());//位置表示缓冲区正在操作的位置
        System.out.println(buffer.limit());//界限 表示缓冲区可以操作数据的大小（limit后面的数据不能读写）
        System.out.println(buffer.capacity());//缓冲区的容量

        //3,切换到读取数据模式flip()

        buffer.flip();

        System.out.println("-----------flip()----------------");
        System.out.println(buffer.position());//位置表示缓冲区正在操作的位置
        System.out.println(buffer.limit());//界限 表示缓冲区可以操作数据的大小（limit后面的数据不能读写）
        System.out.println(buffer.capacity());//缓冲区的容量

        //4,利用get（）方法 读取缓冲区数据

        byte[] dst = new byte[buffer.limit()];

        buffer.get(dst);

        System.out.println(new String(dst,0,dst.length));

        System.out.println("-----------get()----------------");
        System.out.println(buffer.position());//位置表示缓冲区正在操作的位置
        System.out.println(buffer.limit());//界限 表示缓冲区可以操作数据的大小（limit后面的数据不能读写）
        System.out.println(buffer.capacity());//缓冲区的容量

        //5rewind();  可重复读数据
        buffer.rewind();

        System.out.println("-----------rewind()----------------");
        System.out.println(buffer.position());//位置表示缓冲区正在操作的位置
        System.out.println(buffer.limit());//界限 表示缓冲区可以操作数据的大小（limit后面的数据不能读写）
        System.out.println(buffer.capacity());//缓冲区的容量

        //6，clear（）清空缓冲区  但缓冲区数据还存在  处于被遗忘状态
        buffer.clear();

        System.out.println("-----------clear()----------------");
        System.out.println(buffer.position());//位置表示缓冲区正在操作的位置
        System.out.println(buffer.limit());//界限 表示缓冲区可以操作数据的大小（limit后面的数据不能读写）
        System.out.println(buffer.capacity());//缓冲区的容量


        System.out.println((char) buffer.get());

    }


}
