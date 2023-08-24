package org.rami.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CompanyDAOTest {

    @Inject
    private CompanyDAO companyDAO;

    @Test
    public void getCompanyTest() throws Exception{
        System.out.println(companyDAO.getCompany(3));
    }

}