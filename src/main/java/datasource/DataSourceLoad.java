package datasource;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import config.AccountDataSourceConfig;
import config.LocalDataSourceConfig;
import config.TestDataSourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 加载数据源
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/3/20
 */
@Component
public class DataSourceLoad {

    private Logger logger = LoggerFactory.getLogger(DataSourceLoad.class);

    @Autowired LocalDataSourceConfig localDataSourceConfig;

    @Autowired TestDataSourceConfig testDataSourceConfig;

    @Autowired AccountDataSourceConfig accountDataSourceConfig;

    @Bean(name = "local")
    public DataSource local() {
        Map<String,String> config = new HashMap<String, String>();
        config.put("driverClassName",localDataSourceConfig.getDriverclassname());
        config.put("url",localDataSourceConfig.getUrl());
        config.put("username",localDataSourceConfig.getUsername());
        config.put("password",localDataSourceConfig.getPassword());
        config.put("validationQueryTimeout","30000");
        config.put("validationQuery","select 1");
        DataSource dataSource = null;
        try {
            dataSource = DruidDataSourceFactory.createDataSource(config);
        }
        catch (Exception e) {
            logger.error("LoadDataSourceException");
        }
        return dataSource;
    }




    @Bean(name = "test")
    public DataSource test() {
        Map<String,String> config = new HashMap<String, String>();
        config.put("driverClassName",testDataSourceConfig.getDriverclassname());
        config.put("url",testDataSourceConfig.getUrl());
        config.put("username",testDataSourceConfig.getUsername());
        config.put("password",testDataSourceConfig.getPassword());
        config.put("validationQueryTimeout","30000");
        config.put("validationQuery","select 1");
        DataSource dataSource = null;
        try {
            dataSource = DruidDataSourceFactory.createDataSource(config);
        }
        catch (Exception e) {
            logger.error("LoadDataSourceException");
        }
        return dataSource;
    }

    @Bean(name = "account")
    public DataSource Account() {
        Map<String,String> config = new HashMap<String, String>();
        config.put("driverClassName",accountDataSourceConfig.getDriverclassname());
        config.put("url",accountDataSourceConfig.getUrl());
        config.put("username",accountDataSourceConfig.getUsername());
        config.put("password",accountDataSourceConfig.getPassword());
        config.put("validationQueryTimeout","30000");
        config.put("validationQuery","select 1");
        DataSource dataSource = null;
        try {
            dataSource = DruidDataSourceFactory.createDataSource(config);
        }
        catch (Exception e) {
            logger.error("LoadDataSourceException");
        }
        return dataSource;
    }


    @Bean(name = "dynamic")
    public DataSource dynamic(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(local());

        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap(8);
        dsMap.put("local", local());
        dsMap.put("test", test());
        dsMap.put("account", Account());
        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }

}
