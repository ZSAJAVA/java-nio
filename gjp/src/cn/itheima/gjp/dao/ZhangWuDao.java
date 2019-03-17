package cn.itheima.gjp.dao;

import cn.itheima.gjp.domain.ZhangWu;
import cn.itheima.gjp.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/23 - 11:29
 */
public class ZhangWuDao {

    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());


    public List<ZhangWu> seleceAll(){

        try {
            String sql = "select * from gjp_zhangwu";

            List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));

            return list;

        }catch (SQLException ex){

            System.out.println(ex);
            throw new RuntimeException("查询所有失败！");

        }


    }

    public List<ZhangWu> select(String startDate,String endDate){


        String sql = "select * from gjp_zhangwu where createtime between ? and ?";

        Object[] params = {startDate,endDate};

        List<ZhangWu> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<>(ZhangWu.class), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  list;



    }

    public int addZhangwu(ZhangWu zw){

        String sql = "insert into gjp_zhangwu(flname,money,zhanghu,createtime,description) values(?,?,?,?,?)";


        Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhangHu(),zw.getCreatetime(),zw.getDescription()};

        int i = 0;
        try {
            i = qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }

    public void editZhangWu(ZhangWu zw) {

        String sql = "update gjp_zhangwu set flname=?, money=?,zhanghu=?,createtime=?,description=? where zwid=?";

        Object[] parmas={zw.getFlname(),zw.getMoney(),zw.getZhangHu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};


        try {
             qr.update(sql, parmas);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteZhangWu(int id) {

        String sql = "delete from gjp_zhangwu where zwid=?";

        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
