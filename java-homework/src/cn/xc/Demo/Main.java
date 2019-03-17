package cn.xc.Demo;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author ShouAn.Zhang
 * @date 2018/10/12 - 9:59
 */
public class Main {


    public static void main(String[] args) {

        function();
    }


    public static void function(){


        BigInteger b1 = new BigInteger("65656554446131645156465465165");
        BigInteger b2 = new BigInteger("65656554446131645156465465165");

        BigInteger add = b1.add(b2);

        System.out.println(add);

       // System.out.println(0.01+0.09);

        BigDecimal g1 = new BigDecimal("0.09");
        BigDecimal g2 = new BigDecimal("0.01");

        BigDecimal add1 = g1.add(g2);

        System.out.println(add1);


    }

}
