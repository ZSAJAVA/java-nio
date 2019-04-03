package com.xcu.count;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author ShouAn.Zhang
 * @date 2019/3/16 - 21:06
 */
public class Count {

    public static void main(String[] args) throws  Exception {

        //统计单词个数
        BufferedReader br = new BufferedReader(new FileReader("d:/wl/小王子英文版.txt"));

        Map<String,Integer> map = new TreeMap<String, Integer>();

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







//        Set<String> keys = map.keySet();
//
//        for (String key : keys) {
//
//            System.out.println(key + "有：" + map.get(key) + "个.");
//
//        }


        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return  o1.getValue().compareTo(o2.getValue());
            }
        });

        for(Map.Entry<String,Integer> mapping:list){
            System.out.println(mapping.getKey()+"的个数:"+mapping.getValue());
        }


        //单词总个数
        System.out.println("单词总个数："+countWordNm);

        //字符数
        int length = sb.toString().length();

        System.out.println("字符个数："+length);

        //结果写入文件  输出文件地址

        PrintWriter writer = new PrintWriter(new FileOutputStream("d:/wl/resut.txt"), true);
        Iterator<String> iterator = map.keySet().iterator();


        while (iterator.hasNext()){
            String word = iterator.next().toString();
            int num = Integer.parseInt(map.get(word).toString());
            writer.println(word + "有" + num+"个");

        }
        writer.println("单词总个数："+countWordNm);
        writer.println("字符个数："+length);


        br.close();
        writer.close();


    }





}
