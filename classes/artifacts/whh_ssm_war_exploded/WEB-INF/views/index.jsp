<%--
  Created by IntelliJ IDEA.
  User: weihh
  Date: 2017/4/20
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
${message}
<form id="formId" action="/user/showUser" method="post">
    <table>
        <tr>
            <td>
                用户名：<input type="text" id="id" name="id">
            </td>
        </tr>
        <tr>
            <td>
                密&nbsp;码：<input type="password" id="pwd" name="pwd">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="登录">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
