<%@ page import="com.grepp.model.dto.BoardDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: geonoo
  Date: 2024. 8. 20.
  Time: 오전 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판목록</title>
</head>
<body>
<%@include file="common/header.jsp"%>
<%
    BoardDTO bbb = (BoardDTO) request.getAttribute("bbb");
%>
<a href="<%=request.getContextPath()%>/board/writeForm.do">[글쓰기]</a>
<table border="1">
    <%
        List<BoardDTO> bList = (List<BoardDTO>) request.getAttribute("bList");
        for(BoardDTO b: bList){
    %>
    <tr>
        <td><%=b.getNo()%></td>
        <td><a href="<%=request.getContextPath()%>/board/read.do?no=<%=b.getNo()%>"><%=b.getTitle()%></a></td>
        <td><%=b.getWriter()%></td>
        <td><%=b.getRegDate()%></td>
        <td><%=b.getReadCount()%></td>
    </tr>
    <%
        }
    %>
</table>
<a href="#">[수정하기]</a>
<a href="<%=request.getContextPath()%>/board/list.do">[게시판 목록으로]</a>
</body>
</html>
