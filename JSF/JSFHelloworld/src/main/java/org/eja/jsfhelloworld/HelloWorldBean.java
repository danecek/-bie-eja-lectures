package org.eja.jsfhelloworld;

import javax.enterprise.inject.Model;

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
