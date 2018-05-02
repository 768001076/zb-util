package hessian;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import constant.MapConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: MQ监控实现方法
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/3/28
 */
@Component
@Service("MQServerMonitor")
public class MQServerMonitorHessianServerImpl implements MQServerMonitorHessianServer {
    private Logger logger = LoggerFactory.getLogger(MQServerMonitorHessianServerImpl.class);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
    @Override public String UpdateMQServerInfo(String param) {
        JSONObject jsonObject = JSONObject.parseObject(param);
        String key = jsonObject.getString("key");
        JSONArray mqServerMonitorInfos = new JSONArray();
        JSONArray info = JSONArray.parseArray(jsonObject.getString("value"));
        for (int i = 0; i < info.size();i++){
            JSONObject mqServerMonitorInfo = new JSONObject();
            JSONObject queue = info.getJSONObject(i);
            JSONObject message_stats = queue.getJSONObject("message_stats");
            mqServerMonitorInfo.put("queue",queue.getString("name"));
            mqServerMonitorInfo.put("consumers",queue.getInteger("consumers"));
            mqServerMonitorInfo.put("reday",queue.getIntValue("messages_ready"));
            mqServerMonitorInfo.put("unAck",queue.getIntValue("messages_unacknowledged"));
            mqServerMonitorInfo.put("toTal",queue.getIntValue("messages"));
            if (message_stats != null && message_stats.containsKey("deliver_details")){
                mqServerMonitorInfo.put("incoming",message_stats.getJSONObject("deliver_details").getDoubleValue("rate"));
                mqServerMonitorInfo.put("deliver",message_stats.getJSONObject("publish_details").getDoubleValue("rate"));
                mqServerMonitorInfo.put("ack",message_stats.getJSONObject("ack_details").getDoubleValue("rate"));
            }else {
                mqServerMonitorInfo.put("incoming",0);
                mqServerMonitorInfo.put("deliver",0);
                mqServerMonitorInfo.put("ack",0);
            }
            mqServerMonitorInfos.add(mqServerMonitorInfo);
        }
        MapConstant.MQServerMonitorInfo.put(key,mqServerMonitorInfos);
        System.out.println(mqServerMonitorInfos.toJSONString());
        logger.info("MQServerMonitorInfoUpdate" + dateFormat.format(new Date()));
        return "LastUpdate:" + dateFormat.format(new Date());
    }
}
