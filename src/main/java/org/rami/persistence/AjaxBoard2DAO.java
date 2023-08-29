package org.rami.persistence;

import org.rami.domain.AjaxBoard2VO;
import org.rami.domain.AjaxBoardReply2VO;

import java.util.List;

public interface AjaxBoard2DAO {

    public int insertAjaxBoard2(AjaxBoard2VO vo) throws Exception;

    public List<AjaxBoard2VO> getAjaxBoard2List() throws Exception;

    public AjaxBoard2VO getAjaxBoard2(int id) throws Exception;

    public int deleteAjaxBoard2(int id) throws Exception;


    public int insertReply(AjaxBoardReply2VO vo) throws Exception;

    public List<AjaxBoardReply2VO> getReplyList(int ajax_board_id) throws Exception;

    public AjaxBoardReply2VO getReply(int reply_id) throws Exception;

    public int deleteReply(int ajax_board2_id) throws Exception;

    public int countReply(int ajax_board2_id) throws Exception;

    // gogo
    public int updateAjaxBoard2(AjaxBoard2VO vo) throws Exception;

}
