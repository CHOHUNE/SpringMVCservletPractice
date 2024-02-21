<%@ page import="hello.servlert.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>id=${member.age}</li>
<%--    JSP 가 제공하는 프로퍼티 접근법  --%>
</ul>
<a href="/index.html">메인</a>
</body>
</html>