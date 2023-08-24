package org.rami.service;

import org.rami.domain.NoticeVO;

import java.util.List;

public interface NoticeService {

    public int insertNoticeService(NoticeVO vo) throws Exception;

    public NoticeVO getNoticeService(int id) throws Exception;

    public List<NoticeVO> getNoticeListService() throws Exception;
}
