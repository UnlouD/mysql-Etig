package app.service.impl;

import app.service.AbstractService;
import app.dao.impl.CountryDaoImpl;

public class CountryServiceImpl<Country> extends AbstractService {
    public CountryServiceImpl() {
        dao = new CountryDaoImpl<>();
    }
}
