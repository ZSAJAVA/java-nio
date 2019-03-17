package cn.itheima.gjp.view;

import cn.itheima.gjp.controller.ZhangWuController;
import cn.itheima.gjp.domain.ZhangWu;

import java.util.List;
import java.util.Scanner;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/23 - 11:41
 */
public class MainView {

    private ZhangWuController controller = new ZhangWuController();


    public void run() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("---------------管家婆家庭记账软件---------------");
            System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
            System.out.println("请输入要操作的功能序号[1-5]:");

            //接收键盘输入
            int op = sc.nextInt();

            switch (op) {


                case 1:
                    addZhangWu();
                    break;
                case 2:
                    editZhangWu();
                    break;
                case 3:
                    deleteZhangWu();
                    break;
                case 4:
                    selectZhangWu();
                    break;
                case 5:
                    System.out.println("再见");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误！");


            }


        }


    }

    public void selectZhangWu() {
        System.out.println("1.查询所有    2.按条件查询");


        Scanner sc = new Scanner(System.in);

        int selectChoose = sc.nextInt();

        switch (selectChoose) {

            case 1:
                selectAll();
                break;
            case 2:
                select();
                break;

        }


    }


    public void selectAll() {

        List<ZhangWu> list = controller.selectAll();

        if (list.size()!=0)
            print(list);

        else
            System.out.println("很遗憾 没数据");


    }


    public void select() {


        Scanner sc = new Scanner(System.in);
        System.out.print("请输入开始日期：");
        String startDate = sc.nextLine();
        System.out.print("请输入结束日期：");
        String endDate = sc.nextLine();


        List<ZhangWu> list = controller.select(startDate, endDate);

        if (list.size()!=0)
        print(list);

        else
            System.out.println("很遗憾 没数据");

    }

    public void addZhangWu(){

        ZhangWu zw = new ZhangWu();

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入消费类别：");
        String flname = sc.next();
        System.out.println("请输入消费金额：");
        double money = sc.nextDouble();
        System.out.println("请输入消费方式：");
        String zhangHu = sc.next();
        System.out.println("请输入消费时间 格式 xxxx-xx-xx：");
        String createtime = sc.next();
        System.out.println("请输入消费说明：");
        String description = sc.next();

       zw.setCreatetime(createtime);
       zw.setDescription(description);
       zw.setFlname(flname);
       zw.setMoney(money);
       zw.setZhangHu(zhangHu);


        int i = controller.addZhangwu(zw);

        if (i>0){

            System.out.println("添加成功！");

        }

    }


    public void editZhangWu(){
        selectAll();
        System.out.println("你选择的是编辑功能！");

        ZhangWu zw = new ZhangWu();

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入ID:");
        int id = sc.nextInt();
        System.out.println("请输入消费类别：");
        String flname = sc.next();
        System.out.println("请输入消费金额：");
        double money = sc.nextDouble();
        System.out.println("请输入消费方式：");
        String zhangHu = sc.next();
        System.out.println("请输入消费时间 格式 xxxx-xx-xx：");
        String createtime = sc.next();
        System.out.println("请输入消费说明：");
        String description = sc.next();

        zw.setZwid(id);
        zw.setCreatetime(createtime);
        zw.setDescription(description);
        zw.setFlname(flname);
        zw.setMoney(money);
        zw.setZhangHu(zhangHu);


        controller.editZhangWu(zw);

        System.out.println("编辑成功！");
    }


    public void deleteZhangWu(){
        selectAll();
        Scanner sc = new Scanner(System.in);
        System.out.println("你选择的删除功能！");
        System.out.println("请输入你要删除的id：");
        int id = sc.nextInt();


        controller.deleteZhangWu(id);

        System.out.println("删除成功！！");


    }

    public static void print(List<ZhangWu> list) {

        System.out.println("ID\t类别\t\t\t账户\t\t\t金额\t\t\t时间\t\t\t\t\t说明");

        for (ZhangWu zw : list) {

            System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t"
                    + zw.getZhangHu() + "\t\t\t" + zw.getMoney() + "\t\t"
                    + zw.getCreatetime() + "\t\t" + zw.getDescription());
        }


    }

}
