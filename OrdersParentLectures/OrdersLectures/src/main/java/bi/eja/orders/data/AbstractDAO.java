/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

public abstract class AbstractDAO<T, K> {

    private final Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public boolean exists(K key) {
        return find(key) != null;
    }

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    public void delete(K key) {
        getEntityManager().remove(find(key));
    }

    public T find(K key) {
        return getEntityManager().find(entityClass, key, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

}
