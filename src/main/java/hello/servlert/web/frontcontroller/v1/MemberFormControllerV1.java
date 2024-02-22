package hello.servlert.web.frontcontroller.v1;

import hello.servlert.web.frontcontroller.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String viewPath = "/WEB-INF/views/new-form.jsp";
        // 컨트롤러는 단순히 JSP로 가주기만 하면 된다 ( 뷰 )
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // 컨트롤러 - > 뷰 에서 이동할 때 사용하는 메서드
        dispatcher.forward(request,response);

    }
}
