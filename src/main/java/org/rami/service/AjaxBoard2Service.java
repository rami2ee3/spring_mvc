package org.rami.service;

import org.rami.domain.AjaxBoard2VO;
import org.rami.domain.AjaxBoardReply2VO;

import java.util.List;

public interface AjaxBoard2Service {
    public int insertAjaxBoard2Service(AjaxBoard2VO vo) throws Exception;

    public List<AjaxBoard2VO> getAjaxBoard2ListService() throws Exception;

    public AjaxBoard2VO getAjaxBoard2Service(int id) throws Exception;

    public int deleteAjaxBoard2Service(int id) throws Exception;


    public int insertReplyService(AjaxBoardReply2VO vo) throws Exception;

    public List<AjaxBoardReply2VO> getReplyListService(int ajax_board_id) throws Exception;

    public AjaxBoardReply2VO getReplyService(int reply_id) throws Exception;

    public int updateAjaxBoard2(AjaxBoard2VO vo) throws Exception;

}
