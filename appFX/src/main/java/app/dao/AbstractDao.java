package app.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractDao<T> implements Dao<T> {

    @PersistenceContext
    protected EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
    protected Class<T> entity;
    protected Class<? extends AbstractDao> type = getClass();
    protected String persistentClass = type.getSimpleName();

    @Override
    public T getById(int id) {
        TypedQuery<T> findStudent = entityManager.createNamedQuery(persistentClass + ".find", entity);
        findStudent.setParameter("id", id);
        return findStudent.getSingleResult();
    }

    @Override
    public T add(T domain) {
        this.entityManager.getTransaction().begin();
        this.entityManager.clear();
        this.entityManager.merge(domain);
        this.entityManager.getTransaction().commit();
        return domain;
    }

    @Override
    public void update(T domain) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(domain);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(getById(id));
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List<T> getAll() {
        TypedQuery<T> typedQuery = this.entityManager.createNamedQuery(persistentClass + ".getAll", entity);
        return typedQuery.getResultList();
    }
}
