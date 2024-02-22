package hello.servlert.web.frontcontroller.v2.controller;

import hello.servlert.domain.member.Member;
import hello.servlert.domain.member.MemberRepository;
import hello.servlert.web.frontcontroller.MyView;
import hello.servlert.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListController implements ControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);
//        String viewPath = "/WEB-INF/views/members.jsp";
//        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request, response);

        return new MyView("/WEB-INF/views/members.jsp");
    }
}
