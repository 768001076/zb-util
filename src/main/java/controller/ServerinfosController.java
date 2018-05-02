package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ServerInfoService;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 服务器信息
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/4/24
 */
@RequestMapping(value = "/server")
@Controller
public class ServerinfosController {

    @Autowired ServerInfoService serverInfoService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8"})
    @ResponseBody
    public String getAllServerInfos(){
        return serverInfoService.getAllServerInfo();
    }

    @RequestMapping(value = "/server/*", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8"})
    @ResponseBody
    public String getServerInfos(HttpServletRequest request){
        String[] split = request.getAttribute("URI").toString().split("/");
        String serverInfoByIp = serverInfoService.getServerInfoByIp(split[split.length - 1]);
        return serverInfoByIp;
    }

}
