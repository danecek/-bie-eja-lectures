/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.ejbrest;

import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author danecek
 */
@Singleton
@Path("hello")
public class ResourceSessionBean {

    @GET
    public String hello() {
        return "hello";
    }
}
