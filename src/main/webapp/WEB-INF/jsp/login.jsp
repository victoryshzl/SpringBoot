<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>用户登录</title>
<body>
<form name="form1" action="/register" method="post">
    学号：<input type="text" name="uid" id="uid"/>
    <br>
    用户名：<input type="text" name="username"/>
    <br>
    密码：<input type="password" name="password"/>
    <br>
    <input type="submit" value="注册">
    <input type="button" class="mulButton" name="cx" id="btn01" onclick="search('/find')" value="查询"/>

    <script>
        function search(href) {
            var form = document.form1;
            form.action = href;
            form.submit();
        }
    </script>
</form>
</body>
</html>