<%--
  Created by IntelliJ IDEA.
  User: WangLei
  Date: 2021/10/11
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<h1>Hello</h1>

<table border="1" width="300px">
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>

    <tr>
        <td>${user1.id}</td>
        <td>${user1.name}</td>
    </tr>

    <tr>
        <td>${user2.id}</td>
        <td>${user2.name}</td>
    </tr>

    <tr>
        <td>${user3.id}</td>
        <td>${user3.name}</td>
    </tr>

</table>

</body>
</html>
