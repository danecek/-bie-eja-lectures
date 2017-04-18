/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jpql;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
    @NamedQuery(name = "customers", query
            = " SELECT c"
            + " FROM Customer c")
    , @NamedQuery(name = "customer", query
            = " SELECT c"
            + " FROM Customer c"
            + " WHERE c.id=:custId")
    , @NamedQuery(name = "orders", query
            = " SELECT o"
            + " FROM Customer c"
            + " JOIN c.customerOrders o"
            + " WHERE c.id=?1")
    , @NamedQuery(name = "ordersCount", query
            = " SELECT COUNT(o)"
            + " FROM Customer c"
            + " JOIN c.customerOrders o"
            + " WHERE c.id=:custId")
//    , @NamedQuery(name = "orderCounts", query
//            = " SELECT NEW edu.jpql.OrderCount(c.id, COUNT(o))"
//            + " FROM Customer c"
//            + " JOIN c.itemsOrders o"
//            + " GROUP BY c.id")
    , @NamedQuery(name = "sumOrdersPrice", query
            = " SELECT SUM(o.price)"
            + " FROM Customer c"
            + " JOIN c.customerOrders o"
            + " WHERE c.id=:custId")
//    , @NamedQuery(name = "sumPrice2", query
//            = " SELECT SUM(i.price)"
//            + " FROM Customer c"
//            + " JOIN c.itemsOrders o"
//            + " JOIN o.items i"
//            + " WHERE c.id = 100L"
//    )

})
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "customer")
    public Collection<CustomerOrder> customerOrders;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", customerOrders=" + customerOrders + '}';
    }

}
