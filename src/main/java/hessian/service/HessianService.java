package hessian.service;

import hessian.MQServerMonitorHessianServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.stereotype.Component;

@Component
public class HessianService {

    @Autowired MQServerMonitorHessianServer mqServerMonitorHessianServer;

    @Bean("/MQServerMonitor")
    public HessianServiceExporter MQServerMonitorService(){
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(mqServerMonitorHessianServer);
        exporter.setServiceInterface(MQServerMonitorHessianServer.class);
        return exporter;
    }

}
