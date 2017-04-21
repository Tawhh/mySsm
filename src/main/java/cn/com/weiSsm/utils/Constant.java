package cn.com.weiSsm.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by t420 on 2017/4/21.
 */
public class Constant {
    public static String LOGIN_ERROR_CODE_100000 = "100000";
    public static String LOGIN_ERROR_MESSAGE_VALIDATECODE = "验证码输入错误，请重新输入！";
    public static String LOGIN_ERROR_CODE_100001 = "100001";
    public static String LOGIN_ERROR_MESSAGE_USERERROR = "账号或密码错误，请重新输入！";
    public static String LOGIN_ERROR_CODE_100002 = "100002";
    public static String LOGIN_ERROR_MESSAGE_SYSTEMERROR = "用户已经被锁定不能登录，请与管理员联系！";
    public static String LOGIN_ERROR_CODE_100003 = "100003";
    public static String LOGIN_ERROR_MESSAGE_MAXERROR = "登录失败次数过多,锁定10分钟！";
    public static String LOGIN_ERROR_CODE_100004 = "100004";
    public static String LOGIN_ERROR_MESSAGE_FORCELOGOUT = "您已经被管理员强制退出，请重新登录";
    public static void printJsonForJSONP(JSONObject jsonOb, HttpServletResponse response)
    {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        try
        {
            response.getWriter().write(JSON.toJSONString(jsonOb, new SerializerFeature[] { SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullBooleanAsFalse }));
            response.getWriter().flush();
            response.getWriter().close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

