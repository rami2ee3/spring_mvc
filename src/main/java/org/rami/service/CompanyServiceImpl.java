package org.rami.service;

import org.rami.domain.CompanyVO;
import org.rami.persistence.CompanyDAO;
import org.rami.persistence.CompanyDAOImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Inject
    private CompanyDAO companyDAO;

    @Override
    public CompanyVO getCompanyService(int id) throws Exception {
        return companyDAO.getCompany(id);
    }
}
