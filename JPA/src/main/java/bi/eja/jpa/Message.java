package bi.eja.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message implements Serializable {

    @Id
    private String id;
    private String text;

    public Message(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public Message() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", text=" + text + '}';
    }

}
