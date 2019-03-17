package cn.itheima.gjp.service;

import cn.itheima.gjp.dao.ZhangWuDao;
import cn.itheima.gjp.domain.ZhangWu;

import java.util.List;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/23 - 11:34
 */
public class ZhangWuService {

    private ZhangWuDao zhangWuDao = new ZhangWuDao();

    public List<ZhangWu> selectAll() {
        List<ZhangWu> zhangWus = zhangWuDao.seleceAll();


        return zhangWus;
    }

    public List<ZhangWu> select(String startDate, String endDate) {

        return zhangWuDao.select(startDate, endDate);

    }

    public int addZhangwu(ZhangWu zw) {


        return zhangWuDao.addZhangwu(zw);

    }

    public void editZhangWu(ZhangWu zw) {

        zhangWuDao.editZhangWu(zw);


    }


    public void deleteZhangWu(int id) {

        zhangWuDao.deleteZhangWu(id);

    }
}
