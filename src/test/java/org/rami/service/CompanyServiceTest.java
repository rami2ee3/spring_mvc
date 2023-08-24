package org.rami.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CompanyServiceTest {

    @Inject
    private CompanyService companyService;

    @Test
    public void getCompanyServiceTest() throws Exception{
        System.out.println(companyService.getCompanyService(1));
    }

}
