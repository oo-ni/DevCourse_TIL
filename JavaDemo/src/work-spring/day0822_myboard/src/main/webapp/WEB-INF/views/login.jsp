<%--
  Created by IntelliJ IDEA.
  User: geonoo
  Date: 2024. 8. 22.
  Time: 오전 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
<h2>로그인</h2>
<form action="<%=request.getContextPath()%>/member/login" method="post">
    <label for="userId">아이디 &nbsp;:  &nbsp; </label>
    <input type="text" id="userId" name="userId" value="<%=request.getAttribute("savedId") != null ? request.getAttribute("savedId") : "" %>">
    <br><br>
    <label for="password">비밀번호 :</label>
    <input type="password" id="password" name="password">
    <br><br>
    <label for="remember">아이디 기억하기</label>
    <input type="checkbox" id="remember" name="remember">
    <br><br>
    <input type="submit" value="로그인">
</form>
</body>
</html>
