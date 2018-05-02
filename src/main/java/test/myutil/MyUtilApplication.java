package test.myutil;

import hessian.MQServerMonitorHessianServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.remoting.caucho.HessianServiceExporter;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
@ComponentScan(value = {"controller","util","service","config","aop","annotation","entity","datasource","hessian",
		"filter"})
@MapperScan(value = {"mapper"})
public class MyUtilApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyUtilApplication.class, args);
	}

}
