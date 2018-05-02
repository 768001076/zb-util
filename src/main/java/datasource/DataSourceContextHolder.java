package datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: 维护线程使用的数据源
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/3/21
 */
public class DataSourceContextHolder {

    private static Logger logger = LoggerFactory.getLogger(DataSourceContextHolder.class);

    public static String DEFAULT_DATASOURCE = "local";

    public static ThreadLocal<String> DATA_SOURCE = new ThreadLocal<String>();

    // 设置数据源名
    public static void setDB(String dbType) {
        logger.info("切换到{}数据源", dbType);
        DATA_SOURCE.set(dbType);
    }

    // 获取数据源名
    public static String getDB() {
        return (DATA_SOURCE.get());
    }

    // 清除数据源名
    public static void clearDB() {
        DATA_SOURCE.remove();
    }

}
