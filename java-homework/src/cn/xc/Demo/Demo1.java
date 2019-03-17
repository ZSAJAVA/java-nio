package cn.xc.Demo;

import com.sun.deploy.util.ArrayUtil;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ShouAn.Zhang
 * @date 2018/10/21 - 19:22
 */
public class Demo1 {

    public static void main(String[] args) {

        String[] roms = {"101","102","103","104","105"};

        printRoms(roms);

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要预定的房间号");
        String no = sc.next();

        order(no,roms);

        printRoms(roms);

    }

    //显示房间列表
    public static void printRoms(String[] roms){

        System.out.println("可预定的房间列表");
        for (int i = 0; i < roms.length; i++) {

            if(i == roms.length-1){

                System.out.println(roms[i]);
            }else {

                System.out.print(roms[i] + "   ");
            }
        }

    }

    //输入房间号进行预定
    public static void order(String no,String[] roms){


        for (int i = 0; i < roms.length; i++) {

            if (roms[i] == no){

                roms[i]=no+"房间预订成功";
            }

        }



    }




}
