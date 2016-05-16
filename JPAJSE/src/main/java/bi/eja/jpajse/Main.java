/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bi.eja.jpajse;

import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void createMessage(String key, String text) {//, EntityManager em) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Messages");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(new Message(key, text));
            et.commit();
        } catch (PersistenceException pex) {
            LOG.severe(pex.toString());
            if (et.isActive())
            et.rollback();
        }
    }

    public static Message getMessage(String key, EntityManager em) {

        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Message m = em.find(Message.class, key);
            et.commit();
            return m;
        } catch (PersistenceException pex) {
            et.rollback();
            throw pex;
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Messages");
        EntityManager em = emf.createEntityManager();
        createMessage("key41", "text");//, em);
        System.out.println(getMessage("key41", em));
    }
}
