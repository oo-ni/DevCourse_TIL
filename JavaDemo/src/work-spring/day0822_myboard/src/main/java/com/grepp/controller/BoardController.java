package com.grepp.controller;

import com.grepp.model.dto.BoardDTO;
import com.grepp.model.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;
//    private final BoardService boardService = BoardService.getInstance();

    @GetMapping("/list")
    public String list(Model model) throws SQLException {
        List<BoardDTO> boardList = boardService.getBoards();
        model.addAttribute("boardList", boardList);
        return "list";
    }

    @GetMapping("/read")
    public String read(@RequestParam("no") int no, Model model) throws SQLException {
        // 인터셉터 활용하며 삭제
//        String userId = (String) session.getAttribute("userId");
//
//        if (userId == null) {
//            model.addAttribute("msg", "로그인이 필요합니다.");
//            model.addAttribute("path", req.getContextPath() +"/member/login");
//
//            return "alert";
//        }

        BoardDTO board = boardService.read(no);
        model.addAttribute("board", board);
        return "read";
    }

    @GetMapping("/write")
    public String writeGet() {
        return "write";
    }

    @PostMapping("/write")
    public String writePost(BoardDTO board) throws SQLException {
        // 인터셉터 활용하며 삭제
//        String userId = (String) session.getAttribute("userId");
//
//        if (userId == null) {
//            model.addAttribute("msg", "로그인이 필요합니다.");
//            model.addAttribute("path", req.getContextPath() +"/member/login");
//
//            return "alert";
//        }

        boardService.write(board);
        return "redirect:/board/list";
    }

    @GetMapping("/edit")
    public String editGet(@RequestParam("no") int no, HttpSession session, HttpServletRequest req, Model model) {
        return null;
    }
}
