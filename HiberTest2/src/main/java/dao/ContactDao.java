package dao;

import models.Contact;
import models.Group;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class ContactDao extends Dao {
    private Session session;
    private Transaction txl;

    public Contact findContact(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Contact.class, id);
    }

    public Contact findContact(String lastName, String firstName) {
        openSession();
        String hql = "From Contact where (lastname = '" + lastName + "') and (firstname = '" + firstName + "');";
        System.out.println(hql);
        Contact contact = (Contact) session.createQuery(hql);
        closeSession();
        return contact;
    }

    public Group findGroupById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Group.class, id);
    }

    public List<Contact> findAll() {
        List<Contact> users = (List<Contact>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Contact ORDER BY lastname").list();
        return users;
    }
}
