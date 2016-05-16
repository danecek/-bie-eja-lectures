package bi.eja.springhw;

import bi.eja.springhw.model.ProductDAO;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Bean
    ProductDAO productDAO() {
        return new ProductDAO();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
