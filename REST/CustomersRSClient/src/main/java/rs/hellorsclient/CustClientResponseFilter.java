/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.hellorsclient;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CustClientResponseFilter implements ClientResponseFilter {

    private static final Logger LOG = Logger.getLogger(CustClientResponseFilter.class.getName());

    @Override
    public void filter(ClientRequestContext crc, ClientResponseContext crc1) throws IOException {
        if (crc != null) {
            LOG.info(crc.getEntity() + "");
        }
        if (crc1 != null) {                      
            BufferedReader b
                   = new BufferedReader(new InputStreamReader(crc1.getEntityStream()));
            String r = b.lines().collect(Collectors.joining("\n"));
            LOG.info(r);
            crc1.setEntityStream(new ByteArrayInputStream(r.getBytes()));

        }

    }

}
