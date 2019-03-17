package cn.xc.java82;

import cn.xc.java8.Employee;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.LongStream;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/19 - 9:43
 */
public class TestStreamAPI3 {

    List<Employee> employees = Arrays.asList(
            new Employee("aa", 18, 999.99),
            new Employee("bb", 8, 666.6),
            new Employee("cc", 30, 55555.5),
            new Employee("dd", 26, 12000.99),
            new Employee("dd", 27, 12000.99),
            new Employee("dd", 28, 12000.99)
    );


    @Test
    public void test(){

        Integer[] integers = new Integer[]{1,2,3,4,5};

        Arrays.stream(integers)
                .map((x)->x*x)
                .forEach(System.out::println);
    }

    @Test
    public void test1(){

        Optional<Integer> reduce = employees.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);

        System.out.println("reduce = " + reduce.get());

    }


    @Test
    public void test2(){

        Instant start = Instant.now();

        long reduce = LongStream.rangeClosed(0, 1000000L)
                .parallel()
                .reduce(0, Long::sum);

        System.out.println("reduce = " + reduce);

        Instant end = Instant.now();

        long seconds = Duration.between(start, end).getSeconds();

        System.out.println("seconds = " + seconds);


    }




}
