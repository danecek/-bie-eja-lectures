package jpql;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    public Address() {
    }

    private String town;

    public Address(String town) {
        this.town = town;
    }

    public String getTown() {
        return town;
    }

    @Override
    public String toString() {
        return town;
    }
}
