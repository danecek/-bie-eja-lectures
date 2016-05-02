package bi.eja.orders.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

    public Address() {
    }

    @Override
    public String toString() {
        return address;
    }

    public Address(String address) {
        this.address = address;
    }

    private String address;

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
