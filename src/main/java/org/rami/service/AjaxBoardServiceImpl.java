package org.rami.service;

import org.rami.domain.AjaxBoardReplyVO;
import org.rami.domain.AjaxBoardVO;
import org.rami.persistence.AjaxBoardDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class AjaxBoardServiceImpl implements AjaxBoardService {

    @Inject
    private AjaxBoardDAO ajaxBoardDAO;

    @Override
    public int ajaxBoardWriteService(AjaxBoardVO vo) throws Exception {
        return ajaxBoardDAO.ajaxBoardWrite(vo);
    }

    @Override
    public List<AjaxBoardVO> getAjaxBoardListService() throws Exception {
        return ajaxBoardDAO.getAjaxBoardList();
    }

    @Override
    public AjaxBoardVO getAjaxBoardService(int id) throws Exception {
        return ajaxBoardDAO.getAjaxBoard(id);
    }

    @Override
    public int insertReplyService(AjaxBoardReplyVO vo) throws Exception {
        return ajaxBoardDAO.insertReply(vo);
    }

    @Override
    public List<AjaxBoardReplyVO> getReplyListService(int ajax_board_id) throws Exception {
        return ajaxBoardDAO.getReplyList(ajax_board_id);
    }

    @Override
    public AjaxBoardReplyVO getReplyService(int ajaxBoardReplyId) throws Exception {
        return ajaxBoardDAO.getReply(ajaxBoardReplyId);
    }

    @Override
    public int deleteAjaxBoardService(int id) throws Exception {
        int result = 1;
        int boardResult = ajaxBoardDAO.deleteAjaxBoard(id);
        // 글 삭제에 실패했을경우 결과를 0으로 바꿔준다.
        if ( boardResult == 0 ){
            result = boardResult;
        }
        int replyResult = ajaxBoardDAO.deleteAjaxBoardReply(id);
        // 댓글글 삭제에 실패했을경우 결과를 0으로 바꿔준다.
        if ( replyResult == 0 ){
            result = replyResult;
        }
        return result;
    }
}
