package cn.xc.javaHomework;

import java.util.Scanner;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/17 - 8:29
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数据的个数： ");
        int num = sc.nextInt();

        //定义对应个数的数组数组
        int[] arr = new int[num];

        for (int i =0;i<=num-1;i++){

            System.out.print("请输入第"+ (i+1) +"个值: ");

            int i1 = sc.nextInt();

            arr[i] = i1;

        }

        System.out.println("交换之前:");
        print(arr);
        int max=getMax(arr);//调用最大值方法
        int maxIndex=getIndex(arr,max); //调用最大值索引的方法
        swap(arr,maxIndex,0);

        int min=getMin(arr);//调用最小值方法
        int minIndex=getIndex(arr,min); //调用最小值索引的方法

        System.out.println("\n=====================");

        swap(arr,minIndex,arr.length-1);
        System.out.println("交换之后:");
        print(arr);
    }



    //求最大值的方法
    public static int getMax(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[0]){
                max=arr[i];
            }
        }
        return max;
    }

    //求最小值的方法
    public static int getMin(int[] arr){
        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[0]){
                min=arr[i];
            }
        }
        return min;
    }

    //求数组中元素角标的方法
    public static int getIndex(int[] arr,int number){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==number){
                return i;
            }
        }
        return -1;//返回-1代表要查询的数在数组中不存在
    }

    //遍历数组的方法
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {


            if (i == arr.length - 1) {
                System.out.println(arr[i]);

            }
            else {
                System.out.print(arr[i] +", ");
            }


        }
    }

    //交换的方法
    public static void swap(int[] arr,int x,int y){ //x,y索引
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }


}
