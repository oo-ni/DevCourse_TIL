<%--
  Created by IntelliJ IDEA.
  User: geonoo
  Date: 2024. 8. 14.
  Time: 오후 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            margin: 0;
        }

        div {
            width: 60vw;
            height: 30vh;
            margin-top: 5em;
        }
        table {
            width: 100%;
            border: black solid 1px;

            * tr {
                margin: 1em;
            }

            * td {
                height: 5vh;
                border: black solid 0.5px;
            }

            * input {
                width: 100%;
                border: none;

                *:focus {
                    border: blue solid 1px;
                    border-radius: 0.3em;
                }
            }
        }
        textarea {
            width: 100%;
            height: 6.25em;
            border: none;
            resize: none;
        }

    </style>
</head>
<body>
<div>
    <form action="<%= request.getContextPath() %>/board.do" method="post">
        <table>
            <tbody>
            <tr hidden="hidden">
                <td>번호</td>
                <td>
                    <label for="no"></label>
                    <input type="text" id="no" name="no" value="<%= request.getAttribute("no")%>">
                </td>
            </tr>
            <tr>
                <td>제목</td>
                <td>
                    <label for="title"></label>
                    <input type="text" id="title" name="title" placeholder="<%= request.getAttribute("title")%>">
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>
                    <label for="writer"></label>
                    <input type="text" id="writer" name="writer" disabled>
                </td>
            </tr>
            <tr>
                <td>내용</td>
                <td>
                    <label for="content"></label>
                    <textarea id="content" name="content" placeholder="<%= request.getAttribute("content")%>"></textarea>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="작성하기"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
