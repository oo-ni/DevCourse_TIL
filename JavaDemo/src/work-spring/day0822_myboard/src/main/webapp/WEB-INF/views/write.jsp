<%--
  Created by IntelliJ IDEA.
  User: geonoo
  Date: 2024. 8. 22.
  Time: 오전 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 작성 페이지</title>
</head>
<body>
<%@ include file="common/header.jsp" %>

<h2>게시글을 작성해주세요.</h2>
<form action="<%=request.getContextPath()%>/board/write" method="post">
    <label>제목 : </label>
    <input type="text" name="title">
    <br><br>
    <label>내용 : </label>
    <textarea name="content"></textarea>
    <br><br>
    <input type="submit" name="작성완료">
</form>
</body>
</html>
