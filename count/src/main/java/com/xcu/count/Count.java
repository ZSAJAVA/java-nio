package com.xcu.count;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ShouAn.Zhang
 * @date 2019/3/16 - 21:06
 */
public class Count {

    public static void main(String[] args) throws  Exception {

        //统计单词个数
        BufferedReader br = new BufferedReader(new FileReader("d:/wl/test.txt"));

        Map<String,Integer> map = new HashMap<String, Integer>();

        String line;

        int countWordNm = 0;

        StringBuffer sb = new StringBuffer();

        while (null != (line=br.readLine())){

            String[] ss = line.split("\\s+");


            for (String s : ss) {

                char[] chars = s.toCharArray();

                for (char ch : chars) {

                    if( ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') ){

                        sb.append(ch);

                    }


                }



                countWordNm++;

                String s1 = s.toLowerCase();

                if (map.containsKey(s1)){

                    map.put(s1, map.get(s1)+1);

                }else {

                    map.put(s1, 1);
                }


            }
        }

        Set<String> keys = map.keySet();

        for (String key : keys) {

            System.out.println(key + "有：" + map.get(key) + "个.");

        }

        //单词总个数
        System.out.println("单词总个数："+countWordNm);

        //字符数
        int length = sb.toString().length();

        System.out.println("字符个哈哈哈数："+length);


        br.close();



    }





}
