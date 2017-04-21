$(document).ready(function(){

//  $("#clicke").click(function(){
//      clickeBut();
//  });
});

/**
 * 更换图片
 */
function changeImg() {
    var imgSrc = $("#imgObj");
    var src = imgSrc.attr("src");
    imgSrc.attr("src", chgUrl(src));
};
/**
 * 时间戳
 * 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
 */
function chgUrl(url) {
    var timestamp = (new Date()).valueOf();
    var stamp = $("#timestamp");
//    alert(url);
    url = url.substring(0, 60);
    if ((url.indexOf("&") >= 0)) {
        url = url + "×tamp=" + timestamp;
    } else {
        url = url + "?timestamp=" + timestamp;
        stamp.val(timestamp);
    }
    return url;
};
/**
 * 提交
 */
function clickeBut(){
    //帐号
    var userName = $("#id").val().trim();
    //密码
    var password = $("#pwd").val().trim();
    //验证码
    var imageContent = $("#imageContent").val().trim();
    if(userName.length == 0){
        $("#message").text("请输入帐号");
        return false;
    }
//  console.log(password);

    if(password.length == 0){
        $("#message").text("请输入密码");
        return false;
    }
    if(imageContent.length == 0){
        $("#message").text("请输入验证码");
        return false;
    }else if(imageContent.length < 4){
        $("#message").text("验证码错误");
        return false;
    }else{
        //密码判断
        $.ajax({
            type : 'post',
            url : 'user/showUser',
            data : {
                "id" : id,
                "pwd" : pwd
            },
            success : function(data) {
                //'0'失败,'1'成功
                if(data==0){
                    $("#message").text("账号或密码错误");
                    return false;
                }else if(checkImageCode(imageContent)){
                    //成功提交
                    $("#form").attr("action", "user/showUser");
                    $("#form").submit();
                }
            }
        });

    }
};
/**
 * 验证码校验
 */
function checkImageCode(s) {
    //验证码
    var code = s.trim();
    var timestamp = $("#timestamp").val().trim();
//    console.log(code + " " + timestamp);
    var status = "";
    var boo=false;
    if(code.length != 0 ){
        $.ajax({
            type : 'post',
            async : false,
            url : 'user/checkCaptcha',
            data : {
                "code" : code
            },
            success : function(data) {
                status = data;
            }
        });
        if(status.indexOf("true")>=0){
            document.getElementById("imgObj111").style.display = "block";
            $("#imagCheck").val("true");
            $("#message").text("");
            boo = true;
        }else{
            changeImg();
            document.getElementById("imgObj111").style.display = "none";
            $("#message").text("验证码错误");
            return false;
        }
    }else{
        $("#message").text("请输入验证码");
        return;
    }
    return boo;
//    console.log(status);
}