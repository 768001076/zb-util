package controller;

import com.alibaba.fastjson.JSONArray;
import constant.MapConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: MQ 监控 对外接口
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/3/29
 */
@Controller
public class MQServerMonitorController {

    /**
     * @Description:
     *
     * @Param id
     * @Return JSONArray
     */
    @RequestMapping(value = "/getMQServerInfo/{id}",method = RequestMethod.GET)
    public JSONArray getMQServerInfo(@PathVariable String id){
        JSONArray infos = MapConstant.MQServerMonitorInfo.get(id);
        return infos;
    }

}
