package controller;

import config.LocalDataSourceConfig;
import constant.MapConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.LogService;

import java.util.*;

/**
 * @Description: Log快速查询
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/3/19
 */
@Controller
@RequestMapping("log")
public class LogSelectController {

    private Logger logger = LoggerFactory.getLogger(LogSelectController.class);

    @Autowired
    LogService service;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("log/index");
        return modelAndView;
    }

    @RequestMapping(value = "/getCon/{logPath}/{whe}/{fen}/{dxx}", method = RequestMethod.POST)
    public ModelAndView getContentBY(@PathVariable String logPath,@PathVariable String whe,@PathVariable String
            fen,@PathVariable int dxx){
        logPath= "C:\\Users\\Administrator\\Desktop\\log\\" + logPath + ".log";
        ModelAndView modelAndView = new ModelAndView();
        if (!MapConstant.LOG_NAME_CONTENT.containsKey(logPath)){
            List<String> logContent = service.getLogContent(logPath);
            MapConstant.LOG_NAME_CONTENT.put(logPath,logContent);
        }
        List<String> conts = MapConstant.LOG_NAME_CONTENT.get(logPath);
        List<String> newConts = new ArrayList<String>();
        if (!"-*-*-".equals(whe)){
            Set<String> whes = new HashSet<String>();
            if (!"-*-*-".equals(fen)){
                for (String s : whe.split(fen)) {
                    whes.add(s);
                }

            }else {
                whes.add(whe);
            }
            for (String cont : conts) {
                for (String s : whes) {
                    if (dxx == 0){
                        if (cont.toLowerCase().contains(s.toLowerCase())) {
                            newConts.add(cont);
                        }
                    }else {
                        if (cont.contains(s)) {
                            newConts.add(cont);
                        }
                    }
                }
            }
            modelAndView.addObject("content",newConts);
            modelAndView.addObject("count",newConts.size());
        }else {
            modelAndView.addObject("content",conts);
            modelAndView.addObject("count",conts.size());
        }
        modelAndView.setViewName("log/cont");
        return modelAndView;
    }

}
