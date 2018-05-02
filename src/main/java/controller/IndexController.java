package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:
 *
 * @Author:shijialei
 * @Version:1.0
 * @Date:2018/4/4
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
