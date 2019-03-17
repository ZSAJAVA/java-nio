package cn.xc.java82;

import cn.xc.java8.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/18 - 17:12
 */
public class TestStreamAPI2 {


    List<Employee> employees = Arrays.asList(
            new Employee("aa", 18, 999.99),
            new Employee("bb", 8, 666.6),
            new Employee("cc", 30, 55555.5),
            new Employee("dd", 26, 12000.99),
            new Employee("dd", 27, 12000.99),
            new Employee("dd", 28, 12000.99)
    );

    @Test
    public void test15(){

        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining("先生  "));
        System.out.println("str = " + str);

    }

    @Test
    public void test14(){

        DoubleSummaryStatistics collect = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("collect = " + collect.getMax()+collect.getMin());


    }


    @Test
    public void test13(){


        Map<Boolean, List<Employee>> collect = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 12000));

        System.out.println("collect = " + collect);



    }


    @Test
    public void test12(){

        Map<String, Map<String, List<Employee>>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.groupingBy(e -> {

                    if (((Employee) e).getAge() < 20) {

                        return "青年";
                    } else {

                        return "shaonian";

                    }

                })));

        System.out.println("collect = " + collect);

    }


    @Test
    public void test11(){

        Long collect = employees.stream()
                .collect(Collectors.counting());
        System.out.println("collect = " + collect);


        Double collect1 = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("collect1 = " + collect1);

        Double collect2 = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));

        System.out.println("collect2 = " + collect2);


        Optional<Employee> collect3 = employees.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));

        System.out.println("collect3 = " + collect3.get().getSalary());

        Optional<Double> collect4 = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));

        System.out.println("collect4 = " + collect4.get());


        Map<String, List<Employee>> collect5 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName));
        System.out.println("collect5 = " + collect5);



    }


    @Test
    public void test10(){

        List<String> list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        for (String s : list) {
            System.out.println("s = " + s);

        }


        System.out.println("==========================");

        Set<String> set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());


        set.forEach(System.out::println);

        for (String s : set) {

            System.out.println("s = " + s);
        }

        System.out.println("===================");

        HashSet<String> collect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        collect.forEach(System.out::println);

    }

    @Test
    public void test9(){

     List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println("reduce = " + reduce);


        System.out.println("=============================");

        Optional<Double> reduce1 = employees.stream()
                .map(Employee::getSalary)
                //.reduce(0.0, (x, y) -> x + y);
                .reduce(Double::sum);
        System.out.println("reduce1 = " + reduce1.get());



    }


    @Test
    public void test8(){

        Optional<Employee> first = employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(first.get());


        Optional<Employee> dd = employees.parallelStream()
                .filter((e) -> e.getName().equals("dd"))
                .findAny();

        System.out.println(dd.get());


        long count = employees.stream()
                .count();
        System.out.println(count);


        Optional<Employee> max = employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

        System.out.println(max.get());


        Optional<Double> max1 = employees.stream()
                .map(Employee::getSalary)
                .max(Double::compare);

        System.out.println(max1.get());


    }


    @Test
    public void test7(){

        employees.stream()
                .sorted((e1,e2)->{

                    if (e1.getAge().equals(e2.getAge())){
                        return e1.getName().compareTo(e2.getName());
                    }else {

                        return e1.getAge().compareTo(e2.getAge());
                    }

                }).forEach(System.out::println);
    }



    @Test
    public void test6(){

        List<String> list = Arrays.asList("aaa","vvv","ddd");

        list.stream()
                .map((str)->str.toUpperCase())
                .forEach(System.out::println);

        System.out.println("--------------------");

        employees.stream()
                .map(Employee::getName)
                .sorted()
                .forEach(System.out::println);

    }


    @Test
    public void test(){

        employees.stream()
                .filter((e)->e.getAge()>20)
                .limit(2)
                .forEach(System.out::println);


    }

    @Test
    public void test1(){

        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()){

            System.out.println(iterator.next());

        }

    }

    @Test
    public void test3(){

     employees.stream()
             .skip(1)
             .forEach(System.out::println);

    }

    @Test
    public void test4(){

        employees.stream()
                .distinct()
                .forEach(System.out::println);

    }
}
