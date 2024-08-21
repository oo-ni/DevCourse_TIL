package com.grepp.myboard.controller;

import com.grepp.myboard.model.Post;
import com.grepp.myboard.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {

    private final BoardService boardService = new BoardService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userId");

        // 게시글 작성 요청시 로그인 여부 판단
        if (action.equals("write")) {
            if (userId == null) {
                req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
            }
            req.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(req, resp);
        } else if (action.equals("edit")) {         // 게시글 수정 요청 처리
            int postId = Integer.parseInt(req.getParameter("postId"));
            Post post = boardService.getPostById(postId);

            // 게시글 존재, 수정하려는 사용자 == 작성하려는 사용자일 경우, 수정 페이지로 이동.
            if (post != null && post.getAuthor().equals(userId)) {
                req.setAttribute("post", post);
                req.setAttribute("postId", postId);
                req.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/board");
            }
        } else if (action.equals("delete")) {           // 게시글 삭제 요청 처리
            int postId = Integer.parseInt(req.getParameter("postId"));
            Post post = boardService.getPostById(postId);

            // 게시글 존재, 삭제하려는 사용자 == 작성하려는 사용자일 경우, deletePost
            if (post != null && post.getAuthor().equals("userId")) {
                boardService.deletePost(postId);
            }
            resp.sendRedirect(req.getContextPath() + "/board");
        } else if (action.equals("view")) {
            int postId = Integer.parseInt(req.getParameter("postId"));
            Post post = boardService.getPostById(postId);

            post.incrementViewCount();  // 조회수 증가
            req.setAttribute("post", post);
            req.getRequestDispatcher("/WEB-INF/views/viewBoard.jsp").forward(req, resp);
        } else {
            req.getAttribute("posts");
            req.getRequestDispatcher("/WEB-INF/views/boardList.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }

        // action null값 예외
        String action = req.getParameter("action");
        if (action == null) {
            resp.sendRedirect(req.getContextPath() + "/board");
            return;
        }


        if (action.equals("update")) {
            int postId = Integer.parseInt(req.getParameter("postId"));
            String title = req.getParameter("title");
            String content = req.getParameter("content");

            Post post = boardService.getPostById(postId);
            if (post != null && post.getAuthor().equals(userId)) {
                post.setTitle(title);
                post.setContent(content);
                boardService.updatePost(postId, post);
            }

            resp.sendRedirect(req.getContextPath() + "/board?action=view&id=" + postId);
        } else {
            String title = req.getParameter("title");
            String content = req.getParameter("content");

            Post post = new Post(userId, title, content);
            boardService.addPost(post);

            resp.sendRedirect(req.getContextPath() + "/board");
        }
    }
}
