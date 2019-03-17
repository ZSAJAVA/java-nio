package cn.itheima.gjp.controller;

import cn.itheima.gjp.domain.ZhangWu;
import cn.itheima.gjp.service.ZhangWuService;

import java.util.List;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/23 - 11:39
 */
public class ZhangWuController {

    private ZhangWuService service = new ZhangWuService();

    public List<ZhangWu> selectAll(){

        List<ZhangWu> zhangWus = service.selectAll();


        return zhangWus;



    }


public List<ZhangWu> select(String startDate,String endDate){

        return  service.select(startDate,endDate);


}

public int addZhangwu(ZhangWu zw){

   return service.addZhangwu(zw);


}


public void editZhangWu(ZhangWu zw){


    service.editZhangWu(zw);


}


    public void deleteZhangWu(int id) {

        service.deleteZhangWu(id);

    }
}
