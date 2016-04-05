/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eja.ordersclient;

import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.Logger;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

/**
 *
 * @author danecek
 */
public class LoginFilter implements ClientResponseFilter {

    private static final Logger LOG = Logger.getLogger(LoginFilter.class.getName());

    @Override
    public void filter(ClientRequestContext crc, ClientResponseContext crc1) throws IOException {
///        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        LOG.info(crc.getMethod());
        LOG.info(crc1.getHeaders().toString());
    }

}
