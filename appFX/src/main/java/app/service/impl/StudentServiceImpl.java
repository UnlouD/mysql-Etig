package app.service.impl;

import app.service.AbstractService;
import app.dao.impl.StudentDaoImpl;

public class StudentServiceImpl<Student> extends AbstractService {
    public StudentServiceImpl() {
        dao = new StudentDaoImpl<>();
    }
}
