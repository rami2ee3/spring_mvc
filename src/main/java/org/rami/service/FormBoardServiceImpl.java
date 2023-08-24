package org.rami.service;

import org.rami.controller.HomeController;
import org.rami.domain.FormBoardVO;
import org.rami.persistence.FormBoardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class FormBoardServiceImpl implements FormBoardService{

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Inject
    FormBoardDAO formBoardDAO;

    @Override
    public int insertFormBoardService(FormBoardVO vo) throws Exception {
        return formBoardDAO.insertFormBoard(vo);
    }

    @Override
    public FormBoardVO getFormBoardService(int id) throws Exception {
        return formBoardDAO.getFormBoard(id);
    }

    @Override
    public List<FormBoardVO> getFormBoardListService() throws Exception {
        return formBoardDAO.getFormBoardList();
    }

    @Override
    public int updateFormBoardService(FormBoardVO vo) throws Exception {
        return formBoardDAO.updateFormBoard(vo);
    }

    @Override
    public int deleteFormBoardService(int id) throws Exception {
        return formBoardDAO.deleteFormBoard(id);
    }
}
