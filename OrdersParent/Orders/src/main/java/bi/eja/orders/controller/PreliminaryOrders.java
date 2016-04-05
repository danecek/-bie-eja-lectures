/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.controller;

import bi.eja.orders.data.OrderDAO;
import bi.eja.orders.model.Item;
import java.util.Collection;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@Stateful
@SessionScoped
public class PreliminaryOrders {

    @Inject
    OrderDAO objednavky;

    private Integer idZakaznik;

    Collection<Item> objednanePolozky;

    public void predbezneObjednej(Item p) {
        objednanePolozky.add(p);
    }

    public void umistiPredbezneObjednavky() {
//        for (Item p : objednanePolozky) {
//            objednavky.createOrder(idZakaznik, p);
//        }
    }

    public void setIdZakaznik(Integer idZakaznik) {
        this.idZakaznik = idZakaznik;
    }

}
