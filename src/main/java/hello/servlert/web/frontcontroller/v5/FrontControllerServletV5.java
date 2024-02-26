package hello.servlert.web.frontcontroller.v5;

import hello.servlert.web.frontcontroller.ModelView;
import hello.servlert.web.frontcontroller.MyView;
import hello.servlert.web.frontcontroller.v3.ControllerV3;
import hello.servlert.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlert.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlert.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlert.web.frontcontroller.v4.ControllerV4;
import hello.servlert.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlert.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlert.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import hello.servlert.web.frontcontroller.v5.adapter.ControllerV3HandlerApater;
import hello.servlert.web.frontcontroller.v5.adapter.ControllerV4HandlerApater;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "frontControllerServlet5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {


    //    private Map<String, ControllerV4> controllerMap = new HashMap<>();
//    기존에 있던 V4 Controller
    private final Map<String, Object> handlerMappingMap = new HashMap<>();
//v5 와 비교해보면 v5는 어떤 버전의 컨트롤러도 와야 하기 때문에 Object로 변경 되었다.

    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {

        initHandlerMappingMap();
        initHandlerAdapters();


    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        //v4추가
        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());


    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerApater());
        handlerAdapters.add(new ControllerV4HandlerApater());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object handler = getHandler(request);


        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);

        ModelView mv = adapter.handle(request, response, handler);


        String viewName = mv.getViewName(); //논리 이름 new-form
        MyView view = viewResolver(viewName);

        view.render(mv.getModel(), request, response);

    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {

        for (MyHandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler apdapter를 찾을 수 없습니다");
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

}
