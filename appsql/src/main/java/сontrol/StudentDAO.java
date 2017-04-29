package сontrol;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public interface StudentDAO<T, id extends Serializable> {

    void persist(T entity);

    void update(T entity);

    T findById(Id id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();

}
