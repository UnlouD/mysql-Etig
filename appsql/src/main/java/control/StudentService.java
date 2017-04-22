package control;

import app.entity.Student;

import java.util.List;

public interface StudentService {

    Student getById(long id);

    Student add(Student student);

    void update(Student student);

    void delete(long id);

    List<Student> getAll();

}
