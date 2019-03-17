package cn.xc.java82;

import cn.xc.java8.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/19 - 11:37
 */
public class TestOptional {

    @Test
    public void test5(){

        Optional<Employee> o = Optional.ofNullable(new Employee("zz", 55, 55.5));

//        Optional<String> s = o.map((e) -> e.getName());
//        System.out.println("s = " + s.get());
        Optional<String> s = o.flatMap((e) -> Optional.of(e.getName()));

        System.out.println("s = " + s.get());

    }

    @Test
    public void test(){


        Optional<Employee> op = Optional.of(null);

        Employee employee = op.get();

        System.out.println(employee);

    }

    @Test
    public void test1(){

        Optional<Employee> empty = Optional.empty();

        System.out.println(empty.get());

    }

    @Test
    public void test2(){

        Optional<Employee> o = Optional.ofNullable(null);

//        if (o.isPresent()){
//            System.out.println("o = " + o.get());
//        }
//
//        Employee zz = o.orElse(new Employee("zz", 55, 55.5));
//
//        System.out.println("zz = " + zz);

        Employee employee = o.orElseGet(() -> new Employee());

        System.out.println("employee = " + employee);




    }
}
