package org.rami.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rami.domain.NoticeVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class NoticeServiceTest {

    @Inject
    private NoticeService noticeService;

    @Test
    public void insertNoticeService() throws Exception {
        NoticeVO vo = new NoticeVO();
        vo.setTitle("배불러");
        vo.setContent("적당히 먹어야지");
        vo.setWriter("꿀꿀");
        System.out.println(noticeService.insertNoticeService(vo));
    }

    @Test
    public void getNoticeService() throws Exception {
        System.out.println(noticeService.getNoticeService(1));
    }

    @Test
    public void getNoticeListService() throws Exception {
        System.out.println(noticeService.getNoticeListService());
    }

}
