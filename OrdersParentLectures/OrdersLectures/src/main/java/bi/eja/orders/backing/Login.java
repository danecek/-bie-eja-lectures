/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.orders.backing;

import java.security.Principal;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Model
public class Login {

    private String username = "admin";
    private String password = "admin";

    public String login() {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            HttpServletRequest c = (HttpServletRequest) fc.getExternalContext().getRequest();
            c.login(username, password);
        } catch (ServletException ex) {
            fc.addMessage("", new FacesMessage(ex.getMessage()));
        }
        return "/protected/customers";
    }

    public String logout() {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            HttpServletRequest c = (HttpServletRequest) fc.getExternalContext().getRequest();
            c.logout();
        } catch (ServletException ex) {
            fc.addMessage("", new FacesMessage(ex.getMessage()));
        }
        return "/index";
    }

    public String getUser() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest c = (HttpServletRequest) fc.getExternalContext().getRequest();
        Principal p = c.getUserPrincipal();
        if (p == null) {
            return "anonym";
        }
        return p.getName();
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
