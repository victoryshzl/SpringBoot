<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>成绩登入</title>
<body>
学生成绩登入
<form action="/aop/rget" method="post">
    用户名：<input type="text" name="name"/>
    <br>
    语文：<input type="text" name="yw"/>
    数学：<input type="text" name="sx"/>
    英语：<input type="text" name="yy"/>
    <br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>