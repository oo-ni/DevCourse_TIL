<%@ page import="com.grepp.model.dto.BoardDTO" %><%--
  Created by IntelliJ IDEA.
  User: geonoo
  Date: 2024. 8. 22.
  Time: 오전 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 상세보기 페이지</title>
</head>
<body>
<%@ include file="common/header.jsp"%>

<%
    BoardDTO b = (BoardDTO) request.getAttribute("board");
%>
<table border="1">
    <tr>
        <td>글번호 : </td>
        <td><%=b.getNo()%></td>
    </tr>
    <tr>
        <td>제목 : </td>
        <td><%=b.getTitle()%></td>
    </tr>
    <tr>
        <td>작성자 : </td>
        <td><%=b.getWriter()%></td>
    </tr>
    <tr>
        <td>작성일시 : </td>
        <td><%=b.getRegDate()%></td>
    </tr>
    <tr>
        <td>조회수 : </td>
        <td><%=b.getReadCount()%></td>
    </tr>
    <tr>
        <td>내용 : </td>
        <td><%=b.getContent()%></td>
    </tr>
</table>
<a href="#">[수정하기]</a>
<a href="<%=request.getContextPath()%>/board/list">[게시판 목록으로]</a>

</body>
</html>
