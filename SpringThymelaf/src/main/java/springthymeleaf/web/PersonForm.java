package springthymeleaf.web;

import springthymeleaf.domain.Person;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonForm {

    @Size(min = 2, max = 30)//, message = "{invalid.name}")
    private String name;
    @NotNull
    @Min(0) @Max(120)
    private Integer age;

    public PersonForm() {
    }

    public PersonForm(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person getPerson() {
        return new Person(name, age);
    }
}
