package com.example.board_practice.service;

import com.example.board_practice.entity.Board;
import com.example.board_practice.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board, MultipartFile file) throws Exception {
        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files";

        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + file.getOriginalFilename();
        File saveFile = new File(projectPath, fileName);
        file.transferTo(saveFile);
        board.setFilename(fileName);
        board.setFilepath("/files/" +fileName);

        boardRepository.save(board);
    }

    public List<Board> boardList(){
        return boardRepository.findAll();

    }


    public Board boardView(Long boardId){
        return boardRepository.findById( boardId).get();

    }

    public void boardDelete(Long id){
        boardRepository.deleteById(id);;


    }


}
