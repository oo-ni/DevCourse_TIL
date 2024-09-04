<%@ page import="com.grepp.boot.model.dto.ProblemDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Problem Form</title>
</head>
<body>
<%@ include file="common/header.jsp"%>
<h1>문제 추가</h1>
<form action="<%= request.getContextPath() %>/problems" method="post">
    <label for="problemName">문제 이름:</label><br>
    <input type="text" id="problemName" name="problemName" required><br><br>

    <label for="description">문제 설명:</label><br>
    <textarea id="description" name="description" rows="10" cols="50"></textarea><br><br>

    <input type="submit" value="추가">
</form>
<br>
<a href="<%= request.getContextPath() %>/problems">목록으로 돌아가기</a>
<br>
<a href="<%= request.getContextPath() %>/problems">목록으로 돌아가기</a>
</body>
</html>