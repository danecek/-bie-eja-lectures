/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.data;

import java.util.List;

public interface DAO<T, K> {

    void create(T entity);

    void update(T entity);

    T find(K id);

    List<T> findAll();

    void delete(K id);
    
}
