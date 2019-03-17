package com.it.demo;

/**
 * @author ShouAn.Zhang
 * @date 2018/10/10 - 10:34
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity){

       data= (E[]) new Object[capacity];
        size = 0;
    }

    public Array(){

        this(10);
    }

    public int getSize(){

        return size;

    }


    public int getCapacity(){

        return data.length;
    }

    public boolean isEmpty(){

        return size==0;

    }

    public void addLast(E e){

        if (size == data.length){

            throw new IllegalArgumentException("AddLast is failed  arrar is full!!");
        }

        data[size] = e;
        size ++;

        //add(size,e);

    }

    public void addFirst(E e){

        add(0,e);

    }

    public void add(int index,E e){
        if (size == data.length){

            throw new IllegalArgumentException("Add failed  arrar is full!!");
        }


        if (index < 0 || index>size){

            throw new IllegalArgumentException("Add failed  index > 0 || index<=size");
        }

        for (int i = size-1; i>= index;i--){

            data[i+1] = data[i];
            data[index] = e;
            size ++;

        }

    }

    E get(int index){

        if (index<0 || index>=size)
            throw new IllegalArgumentException("index<0 || index>=size");
        return data[index];
    }

    void set(int index,E e){
        if (index<0 || index>=size)
            throw new IllegalArgumentException("index<0 || index>=size");
        data[size] = e;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();

        res.append(String.format("ArraySize: %d,capacity = %d\n",size,data.length));

        res.append("[");
        for (int i = 0;i<size;i++){
            res.append(data[i]);
            if (i != size-1){
                res.append(", ");
            }
            else {
                res.append("]");

            }
        }

        return res.toString();
    }

}

