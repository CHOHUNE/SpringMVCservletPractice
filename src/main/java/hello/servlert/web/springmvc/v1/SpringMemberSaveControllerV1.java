package hello.servlert.web.springmvc.v1;

import hello.servlert.domain.member.Member;
import hello.servlert.domain.member.MemberRepository;
import hello.servlert.web.frontcontroller.ModelView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class SpringMemberSaveControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();


    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        // 이전에 해왔 듯 HttpServletRequest.getParametr()로 꺼내는 게 아니라 X
        // 위의 정보는 프론트 컨트롤러에서 처리하고
        // 파람 맵에다가 요청 파라메터 정보를 전부 담아 넘겨줄 것이다.
        // 여기서는 단순히 꺼내서 쓰기만 하면 된다.
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);

        return mv;
    }
}
