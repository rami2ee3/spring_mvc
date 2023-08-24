package org.rami.service;

import org.rami.domain.BoardVO;
import org.rami.persistence.BoardDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    // DAO를 여기서 inject or Autowired
    @Inject
    private BoardDAO boardDAO;

    @Override
    public int insertBoardService(BoardVO vo) throws Exception {
        return boardDAO.insertBoard(vo);
    }

    @Override
    public List<BoardVO> getBoardListService() throws Exception {
        return boardDAO.getBoardList();
    }
}
