package com.example.board_practice.controller;

import com.example.board_practice.entity.Board;
import com.example.board_practice.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") //localhost:8080/board/write
    public String boardWriteForm() {

        return "boardwrite";
    }

    @PostMapping("/board/writepro") //localhost:8080/board/write
    public String boardWritePro(Board board) {
        System.out.println("제목" + board.getTitle());
        System.out.println("내용" + board.getContent());

        boardService.write(board);
        return "";
    }


    @GetMapping("/board/list")
    public String boardList(Model model) {
        model.addAttribute("list", boardService.boardList());

        return "boardlist";
    }

    @GetMapping("/board/view")
    public String boardView() {
        return "boardview";
    }

}
