/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.jsfhelloworld;

import javax.enterprise.inject.Model;

/**
 *
 * @author danecek
 */
@Model
public class HelloWorldBean {

    private String name = "???";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String submit() {
        return "helloworld";
    }

}
