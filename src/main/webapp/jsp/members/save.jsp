<%@ page import="hello.servlert.domain.member.MemberRepository" %>
<%@ page import="hello.servlert.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //request, response 사용 가능


  MemberRepository memberRepository = MemberRepository.getInstance();
  System.out.println("save.jsp");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));
  Member member = new Member(username, age);
  System.out.println("member = " + member);
  memberRepository.save(member);
%>


<html>
<head>
  <meta charset="UTF-8">
</head>
<body>
<ul>
  <li>id=<%=member.getId()%></li>
  <li>username=<%=member.getUsername()%></li>
  <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>

<%--대괄호퍼센테이지가 아닌 꺽쇄 괄호는 전부 HttpResponse에 담긴다--%>