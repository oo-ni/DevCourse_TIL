package com.grepp.boot.controller;

import com.grepp.boot.model.dto.CommentDTO;
import com.grepp.boot.model.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@RestController     // 모든 메소드가 view를 생성하지 않고 data를 응답하는 @ResponseBody인게 됨.
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/write")
//    @ResponseBody   // /WEB-INF/views/comment write success.jsp 이런 행동 하지 말아라~ ViewResolver 한테 안보낸다~ 화면 안만든다~!!
    public String write(CommentDTO commentDTO) {
        boardService.writeComment(commentDTO);
        return "comment write success";     // 반환값이 String이면, 위처럼 jsp 링크가 됨.
    }

//    @GetMapping("/list")    // front에서 요청 url에 /comment/list?bno=238 이렇게 보낼 때의 요청처리
//    public List<CommentDTO> list(@RequestParam("bno") int bno) {
//
//    }

//    @GetMapping("/list/{bbb}")  // front에서 요청 url에 /comment/list/238 이렇게 보낼 때의 요청처리 -> 238이 뭘 의미하는 숫자인지 모르게 됨.
//    @ResponseBody   // 뷰리졸버가 되면 안돼! 화면 만들면 안돼! 내가 리턴한 데이터 바로 front한테 응답으로 줘!
//    public List<CommentDTO> list(@PathVariable("bbb") int bno) {    // @PathVariable : 경로 자체가 변수가 되는 경우
//        System.out.println(boardService.getComments(bno));
//        return boardService.getComments(bno);
//    }

    @GetMapping("/list/{bbb}")
    @ResponseBody
    public ResponseEntity<?> list(@PathVariable("bbb") int bno) {
        System.out.println(boardService.getComments(bno));

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return ResponseEntity.ok().headers(header).body(boardService.getComments(bno));
    }
}
