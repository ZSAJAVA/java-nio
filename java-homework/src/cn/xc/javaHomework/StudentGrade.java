package cn.xc.javaHomework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/16 - 21:50
 */
public class StudentGrade {

    public static void main(String[] args) {

        studentInfo();
    }

    public static void studentInfo() {


        List<Student> students = new ArrayList<Student>();

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生总人数！");
        int count = sc.nextInt();


        for (int i = 0; i <= count - 1; i++) {

            Student student = new Student();

            System.out.println("请输入学生的学号！");
            String sno = sc.next();
            student.setSno(sno);

            System.out.println("请输入学生的姓名！");
            String sname = sc.next();
            student.setSname(sname);

            System.out.println("请输入学生的语文成绩！");
            int yuwen = sc.nextInt();
            student.setYuwen(yuwen);

            System.out.println("请输入学生的数学成绩！");
            int shuxue = sc.nextInt();
            student.setShuxue(shuxue);

            System.out.println("请输入学生的英语成绩！");
            int yingyu = sc.nextInt();
            student.setYingyu(yingyu);

            int avgGrade = (yuwen + shuxue + yingyu) / 3;

            student.setAvgGrade(avgGrade);
            students.add(student);


        }

        for (Student student1 : students) {
            System.out.println("学号" + student1.getSno() + "," + "姓名：" + student1.getSname() + "," + "语文成绩："
                    + student1.getYuwen() + "," + "数学成绩：" + student1.getShuxue() + "," + "英语成绩：" + student1.getYingyu() + "," +
                    "平均成绩： " + student1.getAvgGrade());
        }

    }
}
