package com.blogcode.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    @Override
    public void getTest() {
        System.out.println("aop test");
    }
}
