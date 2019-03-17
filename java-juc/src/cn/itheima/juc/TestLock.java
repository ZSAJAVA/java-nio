package cn.itheima.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/22 - 15:55
 */
public class TestLock {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(ticket, "1号窗口").start();
        new Thread(ticket, "2号窗口").start();
        new Thread(ticket, "3号窗口").start();

    }

}

class Ticket implements Runnable {

    private int ticket = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {

       while (true){

           lock.lock();//上锁

           try {
               if (ticket>0){


                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

                   System.out.println(Thread.currentThread().getName()+"完成售票剩余"+ --ticket);
               }

           }finally {

               lock.unlock();//释放锁

           }

       }

    }
}