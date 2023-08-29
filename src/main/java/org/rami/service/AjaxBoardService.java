package org.rami.service;

import org.rami.domain.AjaxBoardReplyVO;
import org.rami.domain.AjaxBoardVO;

import java.util.List;

public interface AjaxBoardService {
    public int ajaxBoardWriteService(AjaxBoardVO vo) throws Exception;

    public List<AjaxBoardVO> getAjaxBoardListService() throws Exception;

    public AjaxBoardVO getAjaxBoardService(int id) throws Exception;

    public int insertReplyService(AjaxBoardReplyVO vo) throws Exception;

    public List<AjaxBoardReplyVO> getReplyListService(int ajax_board_id) throws Exception;

    public AjaxBoardReplyVO getReplyService(int ajaxBoardReplyId) throws Exception;

    public int deleteAjaxBoardService(int id) throws Exception;

}
