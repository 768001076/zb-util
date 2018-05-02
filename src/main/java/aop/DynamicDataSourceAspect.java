package aop;

import annotation.DS;
import datasource.DataSourceContextHolder;
import datasource.DynamicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DynamicDataSourceAspect {

    private Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(annotation.DS)")
    public void beforeDynamicDataSource(JoinPoint point){
        //获取对象
        Class<?> useClass = point.getTarget().getClass();
        //获取方法名
        String methodName = point.getSignature().getName();
        //获取方法参数
        Class[] methodParameters = ((MethodSignature) point.getSignature()).getParameterTypes();
        String datasource = DataSourceContextHolder.DEFAULT_DATASOURCE;

        try {
            //得到方法对象
            Method method = useClass.getMethod(methodName, methodParameters);
            if (method.isAnnotationPresent(DS.class)){
                DS annotation = method.getAnnotation(DS.class);
                datasource = annotation.value();
            }
        }catch (Exception e){
            logger.error("切换数据源异常:" + e.getMessage());
        }
        DataSourceContextHolder.setDB(datasource);
    }

    @After("@annotation(annotation.DS)")
    public void afterDynamicDataSource(){
        DataSourceContextHolder.clearDB();
    }

}
