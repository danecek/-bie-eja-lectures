package bi.eja.htmltags;

public class Person {

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private final int age;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
}
