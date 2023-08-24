package org.rami.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rami.domain.FormBoardVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class FormBoardServiceTest {

    @Inject
    FormBoardService formBoardService;

    @Test
    public void insertFormBoardService() throws Exception{
        FormBoardVO vo = new FormBoardVO();
        vo.setTitle("힘내");
        vo.setContent("파이팅");
        vo.setWriter("람");
        System.out.println(formBoardService.insertFormBoardService(vo));
    }

    @Test
    public void getFormBoardService() throws Exception{
        System.out.println(formBoardService.getFormBoardService(5));
    }

    @Test
    public void getFormBoardListService() throws Exception{
        System.out.println(formBoardService.getFormBoardListService());
    }

    @Test
    public void updateFormBoardService() throws Exception{
        FormBoardVO vo = new FormBoardVO();
        vo.setId(5);
        vo.setTitle("오늘하루");
        vo.setContent("기운내");
        vo.setWriter("람");
        System.out.println(formBoardService.updateFormBoardService(vo));
    }

    @Test
    public void deleteFormBoardService() throws Exception{
        System.out.println(formBoardService.deleteFormBoardService(4));
    }
}
