package org.rami.persistence;

import org.rami.domain.FormBoardVO;

import java.util.List;

public interface FormBoardDAO {
    // CRUD 만들기
    // 이름은
    // insertFormBoard (FormBoardVO vo)
    // getFormBoard ( int id )
    // getFormBoardList ()
    // updateFormBoard (FormBoardVO vo )
    // deleteFormBoard ( int id )

    public int insertFormBoard (FormBoardVO vo) throws Exception;
    public FormBoardVO getFormBoard ( int id ) throws Exception;
    public List<FormBoardVO> getFormBoardList () throws Exception;
    public int updateFormBoard (FormBoardVO vo ) throws Exception;
    public int deleteFormBoard ( int id ) throws Exception;

}
