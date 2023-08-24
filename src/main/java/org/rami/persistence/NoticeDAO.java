package org.rami.persistence;

import org.rami.domain.NoticeVO;

import java.util.List;

public interface NoticeDAO {

    public int insertNotice(NoticeVO vo) throws Exception;
    public NoticeVO getNotice(int id) throws Exception;
    public List<NoticeVO> getNoticeList () throws Exception;
}
