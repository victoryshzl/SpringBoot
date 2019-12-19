<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>用户登录</title>
<body>
排序！
<br>
<table class="table table-bordered" style="font-family: 微软雅黑">
    <tr>
        <th style="text-align: center">tid</th>
        <th style="text-align: center">tname</th>
        <th style="text-align: center">password</th>
    </tr>
    <c:forEach items="${sessionScope.sort}" var="teacher">
        <tr>
            <td>${teacher.tid}</td>
            <td>${teacher.tname}</td>
            <td>${teacher.password}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>