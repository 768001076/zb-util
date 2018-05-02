package controller;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TestService;

/**
 * @Description: 测试
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/3/21
 */
@Controller
@RequestMapping("test")
public class TestController {

    @Autowired TestService service;

    @RequestMapping("localTest")
    @ResponseBody
    public String getTestFromLocal(){
        JSONArray result = service.getTestFromLocal();
        return result.toJSONString();
    }

}
