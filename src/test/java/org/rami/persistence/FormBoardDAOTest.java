package org.rami.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rami.domain.FormBoardVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class FormBoardDAOTest {
    @Inject
    FormBoardDAO formBoardDAO;

    @Test
    public void insertFormBoard() throws Exception{
        FormBoardVO vo = new FormBoardVO();
        vo.setTitle("타이틀");
        vo.setContent("내용용용");
        vo.setWriter("글쓰니");
        System.out.println(formBoardDAO.insertFormBoard(vo));
    }

    @Test
    public void getFormBoard() throws Exception{
        System.out.println(formBoardDAO.getFormBoard(3));
    }

    @Test
    public void getFormBoardList() throws Exception{
        System.out.println(formBoardDAO.getFormBoardList());
    }

    @Test
    public void updateFormBoard() throws Exception{
        FormBoardVO vo = new FormBoardVO();
        vo.setId(4);
        vo.setTitle("타이틀");
        vo.setContent("용용용");
        vo.setWriter("쓰니");
        System.out.println(formBoardDAO.updateFormBoard(vo));
    }

    @Test
    public void deleteFormBoard() throws Exception{
        System.out.println(formBoardDAO.deleteFormBoard(3));
    }
}
