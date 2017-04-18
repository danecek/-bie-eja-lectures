package bi.eja.jpa;

import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class IndexBean {

    private String text;
    private String id;
    

    @Inject
    MessageDAO messageDAO;

    public List<Message> getMessages() throws MessageException {
        return messageDAO.getMessages();
    }
    
    public String insertMessage() {
        messageDAO.insert(text, text);
        return "index";
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
