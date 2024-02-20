package hello.servlert.web.servlet;

import hello.servlert.domain.member.Member;
import hello.servlert.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="memberListServlet",urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter w = resp.getWriter();
        w.write("");

        w.write("<html>");
        w.write("<head>");
        w.write("    <meta charset=\"UTF-8\">");
        w.write("    <title>Title</title>");
        w.write("</head>");
        w.write("<body>");
        w.write("<a href=\"/index.html\">메인</a>");
        w.write("<table>");
        w.write("<thead>");
        w.write("<th>id</th>");
        w.write("<th>username</th>");
        w.write("<th>age</th>");
        w.write("<tbody>");
        /*
        정적으로 넣는 코드
        * w.write("<tr>");
        * w.write("<td>1</td>);
        * w.write("<td>userA</td>");
        * */

        // 동적으로 넣는 코드
        for (Member member : members) {
            w.write("</tr>");
            w.write("<td>" + member.getId() + "</td>");
            w.write("<td>" + member.getUsername() + "</td>");
            w.write("<td>" + member.getAge() + "</td>");
            w.write("  <tr>");
        }

        w.write("<tbody>");
        w.write("</table>");
        w.write("</body>");
        w.write("</html>");

    }
}
