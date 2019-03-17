package com.it.stack;

import com.it.demo.Array;

/**
 * @author ShouAn.Zhang
 * @date 2018/10/10 - 19:19
 */
public class ArrayStack<E> implements Stack<E> {


    Array<E> array;

    public ArrayStack(int capacity) {

        array = new Array<>(capacity);

    }

    public ArrayStack() {

        array = new Array<>();

    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {

        array.addLast(e);
    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }


    public int getCapacity(){

        return array.getCapacity();

    }
}
