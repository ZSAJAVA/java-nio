package cn.xc.java82;

import cn.xc.java8.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/18 - 16:42
 */
public class TestStreamAPI {

    //创建stream
    @Test
    public void test (){

        //1
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2
        Employee[] employees = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);

        //3
        Stream<String> stream2 = Stream.of("aa", "vv", "dd");

        //4创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);

        stream4.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(()->Math.random())
                .limit(10)
                .forEach(System.out::println);
    }



}
