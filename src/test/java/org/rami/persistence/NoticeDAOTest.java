package org.rami.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rami.domain.NoticeVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class NoticeDAOTest {

    @Inject
    private NoticeDAO noticeDAO;

    @Test
    public void insertNotice () throws Exception {
        NoticeVO vo = new NoticeVO();
        vo.setTitle("비오는 날");
        vo.setContent("파전에 막걸리");
        vo.setWriter("라미");
        System.out.println(noticeDAO.insertNotice(vo));
    }
}
