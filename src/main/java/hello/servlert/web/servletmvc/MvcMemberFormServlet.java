package hello.servlert.web.servletmvc;


import hello.servlert.basic.HelloServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String viewPath = "/WEB-INF/views/new-form.jsp";
        // 컨트롤러는 단순히 JSP로 가주기만 하면 된다 ( 뷰 )
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // 컨트롤러 - > 뷰 에서 이동할 때 사용하는 메서드
        dispatcher.forward(request,response)
        ;



    }
}
