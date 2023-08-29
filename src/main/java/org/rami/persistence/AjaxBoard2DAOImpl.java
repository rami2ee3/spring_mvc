package org.rami.persistence;

import org.apache.ibatis.session.SqlSession;
import org.rami.domain.AjaxBoard2VO;
import org.rami.domain.AjaxBoardReply2VO;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;
@Repository
public class AjaxBoard2DAOImpl implements AjaxBoard2DAO{

    @Inject
    SqlSession sqlSession;

    private static final String NAMESPACE = "org.rami.mapper.ajaxBoard2Mapper";

    @Override
    public int insertAjaxBoard2(AjaxBoard2VO vo) throws Exception {
        return sqlSession.insert(NAMESPACE + ".insertAjaxBoard2", vo);
    }

    @Override
    public List<AjaxBoard2VO> getAjaxBoard2List() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".getAjaxBoard2List");
    }

    @Override
    public AjaxBoard2VO getAjaxBoard2(int id) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".getAjaxBoard2", id);
    }

    @Override
    public int deleteAjaxBoard2(int id) throws Exception {
        return sqlSession.update(NAMESPACE + ".deleteAjaxBoard2", id);
    }

    @Override
    public int insertReply(AjaxBoardReply2VO vo) throws Exception {
        sqlSession.insert(NAMESPACE + ".insertReply", vo);
        return vo.getId();
    }

    @Override
    public List<AjaxBoardReply2VO> getReplyList(int ajax_board_id) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".getReplyList", ajax_board_id);
    }

    @Override
    public AjaxBoardReply2VO getReply(int reply_id) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".getReply", reply_id);
    }

    @Override
    public int deleteReply(int ajax_board2_id) throws Exception {
        return sqlSession.update(NAMESPACE + ".deleteReply", ajax_board2_id);
    }

    @Override
    public int countReply(int ajax_board2_id) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".countReply");
    }

    @Override
    public int updateAjaxBoard2(AjaxBoard2VO vo) throws Exception {
        return sqlSession.update(NAMESPACE + ".updateAjaxBoard2", vo);
    }
}
