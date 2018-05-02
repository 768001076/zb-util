package datasource.mybatisconfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Description: Test Mapper DataSource 配置
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/3/21
 */
@Component
@MapperScan(basePackages = {"mapper.test"},sqlSessionTemplateRef = "sqlSessionTemplateTest",sqlSessionFactoryRef = "sqlSessionFactoryTest")
public class MybatisTestlDataSourceConfig {

    @Autowired
    @Qualifier("test") DataSource testSource;

    @Bean
    public SqlSessionFactory sqlSessionFactoryTest() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(testSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateTest() throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryTest());
        return sqlSessionTemplate;
    }

}
