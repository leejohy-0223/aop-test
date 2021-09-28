package com.blogcode.board;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    List<Board> getBoards();

    void getTest();
}
