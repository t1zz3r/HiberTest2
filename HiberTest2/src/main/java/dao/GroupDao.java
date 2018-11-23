package dao;

import models.Contact;
import models.Group;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class GroupDao extends Dao {
    private Session session;
    private Transaction txl;

    public Group findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Group.class, id);
    }

    public Contact findContactById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Contact.class, id);
    }

    public List<Group> findAll() {
        List<Group> groups = (List<Group>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Group order by name").list();
        return groups;
    }
}
