package hello.servlert.web.frontcontroller.v3;

import hello.servlert.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
//    v와 비교 해봤을 때 서블릿이 사라져서 매우 간결해졌다.
}
