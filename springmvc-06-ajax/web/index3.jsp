<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.1.1.js"></script>

    <script>
        function userInfoMsg() {
            $.post({
                url:"${pageContext.request.contextPath}/a3",
                data:{"name":$("#name").val()},
                success:function(data) {
                    if (data.toString()==='ok') {
                        $("#userInfo").css("color","green");
                    }else {
                        $("#userInfo").css("color","red");
                    }
                    $("#userInfo").html(data);
                }
            })
        }

        function pwdInfoMsg() {
            $.post("${pageContext.request.contextPath}/a3",{"pwd":$("#pwd").val()},function (data) {
                if (data.toString()==='ok') {
                    $("#pwdInfo").css("color","green");
                }else {
                    $("#pwdInfo").css("color","red");
                }
                $("#pwdInfo").html(data);
            })
        }
    </script>
</head>
<body>

<p>
    用户名：
    <input type="text" id="name" onblur="userInfoMsg()"/>
    <span id="userInfo"></span>
</p>
<p>
    密码：
    <input type="text" id="pwd" onblur="pwdInfoMsg()"/>
    <span id="pwdInfo"></span>
</p>

</body>
</html>
