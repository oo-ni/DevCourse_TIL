package com.grepp.jpa.controller;

import com.grepp.jpa.model.dto.BoardDTO;
import com.grepp.jpa.model.entity.BoardEntity;
import com.grepp.jpa.model.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/board")
public class BoardController {
    // 원래는 BoardService 여야 하는데 지금은 jpa 간단 테스트 목적으로 repository 가져옴.
    @Autowired
    private BoardRepository boardRepository;

    // 기존에 완전 REST 아니고 MVC로 작성하던 시절의 컨트롤러는 이렇게 생겼었음
//    @PostMapping("/write")  // headers = ("content-type=multipart/*")
//    public ModelAndView write(BoardDTO board, HttpSession session, @RequestParam(value = "uploadFile", required = false) MultipartFile[] uploadFile) throws SQLException, IOException {}

    @PostMapping
    public BoardDTO write(@RequestBody BoardDTO boardDTO) {     // 중간에 보이지 않는 spring 전처리로 json -> java dto object로 변환하는 과정이 있었을거임.
        // 뭔가 null 체크 같은 작업을 한다거나 필요한 동작은 DTO로 처리하다가 model 쪽에 데이터를 줄 때는 entity 형태로 넘겨줌.
        BoardEntity entity = new BoardEntity();
        entity.setTitle(boardDTO.getTitle());
        entity.setWriter(boardDTO.getWriter());     // 나중에는 로그인한 정보로 작성자 set 해야함!
        entity.setContent(boardDTO.getContent());
        boardRepository.save(entity);       // extends 했었던 JpaRepository에 기본 insert, delete, select가 있었던 것. save == insert
        System.out.println(boardDTO);
        System.out.println(entity);

        boardDTO.setNo(entity.getNo());     // entity는 모델에서 쓰기로 약속했으니, 필요하다면 entity의 정보를 dto로 옮겨 담는 과정이 필요할 수 있음.
        boardDTO.setRegDate(entity.getRegDate());
        return boardDTO;
    }

    @GetMapping
    public List<BoardDTO> list() {
        List<BoardEntity> entities = boardRepository.findAll();
        List<BoardDTO> dtos = entities.stream().map(BoardDTO::new).collect(Collectors.toList());    // model은 이제 entity로 뭔가 다 처리하려 함. dto로 변환 필요할 수 있음.
        return dtos;
    }

    @GetMapping("/{no}")
    public BoardDTO read(@PathVariable("no") int no) {
        BoardDTO boardDTO = new BoardDTO(boardRepository.findByNo(no));
        return boardDTO;
    }

    @GetMapping("/title")
    public List<BoardDTO> list(@RequestParam("keyword") String keyword) {
        List<BoardEntity> entities = boardRepository.findByTitle(keyword);
        List<BoardDTO> dtos = entities.stream().map(BoardDTO::new).collect(Collectors.toList());
        return dtos;
    }

    @Transactional  // JPA가 기존에 있는 데이터를 변경해야 하는 경우에는 해당 메서드를 Transactional로 처리해야한다!!
    @PutMapping("/{no}")
    public int like(@PathVariable("no") int no) {
        return boardRepository.updateReadCount(no);
    }

}
