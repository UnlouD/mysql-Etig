package app.service.impl;

import app.service.AbstractService;
import app.dao.impl.RegionDaoImpl;

public class RegionServiceImpl<Region> extends AbstractService {
    public RegionServiceImpl() {
        dao = new RegionDaoImpl<>();
    }
}
