<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>成绩登入</title>
<body>
查询
<br>
<table class="table table-bordered" style="font-family: 微软雅黑">
    <tr>
        <th style="text-align: center">EID</th>
        <th style="text-align: center">ENAME</th>
        <th style="text-align: center">EAGE</th>
    </tr>
    <c:forEach items="${sessionScope.employees}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>