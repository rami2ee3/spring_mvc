package org.rami.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rami.domain.BoardVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardServiceTest {

    @Inject
    private BoardService boardService;

    @Test
    public void boardService () throws Exception {
        BoardVO vo = new BoardVO();
        vo.setTitle("제목1111");
        vo.setContent("내용");
        System.out.println(boardService.insertBoardService(vo));
    }

    @Test
    public void getBoardListService () throws Exception {
        System.out.println(boardService.getBoardListService());
    }
}
