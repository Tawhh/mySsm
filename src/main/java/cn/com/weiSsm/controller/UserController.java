package cn.com.weiSsm.controller;

import cn.com.weiSsm.model.User;
import cn.com.weiSsm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by weihh on 2017/4/20.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger loggg = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 项目初始启动页面  在web.xml注释掉welcome配置欢迎页
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        return "/index";
    }

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model) {
        loggg.info("login for judge");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        User user = userService.get(id);
        if (user != null && pwd.equals(user.getPwd())) {
            model.addAttribute("user", user);
            return "/showUser";
        } else {
            model.addAttribute("message", "loginError");
            return "/index";
        }
    }
}
