package cn.itheima.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/22 - 15:25
 */
public class TestCallable {

    public static void main(String[] args) {
        TherdTest td = new TherdTest();

        FutureTask<Integer> result = new FutureTask<>(td);


        new Thread(result).start();

        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}


class TherdTest implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {

        int sum = 0;
        for (int i = 1; i <= 100; i++) {

            sum += i;

        }

        return sum;
    }
}