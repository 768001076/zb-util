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
 * @Description: dynamic Mapper DataSource 配置
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/3/21
 */
@Component
@MapperScan(basePackages = {"mapper.dynamic"},sqlSessionTemplateRef = "sqlSessionTemplateDynamic",sqlSessionFactoryRef =
        "sqlSessionFactoryDynamic")
public class MybatisDynamicDataSourceConfig {

    @Autowired
    @Qualifier("dynamic") DataSource dynamicSource;

    @Bean
    public SqlSessionFactory sqlSessionFactoryDynamic() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateDynamic() throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryDynamic());
        return sqlSessionTemplate;
    }

}
