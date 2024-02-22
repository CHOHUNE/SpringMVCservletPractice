package hello.servlert.web.frontcontroller.v3.controller;

import hello.servlert.domain.member.Member;
import hello.servlert.domain.member.MemberRepository;
import hello.servlert.web.frontcontroller.ModelView;
import hello.servlert.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();


    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        // 이전에 해왔 듯 HttpServletRequest.getParametr()로 꺼내는 게 아니라 X
        // 위의 정보는 프론트 컨트롤러에서 처리하고
        // 파람 맵에다가 요청 파라메터 정보를 전부 담아 넘겨줄 것이다.
        // 여기서는 단순히 꺼내서 쓰기만 하면 된다.
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);

        return mv;

    }
}
