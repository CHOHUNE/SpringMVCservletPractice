package hello.servlert.web.frontcontroller.v3;

import hello.servlert.web.frontcontroller.ModelView;
import hello.servlert.web.frontcontroller.MyView;
import hello.servlert.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlert.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlert.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="FrontControllerServletV3",urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //paramMap을 넘겨줘야 한다.
        // 이터레이터로 파람 맵을 다 꺼내야 한다.
        Map<String, String> paramMap = createParamMap(request);

        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName();//논리이름만 얻고 있어 (new-form) 물리 이름으로 변경 해주는 과정이 필요하다
        MyView view = viewResolver(viewName);


        view.render(mv.getModel(), request, response);

    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB_INF/views/" + viewName + "jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

}
