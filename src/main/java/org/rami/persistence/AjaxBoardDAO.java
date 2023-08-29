package org.rami.persistence;

import org.rami.domain.AjaxBoardReplyVO;
import org.rami.domain.AjaxBoardVO;

import java.util.List;

public interface AjaxBoardDAO {
    public int ajaxBoardWrite(AjaxBoardVO vo) throws Exception;

    public List<AjaxBoardVO> getAjaxBoardList() throws Exception;

    public AjaxBoardVO getAjaxBoard(int id) throws Exception;

    public int insertReply(AjaxBoardReplyVO vo) throws Exception;

    public List<AjaxBoardReplyVO> getReplyList(int ajax_board_id) throws Exception;

    public AjaxBoardReplyVO getReply(int ajaxBoardReplyId) throws Exception;

    public int deleteAjaxBoard(int id) throws Exception;

    public int deleteAjaxBoardReply(int ajax_board_id) throws Exception;

}
