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

    <button id="btnAddFile">파일 추가</button>
    <div id="divFiles"></div>
    <input type="submit" value="작성 완료">
</form>

<script>
    document.getElementById('btnAddFile').onclick = function () {
        let div = document.createElement('div');

        let input = document.createElement('input');
        input.setAttribute('type', 'file');
        input.setAttribute('name', 'uploadFile');

        let remove = document.createElement('button');
        remove.innerText = '파일 삭제';
        remove.onclick = function () {
            div.remove();
            return false;
        }

        div.appendChild(input);     // <div> <input type="file" name="uploadFile"> </div>
        div.appendChild(remove);
        document.getElementById('divFiles').appendChild(div);

        return false;   // form이 갑자기 파일 추가 버튼 눌렀다고 submit 하는 상황을 막아줌.
    }
</script>
</body>
</html>
