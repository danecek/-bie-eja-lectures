package bi.eja.springhw.model;

import groovy.lang.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ProductDAO {

    private List<Product> products = new ArrayList<>();

    public ProductDAO() {
        products.add(new Product("TV", 20));
        products.add(new Product("REC", 30));
    }

    /**
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
