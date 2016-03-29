/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author danecek
 */
@ManagedBean
@RequestScoped
public class IndexBean {

    private String surname;

    /**
     * Creates a new instance of IndexBean
     */
    public IndexBean() {
    }

    public String register() {
        return "index";
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

}
