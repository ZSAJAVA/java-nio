package cn.itheima.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/22 - 10:58
 */
public class TestAtomicDemo {


    public static void main(String[] args) {


        AtomicDemo at = new AtomicDemo();


        for (int i = 0;i<10;i++){

            new Thread(at).start();

        }

    }


}

class AtomicDemo implements Runnable{

    //private int serialNumber = 0;

    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public void run() {


        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber.getAndIncrement();
    }


}