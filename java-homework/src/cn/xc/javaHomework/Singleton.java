package cn.xc.javaHomework;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/17 - 15:11
 */

/**
 * 饿汉模式
 */
public class Singleton {

    private Singleton(){


    }

    private static Singleton intence = new Singleton();

    public static Singleton getIntence(){

        return intence;

    }


}
