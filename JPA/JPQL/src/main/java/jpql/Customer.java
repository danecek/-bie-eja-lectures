package jpql;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
    @NamedQuery(name = "nameTowns", query
            = " SELECT NEW jpql.NameTown(c.name, c.address.town)"
            + " FROM Customer c")
    , @NamedQuery(name = "customers", query
            = " SELECT c"
            + " FROM Customer c")
    , @NamedQuery(name = "customerByName", query
            = " SELECT c"
            + " FROM Customer c"
            + " WHERE c.name = :custName")
    , @NamedQuery(name = "ordersById", query
            = " SELECT o"
            + " FROM Customer c"
            + " JOIN c.orders o"
            + " WHERE c.id=?1")
    , @NamedQuery(name = "ordersCountById", query
            = " SELECT COUNT(o)"
            + " FROM Customer c"
            + " JOIN c.orders o"
            + " WHERE c.id=:custId")
    ,  @NamedQuery(name = "statuscounts", query
            = "SELECT NEW jpql.StatusCount(c.status, COUNT(c))"
            + " FROM Customer c"
            + " GROUP BY c.status"
            + " HAVING c.status IN (jpql.Status.PLATINUM, jpql.Status.GOLD)")
    , @NamedQuery(name = "sumOrdersPrice", query
            = " SELECT SUM(o.price)"
            + " FROM Customer c"
            + " JOIN c.orders o"
            + " WHERE c.id=:custId")

})
@Entity
public class Customer implements Serializable {

    public Address getAddress() {
        return address;
    }

    public Status getStatus() {
        return status;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Address address;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    public Collection<Order> orders;

    public Customer() {
    }

    public Customer(String name, Address address, Status status) {
        this.name = name;
        this.address = address;
        this.status = status;
    }

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
        StringBuilder sb = new StringBuilder();
        for (Order o : orders) {
            sb.append(", ").append(o);
        }
        return "Customer{" + "id=" + id + ", name=" + name + ", orders=" + sb + '}';
    }

}
