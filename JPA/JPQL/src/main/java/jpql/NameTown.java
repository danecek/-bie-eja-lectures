package jpql;

public class NameTown {

    private final String name;
    private final String town;

    public NameTown(String name, String town) {
        this.name = name;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[" + name + ": " + town + ']';
    }

}
