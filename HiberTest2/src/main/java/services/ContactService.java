package services;

import dao.ContactDao;
import models.Contact;
import models.Group;

import java.util.List;

public class ContactService extends Service {

    private ContactDao contactDao = new ContactDao();

    public ContactService() {
    }

    public Contact findContact(int id) {
        return contactDao.findContact(id);
    }

    public Contact findContact(String lastname, String firstName) {return contactDao.findContact(lastname, firstName);}

    public List<Contact> findAllContacts() {
        return contactDao.findAll();
    }

    public Group findGroupById(int id) {
        return contactDao.findGroupById(id);
    }
}
