<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--첫 줄은 JSP 라는 뜻이다.JSP 문서는 이렇게 시작한다.--%>

<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="/jsp/members/save.jsp" method="post"> username: <input type="text" name="username" /> age: <input type="text" name="age" /> <button type="submit">전송</button>
</form>
</body>
</html>

<%--첫 줄을 제외 하고는 완전히 HTML 과 동일한데, JSP는 서버 내부에서 서블릿으로 변환된다
우리가 맏늘었던 MemberFormServlet과 비슷한 모습으로 변환된다.--%>