package cn.com.weiSsm.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.StringUtils;

public class RoleFilter implements Filter{
    public static String defaultUrl;
    // 不拦截的资源类型
    private static String[] ignoreTypes;
    @Override
    public void destroy() {
        System.out.println("销毁拦截器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());


        boolean isIgnoreType = false;
        if(ignoreTypes != null){
            for (int i = 0; i < ignoreTypes.length; i++) {
                if (url.endsWith("." + ignoreTypes[i])) {
                    isIgnoreType = true;
                    break;
                }
            }
        }else{
            chain.doFilter(request, response);
        }

        /*if(url.indexOf("/user/showUser") > -1||url.indexOf("/user/showUser") > -1||url.indexOf("/user/showUser") > -1||isIgnoreType==true){
            System.out.println(url+"这是登录入口或者静态资源，放行");
            chain.doFilter(request, response);
        }else{
            String name = (String)request.getSession().getAttribute("UserName");
            if(name==null){
                response.sendRedirect(contextPath+"/user/showUser");
            }else{
                System.out.println("用户名:"+name);
                chain.doFilter(request, response);
            }
        }*/
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { defaultUrl = filterConfig.getInitParameter("defaultUrl"); String ignoreTypes = filterConfig.getInitParameter("ignoreTypes"); if(ignoreTypes != null && !ignoreTypes.trim().equals("")){ this.ignoreTypes = ignoreTypes.split(","); } }

}
