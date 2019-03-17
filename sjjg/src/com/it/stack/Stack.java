package com.it.stack;

/**
 * @author ShouAn.Zhang
 * @date 2018/10/10 - 19:16
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
