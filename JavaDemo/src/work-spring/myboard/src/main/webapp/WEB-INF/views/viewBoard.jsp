<%--
  Created by IntelliJ IDEA.
  User: geonoo
  Date: 2024. 8. 19.
  Time: 오후 5:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <h2>${post.title}</h2>
    <p>작성자: ${post.author}</p>
    <p>조회수: ${post.viewCount}</p>
    <p>${post.content}</p>
    <p><a href="<%=request.getContextPath()%>/board?action=edit&id=${post.id}">수정</a></p>
    <p><a href="<%=request.getContextPath()%>/board?action=delete&id=${post.id}">삭제</a></p>
    <p><a href="<%=request.getContextPath()%>/board">목록으로</a></p>
</body>
</html>
