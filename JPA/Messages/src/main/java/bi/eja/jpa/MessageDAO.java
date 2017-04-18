package bi.eja.jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Named
public class MessageDAO {

    @PersistenceContext
    EntityManager em;

    public Message getMessages(String key) throws MessageException {
        return em.find(Message.class, key);
    }

    public List<Message> getMessages() throws MessageException {
        List<Message> list
                = em.createQuery("select m from Message m", Message.class)
                .getResultList();
        return list;
    }

    public String insert(String key, String text) {
        em.persist(new Message(key, text));
        return "index";
    }

}
