package com.grepp.controller;

import com.grepp.controller.util.MyPageInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// board.do, member.do, login.do ... 등등 모두 다 여기로 실행되게
// 그런고로 혹시 다른 서블릿이 있다면 걔들보다 이 서블릿이 더 먼저 생성되게 loadOnStartup = 1
// Spring 백엔드 프레임워크 만든 사람들의 생각. 서블릿 단 하나로 다 처리되게 하자. -> dispatcherServlet
@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
    MyControllerMapping controllerMapping = new MyControllerMapping();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        System.out.println("request here : " + url);

        // 컨트롤러 특정해서 무언가 핵심작업 처리하기 전. 공통작업.
        ////////////////////////////////////////////////////////////////////////////////////////////////////

        HttpSession session = req.getSession();
        String loginId = (String) session.getAttribute("loginId");
        if (url.startsWith("/board") && !url.endsWith("/list.do") && loginId == null) {     // 게시판 작업 하고싶은데 && 목록은 아니고 && 로그인 정보 없어?
            req.setAttribute("msg", "로그인 정보가 필요합니다.");
            req.setAttribute("path", req.getContextPath() + "/member/loginForm.do");
            req.getRequestDispatcher("/WEB-INF/views/alert.jsp").forward(req, resp);
            return;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////

        try {
            MyController controller = controllerMapping.getController(url);     // 얘한테 물어보면 컨트롤러 객체중에 하나 줄거임~~ BoardController, MemberController, MainController, ...etc

            Object controllerResult = null;
            if (controller != null) {   // 해당 요청을 처리할 컨트롤러 객체가 있음!
                controllerResult = controller.handleRequest(req, resp);     // 야 일해라~!
            } else {    // 해당 요청을 처리할 컨트롤러 못찾았음!
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }

            if (controllerResult instanceof MyPageInfo) {   // forward 또는 redirect 둘 중 하나일 때 여기. (html 화면이 필요한 경우)
                MyPageInfo pageInfo = (MyPageInfo) controllerResult;
                System.out.println(pageInfo);
                if (pageInfo.isForward()) {     // html 만들라고 jsp한테 전달해서 화면 만들기
                    req.getRequestDispatcher("/WEB-INF/views" + pageInfo.getPath() + ".jsp").forward(req, resp);
                } else {    // jsp한테 화면 만들라고 안시키고 클라이언트에게 새로운 요청 유도하기. ~~~.do 라고 리다이렉트 시키겠죵
                    resp.sendRedirect(req.getContextPath() + pageInfo.getPath());
                }
            } else {    // REST 요청에 대한 data 응답. (백엔드가 html 화면이 아니라 날것의 data만 응답하는 경우가 여기.)

            }
        } catch (Exception e) {
//            throw new RuntimeException(e);  // 이러면 tomcat한테까지 예외 던져지는 거임. 걔가 에러페이지 만들거임. 안이쁨...
            e.printStackTrace();
            req.getRequestDispatcher("/WEB-INF/views/errer.jsp").forward(req, resp);
        }
    }
}
