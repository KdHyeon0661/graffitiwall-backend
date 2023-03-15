package com.example.graffitiwall.web.service;

import com.example.graffitiwall.domain.entity.Board;
import com.example.graffitiwall.domain.repository.BoardRepository;
import com.example.graffitiwall.web.converter.BoardConverter;
import com.example.graffitiwall.web.dto.board.BoardPostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardConverter boardConverter;

    public Long save(BoardPostDto boardPostDto) {
        Board savedBoard = boardRepository.save(boardConverter.boardPostDtoToEntity(boardPostDto));
        log.info("board = {}", savedBoard);
        return savedBoard.getId();
    }
}