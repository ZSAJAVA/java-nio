package cn.xc.ArraysDemo;

import java.util.Arrays;

/**
 * @author ShouAn.Zhang
 * @date 2018/10/12 - 9:26
 */
public class ArrayDemo {

    public static void main(String[] args) {


        int[] arry = {55,99,66,88,22,22,66,77,99};

        int[] test = test(arry);

        System.out.println(Arrays.toString(test));



    }

    
    public static int[] test(int[] arry){
        
        Arrays.sort(arry);
        
        int[] rest =new int[3];
        
        System.arraycopy(arry,0,rest,0,3);
        
        
        return rest;
        
        
    } 

    public static void function_3() {

        int[] arry = {1, 2, 6, 9, 11, 55};


        String string = Arrays.toString(arry);



        System.out.println(string);

    }


    public static void function_2() {

        int[] arry = {1, 2, 6, 9, 11, 55};


        int i = Arrays.binarySearch(arry, 11);


        System.out.println(arry[i]);

    }


    public static void function_1() {

        int[] arry = {1, 5, 9, 8, 6, 7, 2};

        Arrays.sort(arry);

        for (int i : arry) {

            System.out.println(i);

        }


    }

}
