<%--
  Created by IntelliJ IDEA.
  User: fla90
  Date: 2022-09-27
  Time: 오후 4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/hello" method="post">
  <h1>Todo List Page</h1>
    <input value="text" placeholder="할일을 적어주세요" class="text">
    <button type="submit" name="submitBtn" value="sumit">등록</button>
    <button type="submit" name="editBtn" value="edit">수정</button>
    <button type="submit" name="deleteBtn" value="delete">삭제</button>
    <div class="todolists">

    </div>
</form>
  //스크립트 부분
  <script>
      document.querySelector(".submitBtn").addEventListener("click",()=>{
        let todo = document.getElementsByClassName("text")[0].value;

        console.log(todo);

        const todolists = document.querySelector(".todolists")
      })
  </script>
</body>
</html>
