package org.rami.persistence;

import org.apache.ibatis.session.SqlSession;
import org.rami.domain.AjaxBoardReplyVO;
import org.rami.domain.AjaxBoardVO;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class AjaxBoardDAOImpl implements AjaxBoardDAO {

    @Inject
    SqlSession sqlSession;

    private static final String NAMESPACE = "org.rami.mapper.ajaxBoardMapper";

    @Override
    public int ajaxBoardWrite(AjaxBoardVO vo) throws Exception {
        return sqlSession.insert(NAMESPACE + ".insertAjaxBoard", vo);
    }

    @Override
    public List<AjaxBoardVO> getAjaxBoardList() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".ajaxBoardList");
    }

    @Override
    public AjaxBoardVO getAjaxBoard(int id) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".getAjaxBoard", id);
    }

    @Override
    public int insertReply(AjaxBoardReplyVO vo) throws Exception {
        // before insertReply
        System.out.println(vo);
        sqlSession.insert(NAMESPACE + ".insertReply", vo);
        // after insertReply ( vo에 id가 담겨서 온다 )
        System.out.println(vo);
        return vo.getId();
    }

    @Override
    public List<AjaxBoardReplyVO> getReplyList(int ajax_board_id) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".getReplyList", ajax_board_id);
    }

    @Override
    public AjaxBoardReplyVO getReply(int ajaxBoardReplyId) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".getReply", ajaxBoardReplyId);
    }

    @Override
    public int deleteAjaxBoard(int id) throws Exception {
        return sqlSession.update(NAMESPACE + ".deleteAjaxBoard", id);
    }

    @Override
    public int deleteAjaxBoardReply(int ajax_board_id) throws Exception {
        return sqlSession.update(NAMESPACE + ".deleteAjaxBoardReply", ajax_board_id);
    }
}
