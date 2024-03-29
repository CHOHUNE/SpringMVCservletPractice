package hello.servlert.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // [status-line]
        resp.setStatus(HttpServletResponse.SC_OK);
//    resp.setStatus(HttpServletResponse.SC_CONFLICT);

        //[response-headers]
        resp.setHeader("Content-type", "text/plain");
        resp.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");
        //임의로 직접 만든 헤더

        //헤더 편의 메서드

        content(resp);
        cookie(resp);

        PrintWriter writer = resp.getWriter();
        writer.println("ok");

    }

    //    Content 편의 메서드
    private void content(HttpServletResponse response) {
//Content-Type: text/plain;charset=utf-8
//Content-Length: 2
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.setContentLength(2); //(생략시 자동 생성)
    }

    //        **쿠키 편의 메서드**
    private void cookie(HttpServletResponse response) {
//Set-Cookie: myCookie=good; Max-Age=600;
        response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    //        **redirect 편의 메서드**
    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html
        response.setStatus(HttpServletResponse.SC_FOUND); //302
        response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }

}
