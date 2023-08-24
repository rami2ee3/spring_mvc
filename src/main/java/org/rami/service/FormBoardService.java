package org.rami.service;

import org.rami.domain.FormBoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FormBoardService {
    public int insertFormBoardService(FormBoardVO vo) throws Exception;
    public FormBoardVO getFormBoardService(int id) throws Exception;
    public List<FormBoardVO> getFormBoardListService() throws Exception;
    public int updateFormBoardService(FormBoardVO vo) throws Exception;
    public int deleteFormBoardService(int id) throws Exception;

}
