package service;

import annotation.DS;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import mapper.dynamic.ServerInfoDynamicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 获取信息
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/4/24
 */
@Service
public class ServerInfoServiceImpl implements ServerInfoService {

    @Autowired ServerInfoDynamicMapper mapper;

    /**
     * @Description: 获取所有信息
     *
     * @Return String
     */
    @DS("account")
    @Override public String getAllServerInfo() {
        JSONArray servers = new JSONArray();
        List<Map<String, String>> allServerInfo = mapper.getAllServerInfo();
        MapToJson(servers,allServerInfo);
        return servers.toJSONString();
    }

    /**
     * @Description: 根据ip获取信息
     *
     * @Param ip
     * @Return String
     */
    @DS("account")
    @Override public String getServerInfoByIp(String ip) {
        JSONArray servers = new JSONArray();
        List<Map<String, String>> serverInfo = mapper.getServerInfo(ip);
        MapToJson(servers,serverInfo);
        return servers.toString();
    }

    public void MapToJson(JSONArray array, List<Map<String,String>> serinfo){
        for (Map<String, String> serverInfo : serinfo) {
            JSONObject server = new JSONObject();
            Set<String> keys = serverInfo.keySet();
            for (String key : keys) {
                server.put(key,serverInfo.get(key));
            }
            array.add(server);
        }
    }
}
