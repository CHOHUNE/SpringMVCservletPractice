<%@ page import="hello.servlert.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=<%=((Member)request.getAttribute("member")).getId() %></li>
    <li>id=<%=((Member)request.getAttribute("member")).getUsername() %></li>
    <li>id=<%=((Member)request.getAttribute("member")).getAge() %></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>