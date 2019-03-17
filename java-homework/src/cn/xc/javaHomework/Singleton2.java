package cn.xc.javaHomework;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/17 - 15:30
 */

/**
 * 懒汉模式
 */
public class Singleton2 {

    private Singleton2(){

    }

    private static Singleton2 intence;

    public static Singleton2 getIntence(){

        if (intence==null){


            intence = new Singleton2();

        }


        return intence;
    }


}
