package dao;

import models.Model;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class Dao {
    private Session session;
    private Transaction txl;

    public void openSession() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        txl = session.beginTransaction();
    }

    public void closeSession() {
        txl.commit();
        session.close();
    }

    public void save(Model model) {
        openSession();
        session.save(model);
        closeSession();
    }

    public void update(Model model) {
        openSession();
        session.update(model);
        closeSession();
    }

    public void delete(Model model) {
        openSession();
        session.delete(model);
        closeSession();
    }
}
