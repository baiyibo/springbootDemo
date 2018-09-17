<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/4
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="../static/js/jquery-1.8.3.min.js"></script>
    <title>登陆</title>
</head>
<body>
<form>
    name:<input type="text" id="username"/>
    password:<input type="text" id="password"/>
    <button id="submit" type="submit">登陆</button>
</form>
</body>
</html>
<script>
    $('#submit[type="submit"]').on('click', function () {
        var username=$('#username').val();
        var password=$('#password').val();

        $.ajax({
            type: "post",
            url: "/login",    //向后端请求数据的url
            data: {username:username,password:password},
            success: function (data) {
              console.log(data);
            }
        });
    });
</script>
