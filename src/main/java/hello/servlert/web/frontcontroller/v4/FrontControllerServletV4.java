package hello.servlert.web.frontcontroller.v4;

import hello.servlert.basic.HelloServlet;
import hello.servlert.web.frontcontroller.ModelView;
import hello.servlert.web.frontcontroller.MyView;
import hello.servlert.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlert.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlert.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServlet4",urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HelloServlet {

    private Map<String, ControllerV4> controllerMap = new HashMap<>();
    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new
                MemberFormControllerV4());

        controllerMap.put("/front-controller/v4/members/save", new
                MemberSaveControllerV4());

        controllerMap.put("/front-controller/v4/members", new
                MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV4 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return; }
        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>(); //추가된 부분

        //기존에는 모델뷰를 전달 받고 model.get() 꺼내썼는데 이제 그럴 필요가 없어졌다.

        String viewName = controller.process(paramMap, model);

        MyView view = viewResolver(viewName);

        view.render(model, request, response);
    }
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,
                        request.getParameter(paramName)));
        return paramMap;
    }
    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
