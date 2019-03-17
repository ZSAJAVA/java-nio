package cn.xc.java82;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/17 - 20:32
 */
public class TestLambda {
    @Test
    public void test() {

        happy(10000, (m) -> System.out.println("花了" + m + "yuan"));

    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {


        List<Integer> num = getNum(10, () -> (int) (Math.random() * 100));


        for (Integer integer : num) {

            System.out.println(integer);
        }


    }


    public List<Integer> getNum(int num, Supplier<Integer> sup) {


        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {

            Integer integer = sup.get();

            list.add(integer);

        }

        return list;
    }


    @Test
    public void test6() {

        String asdf = getFun("asdf", (str) -> str.toUpperCase());

        System.out.println(asdf);

    }

    public String getFun(String str, Function<String, String> fun) {

        return fun.apply(str);
    }


    @Test
    public void test8(){

        List<String> list = Arrays.asList("aaa","vvvvv","rrrrr","ok");

        List<String> filter = filter(list, (str) -> str.length() > 3);

        for (String s : filter) {

            System.out.println(s);
        }


    }



    public List<String> filter(List<String> list, Predicate<String> pre){

        List<String> strings = new ArrayList<>();


        for (String s : list) {

            if (pre.test(s)){
                strings.add(s);

            }

        }
        return strings;

    }


}
