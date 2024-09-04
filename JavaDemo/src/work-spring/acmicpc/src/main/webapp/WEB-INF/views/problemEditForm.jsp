<%@ page import="com.grepp.boot.model.dto.ProblemDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Problem Edit Form</title>
</head>
<body>
<%@ include file="common/header.jsp"%>
<%
    ProblemDTO problem = (ProblemDTO) request.getAttribute("problem");
%>
<h1>문제 수정</h1>
<form action="<%= request.getContextPath() %>/problems/<%= problem.getProblemId() %>" method="post">
    <label for="problemName">문제 이름:</label><br>
    <input type="text" id="problemName" name="problemName" value="<%= problem.getProblemName() %>" required><br><br>

    <label for="description">문제 설명:</label><br>
    <textarea id="description" name="description" rows="10" cols="50"><%= problem.getDescription() %></textarea><br><br>

    <input type="submit" value="수정">
</form>
<br>
<a href="<%= request.getContextPath() %>/problems">목록으로 돌아가기</a>
</body>
</html>