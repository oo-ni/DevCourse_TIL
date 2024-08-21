<%--
  Created by IntelliJ IDEA.
  User: geonoo
  Date: 2024. 8. 19.
  Time: 오전 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>건우의 블로그</title>
</head>
<body>
    <h2><%= session.getAttribute("userId") %>님 반갑습니다~!</h2>
    <p><a href="<%=request.getContextPath()%>/board?action=write">게시글 작성하기</a></p>
    <p><a href="<%=request.getContextPath()%>/board">게시글 목록 확인</a></p>
    <p><a href="<%=request.getContextPath()%>/logout">로그아웃</a></p>
</body>
</html>
