<%--
  Created by IntelliJ IDEA.
  User: geonoo
  Date: 2024. 8. 19.
  Time: 오전 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>게시글 목록</h2>
    <table border="1">
        <tr>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
        </tr>
        <c:forEach var="post" items="${posts}">
            <tr>
                <td><a href="<%=request.getContextPath()%>/board?action=view&id=${post.id}">${post.title}</a></td>
                <td>${post.author}</td>
                <td>${post.viewCount}</td>
                <td>
                    <c:if test="${post.author eq sessionScope.userId}">
                        <a href="<%=request.getContextPath()%>/board?action=edit&id=${post.id}">수정</a>
                        <a href="<%=request.getContextPath()%>/board?action=delete&id=${post.id}">삭제</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="<%=request.getContextPath()%>/main">메인 페이지로 돌아가기</a></p>
</body>
</html>
