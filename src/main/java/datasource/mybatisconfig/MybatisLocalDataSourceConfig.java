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
 * @Description: Local Mapper DataSource 配置
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/3/21
 */
@Component
@MapperScan(basePackages = {"mapper.local"},sqlSessionTemplateRef = "sqlSessionTemplateLocal",sqlSessionFactoryRef = "sqlSessionFactoryLocal")
public class MybatisLocalDataSourceConfig {

    @Autowired
    @Qualifier("local") DataSource localSource;

    @Bean
    public SqlSessionFactory sqlSessionFactoryLocal() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(localSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateLocal() throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryLocal());
        return sqlSessionTemplate;
    }

}
