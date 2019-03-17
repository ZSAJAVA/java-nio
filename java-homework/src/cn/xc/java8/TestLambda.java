package cn.xc.java8;

import org.junit.Test;

import java.util.*;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/17 - 16:48
 */
public class TestLambda {

    @Test
    public void test() {

        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> treeSet = new TreeSet<>(com);


    }

    //lambda表达式
    @Test
    public void test2() {


        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> treeSet = new TreeSet<>(com);

    }

    List<Employee> employees = Arrays.asList(
            new Employee("aa", 18, 999.99),
            new Employee("bb", 8, 666.6),
            new Employee("cc", 30, 55555.5),
            new Employee("dd", 25, 12000.99)
    );


    @Test
    public void test4() {

        List<Employee> filter = filter(employees, new FileterEmp());

        for (Employee employee : filter) {

            System.out.println(employee);
        }


    }

    @Test
    public void test6(){

        List<Employee> filter = filter(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 10000;
            }
        });

        for (Employee employee : filter) {

            System.out.println(employee);
        }


    }

    @Test
    public void test7(){

        List<Employee> filter = filter(employees, (e) -> e.getSalary() < 5000);

        filter.forEach(System.out::println);


    }


    @Test
    public void test8(){

        employees.stream()
                .filter((e)-> e.getSalary()>5000)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("-------------------------");

        employees.stream()
                .map(Employee :: getName)
                .forEach(System.out::println);

    }

    public List<Employee> filter(List<Employee> list, MyPredicate<Employee> mp) {

        List<Employee> employees = new ArrayList<>();


        for (Employee employee : list) {


            if (mp.test(employee)) {

                employees.add(employee);

            }

        }

        return employees;

    }







}
