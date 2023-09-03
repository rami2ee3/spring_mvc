package org.rami.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rami.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class MemberDAOTest {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void insertMemberTest() throws Exception {
        MemberVO vo = new MemberVO();
        vo.setUserId("test001");
        vo.setUserPw("testpw0012");
        vo.setUserName("테스터");
        vo.setUserAddress("서울");
        System.out.print(memberDAO.insertMember(vo));
    }

    @Test
    public void getMemberTest() throws Exception {
        MemberVO vo = new MemberVO();
        vo.setUserId("test001");
        vo.setUserPw("testpwd001");
        System.out.println(memberDAO.getMember(vo));
    }


}
