<%--<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>Hello ZhangZhang</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <%--<base href="<%=basePath%>">--%>
    <style type="text/css">
        @font-face {
            font-family: digit;
            src: url('/static/digital-7_mono.ttf') format("truetype");
        }
    </style>

    <script type="text/javascript" src="/static/js/jquery.js"></script>
    <script type="text/javascript" src="/static/js/garden.js"></script>
    <script type="text/javascript" src="/static/js/functions.js"></script>
    <link href="/static/css/default.css" type="text/css" rel="stylesheet">
</head>

<body>

<div id="mainDiv">
    <div id="content">
        <div id="code">
            <span class="comments">/**</span><br />
            <span class="space"/><span class="comments">*2017—04-21,</span><br />
            <span class="space"/><span class="comments">*/</span><br />
            Boy name = <span class="keyword">Mr</span> WEI<br />
            Girl name = <span class="keyword">Mrs</span> ZHANG<br />
            <span class="comments">// Fall in love river. </span><br />
            The boy love the girl;<br />
            The girl loved the boy;<br />
            <span class="comments">// They love each other.</span><br />
            <br>
            <br>
            I want to say:<br />
            Baby, I love you forever;<br />
        </div>
        <div id="loveHeart">
            <canvas id="garden"></canvas>
            <div id="words">
                <div id="messages">
                    爱你呦，哈尼。
                    <%--<div id="elapseClock"></div>--%>
                </div>
                <div id="loveu">
                    爱你直到永永远远。<br/>
                    <div class="signature">- Mr WEI</div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var offsetX = $("#loveHeart").width() / 2;
    var offsetY = $("#loveHeart").height() / 2 - 55;
    var together = new Date();
    together.setFullYear(2013, 2, 28);
    together.setHours(20);
    together.setMinutes(0);
    together.setSeconds(0);
    together.setMilliseconds(0);

    if (!document.createElement('canvas').getContext) {
        var msg = document.createElement("div");
        msg.id = "errorMsg";
        document.body.appendChild(msg);
        $("#code").css("display", "none")
        $("#copyright").css("position", "absolute");
        $("#copyright").css("bottom", "10px");
        document.execCommand("stop");
    } else {
        setTimeout(function () {
            startHeartAnimation();
        }, 5000);

        timeElapse(together);
        setInterval(function () {
            timeElapse(together);
        }, 500);

        adjustCodePosition();
        $("#code").typewriter();
    }
</script>
<div style="text-align:center;clear:both">
</div>
</body>
</html>