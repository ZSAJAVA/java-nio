package cn.itheima.juc;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/22 - 10:22
 */
public class TestVolatile {


    public static void main(String[] args) {

        ThreadDemo td = new ThreadDemo();

        new Thread(td).start();

        while (true){

            if (td.isFalg()){

                System.out.println("=============");
                break;
            }


        }



    }


}

class ThreadDemo implements Runnable {

    private volatile boolean falg = false;

    @Override
    public void run() {


        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        falg = true;

        System.out.println("falg = " + isFalg());


    }

    public boolean isFalg() {
        return falg;
    }

    public void setFalg(boolean falg) {
        this.falg = falg;
    }
}