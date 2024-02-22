package hello.servlert.web.frontcontroller.v3.controller;

import hello.servlert.web.frontcontroller.ModelView;
import hello.servlert.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
//        물리적인 이름이 아니라 논리적인 이름만\ 넣는다.
    }
}
