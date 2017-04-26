package cn.com.weiSsm.utils;

/**
 * 内容过滤工具类
 */

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.safety.Whitelist;

public class ContentSafeFilter {
    private final static Whitelist user_content_filter = Whitelist.relaxed();
    static {
        //增加可信标签到白名单
        user_content_filter.addTags("font");
        //增加可信属性
        user_content_filter.addAttributes(":all", "style", "class", "id", "name");
        user_content_filter.addAttributes("font", "color","face","size");
    }

    /**
     * 对用户输入内容进行过滤
     * @param html
     * @return
     */
    public static String filter(String html) {
        if(StringUtil.isBlank(html)) return "";
        return Jsoup.clean(html, user_content_filter);
        //return filterScriptAndStyle(html);
    }

    /**
     * 比较宽松的过滤，但是会过滤掉object，script， span,div等标签，适用于富文本编辑器内容或其他html内容
     * @param html
     * @return
     */
    public static String relaxed(String html) {
        return Jsoup.clean(html, Whitelist.relaxed());
    }

    /**
     * 去掉所有标签，返回纯文字.适用于textarea，input
     * @param html
     * @return
     */
    public static String pureText(String html) {
        return Jsoup.clean(html, Whitelist.none());
    }

    /**
     * @param args
     */
   /* public static void main(String[] args) {
        String unsafe = "<table><tr><td>1</td></tr></table>" +
                "<img src='' alt='' />" +
                "<p><a href='http://example.com/' onclick='stealCookies()'>Link</a>" +
                "<object></object>" +
                "<script>alert(1);</script>" +
                "</p>";
        String safe = ContentSafeFilter.filter(unsafe);
        System.out.println("safe: " + safe);
    }*/

}
