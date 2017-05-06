package app.service.impl;

import app.service.AbstractService;
import app.dao.impl.CityDaoImpl;

public class CityServiceImpl<City> extends AbstractService {
    public CityServiceImpl() {
        dao = new CityDaoImpl<>();
    }
}
