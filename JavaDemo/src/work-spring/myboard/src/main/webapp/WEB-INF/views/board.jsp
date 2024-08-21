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
    <title>Title</title>
</head>
<body>
    <h2>
        Post
    </h2>

    <form action="${pageContext.request.contextPath}/board" method="post">
        <input type="hidden" name="action" value="${not empty post ? 'update' : 'create'}">
        <input type="hidden" name="postId" value="${post.id}">

        <label for="title">제목:</label>
        <input type="text" id="title" name="title" value="${post.title}">
        <br>

        <label for="content">내용:</label>
        <textarea id="content" name="content">${post.content}</textarea>
        <br>

        <input type="submit" value="저장">
    </form>

    <p><a href="<%=request.getContextPath()%>/board">목록으로</a></p>
</body>
</html>
