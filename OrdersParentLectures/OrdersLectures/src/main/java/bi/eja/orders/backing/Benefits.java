package bi.eja.orders.backing;

import bi.eja.orders.data.CustomerDAO;
import bi.eja.orders.model.Benefit;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Model
public class Benefits {

    private String username;
    private String benefit;
    @Inject
    CustomerDAO customerDAO;

    public List<Benefit> getBenefits() {
        if (username == null) {
            return null;
        }
        return customerDAO.findVIP(username).getBenefits();
    }

    @PostConstruct
    void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        username = request.getParameter("customerUsername");
    }

    public String add() {
        customerDAO.addBenefit(username, benefit);
        return "customers";
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the benefit
     */
    public String getBenefit() {
        return benefit;
    }

    /**
     * @param benefit the benefit to set
     */
    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

}
