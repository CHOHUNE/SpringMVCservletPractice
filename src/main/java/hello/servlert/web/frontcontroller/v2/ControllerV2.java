package hello.servlert.web.frontcontroller.v2;

import hello.servlert.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV2 {

    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    //기존의 v1과 구조는 똑같은데 반환만 MyView로 반환한다.



}
