package org.rami.persistence;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rami.domain.BoardVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class BoardDAOTest {
    @Inject
    private BoardDAO boardDAO;

    @Test
    public void insertBoard() throws Exception {
        BoardVO vo = new BoardVO();
        vo.setTitle("제목이야");
        vo.setContent("내용이야");
        System.out.println(boardDAO.insertBoard(vo));
    }

    @Test
    public void getBoardList() throws Exception {
        System.out.println(boardDAO.getBoardList());
    }


}
