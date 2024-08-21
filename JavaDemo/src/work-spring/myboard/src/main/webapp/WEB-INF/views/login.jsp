<%--
  Created by IntelliJ IDEA.
  User: geonoo
  Date: 2024. 8. 19.
  Time: 오전 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>로그인 페이지 입니다.</h2>
    <form action="<%=request.getContextPath()%>/user" method="post">
        <label for="userId">아이디:</label>
        <input type="text" id="userId" name="userId" value="<%=request.getAttribute("save") != null ? request.getAttribute("save") : "" %>">
        <br>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password">
        <br>
        <label for="remember">아이디 기억하기:</label>
        <input type="checkbox" id="remember" name="remember">
        <br>
        <input type="submit" value="로그인">
    </form>
</body>
</html>
