/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "ORDERS")
@NamedQueries({
    @NamedQuery(name = "getOrders", query = "SELECT o FROM Order o"),
    @NamedQuery(name = "ordersByCustomer", query = "SELECT o FROM Order o WHERE o.customer.username=?1")})
public class Order implements Serializable {

    public Order() {
    }
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Customer customer;
    private int quantity;
    private Item item;

    public Order(Customer customer, Item polozka, int quantity) {
        this.customer = customer;
        this.item = polozka;
        this.quantity = quantity;
    }

    public Order(Integer id, Customer customer, Item polozka, int quantity) {
        this(customer, polozka, quantity);
        this.id = id;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerUsername=" + getCustomer().getUsername() + ", item=" + item + '}';
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
