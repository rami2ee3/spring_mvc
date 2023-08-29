package org.rami.service;

import org.rami.domain.AjaxBoard2VO;
import org.rami.domain.AjaxBoardReply2VO;
import org.rami.persistence.AjaxBoard2DAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class AjaxBoard2ServiceImpl implements AjaxBoard2Service {

    @Inject
    private AjaxBoard2DAO ajaxBoard2DAO;

    @Override
    public int insertAjaxBoard2Service(AjaxBoard2VO vo) throws Exception {
        return ajaxBoard2DAO.insertAjaxBoard2(vo);
    }

    @Override
    public List<AjaxBoard2VO> getAjaxBoard2ListService() throws Exception {
        return ajaxBoard2DAO.getAjaxBoard2List();
    }

    @Override
    public AjaxBoard2VO getAjaxBoard2Service(int id) throws Exception {
        return ajaxBoard2DAO.getAjaxBoard2(id);
    }

    @Override
    public int deleteAjaxBoard2Service(int id) throws Exception {
        int result = 1;
        int boardResult = ajaxBoard2DAO.deleteAjaxBoard2(id);
        if (boardResult == 0) {
            result = boardResult;
        }
        // 댓글이 있을경우에는 댓글 삭제 결과도 받아줘야 한다
        int replyCount = ajaxBoard2DAO.countReply(id);
        System.out.println(replyCount);
        if (replyCount > 0) {
            int replyResult = ajaxBoard2DAO.deleteReply(id);
            if (replyResult == 0) {
                result = replyResult;
            }
        }
        return result;
    }

    @Override
    public int insertReplyService(AjaxBoardReply2VO vo) throws Exception {
        return ajaxBoard2DAO.insertReply(vo);
    }

    @Override
    public List<AjaxBoardReply2VO> getReplyListService(int ajax_board_id) throws Exception {
        return ajaxBoard2DAO.getReplyList(ajax_board_id);
    }

    @Override
    public AjaxBoardReply2VO getReplyService(int reply_id) throws Exception {
        return ajaxBoard2DAO.getReply(reply_id);
    }

    @Override
    public int updateAjaxBoard2(AjaxBoard2VO vo) throws Exception {
        return ajaxBoard2DAO.updateAjaxBoard2(vo);
    }


}
