package org.rami.persistence;

import org.rami.domain.BoardVO;

import java.util.List;

public interface BoardDAO {

    public int insertBoard(BoardVO vo) throws Exception;

    public List<BoardVO> getBoardList() throws Exception;
}
