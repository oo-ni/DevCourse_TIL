<%@ page import="com.grepp.boot.model.dto.ProblemDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Problem List</title>
</head>
<body>
<%@ include file="common/header.jsp"%>
<h1>문제 목록</h1>
<table border="1">
    <tr>
        <th>번호</th>
        <th>문제 이름</th>
        <th>작성일</th>
        <th>작업</th>
    </tr>
    <%
        List<ProblemDTO> problems = (List<ProblemDTO>) request.getAttribute("problems");
        if (problems != null) {
            for (ProblemDTO problem : problems) {
    %>
    <tr>
        <td><%= problem.getProblemId() %></td>
        <td><a href="<%= request.getContextPath() %>/problems/<%= problem.getProblemId() %>"><%= problem.getProblemName() %></a></td>
        <td><%= problem.getCreatedAt() %></td>
        <td>
            <a href="<%= request.getContextPath() %>/problems/<%= problem.getProblemId() %>/edit">수정</a>
            <a href="<%= request.getContextPath() %>/problems/<%= problem.getProblemId() %>/delete">삭제</a>
        </td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
<a href="<%= request.getContextPath() %>/problems/write">문제 추가</a>
</body>
</html>