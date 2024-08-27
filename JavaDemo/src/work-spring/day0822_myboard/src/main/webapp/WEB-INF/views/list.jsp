<%@ page import="com.grepp.model.dto.BoardDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: geonoo
  Date: 2024. 8. 22.
  Time: 오전 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판 목록 페이지</title>
</head>
<body>
<%@ include file="common/header.jsp" %>

<h2>게시판 목록입니다.</h2>
<table border="1">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>
    <%
        List<BoardDTO> boardList = (List<BoardDTO>) request.getAttribute("boardList");
        if (boardList != null && !boardList.isEmpty()) {
            for (BoardDTO b : boardList) {
    %>
    <tr>
        <td><%=b.getNo()%></td>
        <td><a href="<%=request.getContextPath()%>/board/read?no=<%=b.getNo()%>"><%=b.getTitle()%></a></td>
        <td><%=b.getWriter()%></td>
        <td><%=b.getRegDate()%></td>
        <td><%=b.getReadCount()%></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5">게시물이 없습니다.</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
