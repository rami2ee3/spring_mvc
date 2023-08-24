package org.rami.persistence;

import org.rami.domain.CompanyVO;

public interface CompanyDAO {
    public CompanyVO getCompany(int id) throws Exception;
}
