<%@ page import="com.grepp.boot.model.dto.ProblemDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Problem Detail</title>
</head>
<body>
<%@ include file="common/header.jsp"%>
<%
    ProblemDTO problem = (ProblemDTO) request.getAttribute("problem");
    if (problem != null) {
%>
<h1><%= problem.getProblemName() %></h1>
<p>문제 번호: <%= problem.getProblemId() %></p>
<p>설명: <%= problem.getDescription() %></p>
<p>작성일: <%= problem.getCreatedAt() %></p>
<a href="<%= request.getContextPath() %>/problems/<%= problem.getProblemId() %>/edit">수정</a>
<a href="<%= request.getContextPath() %>/problems/<%= problem.getProblemId() %>/delete">삭제</a>
<br><br>
<a href="<%= request.getContextPath() %>/problems">목록으로 돌아가기</a>
<%
} else {
%>
<p>문제를 찾을 수 없습니다.</p>
<a href="<%= request.getContextPath() %>/problems">목록으로 돌아가기</a>
<%
    }
%>

</body>
</html>