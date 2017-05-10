package springthymeleaf.web;

import springthymeleaf.service.PersonsService;
import springthymeleaf.domain.Person;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {//extends WebMvcConfigurerAdapter {

    @Autowired
    PersonsService persons;

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/results").setViewName("results");
//    }
    @ModelAttribute("persons")
    public List<Person> populateSeedStarters() {
        return persons.getPersons();
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/addPerson")
    public String showForm(PersonForm personForm, Model model) {
        return "form";
    }

    @PostMapping("/addPerson")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        persons.addPerson(personForm.getPerson());
        return "redirect:/";
    }
}
