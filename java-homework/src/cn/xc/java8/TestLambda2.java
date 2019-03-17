package cn.xc.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/17 - 18:40
 */
public class TestLambda2 {

    @Test
    public void test1(){

        Runnable r = new Runnable() {
            @Override
            public void run() {

                System.out.println("hello Lambda!");
            }
        };

        r.run();

        System.out.println("=======================");

        Runnable r2 = () -> System.out.println("hello Lambda");

        r2.run();

    }

    @Test
    public void test2(){

        //一个参数 括号可以不写
        //Consumer c = (x) -> System.out.println(x);
        Consumer c = x -> System.out.println(x);

        c.accept("Lambda");


    }
    @Test
    public void test3(){

        Comparator<Integer> com = (x,y) -> {

            System.out.println("Lambda");

          return Integer.compare(x,y);

        };

    }

    @Test
    public void test4(){

        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);


    }


    @Test
    public void test5(){

        Integer op = op(5, (x) -> x * x);

        System.out.println(op);


        System.out.println(op(5,(i) -> i+1));

    }

    public Integer op(Integer i ,MyFun mf){

        return mf.getVule(i);


    }


}
