package cn.xc.java8;

import org.junit.Test;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/17 - 19:57
 */
public class TestLambda3 {
    List<Employee> employees = Arrays.asList(
            new Employee("ba", 18, 999.99),
            new Employee("ab", 18, 666.6),
            new Employee("cc", 30, 55555.5),
            new Employee("dd", 25, 12000.99)
    );


    @Test
    public void test1() {

        Collections.sort(employees, (e1, e2) -> {

            if (e1.getAge() == e2.getAge()) {

                return e1.getName().compareTo(e2.getName());

            } else {


                return Integer.compare(e1.getAge(), e2.getAge());

            }


        });


        for (Employee employee : employees) {

            System.out.println(employee);
        }

    }

    @Test
    public void test2(){


      String s =  strHandler("xiaoyi",(str) ->str.toUpperCase());

        System.out.println(s);

    }


    public String strHandler(String str,MyFunction mf){

        return mf.getValue(str);

    }

}
