/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Benefit implements Serializable {

    @Override
    public String toString() {
        return description;
    }

    public Benefit() {
    }

    String description;

    public Benefit(String description) {
        this.description = description;
    }
}
