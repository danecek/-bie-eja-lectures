/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.data;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class AbstractDAO<T, K> implements DAO<T, K> {

    private final Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public boolean exists(K key) {
        return find(key) != null;
    }

    @Override
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void delete(K key) {
        getEntityManager().remove(find(key));
    }

    @Override
    public T find(K key) {
        return getEntityManager().find(entityClass, key);
    }

    @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

}
