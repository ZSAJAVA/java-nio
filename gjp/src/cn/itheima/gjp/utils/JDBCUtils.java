package cn.itheima.gjp.utils;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/23 - 11:14
 */
public class JDBCUtils {

    //创建BasicDataSource对象
    private static BasicDataSource dataSource = new BasicDataSource();

    //静态代码块 实现参数设置
    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/gjp");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setMaxActive(10);
        dataSource.setMaxIdle(5);
        dataSource.setMinIdle(2);
        dataSource.setInitialSize(10);
    }

    public static DataSource getDataSource() {

        return dataSource;

    }


}
