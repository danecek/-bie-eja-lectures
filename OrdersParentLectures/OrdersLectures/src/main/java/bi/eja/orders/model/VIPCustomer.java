/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import static javax.persistence.DiscriminatorType.STRING;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "DISC", discriminatorType = STRING, length = 20)
public class VIPCustomer extends Customer {

    @ElementCollection
    private List<Benefit> benefits;

    public VIPCustomer() {
    }

    public VIPCustomer(String username, Address addr) {
        super(username, addr);
    }

    /**
     * @return the benefits
     */
    public List<Benefit> getBenefits() {
        return benefits;
    }

    /**
     * @param benefits the benefits to set
     */
    public void setBenefits(List<Benefit> benefits) {
        this.benefits = benefits;
    }

}
