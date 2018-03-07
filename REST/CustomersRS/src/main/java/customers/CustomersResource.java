package customers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/customersResource")
@Singleton
public class CustomersResource {

    Map<String, Customer> customers = new HashMap<>();

    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Customer> get() {
        return new ArrayList<>(customers.values());
    }

    @PUT
    @Consumes(MediaType.TEXT_XML)
    public void create(Customer c) {
        customers.put(c.getName(), c);
    }
    private static final Logger LOG = Logger.getLogger(CustomersResource.class.getName());
}
