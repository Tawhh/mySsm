package cn.com.weiSsm.controller;

import cn.com.weiSsm.base.BaseController;
import cn.com.weiSsm.model.User;
import cn.com.weiSsm.service.UserService;
import cn.com.weiSsm.utils.CaptchaUtil;
import cn.com.weiSsm.utils.Constant;
import cn.com.weiSsm.utils.Global;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SessionException;
import java.io.IOException;

/**
 * Created by weihh on 2017/4/20.
 */
@Controller
@RequestMapping("/user")
public class UserController /*extends BaseController*/ {
    private Logger loggg = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 项目初始启动页面  在web.xml注释掉welcome配置欢迎页
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        return "/index";
    }

    @RequestMapping("/checkLogin")
    public void checkLogin(HttpServletRequest request, Model model, String veryCode, HttpSession session, User user, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        int flag = 0;
        try {
            String codes = (String) session.getAttribute("code");
            String code = codes.toLowerCase();             //不区分大小写
            String veryCodes = veryCode.toLowerCase();     //不区分大小写
            User users = userService.get(user.getUserName());
            if (!veryCodes.equals(code)) {
                flag = 1;
            }
            if (users == null || !user.getUserPwd().equals(users.getUserPwd())) {
                flag = 2;
            }
            json.put("data", flag);
            Constant.printJsonForJSONP(json, response);
        } catch (Exception e) {
            e.printStackTrace();
            loggg.info("login error!!!");
        }
    }

    @RequestMapping("/registerCheck")
    public void registerCheck(HttpServletRequest request, Model model, String veryCode, HttpSession session, User user, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        int flag = 0;
        try {
            String codes = (String) session.getAttribute("code");
            String code = codes.toLowerCase();             //不区分大小写
            String veryCodes = veryCode.toLowerCase();     //不区分大小写
            User users = userService.get(user.getUserName());
            if (!veryCodes.equals(code)) {
               flag=1;
            }
            if(null!=users){
                flag=2;
            }
            json.put("data", flag);
            Constant.printJsonForJSONP(json, response);
        } catch (Exception e) {
            e.printStackTrace();
            loggg.info("registerCheck error!!!");
        }
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request, RedirectAttributesModelMap model, String veryCode, HttpSession session, User user, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        int flag = 0;
        try {
            userService.save(user);
            model.addFlashAttribute("message","register success!!");
        } catch (Exception e) {
            e.printStackTrace();
            loggg.info("register error!!!");
        }
        return "redirect:index";
    }

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model) {
        loggg.info("login for judge");
        String ming = request.getParameter("userName");
        String pwd = request.getParameter("userPwd");
        User user = userService.get(ming);
        if (user != null && pwd.equals(user.getUserPwd())) {
            model.addAttribute("user", user);
            return "/showUser";
        } else {
            model.addAttribute("message", "loginError");
            return "/index";
        }
    }


    @RequestMapping("/createCode")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 通知浏览器不要缓存
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "-1");
        CaptchaUtil util = CaptchaUtil.Instance();
        // 将验证码输入到session中，用来验证
        String code = util.getString();
        request.getSession().setAttribute("code", code);
        // 输出打web页面
        ImageIO.write(util.getImage(), "jpg", response.getOutputStream());
    }
}
