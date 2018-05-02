package util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyStaticUrl extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler中的是访问路径，可以修改为其他的字符串
        //addResourceLocations中的是实际路径
        //TODO 测试使用 不重启
        //registry.addResourceHandler("/my/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/my/**").addResourceLocations("file:" + System.getProperty("user.dir") +
                "/src/main/resources/static/");
        super.addResourceHandlers(registry);
    }

}
