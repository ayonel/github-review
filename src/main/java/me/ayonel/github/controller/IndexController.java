package me.ayonel.github.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: ayonel
 * Date: 2017/12/10
 * Blog: https://ayonel.me
 * GitHub: https://github.com/ayonel
 * Email: ayonel@qq.com
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return"forward:index.html";
    }

}
