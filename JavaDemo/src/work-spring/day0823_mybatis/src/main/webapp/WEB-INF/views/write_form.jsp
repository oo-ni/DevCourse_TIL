<%--
  Created by IntelliJ IDEA.
  User: 관리자
  Date: 2024-08-20
  Time: 오전 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 작성화면</title>
</head>
<body>
<%@ include file="common/header.jsp"%>
<br>
<%--multipart 형식으로 변경함--%>
<form action="<%=request.getContextPath()%>/board/write" method="post" enctype="multipart/form-data">
    제목 : <input type="text" name="title"><br>
    내용 : <textarea name="content"></textarea><br>
    <input type="file" name="uploadFile"><br>
    <input type="file" name="uploadFile"><br>
    <input type="submit" value="작성완료">
</form>

</body>
</html>
