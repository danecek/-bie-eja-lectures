package bi.eja.htmltags;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Model;

@Model
public class OrderDAO {

    public List<String> getOrders() {
        ArrayList<String> x = new ArrayList<>();
        x.add("xxxx");
        x.add("yyyy");
        return x;
    }

}
