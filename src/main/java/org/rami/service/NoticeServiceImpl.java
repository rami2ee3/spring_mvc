package org.rami.service;

import org.rami.controller.HomeController;
import org.rami.domain.NoticeVO;
import org.rami.persistence.NoticeDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Inject
    private NoticeDAO noticeDAO;

    @Override
    public int insertNoticeService(NoticeVO vo) throws Exception {
        return noticeDAO.insertNotice(vo);
    }

    @Override
    public NoticeVO getNoticeService(int id) throws Exception {
        return noticeDAO.getNotice(id);
    }

    @Override
    public List<NoticeVO> getNoticeListService() throws Exception {
        logger.info("서비스 호출");
        return noticeDAO.getNoticeList();
    }
}
