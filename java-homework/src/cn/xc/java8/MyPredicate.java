package cn.xc.java8;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/17 - 17:20
 */
@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);

}
