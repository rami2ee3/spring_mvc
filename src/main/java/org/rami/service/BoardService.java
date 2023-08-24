package org.rami.service;

import org.rami.domain.BoardVO;

import java.util.List;

public interface BoardService {
    public int insertBoardService(BoardVO vo) throws Exception;

    public List<BoardVO> getBoardListService() throws Exception;
}
