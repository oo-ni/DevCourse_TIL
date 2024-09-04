package com.grepp.boot.controller;

import com.grepp.boot.model.dto.ProblemDTO;
import com.grepp.boot.model.dto.UserDTO;
import com.grepp.boot.model.service.ProblemService;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/problems")
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    // 문제 목록 조회
    @GetMapping
    public String list(Model model) {
        List<ProblemDTO> problems = problemService.getProblems();
        model.addAttribute("problems", problems);
        System.out.println("문제 목록 조회 완료 : " + problems.get(problems.size() - 1));

        return "problemList";
    }

    // 문제 단일 조회
    @GetMapping("/{problemId}")
    public String getProblem(@PathVariable int problemId, Model model) {
        ProblemDTO problemDTO = problemService.getProblem(problemId);
        model.addAttribute("problem", problemDTO);
        System.out.println("문제 조회 완료 : " + problemDTO.getProblemName());

        return "problemDetail";
    }

    // 문제 생성 폼
    @GetMapping("/write")
    public String addProblemForm() {

        return "problemForm";
    }

    // 문제 생성
    @PostMapping
    public ModelAndView addProblem(ProblemDTO problemDTO, HttpSession session) {
        UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");    // 세션에 작성자 정보 추가

        problemDTO.setUserId(loginUser.getUserId());
        problemService.addProblem(problemDTO);
        System.out.println("문제 추가 완료 : " + problemDTO.getProblemName());

        ModelAndView mav = new ModelAndView("alert");
        mav.addObject("msg", "문제 생성이 완료되었습니다.");
        mav.addObject("path", "problems");

        return mav;
    }

    // 문제 수정 폼
    @GetMapping("/{problemId}/edit")
    public String editProblemForm(@PathVariable int problemId, HttpSession session, Model model) {
        ProblemDTO problemDTO = problemService.getProblem(problemId);

        UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");

        model.addAttribute("problem", problemDTO);
        model.addAttribute("isEdit", true);

        return "problemEditForm";
    }

    // 문제 수정
    @PostMapping("/{problemId}")
    public ModelAndView editProblem(@PathVariable int problemId, ProblemDTO problemDTO, HttpSession session, Model model) {
        ModelAndView mav = new ModelAndView("alert");
        UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
        problemDTO.setUserId(loginUser.getUserId());
        ProblemDTO existProblem = problemService.getProblem(problemId);

        if (loginUser == null) {
            mav.addObject("msg", "로그인이 필요합니다.");
            mav.addObject("path", "loginForm");
        } else if (!existProblem.getUserId().equals(loginUser.getUserId())) {
            mav.addObject("msg", "수정 권한이 없습니다.");
            mav.addObject("path", "");
        } else {
            mav.addObject("msg", "문제 수정이 완료되었습니다.");
            mav.addObject("path", "");
        }

        problemDTO.setProblemId(problemId);
        problemService.updateProblem(problemDTO);
        System.out.println("문제 수정 완료 : " + problemDTO.getProblemName());

        return mav;
    }

    // 문제 삭제
    @PostMapping("/{problemId}/delete")
    public String deleteProblem(@PathVariable int problemId) {
        problemService.deleteProblem(problemId);

        return "redirect:/problems";
    }
}
