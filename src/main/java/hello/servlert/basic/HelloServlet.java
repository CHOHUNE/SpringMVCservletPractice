package hello.servlert.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // ctrl O 를 누르고 서비스 메서드를 오버라이드
    // 이제 서블릿을 실행 시키면 서비스가 실행된다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        //http://localhost:8080/hello 실행되면 해당 메세지 출력

        // 앞서 공부했던 내용을 다시 상기 해보면 서블릿 리퀘스트 요청이 오면, WAS 가(서블릿 컨테이너) request, response 객체를 만들어서 서블릿에 응답해준다.

        System.out.println("request = " + request);
        System.out.println("response = " + response);


        // 서블릿은 쿼리 파라메터 ( ?username=kim )을 getParameter로 매우 쉽게 읽을 수 있다.
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //헤더에 들어가는 내용

        response.getWriter().write("hello"+username);
        // 바디에 들어가는 내용

    }
}
