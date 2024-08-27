<%--
  Created by IntelliJ IDEA.
  User: geonoo
  Date: 2024. 8. 22.
  Time: 오전 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메인 페이지</title>
</head>
<body>
<h2>Welcome :)</h2>

<%@ include file="common/header.jsp" %>

<div>

    <a href="<%=request.getContextPath()%>/board/list">[게시판 목록]</a><br><br>
    <a href="<%=request.getContextPath()%>/board/write">[게시글 쓰기]</a>
</div>
</body>
</html>
