package cn.xc.javaHomework;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/17 - 15:14
 */
public class Test {

    public static void main(String[] args) {
        Singleton intence = Singleton.getIntence();
        Singleton intence2 = Singleton.getIntence();

        if (intence==intence2){
            System.out.println("intence和intence2一样");

        }else {

            System.out.println("intence和intence2不一样");

        }


        Singleton2 s1 = Singleton2.getIntence();
        Singleton2 s2 = Singleton2.getIntence();

        if (s1==s2){
            System.out.println("s1==s2");

        }else {

            System.out.println("s1 != s2");

        }


    }


}
