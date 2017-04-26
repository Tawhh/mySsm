<%--
  Created by IntelliJ IDEA.
  User: weihh
  Date: 2017/4/20
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/static/js/jquery.js"></script>
</head>
<body>
<script type="text/javascript">
    var flag = false;
    function refresh() {
        var url = $("#basePath").val() + "user/createCode?number=" + Math.random();
        $("#img").attr("src", url);
    }
    function doSubmit(option) {
        var flags = true;
        var ming = $("#userName").val();
        var pwd = $("#userPwd").val();
        var code = $("#veryCode").val();
        if ("" == code || null == code) {
            $("#judges").text("请输入验证码！")
            $("#showHidden").show();
            flags = false;
        }
        if ("" == pwd || null == pwd) {
            $("#judges").text("请输入密码！")
            $("#showHidden").show();
            flags = false;
        }
        if ("" == ming || null == ming) {
            $("#judges").text("请输入用户名！")
            $("#showHidden").show();
            flags = false;
        }
        if (flags) {
            if (option == 1) {
                login();
            }else{
                register();
            }
        }
    }
    function login() {
        $.ajax({
            type: "POST", //提交的类型
            async: false,
            data: {userName: $("#userName").val(), userPwd: $("#userPwd").val(), veryCode: $("#veryCode").val()},
            url: "${basePath}/user/checkLogin", //提交地址
            success: function (data) {
                var judge = data.data;
                if (judge == 1) {
                    $("#judges").text("验证码错误！")
                    $("#showHidden").show();
                } else if (judge == 2) {
                    $("#judges").text("用户名或密码错误！")
                    $("#showHidden").show();
                } else {
                    flag = true;
                }
                if (flag) {
                    login1(flag);
                }
            }
        });
    }
    function login1(fds) {
        $("#formId").attr("action", "/user/showUser");
        $("#formId").submit();
    }
    function register1(fds) {
        $("#formId").attr("action", "/user/register");
        $("#formId").submit();
    }
    function register() {
        $.ajax({
            type: "POST", //提交的类型
            async: false,
            data: {userName: $("#userName").val(), userPwd: $("#userPwd").val(), veryCode: $("#veryCode").val()},
            url: "${basePath}/user/registerCheck", //提交地址
            success: function (data) {
                var judge = data.data;
                if (judge == 1) {
                    $("#judges").text("验证码错误！")
                    $("#showHidden").show();
                } else if (judge == 2) {
                    $("#judges").text("用户名以存在！")
                    $("#showHidden").show();
                } else {
                    flag = true;
                }
                if (flag) {
                    register1(flag);
                }
            }
        });
    }
</script>
<center>
    ${message}
    <div id="showHidden" style="display:none;">
        <span id="judges" style="color: red"></span>
    </div>
    <form id="formId" method="post">
        <table>
            <tr>
                <td>
                    用户名：<input type="text" id="userName" name="userName">
                </td>
            </tr>
            <tr>
                <td>
                    密&nbsp;码：<input type="password" id="userPwd" name="userPwd">
                </td>
            </tr>
            <tr>
                <td>
                    验证码：<input id="veryCode" name="veryCode" type="text" size="8"/>
                    <img id="img" alt="" src="<%=basePath%>user/createCode"/>
                    <a href="#" onclick="refresh()">换一张</a>
                    <input id="basePath" name="basePath" type="hidden" value="<%=basePath%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="button" onclick="doSubmit(1)" value="1">登录</button>
                    <button type="button" onclick="doSubmit(2)" value="2">注册</button>
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
