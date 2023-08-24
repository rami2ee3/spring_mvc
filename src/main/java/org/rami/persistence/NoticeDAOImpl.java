package org.rami.persistence;

import org.apache.ibatis.session.SqlSession;
import org.rami.domain.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class NoticeDAOImpl implements NoticeDAO{

    @Autowired
    SqlSession sqlSession;

    private static final String NAMESPACE = "org.rami.mapper.noticeMapper";
    @Override
    public int insertNotice(NoticeVO vo) throws Exception {
        return sqlSession.insert(NAMESPACE + ".insertNotice", vo);
    }

    @Override
    public NoticeVO getNotice(int id) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".getNotice", id);
    }

    @Override
    public List<NoticeVO> getNoticeList() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".getNoticeList");
    }
}
