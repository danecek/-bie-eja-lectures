package bi.eja.springhw.controller;

import bi.eja.springhw.model.Product;
import bi.eja.springhw.model.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    ProductDAO productDAO;

    @RequestMapping("/")

    public String index(Model model) {
        model.addAttribute("productlist",productDAO.getProducts());
        return "index";
    }
}
