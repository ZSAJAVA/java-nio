package com.it.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShouAn.Zhang
 * @date 2018/10/10 - 10:04
 */
public class ArrayDemo {


    public static void main(String[] args) {

        Array<Integer> array = new Array<Integer>(20);

        for (int i =0 ;i<10;i++){

                array.addLast(i);

        }

        System.out.println(array);

    }

}
