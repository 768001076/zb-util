package db;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class InitTest {

    public static void main(String[] args) throws SQLException {
        InitTest initTest;
        initTest = new InitTest();
        initTest.testDB();
    }

    public void testDB() throws SQLException {
        Map<String,String> config = new HashMap<String, String>();
        config.put("driverClassName","net.sourceforge.jtds.jdbc.Driver");
        config.put("url","jdbc:jtds:sqlserver://127.0.0.1:1434/my");
        config.put("username","sa");
        config.put("password","123123");
        config.put("validationQueryTimeout","0");
        config.put("validationQuery","select 1");
        DataSource dataSource = null;
        try {
            dataSource = DruidDataSourceFactory.createDataSource(config);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dataSource.getConnection());
    }

}
